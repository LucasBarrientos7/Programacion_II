import java.util.ArrayList;

public class Diccionario<C,V> {

	private ArrayList<Tupla<C,V>> entradas;
	
	public Diccionario() {
		entradas = new ArrayList<Tupla<C,V>>();
	}
	
	public boolean estaDefinida(C clave) {
		boolean ret = false;
		for (int i = 0; i < entradas.size(); i++) {
			ret = ret || entradas.get(i).equals(clave);
		}
//		for (Tupla<C, V> entrada : this.entradas) {
//			if (entrada.getX().equals(clave)) {
//				return true;
//			}
//		}
		return ret;
	}
	
	public void definir(C clave, V valor) {
		if (!estaDefinida(clave)) {
			entradas.add(new Tupla<C,V>(clave, valor));
		} else {
			for (int i = 0; i < entradas.size(); i++) {
				if (entradas.get(i).getX().equals(clave)) {
					entradas.get(i).setY(valor);
				}
			}
		}
	}
	
	public V definicion(C clave) {
		for (int i = 0; i < entradas.size(); i++) {
			if (entradas.get(i).getX().equals(clave)) {
				return entradas.get(i).getY();
			}
		}
		return null;
	}
	
	public int tamanio() {
		return 0;
	}
	
	public boolean esVacio() {
		return true;
	}
	
	public boolean eliminar (C clave) {
		return false;
	}
	
	
	
	
	
}
