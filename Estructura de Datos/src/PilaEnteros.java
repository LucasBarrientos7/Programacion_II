import java.util.LinkedList;

public class PilaEnteros {
	private LinkedList<Integer> pila;
	
	public PilaEnteros() {
		this.pila = new LinkedList<Integer>();
	}
	
	public void apilar(Integer elem) {
		pila.addLast(elem);
	}
	
	public Integer desapilar() {
		return pila.removeLast();
	}
	
	public Integer tope() {
		return pila.getLast();
	}
	
	public boolean esVacia() {
		return pila.isEmpty();
	}

}
