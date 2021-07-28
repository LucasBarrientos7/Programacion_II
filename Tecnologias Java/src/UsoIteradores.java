import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UsoIteradores {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ar1.add(10);
		ar1.add(15);
		ar1.add(20);
		ar1.add(25);
		ar1.add(30);

		// Las tres formas de iterar una lista
		// -----------------------------------
		
		// ITERANDO LOS INDICES DE LA LISTA desde 0 hasta size()-1
		// Para una LinkedList, es O(n2), por suma de Gauss
		for (int i=0; i<ar1.size(); i++) {
			System.out.println(ar1.get(i));
		}
		System.out.println();

		// UTILIZANDO UN FOR EACH
		// (mayor nivel de abstracción, cada colección es la que sabe
		//  cómo implementar su recorrido de manera eficiente,
		//  en O(1) cada next)
		for (Integer elem: ar1) {
			System.out.println(elem);
		}
		System.out.println();

		// UTILIZANDO ITERATOR
		// El objeto Iterator es el que sabe cómo obtener el siguiente
		// elemento, y si hay más elementos. También resuelve el problema
		// de la eliminación de elementos de la colección, mientras se recorre
		Iterator<Integer> iter = ar1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
// Esta forma de eliminar, con el for each, falla!!
//		for (Integer elem: ar1) {
//			if (elem.equals(10)) 
//				ar1.remove(elem);
//		}
//		System.out.println(ar1);

// Para eliminar podemos usar el remove del iterator	
//		Iterator<Integer> it = ar1.iterator();
//		Integer elem;
//		while(it.hasNext()) {
//			elem = it.next();
//			if (elem.equals(10)) 
//				it.remove();
//		}
//		System.out.println(ar1);


		// Como iterar sobre un diccionario
		HashMap<Integer,String> alumnos = new HashMap<Integer,String>();
		alumnos.put(123, "Juan");
		alumnos.put(456, "Pedro");

		System.out.println("\nUsando keySet() con for each:");
		for (Integer clave: alumnos.keySet())
			System.out.println("Clave: "+clave+", Valor: "+alumnos.get(clave));
	
		System.out.println("\nUsando entrySet() con for each:");
		for (Map.Entry<Integer,String> ent: alumnos.entrySet())
			System.out.println("Clave: "+ent.getKey()+", Valor: "+ent.getValue());

		
		System.out.println("\nUsando keySet() con Iterator:");
		Iterator<Integer> itClaves = alumnos.keySet().iterator();
		Integer dni;
		while (itClaves.hasNext()) {
			dni = itClaves.next();
			System.out.println("DNI: " + dni + " / Nombre: " + alumnos.get(dni));
		}

		System.out.println("\nUsando entrySet() con Iterator:");
		Iterator<Map.Entry<Integer,String>> itEntradas = alumnos.entrySet().iterator();
		Map.Entry<Integer,String> reg;
		while (itEntradas.hasNext()) {
			reg = itEntradas.next();
			System.out.println("DNI: "+reg.getKey()+" / Nombre: "+reg.getValue());
		}

	}
	
	
}
