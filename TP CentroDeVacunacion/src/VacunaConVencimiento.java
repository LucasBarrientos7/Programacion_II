
public abstract class VacunaConVencimiento extends Vacuna {
	
	// MÉTODOS :
	
	/**
	 * Constructor de la clase VacunaConVencimiento.
	 * @param nombre
	 * @param edadMinima
	 * @param fechaIngreso
	 */
	public VacunaConVencimiento(String nombre, int edadMinima, Fecha fechaIngreso) {		
		super(nombre, -18, edadMinima, fechaIngreso);
		
	}
	
	/**
	 * Determina si una vacuna esta vencida o no.
	 * @param fechaActual
	 * @return boolean
	 */
	public abstract boolean estaVencida(Fecha fechaActual);

}
