
public class DiccionarioConjunto<C, V> {

	private Conjunto<Tupla<C,V>> entradas;
	
	public void Diccionario () {
		entradas = new Conjunto<Tupla<C,V>>();
	}
	
	public boolean estaDefinida(C clave) {
		return entradas.pertenece(new Tupla<C,V>(clave, null));
	}
	
	public void definir(C clave, V valor) {
		Tupla<C,V> tup = new Tupla<C,V>(clave, valor);
		// Se quita antes, por si la clave ya esta definida.
		// Si no, el agregar del conjunto no pisaria la definicion.
		entradas.quitar(tup);
		entradas.agregar(tup);
	}
	
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
	
	public int tamanio() {
		return entradas.tamanio();
	}
	
	public boolean esVacio() {
		return tamanio() == 0;
	}
	
	public boolean eliminar(C clave) {
		return entradas.quitar(new Tupla<C, V>(clave, null)); 
	}
	
	public Conjunto<C> claves() {
		Conjunto<C> claves = new Conjunto<C>();
		for (int i = 0; i < entradas.tamanio(); i++) {
			claves.agregar(entradas.dameUno().getX());
		}
		return claves;
	}
	
	
	
	
}
