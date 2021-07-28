package Empleado;

public class MainEmpleado {

	public static void main(String[] args) {
		
//		Esto no compila
//		Empleado e = new Empleado("Esteban", 100);
//		e.asignarPresupuesto(500);
		
//		Ejecutivo jefe = new Ejecutivo("Edward Blake", 1000);
//		jefe.asignarPresupuesto(1500);
//		jefe.aumentarSueldo(5);
//		jefe.toString();
//		System.out.println(jefe.toString());
		
		// CASTEO:
		Empleado e = new Ejecutivo("Eduard Bleik", 2000);
		e.aumentarSueldo(10);
	
		if (e instanceof Ejecutivo) { // Se fija si es una clase o subclase de ejecutivo...
			Ejecutivo ejec = (Ejecutivo) e;
			ejec.asignarPresupuesto(1500);
		}
		
		System.out.println(e);
		
		
		
	}
	
	
}
