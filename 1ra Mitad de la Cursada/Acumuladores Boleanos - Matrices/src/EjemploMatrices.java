
public class EjemploMatrices
{
	//
	// Comparación de errores de compilación
	// frente a errores en tiempo de ejecución.
	//
	public static void main(String[] args) {
		int a = 17;
		int b;
		int[] arr = { 1, 2, 3 };
		int arr2[] = new int[4];

		//
		// ¿Qué se imprime?
		//
		System.out.println("a = " + a);
		System.out.println("arr.length = " + arr.length);
		System.out.println("arr[1] = " + arr[1]);
		System.out.println("arr = " + arr);

		System.out.println("arr2[1] = " + arr2[1]);

		//
		// ¿Y estos casos?
		//
		/*
		System.out.println("b = " + b);

		System.out.println("arr3.size() = " + arr3.size());

		arr2[4] = 9;
		System.out.println("arr2[4] = " + arr2[4]);

		*/

		ejemploMatriz();
	}

	public static void ejemploMatriz() {
		int[][] matriz = new int[4][2];

		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[1][0] = 3;
		matriz[1][1] = 4;
		matriz[2][0] = 5;
		matriz[2][1] = 6;
		matriz[3][0] = 7;
		matriz[3][1] = 8;

		//
		// O, lo que sería exactamente lo mismo:
		//
		int[][] matriz2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};

		//
		// Imprimir por fila.
		//
		// Una versión usando "i", "j"; otra versión idéntica,
		// cambiando "i" por "f" (fila) y "j" por "c" (columna).
		//

		System.out.println("\nPOR FILAS (i, j)");

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 2; j++)
				System.out.printf(
				    "matriz[%d][%d] = %d\n", i, j, matriz[i][j]);

		System.out.println("\nPOR FILAS (f, c)");

		for (int f = 0; f < 4; f++)
			for (int c = 0; c < 2; c++)
				System.out.printf(
				    "matriz[%d][%d] = %d\n", f, c, matriz[f][c]);

		//
		// Ahora por columna.
		//
		// Observar los cambios.

		System.out.println("\nPOR COLUMNAS (i, j)");

		for (int i = 0; i < 2; i++)		// i permanece, 4 → 2
			for (int j = 0; j < 4; j++)	// j permanece, 2 → 4
				//
				// Cuidado: Cambia el print() también!!
				//
				System.out.printf(
				    "matriz[%d][%d] = %d\n", j, i, matriz[j][i]);

		//
		// Versión alternativa con f y c
		//

		System.out.println("\nPOR COLUMNAS (f, c)");

		for (int c = 0; c < 2; c++)		// f → c, 4 → 2
			for (int f = 0; f < 4; f++)	// c → f, 2 → 4
				//
				// El print() es idéntico a la versión por filas.
				//
				System.out.printf(
				    "matriz[%d][%d] = %d\n", f, c, matriz[f][c]);

		//
		// Los NOMBRES de variables añaden claridad.
		//
	}

	//
	// Funciones para imprimir int[][] de tamaño arbitrario.
	//
	// OJO: ¿es int[][] siempre una matriz?
	//

	/** Imprime una matriz de enteros por filas.
	 *
	 * @param matriz: Una matriz N × M representada como int[][].
	 *
	 * PRECONDICIÓN: "matriz" es una verdadera matriz, es decir:
	 *   matriz.length == N, con N > 0
	 *   para todo 0 <= f < N, matriz[i].length == M, con M > 0
	 */
	public static void porFilaMatriz(int[][] matriz) {
		for (int f = 0; f < matriz.length; f++)
			//
			// Es suficiente "c < matriz[0].length" como
			// condición porque todas las filas tienen la
			// misma longitud.
			//
			for (int c = 0; c < matriz[0].length; c++)
				System.out.printf(
				    "matriz[%d][%d] = %d\n", f, c, matriz[f][c]);
	}

	/** Imprime un arreglo de dos dimensiones por "filas".
	 *
	 * Esta versión no tiene pre-condición alguna, por lo que
	 * si se reusara el código de porFilaMatriz, se produciría
	 * ArrayIndexOutOfBoundsException con parámetros que nadie
	 * dijo que no eran aceptables. Lo cual NO ES aceptable.
	 *
	 * Hacen faltas verificaciones adicionales.
	 */
	public static void porFila(int[][] arr) {
		for (int f = 0; f < arr.length; f++)
			//
			// Para imprimir por filas, es suficiente con
			// usar la longitud de cada fila, arr[f]. Como
			// se verá, el caso de las columnas es de mayor
			// dificultad.
			//
			for (int c = 0; c < arr[f].length; c++)
				System.out.println(arr[f][c]);
	}

	/** Imprime una matriz de enteros por columnas.
	 *
	 * @param matriz: Una matriz N × M representada como int[][].
	 *
	 * PRECONDICIÓN: misma que porColumnaMatriz.
	 */
	public static void porColumnaMatriz(int[][] matriz) {
		for (int c = 0; c < matriz[0].length; c++)
			for (int f = 0; f < matriz.length; f++)
				System.out.printf(
				    "matriz[%d][%d] = %d\n", f, c, matriz[f][c]);
	}

	/** Imprime un arreglo de dos dimensiones por "columnas".
	 */
	public void porColumna1(int[][] arr) {
		//
		// Es complicado saber cuándo parar, porque no podemos
		// saber a priori la longitud de la "columna" más larga.
		//
		// Una opción es pre-recorrer una vez el arreglo para
		// encontrar el máximo. Así:
		//
		int maxCol = 0;

		for (int f=0; f < arr.length; f++)
			if (arr[f].length > maxCol)
				maxCol = arr[f].length;

		//
		// Imprimir por columna. Hace falta un "if" adicional.
		//
		for (int c = 0; c < maxCol; c++)
			for (int f = 0; f < arr.length; f++)
				if (arr[f].length < c)  // Usar 'c', NO maxCol.
					System.out.printf(
					    "matriz[%d][%d] = %d\n", f, c, arr[f][c]);
	}

	/** Implementación alternativa con un solo recorrido.
	 */
	public void porColumna2(int[][] arr) {
		//
		// Condición para parar el incremento de columnas.
		//
		boolean seguir = true;

		for (int c = 0; seguir; c++) {
			//
			// El flag será verdadero si encontramos, al menos,
			// un elemento en esta columna.
			//
			seguir = false;

			for (int f = 0; f < arr.length; f++) {
				if (arr[f].length < c) {
					seguir = true;
					System.out.printf(
					    "matriz[%d][%d] = %d\n", f, c, arr[f][c]);
				}
			}
		}
	}
}
