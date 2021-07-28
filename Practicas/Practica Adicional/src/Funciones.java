
public class Funciones {

	// 1) 	Implementar una función que determine si un arreglo es subconjunto de otro:
	
	public static boolean pertenecenTodos(int[] elems, int[] arreglo) {
		boolean ret = true;
		for (int i = 0; i < elems.length; i++) {
			ret = ret || (elems[i] == arreglo[i]);
		}
		return ret;
	}
	
	// 2) 	Implementar una nueva versión de la función anterior, eliminando la pre-condición: 
	
	public static boolean mayorDiversidad(int mat [][]) {
		boolean ascendente = true;
		boolean parImpar = true;
		boolean par, impar;
		for (int col = 0; col < mat[0].length; col++) {
			par = false;
			impar = false;
			for (int fila = 0; fila < mat.length; fila++) {
				if (col > 0)
					ascendente = ascendente && mat[fila][col] > mat[fila][col-1];
				par = par || esPar(mat[fila][col]);
				impar = impar || !esPar(mat[fila][col]);
			}
			parImpar = parImpar && par && impar;
		}
		return ascendente && parImpar;
	}
	
	/** SIN TERMINAR */

	public static boolean mayorDiversidad2(int[][] arr) {
		boolean ret = false;
		for (int f = 0; f < arr.length; f++)
			for (int c = 0; c < arr.length; c++)
					ret = ret || estaAscendente(arr[f]);
		return ret ;
	
	}
	
	// 3)	Implementar una función que reciba dos arreglos ordenados y 
	// 		devuelva un tercer arreglo ordenado que sea la unión de ambos:
	
	public static int[] combinarOrdenados(int[] a, int[] b) {
		int list [] = intercalar(a, b);
		if (!estaOrdenado(list)) {
			ordenarPorSeleccion(list);
		}
		return list;
	}
	
	// 4)	Implementar una función que devuelva el índice del pico en un 
	// 		arreglo unimodal, o -1 si el arreglo no tiene forma de pico.
	
	public static int indicePico(int[] arreglo) {
		int indice = maximo(arreglo);
		
		if ( estaOrdenado(arreglo) || indice == 0 || cantRepetidos1(arreglo)>0) {
			return -1;
		}
		else
			return indice;
	}

/////////////////////// FUNCIONES AUXILIARES ///////////////////////
	
	public static boolean esPar(int n) {
		return n%2==0;
	}
	
	public static boolean estaAscendente(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] >= a[i+1])
				return false;
		}
		return true;
	}
	
	public static boolean hayPar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] %2 == 0) {
				return true;
			}
		}
		return false;
	}
	
	static void ordenarPorSeleccion(int a[]) {
		for (int i = 0; i < a.length - 1; i++) { // Recorre el entero
			int menor = i;
			for (int j = i + 1; j < a.length; j++) { // Recorre lo que queda del arreglo
				if (a[j] < a[menor])
					menor = j;
			}

			swap(a, i, menor);
		}
	}

	static void swap(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}

	static int[] intercalar(int[] a, int[] b) {
		int nuevo[] = new int[a.length + b.length];
		for (int i = 0; i < Math.min(a.length, b.length) * 2; i++) {
			if (i % 2 == 0) {
				if (i / 2 <= a.length - 1) {
					nuevo[i] = a[i / 2];
				}
			} else {
				if (i / 2 <= b.length - 1)
					nuevo[i] = b[i / 2];
			}
		}
		if (a.length < b.length) {
			int j = a.length;
			for (int i = a.length * 2; i < nuevo.length; i++) {
				nuevo[i] = b[j];
				j++;
			}
		} else {
			int j = b.length;
			for (int i = b.length * 2; i < nuevo.length; i++) {
				nuevo[i] = a[j];
				j++;
			}
		}
		return nuevo;
	}
	
	static boolean estaOrdenado(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}
	
	static int maximo(int[] arreglo) {
		int max = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if ((arreglo[i] > arreglo[max] ) ) {
				max = i; 
			}
		}
		return max;
	}
	
	static int cantRepetidos1(int[] a) {
		int cont = 0;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i; j < a.length-1; j++) {
				if ((a[i] == a[j] && i != j) || (a[i] == a[i+1])) {
					cont++;
				}
			}
		}
		return cont;
	}
	
}
