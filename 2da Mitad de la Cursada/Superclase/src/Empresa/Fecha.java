package Empresa;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int d, int m, int a) {
		dia = d;
		mes = m;
		anio = a;
	// Validar IREP
	}
	
	public Fecha() {
		dia = 27;
		mes = 04;
		anio = 2021;
	}
	
	public int restarFechas(Fecha f) {
		return f.getAnio();
	}
	
	public int getAnio() {
		return anio;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}
	
}
