import java.util.LinkedList;

public class Pila<T> {
	private LinkedList<T> pila;
	
	public Pila() {
		this.pila = new LinkedList<>();
	}

	public void apilar(T elem) {
		pila.addLast(elem);
	}
	
	public T desapilar() {
		return pila.removeLast();
	}
	
	public T tope() {
		return pila.getLast();
	}
	
	public boolean esVacia() {
		return pila.isEmpty();
	}

}
