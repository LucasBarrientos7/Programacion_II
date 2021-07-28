package Empresa;

public class Efectivo extends Empleado {

	private float sueldoBasico;
	private float descuentos;
	
	public Efectivo(String n, String a, Fecha f, float sueldo) {
		super(n, a, f);
		sueldoBasico = sueldo;
	}
	
	@Override
	public float calcularSueldo() {
		return sueldoBasico - descuentos;
	}
	
	public String mostrarDatos() {
		return super.toString() + " " + sueldoBasico;
	}
	
	public float descuentos() {
		return descuentos;
	}
	
	
}
