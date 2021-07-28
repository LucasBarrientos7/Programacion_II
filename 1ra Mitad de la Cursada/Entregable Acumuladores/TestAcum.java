package Tarea1Acumuladores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAcum {

	private int cantF = 5;
	private int cantC = 10;
	private int mat1 [][] = new int[cantF][cantC];
	private int mat2 [][]  = {{10,12,14,16},{2,4,6,8},{18,20,22,24}};
	private int mat3 [][] =  {{2,4,6,8,10,20}, {10,12,14,16,23,45}, {18,20,22,24,18,33}, {18,21,22,24,44,55}};
	private int lista [] = {10,12,14,16};

	@Before
	public void setUp() throws Exception {
		for (int i=0; i<cantF; i++) {
			for (int j=0; j<cantC; j++) {
				mat1[i][j]=2*(i+j);
			}
		}
	}

	@Test
	public void testTodosPares() {
		assertTrue(Acumuladores.todosPares(mat1));
	}

	@Test
	public void testAlgunaFilaPar() {
		assertTrue(Acumuladores.algunaFilaPar(mat3));
	}

	@Test
	public void testAlgunaFilaSumaMenosQue30() {
		assertFalse(Acumuladores.algunaFilaSumaMenosQue30(mat3));
		assertTrue(Acumuladores.algunaFilaSumaMenosQue30(mat2));
	}

	@Test
	public void testColuMasQue50() {
		assertTrue(Acumuladores.algunaColSumaMasQue50(mat1));
	}

	@Test
	public void testaAlgunaFilaParYColMasQue50() {
		assertTrue(Acumuladores.algunaFilaParYColMasQue50(mat1));
	}

	@Test
	public void testAlgunaFilaIgualLista() {
		assertTrue(Acumuladores.algunaFilaIgualLista(mat2, lista));
	}

}
