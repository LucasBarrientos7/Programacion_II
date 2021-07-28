
public class ABB<T extends Comparable<T>> extends AB<T> {

	public ABB() {
		raiz = null;
	}

	public ABB(T dato) {
		raiz = new Nodo<T>(dato);
	}

	public boolean perteneceNodo(T info) {
		return perteneceNodo(info, raiz);
	}

	protected boolean perteneceNodo(T info, Nodo<T> nodo) { // El peor caso es la altura del Arbol
		if (nodo == null) {
			return false;
		}
		if (info.equals(nodo.getInfo())) {
			return true;
		}
		if (info.compareTo(nodo.getInfo()) < 0) {
			return perteneceNodo(nodo.getIzq(), info);
		} else {
			return perteneceNodo(nodo.getDer(), info);
		}
	}

	public void agregarNodo(T info) {
		raiz = agregarNodo(info, raiz);
	}

	protected Nodo<T> agregarNodo(T info, Nodo<T> nodo) {
		if (nodo == null) {
			return new Nodo<T>(info);
		}
		if (nodo.getInfo().compareTo(info) > 0) {
			nodo.setIzq(agregarNodo(info, nodo.getIzq()));
		} else if (nodo.getInfo().compareTo(info) < 0) {
			nodo.setDer(agregarNodo(info, nodo.getDer()));
		}
		return nodo;
	}

	public String mostrar() {
		return mostrar(raiz);
	}

	public String mostrar(Nodo<T> n) {
		if (n == null) {
			return "";
		} else {
			return (mostrar(n.getIzq()) + " " + n.getInfo() + " " + mostrar(n.getDer())).trim();
		}
	}

	public T minimo() {
		if (raiz == null) {
			return null;
		}
		return minimo(raiz);
	}

	private T minimo(Nodo<T> nodo) {
		if (nodo.getIzq() == null) {
			return nodo.getInfo();
		}
		return minimo(nodo.getIzq());
	}

	public int nivel(T elem) {
		if (!perteneceNodo(elem)) {
			return -1;
		}
		return nivel(elem, raiz);
	}

	private int nivel(T elem, Nodo<T> nodo) {
		if (nodo.getInfo().equals(elem)) {
			return 1;
		}
		if (nodo.getInfo().compareTo(elem) > 0) {
			return 1 + nivel(elem, nodo.getIzq());
		} else {
			return 1 + nivel(elem, nodo.getDer());
		}
	}

	public String elemEntre(T elem1, T elem2) {
		if (perteneceNodo(elem1) && perteneceNodo(elem2)) {
			return "{" + elemEntre(elem1, elem2, raiz) + "}";
		}
		return "{}";
	}

	public ABB<T> replicarEnPreOrden() {

		return replicarEnPreOrden(getRaiz(), new ABB<T>());
	}

	private ABB<T> replicarEnPreOrden(Nodo<T> nodo, ABB<T> replica) {

		if (nodo != null) {
			replica.agregarNodo(nodo.getInfo());
			return replicarEnPreOrden(nodo.getDer(), replicarEnPreOrden(nodo.getIzq(), replica));
		}

		return replica;
	}

	private String elemEntre(T elem1, T elem2, Nodo<T> nodo) {
		if (nodo == null) {
			return "";
		}
		String st = "";
		if (nodo.getInfo().compareTo(elem1) >= 0 && nodo.getInfo().compareTo(elem2) <= 0) {
			st = st + nodo.getInfo();
		}
		return elemEntre(elem1, elem2, nodo.getIzq()) + st + elemEntre(elem1, elem2, nodo.getDer());
	}

	// Dado un valor devuelve la cantidad de elementos de la
	// subrama a la que pertenece o 0 en caso en caso contrario.

	public int elemEnSubrama(T elem) {
		if (!this.perteneceNodo(elem)) {
			return 0;
		}
		return elemEnSubrama(raiz, elem);
	}

	private int elemEnSubrama(Nodo<T> actual, T elem) {
		if (actual.getInfo().equals(elem)) {
			return 1;
		}
		if (actual.getInfo().compareTo(elem) > 0) {
			return 1 + elemEnSubrama(actual.getIzq(), elem);
		}
		return 1 + elemEnSubrama(actual.getDer(), elem);
	}

	public String ramaDondeSeInserta(T elemento) {
		if (!perteneceNodo(elemento)) {
			return ramaDondeSeInserta(elemento, raiz);
		}
		return null;
	}

	private String ramaDondeSeInserta(T elemento, Nodo<T> nodo) {
		String nuevo = " ";
		if (nodo == null) {
			return "{}";
		}
		if (nodo.getInfo().compareTo(elemento) > 0) {
			nuevo += nodo.getInfo() + ramaDondeSeInserta(elemento, nodo.getIzq());
		}
		if (nodo.getInfo().compareTo(elemento) < 0) {
			nuevo += nodo.getInfo() + ramaDondeSeInserta(elemento, nodo.getDer());
		}
		return nuevo;
	}

	public int mayoresQue(T elem) {
		return mayoresQue(raiz, elem);
	}

	private int mayoresQue(Nodo<T> nodo, T elem) {
		if (nodo == null) {
			return 0;
		}
		if (elem.compareTo(nodo.getInfo()) < 0) {
			return 1 + mayoresQue(nodo.getDer(), elem) + mayoresQue(nodo.getIzq(), elem);
		} else {
			return mayoresQue(nodo.getDer(), elem);
		}
	} // O(n) en ambos casos.

	// ************ Implementar *************************

	// Cantidad de nodos de distancia
	public int elemsPasandoPorRaiz(T elem1, T elem2) {
		return 0;
	}

	public int mayoresNoHojas(T elem) {
		return mayoresNoHojas(raiz, elem);
	}

	private int mayoresNoHojas(Nodo<T> nodo, T elem) {
		if (nodo == null) {
			return 0;
		}
		if (nodo.getDer()== null && nodo.getIzq()== null) {
			return 0;
		}
		if (elem.compareTo(nodo.getInfo()) < 0) {
			return 1 + mayoresNoHojas(nodo.getDer(), elem) + mayoresNoHojas(nodo.getIzq(), elem);
		} else {
			return mayoresNoHojas(nodo.getDer(), elem);
		}
	} 
	
	// O(n) en ambos casos.

}
