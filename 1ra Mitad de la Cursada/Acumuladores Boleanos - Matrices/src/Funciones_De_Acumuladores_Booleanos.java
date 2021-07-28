
public class Funciones_De_Acumuladores_Booleanos {
	
	/** Verifica si en una columna se encuentra un numero negativo */
	
	static boolean hayNegativoEnColumna (int [][] matriz, int col) {
		boolean hayNegativo = false;
		for (int i=0; i<matriz.length; i++)
			hayNegativo = hayNegativo || matriz[i][col]<0;
		return hayNegativo;
	}
	
	/** Verifica si en diferentes columnas se encuentra un numero negativo */
	
	static boolean hayNegativoEnAlgunaColumna (int[][] matriz) {
		boolean columnaConNegativo = false;
		for (int i=0; i<matriz[0].length; i++)
			columnaConNegativo = columnaConNegativo || hayNegativoEnColumna(matriz, i);
		return columnaConNegativo;
	}

	/** Verifica si todos los numeros de una lista son positivos (Con Funcion)*/
	
	static boolean filaPositivaCorta (int [][] matriz, int fila) {
		return todosPositivos(matriz[fila]);
	}
	
	/** Verifica si todos los numeros de una lista son positivos (Con un For)*/
	
	static boolean filaPositiva (int [][] matriz, int fila) {
		boolean todospositivos = true;
		for (int i=0; i<matriz[fila].length; i++)
			todospositivos = todospositivos && matriz[fila][i]>0;
		return todospositivos;
	}
	
	/** Verifica si existe alguna fila de una matriz con todos sus elementos negativos */
	
	static boolean existeAlgunaFila(int [][] matriz) {
		boolean existeFila = false;
		boolean todosNeg;
		for (int fila = 0; fila < matriz.length; fila++) {
			todosNeg= true;
			for (int columna = 0; columna < matriz[fila].length; columna++) {
				todosNeg = todosNeg && matriz[fila][columna]>0;
			}
			existeFila = existeFila || todosNeg;
		}
		return existeFila; 
	}
	
	/** Indica si existe un elemento en una columna */
	
	public static boolean algunElementoEnColumna(int[][] matriz, int columna, int[] arreglo) {
		boolean ret = false;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < arreglo.length; j++) {
				ret = ret || (matriz[i][columna] == arreglo[j]);
			}
		}
		return ret;
	}
	
	/** Indica si cada columna de la matriz existe un elemento del arreglo */
	
	public static boolean arregloEnColumnas(int[][] matriz, int[] arreglo) {
		boolean ret = true;
		if (arreglo.length <= 0) {
			return true;
		}
		if (matriz.length <= 0) {
			return false;
		}
		for (int j = 0; j < matriz[0].length; j++) {
			ret = ret && (algunElementoEnColumna(matriz, j, arreglo));
		}
		return ret;
	}
	
	boolean existeFilaMayor(int[][] mat, int f) {
		boolean comparacion = true;
		boolean existeFila = false;
		if (mat.length == 0) {
			return existeFila;
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				comparacion = mat[i][j] > mat[f][j];
			}
			existeFila = existeFila || comparacion;
		}
		return existeFila;
	}
	
	/** Indica si existe una columna de l arreglo en donde todos sus elementos
	 * son menores al arreglo c (columna) pasado como parametro */
	
	public static boolean existeColumnaMenor(int mat[][], int c) {
		boolean existeMenor = false;
		boolean ret;
		if (mat.length == 0 || mat[0].length == 0) {
			return false;
		}
		for (int col = 0; col < mat[0].length; col++) {
			ret = true;
			for (int fila = 0; fila < mat.length; fila++) {
				ret = ret && mat[fila][col] < mat[fila][c];
			}
			existeMenor = existeMenor || ret;
		}
		return existeMenor;
	}
	
/////////////////////// FUNCIONES AUXILIARES ///////////////////////
	
	/** Verifica si todos los numeros de una lista son positivos */
	
	static boolean todosPositivos(int[] lista) {
		boolean todosPositivos = true;
		for (int i=0; i<lista.length; i++)
			todosPositivos = todosPositivos && (lista[i]>0);
		return todosPositivos;
	}
	
	/** Verifica si dentro de una lista existe un numero negativo */
	
	static boolean hayNegativo(int[] lista) {
		boolean existeNegativo = false;
		for (int i=0; i<lista.length; i++)
			existeNegativo = existeNegativo || (lista[i]>0); // Acumulador Booleano
		return existeNegativo;
	}
	
	/** Funcion para determinar si un numero es par */
	
	static boolean par(int numero) {
		return numero%2==0;
	}
	
	/** Funcion para determinar si el numero de una lista es par */
	
	static boolean esPar(int[] lista) {
		boolean pares = true;
		for (int i=0; i<lista.length; i++)
			if (!par(lista[i]))
				return false;
		return pares;
	}
	
	/** Funcion para determinar si los elementos de una lista son pares*/
	
	static boolean esParBoolean(int[] lista) {
		boolean pares = true;
		for (int i=0; i<lista.length; i++)
			pares = pares && (par(lista[i])); // Acumulador Booleano
		return pares;
	}
	
	/** Verifica si dentro de la lista existe numeros mayores a 10 */
	
	static boolean mayor10(int[] lista) {
		boolean mayores = true;
		for (int i=0; i<lista.length; i++)
			mayores = mayores && lista[i]>10; // Acumulador Booleano
		return mayores;
	}
			
///////////////////////////// M A I N /////////////////////////////
	
	public static void main (String[] args) {
		int[][] matriz = {{1,2}, {4,5}, {7,9}};
		for (int j=0; j<matriz.length; j++)
			for (int i=0; i<matriz.length; i++)
				System.out.println(matriz[i][j]);
		
		// Si hay algun negativo en alguna coluna
		
		if (hayNegativoEnAlgunaColumna(matriz))
			System.out.println("Hay negativos");
		System.out.println("No hay negativos");
		
	} // Cierre del Main
	
} // Cierre total del Codigo
