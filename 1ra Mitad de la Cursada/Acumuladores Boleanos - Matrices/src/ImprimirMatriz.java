import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ImprimirMatriz {

	public static void main(String[] args) {

//		int [][] mat = {
//				{10, 2, 17, 5},
//				{ 3, 1, 2, 10},
//				{ 1, 1, 1, 1}
//		};
//		
//		String s = "";
//		
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[0].length; j++) {	
//				s = s + mat[i][j] + " ";
//			}
//			s = s + "\n";
//		}
//		System.out.println(s);
//		System.out.println();
//		
//		//Uso del String Builder:
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[0].length; j++) {
//				sb.append(mat[i][j]); // no concatenar con un " + "  
//				sb.append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
	
		LinkedList<Integer> lista = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
		
		// BORRAR IMPARES:
		
//		for (int i = 0; i < lista.size(); i++) {
//			if (lista.get(i) % 2 != 0) {
//				lista.remove(i);
//			}
//		}
		
//		Iterator<Integer> it = lista.iterator(); // Iterator tiene 3 metodos importantes
//		
//		while (it.hasNext()) { // HasNext verifica si hay un elemento a verificar
//			Integer elem = it.next(); // Next para solicitar ese elemento y avanzar
//			if (elem % 2 != 0) {
//				// Si es impar se borra
//				it.remove(); // remove borra elementos
//			}
//		}
//		
//		System.out.println(lista);
		
		for (int i = 0; i < lista.size(); i++) {
			Integer valor  = lista.get(i);
			System.out.print(valor + "-");
		}
		
		System.out.println();
		
		for (Integer valor : lista) {
			System.out.print(valor + "-");
		}
		
		System.out.println();
		
		
		

		
		
	}
}
