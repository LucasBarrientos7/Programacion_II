import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainCompararPersonas {

	public static void main(String[] args) {

		Set<Persona> conj = new HashSet<Persona>();
		// La linea anterior se puede reemplazar por la sig:
		// Set<Persona> conj = new TreeSet<Persona>();
		
		Persona p1 = new Persona(23344556, "Damian");
		Persona p2 = new Persona(12344556, "Barbara");
		Persona p3 = new Persona(67344556, "Jason");

//		conj.add(p1);
//		conj.add(p2);
//		conj.add(p3);
//		conj.add(new Persona(99876543, "Bruce"));
//		System.out.println("Impresion del conjunto:");
//		System.out.println(conj);
//		System.out.println();
		
		if (p1.compareTo(p2) < 0) {
			System.out.println("La persona p1 es menor que p2");
		} else if (p1.compareTo(p2) > 0) {
			System.out.println("La persona p1 es mayor que p2");
		} else {
			System.out.println("La persona p1 y p2 son iguales");
		}
		
		if (p1.compareTo(p3) < 0) {
			System.out.println("La persona p1 es menor que p3");
		} else if (p1.compareTo(p3) > 0) {
			System.out.println("La persona p1 es mayor que p3");
		} else {
			System.out.println("La persona p1 y p3 son iguales");
		}
		
		ListaOrdenada<Persona> lista = new ListaOrdenada<Persona>();
		lista.agregar(p1);
		lista.agregar(p2);
		lista.agregar(p3);
		lista.agregar(new Persona(99876543, "Bruce"));
		System.out.println(lista);

		
	}

}
