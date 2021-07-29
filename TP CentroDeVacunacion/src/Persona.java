
public class Persona {

	// ATRIBUTOS :

	private int dni;
	private Fecha fechaNacimiento;
	private boolean tienePadecimientos;
	private boolean esEmpleadoSalud;

	// METODOS :

	/**
	 * Contructor de la clase Persona.
	 * 
	 * @param dni
	 */
	public Persona(int dni) {
		this.dni = dni;
	}

	/**
	 * Constructor de la clase Persona con cuatro parametros.
	 * 
	 * @param dni
	 * @param nac
	 * @param tienePadecimientos
	 * @param esEmpleadoSalud
	 */
	public Persona(int dni, Fecha nac, boolean tienePadecimientos, boolean esEmpleadoSalud) {

		this.dni = dni;
		this.fechaNacimiento = nac;
		this.tienePadecimientos = tienePadecimientos;
		this.esEmpleadoSalud = esEmpleadoSalud;
	}

	/**
	 * Retorna el valor numerico de la prioridad de una Persona.
	 * 
	 * @return int
	 */
	public int prioridad() {

		if (this.esEmpleadoSalud)
			return 1;
		if (calcularEdad() >= 60)
			return 2;
		if (this.tienePadecimientos)
			return 3;

		return 4;
		
	}

	/**
	 * Calcula la edad de una persona a partir de su fecha de nacimiento.
	 * 
	 * @return int
	 */
	public int calcularEdad() {

		return Fecha.diferenciaAnios(Fecha.hoy(), this.fechaNacimiento);
	}

	// Getters de la clase Persona:

	public int getDni() {
		return dni;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public boolean isTienePadecimientos() {
		return tienePadecimientos;
	}

	public boolean isEsEmpleadoSalud() {
		return esEmpleadoSalud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
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
		Persona other = (Persona) obj;
		if (dni != other.dni)
			return false;
		return true;
	}

	@Override
	public String toString() {

		String aux1;
		String aux2;
		StringBuilder cadena = new StringBuilder();

		if (this.tienePadecimientos)
			aux1 = "Si";
		else
			aux1 = "No";

		if (this.esEmpleadoSalud)
			aux2 = "Si";
		else
			aux2 = "No";

		cadena.append("Persona{\nD.N.I : ").append(dni).append("\nFecha de nacimiento : ").append(fechaNacimiento)
				.append("\nPersonal de salud : ").append(aux2).append("\nPadecimientos : ").append(aux1).append("\n}");

		return cadena.toString();
	}

}
