package Empresa;

public abstract class Empleado {

	private String nombre;
	private String apellido;
	private Fecha fechaNacimiento;
	
	public Empleado(String n, String a, Fecha f) {
		nombre = n;
		apellido = a;
		fechaNacimiento = f;
	}
	
	public abstract float calcularSueldo();

	public abstract String mostrarDatos();

}
