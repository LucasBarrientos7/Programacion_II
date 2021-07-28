import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAccumMatriz {
	@Test
	public void ejemploConsigna1() {
		int[][] mtx = {{1, 2, 3}, {4, 5, 6}};
		assertTrue(Funciones.mayorDiversidad2(mtx));
	}
	
	@Test
	public void ejemploConsigna2() {
		int[][] mtx = {{1, 2, 3}, {4, 5, 5}};
		assertFalse(Funciones.mayorDiversidad2(mtx));
	}

	@Test
	public void ejemploConsigna3() {
		int[][] mtx = {{1, 2, 3}, {2, 4, 6}};
		assertFalse(Funciones.mayorDiversidad2(mtx));
	}
	
	// TODO: añadir más tests.
}
