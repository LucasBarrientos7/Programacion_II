
public class Nodo<T> {

	private T info;
	private Nodo<T> izq, der;
	
	public Nodo(T dato) {
		info = dato;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Nodo<T> getIzq() {
		return izq;
	}

	public void setIzq(Nodo<T> izq) {
		this.izq = izq;
	}

	public Nodo<T> getDer() {
		return der;
	}

	public void setDer(Nodo<T> der) {
		this.der = der;
	}

	public String toString() {
		return String.valueOf(info); // Si es null muestra "null" y si no ejecuta normal
	}
	
}
