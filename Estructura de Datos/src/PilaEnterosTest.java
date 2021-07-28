import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PilaEnterosTest {

	PilaEnteros p1,p2, pVacia;
	
	@Before
	public void setUp () throws Exception {
		p1= new PilaEnteros();
		p1.apilar(20);
		p1.apilar(15);
		p1.apilar(25);
	
		p2 = new PilaEnteros();
		p2.apilar(4);
		p2.apilar(8);
		
		pVacia = new PilaEnteros();
	}
	
	@Test
	public void testApilar() {
		pVacia.apilar(12);
		assertEquals((Integer)12, pVacia.tope());
	}
	
	@Test
	public void testDesapilar() {
		assertEquals((Integer)8, p2.desapilar());
		p1.desapilar();
		assertEquals((Integer)15, p1.tope());
	}
	
	public void testTope() {
		assertEquals((Integer)25, p1.tope());
		assertEquals((Integer)8, p2.tope());
	}
	
	@Test
	public void testEsVacia() {
		assertFalse(p1.esVacia());
		assertFalse(p2.esVacia());
		assertTrue(pVacia.esVacia());
	}
	
}
