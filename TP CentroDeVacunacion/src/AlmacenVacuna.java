
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class AlmacenVacuna {

	// ATRIBUTOS Y SU I.REP :
	
	private int stockTotal;
	
	private LinkedList<String> vacunasPermitidas;

	private Map<String, Integer> stocks;
	// stocks.containsKey(nombreVacuna) == vacunasPermitidas.contains(nombreVacuna).
	
	private Map<Vacuna, Integer> vacunas;
	// vacunas.containsKey(unaVacuna) == vacunasPermitidas.contains(unaVacuna.getNombre()).
	// vacunas.get(vacuna) > 0.
	
	private Map<VacunaConVencimiento, Integer> vacunasConVencimiento;
	// vacunasConVencimiento.containsKey(unaVacuna) == vacunasPermitidas.contains(unaVacuna.getNombre()).
	// vacunasConVencimiento.get(vacunaConVencimiento) > 0.
	
	private Map<String, Integer> vacunasVencidas;

	// METODOS :
	
	/**
	 * Constructor de la clase AlmacenVacuna.
	 */
	public AlmacenVacuna() {
		
		this.stockTotal = 0;
		
		this.stocks                = new HashMap<String,Integer>();
		this.vacunas               = new HashMap<Vacuna,Integer>();
		this.vacunasConVencimiento = new HashMap<VacunaConVencimiento,Integer>();
		this.vacunasVencidas       = new HashMap<String,Integer>();
		this.vacunasPermitidas     = new LinkedList<String>();
		
		this.vacunasPermitidas.add("Sputnik");
		this.vacunasPermitidas.add("Pfizer");
		this.vacunasPermitidas.add("Moderna");
		this.vacunasPermitidas.add("Sinopharm");
		this.vacunasPermitidas.add("AstraZeneca");
	
	}
	
	/**
	 * Devuelve un valor booleano si el nombre de la Vacuna existe dentro de la lista de VacunasPermitidas.
	 * @param nombre
	 * @return boolean
	 */
	private boolean vacunaPermitida(String nombre) {
		
		return this.vacunasPermitidas.contains(nombre);
	}
	
	/**
	 * Retorna una Vacuna tomando en cuenta el stock del almacen y la prioridad de una persona.
	 * @param persona
	 * @return Vacuna
	 */
	public Vacuna traerVacuna(Persona persona) {
		
		Iterator<Vacuna> vacunas;
		Iterator<VacunaConVencimiento> vacunasConVencimiento;
		boolean reservada = false;
		Vacuna vac = null;
		
		vacunasConVencimiento = this.vacunasConVencimiento.keySet().iterator();
			
		while(vacunasConVencimiento.hasNext() && !reservada) {
				
			vac = vacunasConVencimiento.next();
			
			if(!vac.restriccion(persona)) 
				reservada = true;
		}
			
		vacunas = this.vacunas.keySet().iterator();
			
		while(vacunas.hasNext() && !reservada) {
				
			vac = vacunas.next();
				
			if(!vac.restriccion(persona))
				reservada = true;
		}
		
		if(reservada) {
			if(vac instanceof VacunaConVencimiento) {
				ingresarVacunaYSuLote((VacunaConVencimiento)vac, loteDeVacunas(vac)-1);
				
				if(loteDeVacunas(vac) == 0)
					quitarVacunaDelLote(vac);
			}else {
				ingresarVacunaYSuLote(vac, loteDeVacunas(vac) - 1);
				
				if(loteDeVacunas(vac) == 0)
					quitarVacunaDelLote(vac);
			}
			
			this.stocks.put(vac.getNombre(), vacunasDisponibles(vac.getNombre()) - 1);
			this.stockTotal -= 1;
			
		}
		return vac;
	}
	
	/**
	 * A partir del nombre de una vacuna, suma la cantidad pasada como parametro al stock.
	 * @param nombre
	 * @param fechaIngreso
	 * @param cantidad
	 */
	public void reponerVacunas(String nombre,Fecha fechaIngreso,Integer cantidad) {
		Vacuna aux = null;
		
		if(cantidad <= 0)
			throw new RuntimeException("La cantidad ingresada no puede ser un numero menor o igual a 0");
		
		if(!vacunaPermitida(nombre))
			throw new RuntimeException("La vacuna no es valida en el centro de vacunacion " + nombre + fechaIngreso + cantidad);
		
		this.stockTotal += cantidad;
			
		if(!this.stocks.containsKey(nombre))
			this.stocks.put(nombre, cantidad);
		else
			this.stocks.put(nombre,vacunasDisponibles(nombre) + cantidad);
			
			
		if(nombre.equals("Pfizer"))
			aux = new Pfizer(fechaIngreso);
		else if(nombre.equals("Moderna"))
			aux = new Moderna(fechaIngreso);
		else if(nombre.equals("Sputnik"))
			aux = new Sputnik(fechaIngreso);
		else if(nombre.equals("Sinopharm"))
			aux = new Sinopharm(fechaIngreso);
		else if(nombre.equals("AstraZeneca"))
			aux = new Astrazeneca(fechaIngreso);
			
		if(aux instanceof VacunaConVencimiento) {
			if(this.vacunasConVencimiento.containsKey(aux))
				ingresarVacunaYSuLote((VacunaConVencimiento)aux, loteDeVacunas(aux) + cantidad);
			else
				ingresarVacunaYSuLote((VacunaConVencimiento)aux, cantidad);

		}else {
			
			if(this.vacunas.containsKey(aux))
				ingresarVacunaYSuLote(aux, loteDeVacunas(aux) + cantidad);
			else 
				ingresarVacunaYSuLote(aux,cantidad);
		}
	}
	
	/**
	 * Recorre la lista de Vacunas con Vencimiento y elimina aquellas vacunas que tienen una 
	 * fecha anterior a la fecha actual.
	 * @param fechaActual
	 */
	public void eliminarVacunasVencidas(Fecha fechaActual) {
		
		Iterator<VacunaConVencimiento> iterador   = this.vacunasConVencimiento.keySet().iterator();
		LinkedList<VacunaConVencimiento> vencidas = new LinkedList<VacunaConVencimiento>();
		String nombreVac = "";
		
		while(iterador.hasNext()) {
			
			VacunaConVencimiento vac = iterador.next();
			nombreVac = vac.getNombre();
			
			if(vac.estaVencida(fechaActual)) {
				
				int stockActualDeVac = vacunasDisponibles(nombreVac);
				int loteVencido      = loteDeVacunas(vac);

				this.stockTotal -= loteVencido;
				this.stocks.put(nombreVac, stockActualDeVac - loteVencido);
				vencidas.add(vac);
			}
		}
		
		for(VacunaConVencimiento vac : vencidas) {
			
			nombreVac     = vac.getNombre();
			int cantidadVencidas = loteDeVacunas(vac);
			int cantVenActual ;
			
			if(this.vacunasVencidas.containsKey(nombreVac)) {
				cantVenActual = this.vacunasVencidas.get(nombreVac);
				this.vacunasVencidas.put(nombreVac, cantVenActual + cantidadVencidas);
			}else 
				this.vacunasVencidas.put(nombreVac,cantidadVencidas);
			
			quitarVacunaDelLote(vac);
		}
	}
	
	/**
	 * Devuelve la cantidad de vacunas en el almacen.
	 * @param vac
	 * @return Integer
	 */
	private Integer loteDeVacunas(Vacuna vac) {
		
		if(vac instanceof VacunaConVencimiento)
			return this.vacunasConVencimiento.get(vac);
		
		return this.vacunas.get(vac);
	}
	
	/**
	 * Remueve la vacuna con vencimiento del stock.
	 * @param vac
	 */
	private void quitarVacunaDelLote(Vacuna vac) {
		
		if(vac instanceof VacunaConVencimiento)
			this.vacunasConVencimiento.remove(vac);
		else 
			this.vacunas.remove(vac);
	}
	
	/**
	 * Devuelve la suma total de todas las vacunas.
	 * @return int
	 */
	public int getStockTotal() {
		return this.stockTotal;
	}
	
	/**
	 * Devuelve la cantidad de vacunas que se encuentran libres.
	 * @param nombre
	 * @return int
	 */
	public int vacunasDisponibles(String nombre) {
		
		int total = 0;
		
		if(this.stocks.containsKey(nombre))
			total = this.stocks.get(nombre);
		
		return total;
	}
	
	/**
	 * Agrega una cantidad de vacunas a una vacuna pasada como parametro.
	 * @param vac
	 * @param cantidad
	 */
	private void ingresarVacunaYSuLote(Vacuna vac,Integer cantidad) {
		
		if(vac instanceof VacunaConVencimiento)
			this.vacunasConVencimiento.put((VacunaConVencimiento)vac, cantidad);
		else
			this.vacunas.put(vac, cantidad);
	}
	
	/**
	 * Devuelve un listado de las Vacunas que vencieron.
	 * @return Map
	 */
	public Map<String,Integer> reporteVacunasVencidas(){
		
		return this.vacunasVencidas;
	}
	
}
