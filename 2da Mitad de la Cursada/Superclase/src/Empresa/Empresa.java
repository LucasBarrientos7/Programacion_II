package Empresa;
import java.util.ArrayList;

public class Empresa {

	private ArrayList<Empleado> empleados;
	
	public Empresa() {
		empleados = new ArrayList<>();
	}
	
	public void ingresarEmpleado(String n, String a, Fecha f, float s, char tipo) {
		if (tipo == 'E') {
			empleados.add(new Efectivo(n, a, f, s));
		} else {
			empleados.add(new Contratado(n, a, f, s));
		}
	}
	
	public float totalSueldos() {
		StringBuilder datos = new StringBuilder();
		float total = 0;
		for (Empleado e : empleados) {
			datos.append(e.mostrarDatos());
			total += e.calcularSueldo();
		}
		return total;
	}
	
	public float descuentos() {
		float total = 0;
		for (Empleado e : empleados) {
			if (e instanceof Efectivo) {
				total += ((Efectivo)e).descuentos();
			}
		}
		return total;
	}
	
}
