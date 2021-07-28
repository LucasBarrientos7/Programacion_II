
import static  org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ConjuntoTest {
	
	Conjunto<Integer> c1, c2, cVacio;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Conjunto<Integer>();
		c1.agregar(20);
		c1.agregar(30);
		c1.agregar(17);
		
		c1 = new Conjunto<Integer>();
		c2.agregar(17);
		c2.agregar(13);
		
		cVacio = new Conjunto<Integer>();
	}
	
	@Test
	public void testPertenece() {
		assertTrue(c1.pertenece(30));
		assertFalse(c2.pertenece(30));
		assertTrue(c2.pertenece(17));
		assertFalse(cVacio.pertenece(13));
	}
	
	@Test
	public void testAgregar() {
		cVacio.agregar(20);
		assertTrue(cVacio.pertenece(20));
		
		assertFalse(c1.agregar(30));
		assertEquals(3, c1.tamanio());
	}
	
	@Test
	public void testQuitar() {
		assertTrue(c1.quitar(30));
		assertEquals(2, c1.tamanio());
		
		assertFalse(c1.quitar(30));
		assertEquals(2, c1.tamanio());
	}
	
	@Test
	public void testVacio() {
		assertFalse(c1.esVacio());
		assertFalse(c2.esVacio());
		assertTrue(cVacio.esVacio());
	}
	
	@Test
	public void testTamanio() {
		assertEquals(3, c1.tamanio());
		assertEquals(2, c2.tamanio());
		assertEquals(0, cVacio.tamanio());
	}
	
	@Test
	public void testUnion() {
		c1.union(c2);
		assertEquals(4, c1.tamanio());
		assertTrue(c1.pertenece(13));
		assertTrue(c1.pertenece(17));
		assertTrue(c1.pertenece(20));
		assertTrue(c1.pertenece(30));
	}
	
	@Test
	public void testUnion2() {
		Conjunto<Integer> c3 = c1.union2(c2);
		assertEquals(4, c3.tamanio());
		assertEquals(3, c1.tamanio());
		assertEquals(2, c2.tamanio());
		assertTrue(c3.pertenece(13));
		assertTrue(c3.pertenece(17));
		assertTrue(c3.pertenece(20));
		assertTrue(c3.pertenece(30));
	}
	
}
