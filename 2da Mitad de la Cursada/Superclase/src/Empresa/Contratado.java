package Empresa;

public class Contratado extends Empleado {

	private float valorHora;
	private int cantidadHoras;
	
	public Contratado(String n, String a, Fecha f, float valorHora) {
		super(n, a, f);
		this.valorHora = valorHora;
		cantidadHoras = 2;
	}

	@Override
	public float calcularSueldo() {
		return valorHora*cantidadHoras;
	}

	@Override
	public String mostrarDatos() {
		return super.toString() + " " + valorHora;
	}
	
	
	
	
}
