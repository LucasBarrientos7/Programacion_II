import Empresa.Fecha;

public class Principal {
	
	public static void main(String[] args) {
		
		Alumno a,b;
		b = new Alumno(100, "Juan", "Perez", new Fecha(2,4,2021), "informatica");
		a = new Alumno(50, "Ju", "Pe", new Fecha(2,4,2021), "informatica");
//		System.out.println(miAlumno.tosString());
		
		if(a.compareTo(b) > 0) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
		 
	}
	
	
	
}
