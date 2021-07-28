package Tarea1Acumuladores;

public class Acumuladores {
	/*
	 * Consigna Tarea 1: Resolver con Acumuladores Booleanos Subir los archivos
	 * .java a la tarea de moodle
	 */

	/** Devuelve verdadero si todos los elementos de mat son pares */
	static public boolean todosPares(int[][] mat) {
		boolean ret = true;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				ret = ret && (mat[i][j] % 2 == 0);
			}
		}
		return ret;
	}

	/** Devuelve verdadero si todos los elementos de alguna fila de mat son pares */

	static public boolean algunaFilaPar(int[][] mat) {
		// completar y cambiar el valor de retorno
		boolean ret = true;
		boolean valor = true;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				ret = ret && (mat[i][j] % 2 == 0);
			}
			valor = valor || ret;
		}
		return valor;
	}

	/** Devuelve verdadero si alguna fila de mat suma menos que 30 */

	static public boolean algunaFilaSumaMenosQue30(int[][] mat) {
		// completar y cambiar el valor de retorno
		boolean ret = false;
		boolean valor = false;
		int suma = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				suma += mat[i][j];
			}
			ret = ret || (suma < 30);
			valor = valor || ret;
			suma = 0;
		}
		return ret;
	}

	// devuelve verdadero si alguna columna de mat suma mas que 50
	static public boolean algunaColSumaMasQue50(int[][] mat) {
		// completar y cambiar el valor de retorno
		boolean ret = false;
		int suma = 0;
		for (int j = 0; j < mat.length; j++) {
			for (int i = 0; i < mat[j].length; i++) {
				suma += mat[j][i];
			}
			ret = ret || (suma > 50);
			suma = 0;
		}

		return ret;
	}

	// devuelve verdadero si alguna fila es par y alguna columna suma mas que 50
	static public boolean algunaFilaParYColMasQue50(int[][] mat) {
		// completar y cambiar el valor de retorno - Utilizar lo anterior
		boolean ret = false;
		ret = ret || algunaFilaPar(mat) || algunaColSumaMasQue50(mat);
		return ret;
	}

	// devuelve verdadero si alguna fila de mat es igual a lista.
	// Lista tiene tantos elementos como las columnas de mat
	static public boolean algunaFilaIgualLista(int[][] mat, int[] lista) {
		// completar y cambiar el valor de retorno
		boolean ret = false;
		for (int j = 0; j < mat.length; j++)
			for (int i = 0; i < mat[j].length; i++)
				ret = ret || (mat[j][i] == lista[j]);
		return ret;
	}

	public static void imprimirPorFilas(int[][] m) {
		// completar
	}

	public static void imprimirPorColumnas(int[][] m) {
		// completar
	}

	public static void imprimirLista(int[] l) {
		// completar
	}

}
