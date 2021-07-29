
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class Turnos {

	// ATRIBUTOS :
	
	private Map<Integer,Vacuna> turnos;
	
	// MÉTODOS :
	
	/**
	 * Constructor de la clase Turnos.
	 */
	public Turnos() {
		this.turnos = new HashMap<Integer,Vacuna>();
	}
	
	/**
	 * Adiciona un turno a una lista de turnos.
	 * @param dni
	 * @param vacuna
	 */
	public void agregarTurno(Integer dni,Vacuna vacuna) {
		
		this.turnos.put(dni, vacuna);
	}
	
	/**
	 * Vacia el map de turnos y devuelve una lista con 
	 * vacunas asignadas a cada inscripto.
	 * 
	 */
	public LinkedList<Vacuna> eliminarTurnos(){
		
		LinkedList<Vacuna> vacunas = new LinkedList<Vacuna>();
		
		for(Integer dni : listaDeInscriptos()) {
			vacunas.add(eliminarTurno(dni));
		}
		
		return vacunas;
	}
	
	/**
	 * Verifica si una persona esta dentro de la lista de turnos.
	 * @param dni
	 * @return boolean
	 */
	public boolean tieneTurno(Integer dni) {
		
		return this.turnos.containsKey(dni);
	}
	
	/**
	 * Devuelve la vacuna asignada al DNI de una persona.
	 * @param dni
	 * @return Vacuna
	 */
	public Vacuna consultarVacuna(Integer dni) {
		
		return this.turnos.get(dni);
	}
	
	/**
	 * Remueve de la lista el turno de la lista de turnos a partir
	 * del DNI de una persona.
	 * @param dni
	 * @return Vacuna
	 */
	public Vacuna eliminarTurno(Integer dni) {
		
		return this.turnos.remove(dni);
	}
	
	/**
	 * Devuelve la lista de los inscriptos hasta el momento.
	 * @return LinkedList
	 */
	public LinkedList<Integer> listaDeInscriptos(){
		
		return new LinkedList<Integer>(this.turnos.keySet());
	}
	
	/**
	 * Devuelve la cantidad de turnos de la lista de turnos.
	 * @return int
	 */
	public int cantidadDeTurnos() {
		return this.turnos.size();
	}
}
