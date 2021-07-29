
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedList;

public class CentroVacunacion {
   
	// ATRIBUTOS Y SU I.REP :
	
	private String nombreCentro;
	private int capacidadVacunacionDiaria;
	// CapacidadVacunacionDiaria > 0.
	
	AlmacenVacuna almacen;
	// Vacunas -> vacunas no pueden no ser Pfizer,SinoPharm,Moderna,Astrazeneca,Sputnik.
	
	private HashMap<Integer,LinkedList<Persona>>inscriptos;
	// Los inscriptos deben ser mayores a 18 años.
	// No puede haber inscriptos repetidos.
	// No se pueden agregar personas que ya fueron vacunadas.
	
	private LinkedList<Integer>listaEspera;   
	// Si una persona pertenece a la lista de inscriptos => pertenece a la lista de espera.
	
	private Map<Fecha,Turnos> turnosConFecha;
	// No se pueden agregar turnos si la fecha para generar turnos es < Fecha.hoy().
	// ObtenerTurnosDeFecha(fecha).cantidadTurnos() <= capacidadVacunacionDiaria y > 0.
	
	private Map<Integer,String> vacunados;
	// No se pueden agregar a lista de vacunados, personas que no tienen turnos 
    // o que ya fueron vacunados. 
	
	// METODOS :
	
	/**
	* Constructor.
	* recibe el nombre del centro y la capacidad de vacunación diaria.
	* Si la capacidad de vacunación no es positiva se debe generar una excepción.
	* Si el nombre no está definido, se debe generar una excepción.
	*/
	public CentroVacunacion(String nombreCentro, int capacidadVacunacionDiaria) {
		
		this.nombreCentro = nombreCentro;
		if(capacidadVacunacionDiaria <= 0)
			throw new RuntimeException("La capacidad de vacunacion diaria debe ser mayor a 0");
		
		this.capacidadVacunacionDiaria = capacidadVacunacionDiaria;
		this.almacen = new AlmacenVacuna();
        
		this.inscriptos = new HashMap<Integer,LinkedList<Persona>>();
		
		this.listaEspera    = new LinkedList<Integer>();
		this.turnosConFecha = new HashMap<Fecha,Turnos>();
		this.vacunados      = new HashMap<Integer,String>();
	}
	
