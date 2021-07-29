
public class Pfizer extends VacunaConVencimiento {

	// MÉTODOS :
	
	/**
	 * Constructor de la clase Pfizer.
	 * @param fechaIngreso
	 */
	public Pfizer(Fecha fechaIngreso) {
		
		super("Pfizer",60, fechaIngreso);
	}
	
	/**
	 * Compara la edad de una persona y la edad minima de la 
	 * vacuna y determina si es aprobada o no.
	 * @return boolean
	 */
	public boolean restriccion(Persona persona) {
		
		return persona.calcularEdad() < getEdadMinima();
	}

	@Override
	public boolean estaVencida(Fecha fechaActual) {
		
		Fecha aux = new Fecha(getFechaIngreso().dia(),getFechaIngreso().mes(),getFechaIngreso().anio());
		aux = Fecha.avanzarNDias(aux, 30);
		
		return fechaActual.posterior(aux);//checkear
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		Fecha aux = new Fecha(getFechaIngreso().dia(),getFechaIngreso().mes(),getFechaIngreso().anio());
		aux = Fecha.avanzarNDias(aux, 30);
		
		return string.append("\nVacuna { ")
				     .append(super.toStringParaSubClases())
				     .append("\nFecha de vencimiento : ").append(aux)
				     .append("}")
				     .toString();
	}
	
}
