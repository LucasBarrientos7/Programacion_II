import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testABB {

	ABB<Integer> abb1;
	
	@BeforeEach
	void setUp() throws Exception {
		abb1 = new ABB<Integer>();
		abb1.agregarNodo(25);
		abb1.agregarNodo(12);
		abb1.agregarNodo(35);
		abb1.agregarNodo(43);
		abb1.agregarNodo(15);
		abb1.agregarNodo(2);
		abb1.agregarNodo(5);
		abb1.agregarNodo(4);
		abb1.agregarNodo(10);
		abb1.agregarNodo(8);
	}

	@Test
	void testMinimo() {
		assertEquals((Integer)2, abb1.minimo());
	}
	
	@Test
	void testNivel() {
		assertEquals(4, abb1.nivel(5));
		assertEquals(-1, abb1.nivel(28)); // 28 no está
		assertEquals(6, abb1.nivel(8));
	}
	
	@Test
	void testToString() {
		System.out.println(abb1.toString());
	}
	
	@Test
	void testElemEntre() {
		assertEquals(abb1.elemEntre(5, 15), "{58101215}");
	}
	
	@Test
	void testElemEnSubrama() {
		assertEquals(3, abb1.elemEnSubrama(15));
		assertEquals(abb1.elemEntre(2, 15), "{2458101215}");

		assertEquals(0, abb1.elemEnSubrama(13));
		assertEquals(abb1.elemEntre(2, 13), "{}");
	}

}
