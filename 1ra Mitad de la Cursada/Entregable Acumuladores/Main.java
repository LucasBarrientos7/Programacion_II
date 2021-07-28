package Tarea1Acumuladores;

public class Main {

	public static void main(String[] args) {

		 int mat2 [][] =  {{2,5,6,9,10,20}, {10,12,14,16,23, 45}, {18,20,22,24, 18, 33}, {18,21,22,24, 44, 55}};
		 int mat3 [][]  = {{2,4,6,8},{10,12,14,16},{18,20,22,24}};
		 int mat4 [][] =  {{2,4,6,8,10,20}, {10,12,14,16,23, 45}, {18,20,22,24, 18, 33}, {18,21,22,24, 44, 55}};
		 int lista [] =   {10,12,14,16};

		 Acumuladores.imprimirPorFilas(mat3);
		 System.out.println();

		 Acumuladores.imprimirPorColumnas(mat3);
		 System.out.println();

		 Acumuladores.imprimirLista(lista);
		 System.out.println();

		 System.out.println(Acumuladores.algunaFilaIgualLista(mat3, lista));
		 System.out.println(Acumuladores.algunaFilaSumaMenosQue30(mat3));
		 System.out.println(Acumuladores.algunaFilaSumaMenosQue30(mat4));
		 System.out.println(Acumuladores.algunaFilaParYColMasQue50(mat4));
		 System.out.println(Acumuladores.algunaFilaParYColMasQue50(mat2));
	}

}
