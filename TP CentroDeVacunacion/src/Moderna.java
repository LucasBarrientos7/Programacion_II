
public class Moderna extends VacunaConVencimiento {

	// MÉTODOS :
	
	/**
	 * Constructor de la clase Moderna
	 * @param fechaIngreso
	 */
	public Moderna(Fecha fechaIngreso) {
		super("Moderna", 18, fechaIngreso);
	}

	@Override
	public boolean estaVencida(Fecha fechaActual) {
		
		Fecha aux = new Fecha(getFechaIngreso().dia(),getFechaIngreso().mes(),getFechaIngreso().anio());
		Fecha.avanzarNDias(aux, 60);
		
		return fechaActual.posterior(aux);
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		Fecha aux = new Fecha(getFechaIngreso().dia(),getFechaIngreso().mes(),getFechaIngreso().anio());
		aux = Fecha.avanzarNDias(aux, 60);
		
		return string.append("\nVacuna { ")
				     .append(super.toStringParaSubClases())
				     .append("\nFecha de vencimiento : ").append(aux)
				     .append("}")
				     .toString();
	}
	
}
