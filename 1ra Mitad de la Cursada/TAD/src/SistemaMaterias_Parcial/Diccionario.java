package SistemaMaterias_Parcial;

public class Diccionario<C, V> {

	private Conjunto<Tupla<C,V>> entradas;
	
	/** Constructor Diccionario */
	
	public Diccionario () {
		entradas = new Conjunto<>();
	}
	
	/*	Metodo que agrega una clave y su valor a un Diccionario
	 * 
	 * 1. Verificar que la clave no este en el conjunto
	 * 2. si la clave no esta, crear la tupla
	 * 3. agregar la tupla al conjunto de tuplas
	 * 4. si la clave esta, acualizar el significado
	 */
	
	public void agregar(C clave, V valor) {
		if (!perteneceAlDicc(clave)) {
			entradas.agregar(new Tupla<>(clave, valor));
		} else { // Si encuentra la clave modifica su valor
			Tupla<C, V> tupla = dameEntradaConClave(clave);
			tupla.setY(valor);
		}
	}
	
	/** Busca a partir de una clave si existe en un diccionario y la devuelve si la encuentra */
	
	private Tupla<C, V> dameEntradaConClave(C clave){
		Tupla<C, V> ret = null;
		int i = 0;
		while(ret == null && i < entradas.tamanio()) {
			Tupla<C, V> tupla = dameElemento();
			if (tupla.getX().equals(clave)) {
				ret = tupla;
			i++;
			}
		}
		return ret;
	}
	
	/** A partir de una clave devuelve su valor */
	
	public V obtener(C clave) {
		return dameValor (clave);
	}
	
	/** A partir de una clave, lo busca en ele diccionario y devuelve su valor */
	
	private V dameValor(C clave) {
		 V ret = null;
		int i = 0;
		while(ret == null && i < entradas.tamanio()) {
			Tupla<C, V> tupla = dameElemento();
			if (tupla.getX().equals(clave)) {
				ret = tupla.getY();
			i++;
			}
		}
		return ret;
	}
	
	/** Verifica si una clave existe en un diccionario */
	
	public boolean pertenece(C clave) {
		boolean ret = false;
		int i = 0;
		while (!ret && i< entradas.tamanio()) {
			ret = ret || dameClave().equals(clave);
			i++;
		}
		return ret;
	}
	
	/** Devuelve una clave de un Diccionario */
	
	private C dameClave() {
		return entradas.dameUno().getX();
	}
	
	/** Devuelve un elemento de un Diccionario */
	
	private Tupla<C, V> dameElemento(){
		return entradas.dameUno();
	}
	
	/** Metodo que escribe en pantalla todos los elementos */
	
	@Override
	public String toString() {
		return entradas.toString();
	}
	
	/** Verifica si una clave existe en un diccionario */
	
	public boolean perteneceAlDicc(C clave) {
		return entradas.pertenece(new Tupla<C,V>(clave, null));
	}
	
	/** Elimina una clave por si llegase a existir en el diccionario y crea un nuevo elemento */
	
	public void definir(C clave, V valor) {
		Tupla<C,V> tup = new Tupla<C,V>(clave, valor);
		// Se quita antes, por si la clave ya esta definida.
		// Si no, el agregar del conjunto no pisaria la definicion.
		entradas.quitar(tup);
		entradas.agregar(tup);
	}
	
	/** A partir de una clave, lo busca en ele diccionario y devuelve su valor */

	public V definicion(C clave) {
		Tupla<C,V> tup;
		V definicion = null;
		for (int i = 0; definicion==null && i < entradas.tamanio(); i++) {
			tup = entradas.dameUno();
			if (tup.getX().equals(clave)) {
				definicion = tup.getY();
			}
		}
		return definicion;
	}
	
	/** Devuelve la cantidad de elementos */
	
	public int tamanio() {
		return entradas.tamanio();
	}
	
	/** Verifica si esta vacio el diccionario */
	
	public boolean esVacio() {
		return tamanio() == 0;
	}
	
	/** Elimina una clave */
	
	public boolean eliminar(C clave) {
		return entradas.quitar(new Tupla<C, V>(clave, null)); 
	}
	
	/* Devuelve el conjunto de claves */
	
	public Conjunto<C> claves() {
		Conjunto<C> claves = new Conjunto<C>();
		for (int i = 0; i < entradas.tamanio(); i++) {
			claves.agregar(entradas.dameUno().getX());
		}
		return claves;
	}
	
} // Cierre total de la Clase 
