import java.util.ArrayList;

public class Diccionario2<T1, T2> {

	ArrayList<Tupla<T1, T2>> elems;
	Conjunto<T1> claves;
	
	public Diccionario2() {
		elems = new ArrayList<>();
		claves = new Conjunto<>();
	}
	
	public void insertar(T1 clave, T2 valor) {
		if (!pertenece(clave)) {
			elems.add(new Tupla<>(clave, valor));
			claves.agregar(clave);
		}
	}
	
	public void eliminar(T1 clave) {
		if (pertenece(clave)) {
			claves.quitar(clave);
			elems.remove(elemento(clave));
		}
	}
	
	public boolean pertenece(T1 clave) {
		return claves.pertenece(clave);
	}
	
	public T2 obtener(T1 clave) {
		if (pertenece(clave)) {
			Tupla<T1, T2> aux = elemento(clave);
			return aux.getY();
		} else {
			throw new RuntimeException("Clave inexistente");
		}
	}
	
	public boolean vacio() {
		return claves.esVacio();
	}
	
	private Tupla<T1, T2> elemento(T1 clave) {
		for (int i = 0; i < elems.size(); i++) {
			if (elems.get(i).getX().equals(clave)) {
				return elems.get(i);
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