	/**
	* Solo se pueden ingresar los tipos de vacunas planteados en la 1ra parte.
	* Si el nombre de la vacuna no coincidiera con los especificados se debe generar
	* una excepción.
	* También se genera excepción si la cantidad es negativa.
	* La cantidad se debe
	* sumar al stock existente, tomando en cuenta las vacunas ya utilizadas.
	*/
	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) {
		
		almacen.reponerVacunas(nombreVacuna, fechaIngreso, cantidad);
	}
	
	/**
	* total de vacunas disponibles no vencidas sin distinción por tipo.
	*/
	public int vacunasDisponibles() {
	
		return  almacen.getStockTotal();
	}
	
	/**
	* total de vacunas disponibles no vencidas que coincida con el nombre de
	* vacuna especificado.
	*/
	public int vacunasDisponibles(String nombreVacuna) {
		
		return almacen.vacunasDisponibles(nombreVacuna);
	}
	
	/**
	* Se inscribe una persona en lista de espera.
	* Si la persona ya se encuentra inscripta o es menor de 18 años, se debe
	* generar una excepción.
	* Si la persona ya fue vacunada, también debe generar una excepción.
	*/
	public void inscribirPersona(int dni, Fecha nacimiento,boolean tienePadecimientos, boolean esEmpleadoSalud) {
			
		Persona persona;
		
		if(this.listaEspera.contains(dni)) 
			throw new RuntimeException("La persona con el D.N.I : " + dni + " ya esta inscripta");
		else if(this.vacunados.containsKey(dni))
			throw new RuntimeException("Esta persona ya esta vacunada");
		else if(Fecha.diferenciaAnios(Fecha.hoy(), nacimiento)<18)
			throw new RuntimeException("Todavia no estan abiertas las inscripciones para menores de edad");
		
		persona = new Persona(dni,nacimiento,tienePadecimientos,esEmpleadoSalud);
		
		crearNuevaListaDePrioridad(persona.prioridad());
		agregarInscripto(persona.prioridad(),persona);	
		agregarDocumentoAListaDeEspera(dni);
	}
	
	/**
	* Devuelve una lista con los DNI de todos los inscriptos que NO se vacunaron
	* y que NO tienen turno asignado.
	* Si no quedan inscriptos sin vacunas debe devolver una lista vacía.
	*/
	public LinkedList<Integer> listaDeEspera(){
		
		return this.listaEspera;
	}
	
	/**
	* Primero se verifica si hay turnos vencidos "?". En caso de haber turnos
	* vencidos, la persona que no asistió al turno debe ser borrada del sistema
	* y la vacuna reservada debe volver a estar disponible.
	* 
	* Segundo, se deben verificar si hay vacunas vencidas y quitarlas del sistema.
	*
	* Por último, se procede a asignar los turnos a partir de la fecha inicial
	* recibida según lo especificado en la 1ra parte.
	* Cada vez que se registra un nuevo turno, la vacuna destinada a esa persona
	* dejará de estar disponible. Dado que estará reservada para ser aplicada
	* el día del turno.
	*
	*/
	public void generarTurnos(Fecha fechaInicial) {

		if(fechaInicial.anterior(Fecha.hoy()))
			throw new RuntimeException("No se pueden generar turnos vencidos");
	
		int nroLista;
		int tamanioLista;
		Fecha auxFecha = new Fecha(fechaInicial.dia(),fechaInicial.mes(),fechaInicial.anio());
		
		Turnos turnos;
		
		Iterator<Integer> listas = this.inscriptos.keySet().iterator();

		for(Vacuna vacuna : eliminarTurnosVencidos(fechaInicial))
			almacen.reponerVacunas(vacuna.getNombre(), vacuna.getFechaIngreso(), 1);
		
		almacen.eliminarVacunasVencidas(fechaInicial);

		while(listas.hasNext()) {
			
			nroLista      = listas.next();
			tamanioLista  = traerListaDeInscriptos(nroLista).size();
			
			while(tamanioLista > 0 && vacunasDisponibles() > 0) {
				
				turnos = obtenerTurnosDeFecha(auxFecha);
				
				if(turnos == null) {
					turnos = new Turnos();
					asignarTurnosAFecha(auxFecha, turnos);
				}
				
				while(turnos.cantidadDeTurnos() < capacidadVacunacionDiaria && tamanioLista > 0 && vacunasDisponibles() > 0) {
					
					Persona per = obtenerUnInscripto(nroLista);
					
					turnos.agregarTurno(per.getDni(), almacen.traerVacuna(per));
					quitarDeListaDeEspera(per.getDni());

					tamanioLista -= 1;
				}
				
				if(turnos.cantidadDeTurnos() == capacidadVacunacionDiaria)
					auxFecha.avanzarUnDia();
			}
		}
	}
	
	/**
	* Devuelve una lista con los dni de las personas que tienen turno asignado
	* para la fecha pasada por parámetro.
	* Si no hay turnos asignados para ese día, se debe devolver una lista vacía.
	* La cantidad de turnos no puede exceder la capacidad por día de la ungs.
	*/
	public LinkedList<Integer> turnosConFecha(Fecha fecha){

		if(this.turnosConFecha.containsKey(fecha))
			return this.turnosConFecha.get(fecha).listaDeInscriptos();
		else
			return new LinkedList<Integer>();
	}
	
	/**
	* Dado el DNI de la persona y la fecha de vacunación
	* se valida que esté inscripto y que tenga turno para ese dia.
	* - Si tiene turno y está inscripto se debe registrar la persona como
	* vacunada y la vacuna se quita del depósito.
	* - Si no está inscripto o no tiene turno ese día, se genera una Excepcion.
	*/
	public void vacunarInscripto(int dni, Fecha fechaVacunacion) {
		
		if(!this.turnosConFecha.get(fechaVacunacion).tieneTurno(dni))
			throw new RuntimeException("Esta persona no tiene asignado un turno para esta fecha : "+fechaVacunacion);
		this.vacunados.put(dni,this.turnosConFecha.get(fechaVacunacion).eliminarTurno(dni).toString());
	}
	
	/**
	* Devuelve un Diccionario donde
	* - la clave es el dni de las personas vacunadas
	* - Y, el valor es el nombre de la vacuna aplicada.
	*/
	public Map<Integer, String> reporteVacunacion(){
		
		return this.vacunados;
	}
	
	/**
	* Devuelve en O(1) un Diccionario:
	* - clave: nombre de la vacuna
	* - valor: cantidad de vacunas vencidas conocidas hasta el momento.
	*/
	public Map<String, Integer> reporteVacunasVencidas(){
		
		return almacen.reporteVacunasVencidas();
	}
		
	/**
	 * Guarda en la lista de espera el numero de dni de un inscripto.
	 * @param dni
	 */
	private void agregarDocumentoAListaDeEspera(Integer dni) {
		
		this.listaEspera.add(dni);
	}
	
	/**
	 * Remueve de la lista de espera el dni de un inscripto.
	 * @param dni
	 */
	private void quitarDeListaDeEspera(Integer dni) {
		
		this.listaEspera.remove((Object) dni);
	}
	
	/**
	 * @param prioridad
	 * Crea una nueva lista si no existe una con la prioridad recibida como parametro.
	 * 
	 */
	private void crearNuevaListaDePrioridad(Integer prioridad) {
		if(!this.inscriptos.containsKey(prioridad))
			this.inscriptos.put(prioridad,new LinkedList<Persona>());
	}
	
	/**
	 * Devuelve una lista con las personas que tiene el nivel de prioridad recibido como parametro.
	 * @param prioridad
	 * @return LinkedList
	 */
	private LinkedList<Persona> traerListaDeInscriptos(Integer prioridad){
		
		return this.inscriptos.get(prioridad);
	}
	
	/**
	 * 
	 * Agrega un inscripto a la lista con la prioridad indicada
	 * @param prioridad
	 * @param persona
	 */
	private void agregarInscripto(Integer prioridad,Persona persona) {
		
		this.inscriptos.get(prioridad).add(persona);
	}	

	/**
	 * Me devuelve un inscripto de la lista de prioridad indicada 
	 * 
	 * @param prioridad
	 * @return Persona
	 */
	private Persona obtenerUnInscripto(Integer prioridad) {	
		
		return this.inscriptos.get(prioridad).removeFirst();
	}
	
	/**
	 * Agrega turnos a una fecha pasada como parametro.
	 * @param fecha
	 * @param turnos
	 */
	private void asignarTurnosAFecha(Fecha fecha, Turnos turnos) {
		
		if(!this.turnosConFecha.containsKey(fecha)) 
			this.turnosConFecha.put(new Fecha(fecha.dia(),fecha.mes(),fecha.anio()), turnos);
	}
	
	/**
	 * Apartir de una fecha, devuelve los turnos que se le asignaron.
	 * @param fecha
	 * @return Turnos
	 */
	private Turnos obtenerTurnosDeFecha(Fecha fecha) {
		
		if(this.turnosConFecha.containsKey(fecha))
			return this.turnosConFecha.get(fecha);
		
		return null;
	}
	
	/**
	 * Recorre una liste de turnos y elimina los que tinen asignado una fecha pasada a la fecha actual.
	 * @param fecha
	 * @return Linkedlist
	 */
	private LinkedList<Vacuna> eliminarTurnosVencidos(Fecha fecha) {
		
		LinkedList<Vacuna> vacunas = new LinkedList<Vacuna>();
		LinkedList<Fecha> fechasAEliminar = new LinkedList<Fecha>();
		
		Iterator<Fecha>fechasTurnos = this.turnosConFecha.keySet().iterator();
		
		Fecha fechaAux;
		
		while(fechasTurnos.hasNext()) {
			
			fechaAux = fechasTurnos.next();
			
			if(fechaAux.anterior(fecha)) {
				vacunas.addAll(this.turnosConFecha.get(fechaAux).eliminarTurnos());
				fechasAEliminar.add(fechaAux);
			}
		}
		
		for(Fecha fec : fechasAEliminar)
			this.turnosConFecha.remove(fec);
		
		return vacunas;
	}

	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		int cantidadDeTurnos = 0;
		
		Iterator<Fecha> iter = turnosConFecha.keySet().iterator();
		
		while(iter.hasNext()) {
			Fecha aux = iter.next();
			cantidadDeTurnos += this.turnosConFecha.get(aux).cantidadDeTurnos();
		}
		
		return string.append(nombreCentro)
				     .append(" {")
				     .append("\n Capacidad de vacunación diaria   : ").append(capacidadVacunacionDiaria)
				     .append("\n Cantidad  de vacunas disponibles : ").append(vacunasDisponibles())
				     .append("\n Cantidad  de personas en espera  : ").append(listaDeEspera().size())
				     .append("\n Cantidad  de vacunas aplicadas   : ").append(reporteVacunacion().size())
				     .append("\n Cantidad  de turnos totales      : ").append(cantidadDeTurnos)
				     .append("\n}")
				     .toString();
	}
	                    
}
