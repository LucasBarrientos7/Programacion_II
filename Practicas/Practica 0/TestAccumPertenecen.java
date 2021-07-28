import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAccumPertenecen {
	@Test
	public void perteneceUno() {
		int elems[] = { 6 };
		int conjunto[] = { 2, 4, 6, 8 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void pertenecenVarios() {
		int elems[] = { 2, 4, 6 };
		int conjunto[] = { 1, 2, 3, 4, 5, 6, 7 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void perteneceConDuplicadosElems() {
		int elems[] = { 2, 4, 2 };
		int conjunto[] = { 4, 2 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void noPerteneceNinguno() {
		int elems[] = { 2, 4, 6 };
		int conjunto[] = { 1, 3, 5, 7, 9 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void noPerteneceUltimo() {
		int elems[] = { 2, 4, 6 };
		int conjunto[] = { 5, 4, 3, 2, 1 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void noPerteneceConDuplicadosCjto() {
		int elems[] = { 2, 4, 6 };
		int conjunto[] = { 2, 4, 2 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void perteneceVacio() {
		int elems[] = {};
		int conjunto[] = { 1, 2, 3 };
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void perteneceVacioEnVacio() {
		int elems[] = {};
		int conjunto[] = {};
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}

	@Test
	public void noPerteneceNadieEnVacio() {
		int elems[] = { 1 };
		int conjunto[] = {};
		assertTrue(Funciones.pertenecenTodos(elems, conjunto));
	}
}
