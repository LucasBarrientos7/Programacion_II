
public class Recursion {

	public static void main(String[] args) {
		int [] a = {12, 18, 23, 40, 42, 50, 52};
		System.out.println(suma(a));
		
		System.out.println(busquedaBinaria(a, 48));
		System.out.println(busquedaBinaria(a, 50));
	}

	public static int suma(int[] array) {
		return suma(array,0);
	}
	
	private static int suma(int [] array, int i) {
		if(i == array.length) {
			return 0;
		} else { // Llamada recursiva + (propiedad asociativa)
			return array[i] + suma(array, i+1);
		}
	}
	
	public static int busquedaBinaria(int[] array, int numeroBuscado) {
		return busquedaBinaria(array, numeroBuscado, 0, array.length);
	}

	private static int busquedaBinaria(int[] array, int numeroBuscado, int desde, int hasta) {
		if (desde > hasta) { // Caso base 1: no se encontró
			return -1;
		}
		int medio = (desde+ hasta)/2;
		if (array[medio] == numeroBuscado) { // Caso Base 2: se encontro en la pos medio
			return medio;
		}
		if (array[medio] < numeroBuscado) {
			// Llamada recursiva: el nro es mayor, se busca en la derecha
			return busquedaBinaria(array, numeroBuscado, medio+1, hasta);
		} else {
			// Llamada recursiva: el nro es menor, se busca en la izquierda
			return busquedaBinaria(array, numeroBuscado, desde, medio-1);
		}
	}
	
}
