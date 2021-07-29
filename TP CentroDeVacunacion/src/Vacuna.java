
public class Vacuna {

	// ATRIBUTOS :
	
	private String nombre;
	private int grados;
	private int edadMinima;
	private Fecha fechaIngreso;
	
	// MÉTODOS :
	
	/**
	 * Constructor de la clase Vacuna.
	 * @param nombre
	 * @param grados
	 * @param edadMinima
	 * @param fechaIngreso
	 */
	public Vacuna(String nombre,int grados, int edadMinima,Fecha fechaIngreso) {
		this.nombre = nombre;
		this.grados = grados;
		this.edadMinima = edadMinima;
		this.fechaIngreso = fechaIngreso;
	}
	
	/**
	 * Restriccion general de las vacunas.
	 * @param persona
	 * @return
	 */
	public boolean restriccion(Persona persona) {
		return persona.calcularEdad() < this.edadMinima;
//		return false;
	}
	
	// Getters de la clase Vacuna:
	
	public int darGrados() {
		return grados;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdadMinima() {
		return this.edadMinima;
	}

	public Fecha getFechaIngreso() {
		return fechaIngreso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacuna other = (Vacuna) obj;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		return string.append("Vacuna {\n ")
		      .append("Nombre : ").append(nombre)
		      .append("\nRestricción de edad : ").append(edadMinima)
		      .append("\nTemperatura de almacenamiento : ").append(grados)
		      .append("\nFecha de ingreso : ").append(fechaIngreso)
		      .append("}").toString();
		
	}
	
	public String toStringParaSubClases() {
		
		StringBuilder string = new StringBuilder();
		
		return string.append("\nNombre : ").append(nombre)
				     .append("\nRestriccion de edad : ").append(edadMinima)
			         .append("\nTemperatura de almacenamiento : ").append(grados)
			         .append("\nFecha de ingreso : ").append(fechaIngreso).toString();
	}
	
}
