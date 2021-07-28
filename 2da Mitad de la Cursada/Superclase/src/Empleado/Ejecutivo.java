package Empleado;

public class Ejecutivo extends Empleado{

	int presupuesto;
	
	public Ejecutivo(String nombre, int sueldo) {
		super(nombre, sueldo);
	}
	
	public Ejecutivo(String nombre, int sueldo, int presupuesto) { // Sobrecarga de constructores
		super(nombre, sueldo);
		this.presupuesto = presupuesto;
	}
	
	void asignarPresupuesto(int p) {
		presupuesto = p;
	}

//	public String toString() {
//		return super.toString() + ", Presupuesto: " + presupuesto;
//	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		return sb.append(", Presupuesto: ").append(presupuesto).toString();
	}
	
	
	
}
