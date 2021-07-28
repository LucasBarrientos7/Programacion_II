import java.util.ArrayList;

/*
 * Un conjunto no puede tener elementos repetidos sean del mismo tipo.
 * No es necesario el orden.
 * 
 * Datos privadas(tipo de Estructura de dato a utilizar y variables)
 * 
 * Interfaz
 * 
 * Constructor y los metodos correspondientes
 * 
 */

public class ConjuntoInteger {

	private ArrayList<Integer> elementos;
	private int actual; 
	
	public ConjuntoInteger() {
		elementos = new ArrayList<Integer>();
	}
	
	public void agregar(Integer elem) {
		if (!pertenece(elem))	
			elementos.add(elem);
	} 
	
	// Agregar un elemento y que no esté duplicado dentro del conjunto

	public boolean pertenece(Integer elem) {
		return elementos.contains(elem);
	}
	
	// Quitar un elemento
	
	public void quitar(Integer elem) {
		elementos.remove(elem);
	}
	
	// Verificar si un conjunto esta vacio
	
	public boolean esVacio() {
		return tamanio()==0;
	}
	
	// Tamaño del conjunto
	
	public int tamanio() {
		return elementos.size();
	}
	
	
	public Integer dameElemento() {
		Integer aux = null;
		if (!esVacio()) {
			aux = elementos.get(actual);
		}
		actual ++;
		if (actual == elementos.size()) {
			actual = 0;
		}
		return aux;
	}
	
	public ConjuntoInteger union(ConjuntoInteger c) {
		ConjuntoInteger nuevo = new ConjuntoInteger();
		for (int i = 0; i < tamanio(); i++) { // Recorre el conjunto actual
			nuevo.agregar(new Integer(this.dameElemento())); // Se crea un elemento nuevo para que no exista un Aliasing
		}
		for (int i = 0; i < c.tamanio(); i++) { // Recorre el conjunto pasado como parametro
			nuevo.agregar(new Integer(c.dameElemento()));
		}
		return nuevo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
