package SistemaNotas_Entregable;

import java.util.ArrayList;

public class Conjunto<T> {

	/*
	 * IREP:
	 * 	
	 * Para todo par de enteros 0 <= i != j < conj.length 
	 * 		conj.get(i).equals (conj.get(j)) = false
	 * 
	 * indice >= 0 && indice <= conj.length
	 * 
	 */
	
	private ArrayList<T> conj;
	private int indice;
	
	// Crear un conjunto vacio
	
	public Conjunto() {
		conj = new ArrayList<T>();
		indice = 0;
	}
	
	// Agregar un elemento y que no esté duplicado dentro del conjunto

	public boolean pertenece(T elem) {
		return conj.contains(elem);
	}
	
	public boolean agregar(T elem) {
		if (pertenece(elem))
			return false;
		return conj.add(elem);
	} 
	
	// Quitar un elemento
	
	public boolean quitar(T elem) {
		boolean elim = conj.remove(elem);
		if (indice > tamanio())
			indice = tamanio();
		return elim;
	}
	
	// Verificar si un conjunto esta vacio
	
	public boolean esVacio() {
		return tamanio()==0;
	}
	
	// Tamaño del conjunto
	
	public int tamanio() {
		return conj.size();
	}
	
	// Obtener un elemento del conjunto
	
	public T dameUno() {
		if (esVacio())
			return null;
		if (indice == tamanio())
			indice = 0;
		return conj.get(indice++);
	}
	
	//////// Utilizar solo la representacion //////////
	
	// La unión quedara en el conjunto this (es destructiva)
	
	public void union(Conjunto<T> otroConj) {
		for (int i = 0; i < otroConj.tamanio(); i++) {
				this.agregar(otroConj.dameUno());
		}
	}
	
	// La unión queda en el retorno del metodo
	// No destructiva (el this queda sin cambios)
	
	public Conjunto<T> union2(Conjunto<T> otroConj) {
		Conjunto<T> ret = new Conjunto<T>();
		ret.union(this);
		ret.union(otroConj);
		return ret;
	}
	
	// La interseccion quedara en el conjunto this (destructiva)
	
	public void interseccion(Conjunto<T> otroConj) {
		
	}
	
	// La interseccion queda en el retorno del metodo
	
	public Conjunto<T> interseccion2(Conjunto<T> otroConj) {
		return new Conjunto<T>();
	}
	
} // Cierre total de la clase
