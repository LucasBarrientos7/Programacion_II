package Empleado;

public class Empleado {

	private String nombre;
	private int numEmpleado, sueldo;
	
	static private int contador = 0; // Variable de Clase
	
	public Empleado(String nombre, int sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.numEmpleado = ++contador;
	}
	
	public void aumentarSueldo(int porcentaje) {
		sueldo += (int) (sueldo * porcentaje / 100); // (int) sirve para convertir algo en un tipo
	}
	
	public int sueldo() {
		return sueldo;
	}
	
	public String toString() {
		return "Num. empleado " + numEmpleado + ", Nombre: " +
				nombre + ", Sueldo: " + sueldo;
	}
	
}
