
public class AB<T> {

	protected Nodo<T> raiz;

	public AB() {
		raiz = null;
	}

	public AB(T dato) {
		raiz = new Nodo<T>(dato);
	}
	
	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void agregarNodo(T info) {
		raiz = agregarNodo(info, raiz);
	}

	private Nodo<T> agregarNodo(T info, Nodo<T> nodo) {
		if (nodo == null)
			return new Nodo<T>(info);
		if (nodo.getIzq() == null) {
			nodo.setIzq(agregarNodo(info, nodo.getIzq()));
		} else {
			nodo.setDer(agregarNodo(info, nodo.getDer()));
		}
		return nodo;
	}
	
	public int cantidadNodos() {
		return cantidadNodos(raiz);
	}
	
	public int cantidadNodos(Nodo<T> nodo) {
		if(nodo == null) {
			return 0;
		} else {
			return 1 + cantidadNodos(nodo.getIzq()) + cantidadNodos(nodo.getDer());
		}
	}

	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			return 1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer()));
		}
	}

	public boolean perteneceNodo(T elem) {
		return perteneceNodo(raiz, elem);
	}

	protected boolean perteneceNodo(Nodo<T> nodo, T elem) {
		if (nodo == null) {
			return false;
		}
		if (nodo.getInfo().equals(elem)) {
			return true;
		} else {
			return perteneceNodo(nodo.getIzq(), elem) || perteneceNodo(nodo.getDer(), elem);
		}
	}

	public int cantHojas() {
		return cantHojas(raiz);
	}

	private int cantHojas(Nodo<T> nodo) {
		if (nodo == null)
			return 0;
		if (nodo.getIzq() == null && nodo.getDer() == null)
			return 1;
		else
			return cantHojas(nodo.getIzq()) + cantHojas(nodo.getDer());
	}

	public String mostrar(Nodo<T> n) {
		if (n == null) {
			return "";
		} else {
			return mostrar(n.getIzq()) + n.getInfo().toString() + mostrar(n.getDer());
		}
	}

	public boolean estaBalanceado() {
		return estaBalanceado(raiz);
	}

	private boolean estaBalanceado(Nodo<T> nodo) {
		if (nodo == null) {
			return true;
		}
		return Math.abs(altura(nodo.getIzq()) - altura(nodo.getDer())) >= 1 && estaBalanceado(nodo.getIzq())
				&& estaBalanceado(nodo.getDer());
	}

	public T iesimo(int i) {
		if (i < 0 || i >= cantidadNodos()) {
			return null;
		}
		return iesimo(i, raiz);
	}

	private T iesimo(int i, Nodo<T> nodo) {
		int cantIzq = cantidadNodos(nodo.getIzq());
		if (i == cantIzq) {
			// Caso base: retorno la info del nodo
			return nodo.getInfo();
		}
		if (i < cantIzq) {
			// Llamada recursiva sobre el subarbol izq, el i queda igual
			return iesimo(i, nodo.getIzq());
		} else {
			// Llamada recursiva sobre el subarbol der, al i le
			// resto la cantidad de nodos del subarbol izq + 1 (raiz)
			return iesimo(i - (cantIzq + 1), nodo.getDer());
		}
	}

	// Retorna un string de todos los elementos
	// de un arbol, siguiendo el recorrido inorden.

	public String toString() {
		return "{" + toStringInorden(raiz) + "}";
	}

	private String toStringInorden(Nodo<T> nodo) {
		StringBuilder sb = new StringBuilder();
		if (nodo != null) {
			sb.append(toStringInorden(nodo.getIzq()));
			sb.append(nodo.getInfo()).append(" ");
			sb.append(toStringInorden(nodo.getDer()));
		}
		return sb.toString();
	}

	public T maximaHoja() {
		if (raiz == null) {
			return null;
		}
		return maximaHoja(raiz);
	}

	private T maximaHoja(Nodo<T> nodo) {
		if (nodo.getDer() != null) {
			return maximaHoja(nodo.getDer());
		} else if (nodo.getIzq() != null) {
			return maximaHoja(nodo.getIzq());
		} else {
			return nodo.getInfo();
		}
	}

	public int ramaMasCorta() {
		return ramaMasCorta(raiz);
	}

	private int ramaMasCorta(Nodo<T> nodo) {
		if (nodo.getIzq() == null && nodo.getDer() == null) {
			return 1;
		} else if (nodo.getIzq() == null) {
			return 1 + ramaMasCorta(nodo.getDer());
		} else if (nodo.getDer() == null) {
			return 1 + ramaMasCorta(nodo.getIzq());
		} else {
			return 1 + Math.min(ramaMasCorta(nodo.getIzq()), ramaMasCorta(nodo.getDer()));
		}
	}
	
	public void imprimirEntreConNivel(int nivel) {
		imprimirEntreConNivel(raiz, nivel);
	}
	
	public void imprimirEntreConNivel(Nodo<T> tmp, int nivel) {
		if (tmp != null) {
			imprimirEntreConNivel(tmp.getIzq(), nivel + 1);
			System.out.println(tmp.getInfo() + "(" + (nivel+1) + ") - ");
			imprimirEntreConNivel(tmp.getDer(), nivel + 1);
		}
	}

	public void printBinaryTree(Nodo<Integer> root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.getDer(), level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
				System.out.print(" |\t");
			System.out.println(" |------(" + root.getInfo() + ")");
		} else
			System.out.println("(" + root.getInfo() + ")");
		printBinaryTree(root.getIzq(), level + 1);
	}
	
	public boolean isSymmetric(Nodo<T> node){
		return equalsReflected(node.getIzq(), node.getDer());

	}

	private boolean equalsReflected(Nodo<T> left, Nodo<T> right) {
		if (left == null && right == null) return true;
		else if (left != null && right != null){
			if (left.getInfo() != right.getInfo()) return false;
			else {
				return equalsReflected(left.getIzq(), right.getDer()) && equalsReflected(left.getDer(), right.getIzq());
			}
		}else return false;
	}
	
