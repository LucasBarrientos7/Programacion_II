package Empresa;

public class Main {

	public static void main(String[] args) {
		
		// Efectivo nuevo = new Efectivo("Bruno", "Diaz", new Fecha(27,3,1938),100);
	
		Empresa empresa = new Empresa();
		empresa.ingresarEmpleado("Bruno", "Diaz", new Fecha(27,3,1938),100,'E');
		empresa.ingresarEmpleado("Selina", "Kyle", new Fecha(27,3,1938),100, 'C');
		System.out.println(empresa.totalSueldos());

	}

}
