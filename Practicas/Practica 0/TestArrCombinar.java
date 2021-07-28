import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestArrCombinar {
	@Test
	public void ejemploConsigna() {
		int[] a = { 4, 7, 9, 15, 35, 39 };
		int[] b = { 1, 2, 5, 9, 14, 30, 50 };
		int[] res = { 1, 2, 4, 5, 7, 9, 9, 14, 15, 30, 35, 39, 50 };
		assertArrayEquals(res, Funciones.combinarOrdenados(a, b));
	}

	@Test
	public void secuenciados() {
		int[] a = { 0, 1, 2, 3, 4 };
		int[] b = { 5, 6, 7, 8, 9 };
		int[] res = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assertArrayEquals(res, Funciones.combinarOrdenados(b, a));
	}

	@Test
	public void cantidadesDiferentes() {
		int[] a = { 2, 4, 6 };
		int[] b = { 1, 3, 5, 7, 8, 9, 10, 11, 12 };
		int[] res = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		assertArrayEquals(res, Funciones.combinarOrdenados(b, a));
	}

	@Test
	public void valoresNegativos() {
		int[] a = { -10, -5, 15 };
		int[] b = { 0, 10, 20 };
		int[] res = { -10, -5, 0, 10, 15, 20 };
		assertArrayEquals(res, Funciones.combinarOrdenados(b, a));
	}

	@Test
	public void duplicados() {
		int[] a = { 20, 25, 40, 50, 60 };
		int[] b = { 20, 30, 40, 50, 50, 50 };
		int[] res = { 20, 20, 25, 30, 40, 40, 50, 50, 50, 50, 60 };
		assertArrayEquals(res, Funciones.combinarOrdenados(b, a));
	}

	@Test
	public void arreglosVacios() {
		int vacio[] = {};
		int arreglo[] = { 2, 4, 6 };
		assertArrayEquals(vacio, Funciones.combinarOrdenados(vacio, vacio));
		assertArrayEquals(arreglo, Funciones.combinarOrdenados(vacio, arreglo));
		assertArrayEquals(arreglo, Funciones.combinarOrdenados(arreglo, vacio));
	}
}
