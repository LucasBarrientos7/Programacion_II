
public class Tarea_Complejidad {

	/*  N es la cantidad de elementos en la lista.
	 * 
	 *	f(n) = 2 + 3 + 4n + 4n + 2n + {SUM i=[0, n-1] g(i)} + 1
	 *	f(n) = 6 + 10n + {SUM i=[0, n-1] 4 + 10i} (como 10i es mayor a todo lo demas  constantes se considera solamente a 10i)
	 *	f(n) = 6 + 10n + {SUM i=[0, n-1] 10i} Sacamos factor comun el 10
	 *	f(n) = 6 + 10n + 10*{SUM i=[0, n-1] i}
	 *  f(n) = 6 + 10n + 10* ((n -1) * n/2) Suma de gauss
	 *  f(n) = 6 + 10n + 5*(n**2-n)
	 *  f(n) = 6 + 10n + 5*n**2 - 5n
	 *  f(n) = 6 + 5n + 5n**2
	 *  f(n) = cuadratica
	 *  
	 *  Por lo general se pide por definicion pero esto es demostrar por propiedad:
	 *  
	 *  Aplico algebra de ordenes (Propiedad) para demostrar la complejidad
	 *  
	 *  O(f) = O(6 + 5n + 5n**2) 				-> aplico la propiedad de la suma (r2)
	 *  O(f) = O(6) + O(5n) + O(5n**2) 			-> r4 Para reducir la constante
	 *  O(f) = O(1) + O(5n) + O(5n**2) 			-> r3 Para separar el producto
	 *  O(f) = O(1) + O(5)*O(n) + O(5)*O(n**2) 	-> r4 Para reducir las constantes
	 *  O(f) = O(1) + O(1)*O(n) + O(1)*O(n**2) 	-> r3 Para juntar los productos
	 *  O(f) = O(1) + O(n) + O(n**2)			-> r2 Para reducir la suma
	 *  O(f) = O( max {1, n, n**2} )			-> r1 determina que 1 < n < n**2
	 *  
	 *  Resultado: O(f) = O(n**2)
	 *  
	 */
	public static int[] valoresParesAcumulados(int[] lista) {
		int []ret = new int[lista.length];	// asignaciones: +1 +1 = +2
		
		for (int i = 0; i < lista.length; i++) {	// asignaciones y recorrido 1 + (2 + 2)*n + 2(ultima verificacion)
			if (esPar(lista[i])) {		// esPar: +3 instrucciones, asignacion: +1, =4 todo esto se repite n veces
				ret[i] = acumularParesHasta(lista, i);	// 2 + g(i) se repite con i de 1 hasta n (suma de gauss)
			} else {	// Este caso no se cuenta por que no es el peor caso
				ret[i] = 0;		// + 1 + 1 = + 2 * n (porque el for se repite n veces)
			}
		}
		return ret;	// +1
	}
	
	// u = el valor de ultimo (que va desde 0 hasta lista.lenght -1)
	private static int acumularParesHasta(int[] lista, int ultimo) { // g(u) = 4 + 10u
		int acum = 0;	// +1
		for (int i = 0; i <= ultimo; i++) {	// 1 + 3 * u + 1(Ult verificacion en donde tira false)
			if (esPar(lista[i])) { 		// 4 * u
				acum = acum + lista[i]; // 3 * u
			}	
		}
		return acum; // +1
	}
	
	public static boolean esPar(int i) { // 3 instrucciones
		return i%2==0; // asignacion, comparacion y return  1 + 1 + 1
	}	
	
}
