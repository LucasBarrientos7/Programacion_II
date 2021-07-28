import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testAB {

	ABB<Integer> arbol, ab2;
	String mostrarEnOrden;
	int alturaEsperada;

	@BeforeEach
	void setUp() throws Exception {
		arbol = new ABB<>();
		arbol.agregarNodo(10); // ----> Raiz
		arbol.agregarNodo(15);
		arbol.agregarNodo(13);
		arbol.agregarNodo(5);
		arbol.agregarNodo(7);
		arbol.agregarNodo(3);
		alturaEsperada = 3;

		// Es un arbol muy chico y no sirve para validar 
		// que se organicen correctamente en el ABB:
		
		mostrarEnOrden = "3 5 7 10 13 15";
	}

	@Test
	void testNuevoVacio() {
		ABB<Integer> arbolNuevo = new ABB<>();
		assertEquals(0, arbolNuevo.altura());
	}

	@Test
	void testAltura() {
		ABB<Integer> arbolNuevo = new ABB<>();
		assertEquals(0, arbolNuevo.altura());
		assertEquals(alturaEsperada, arbol.altura());
	}

	@Test
	void testAgregarElementoRepetido() {
		// Agrego un elemento existente
		int tamanioInicial = arbol.altura();
		arbol.agregarNodo(15);
		assertEquals(tamanioInicial, arbol.altura());
	}

	@Test
	void testAgregarElementoNuevo() {
		int tamanioInicial = arbol.altura();
		assertFalse(arbol.perteneceNodo(20));

		arbol.agregarNodo(20);
		int tamanioActual = tamanioInicial;

		assertEquals(tamanioActual, arbol.altura());
		assertTrue(arbol.perteneceNodo(20));
	}

	@Test
	public void testMostrar() {
		assertEquals(mostrarEnOrden, arbol.mostrar());
	}

	// Agregar el quitar para pasar el test:

	@Test
	public void testQuitarElementoIncluido() {
		int tamanio = arbol.altura();
		assertTrue(arbol.perteneceNodo(15));

		//arbol.quitar(15);
		tamanio--;

		assertEquals(tamanio, arbol.altura());
		assertFalse(arbol.perteneceNodo(15));
	}

	@Test
	public void testQuitarElementoNoIncluido() {
		int tamanio = arbol.altura();
		assertFalse(arbol.perteneceNodo(20));

		//arbol.quitar(20);

		assertEquals(tamanio, arbol.altura());
	}

}