//	public String gradoDelNodo() {
//		return gradoDelnodo(raiz);
//	}
//
//	private String gradoDelnodo(Nodo<T> nodo) {
//		if (nodo != null) {
//			if (nodo != null) {
//				
//			}
//		}
//	}

	/* Dado un nivel decuelve un string con los nodos que hay en ese nivel */

	public String nodosDelNivel(int nivel) {
		if(getRaiz() == null) {
			return "";
		} else {
			return nodosDelNivel(getRaiz(),nivel,0);
		}
	}
	
	private String nodosDelNivel(Nodo<T> nodo,int nivel,int nivelActual) {
		StringBuilder string = new StringBuilder();
		if(nodo == null) {
			return string.toString();
		} else if (nivel == nivelActual) {
			return string.append("[").append(nodo.getInfo()).append("]").toString();
		} else {
			return string.append(nodosDelNivel(nodo.getIzq(),nivel,nivelActual+1))
						 .append(nodosDelNivel(nodo.getDer(),nivel,nivelActual+1)).toString();	
		}
	}
	
	public int cantidadNodosNoHojas() {
		return cantidadNodosNoHojas(raiz);
	}

	private int cantidadNodosNoHojas(Nodo<T> nodo) {
		if (nodo == null) {
			return 0;
		}
		if (nodo.getDer()!=null || nodo.getIzq() != null) {
			return 1 + cantidadNodosNoHojas(nodo.getDer()) + cantidadNodosNoHojas(nodo.getIzq());
		}  else {
			return 0;
		}
	}
	
	public int sumaDeHojas() {
		return sumaNoHojas(raiz);
	}

	private int sumaDeHojas(Nodo<T> nodo) {
		if (nodo != null) {
			return (int) nodo.getInfo();
		}
		if (nodo.getDer()==null && nodo.getIzq() == null) {
			return (int) nodo.getInfo() + sumaDeHojas(nodo.getDer()) + sumaDeHojas(nodo.getIzq());
		}  else {
			return 0;
		}
	}
	
	public int sumaNoHojas() {
		return sumaNoHojas(raiz);
	}

	private int sumaNoHojas(Nodo<T> nodo) {
		if (nodo == null) {
			return 0;
		}
		if (nodo.getDer()==null && nodo.getIzq() == null) {
			return (int) nodo.getInfo();
		}  else {
			return sumaNoHojas(nodo.getDer()) + sumaNoHojas(nodo.getIzq());
		}
	}
	
	public int sumaInternos() {
		if(getRaiz() == null) {
			return 0;
		} else {
			return sumaInternos(getRaiz());
		}
	}
	
	private int sumaInternos(Nodo<T> nodo) {
		if(nodo == null) {
			return 0;
		}	
		if(nodo == getRaiz()) {
			return sumaInternos(nodo.getIzq()) + sumaInternos(nodo.getDer());
		}
		if(nodo.getIzq() != null || nodo.getDer() != null) {
			return (int)nodo.getInfo() + sumaInternos(nodo.getIzq()) + sumaInternos(nodo.getDer());
		}
		return 0;
	}
	
	public void reemplazaConIzq() {
		if (raiz != null) {
			reemplazaConIzq(raiz);
		}
	}

	private void reemplazaConIzq(Nodo<T> nodo) {
		if (nodo != null) {
			if (nodo.getIzq() != null) {
				nodo.setInfo(nodo.getIzq().getInfo());
			}
			reemplazaConIzq(nodo.getIzq());
			reemplazaConIzq(nodo.getDer());
		}
	}
	
	public int nodosConUnHijo() {
		return nodosConUnHijo(raiz);
	}

	private int nodosConUnHijo(Nodo<T> nodo) {
		if (nodo.getDer() == null && nodo.getIzq() == null) {
			return 0;
		}
		if ((nodo.getDer()==null && nodo.getIzq() != null)) {
			return 1 + nodosConUnHijo(nodo.getIzq());
		} else if (nodo.getDer()!=null && nodo.getIzq() == null){
			return 1 + nodosConUnHijo(nodo.getDer());
		}
		return nodosConUnHijo(nodo.getIzq()) + nodosConUnHijo(nodo.getDer());
	}

}
