
public class Sputnik extends Vacuna {

	// MÉTODOS :
	
	/**
	 * Constructor de la clase Sputnik.
	 * @param fechaIngreso
	 */
	public Sputnik (Fecha fechaIngreso) {
		super("Sputnik", 3, 60, fechaIngreso);
	}

	/**
	 * Compara la edad de una persona y la edad minima de la 
	 * vacuna y determina si es aprobada o no.
	 * @param persona
	 * @return boolean
	 */
	public boolean restriccion(Persona persona) {
		return persona.calcularEdad() < getEdadMinima();
	}
	
}
