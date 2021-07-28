import Empresa.Fecha;

public class Persona {

	private String nombre;
	private String apellido;
	private Fecha fechaNacimiento;
	
	public Persona (String n, String a, Fecha f) {
		nombre = n;
		apellido = a;
		fechaNacimiento = f;
	}
	
	public int Edad() {
		return fechaNacimiento.restarFechas(new Fecha());
	}

	public String tosString() {
		return nombre + " " + apellido;
	}
	
}
