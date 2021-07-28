
public class Main {

	public static void main(String[] args) {
		ABB<Integer> arbolBinario = new ABB<Integer>();
		arbolBinario.agregarNodo(18);
		arbolBinario.agregarNodo(12);
		arbolBinario.agregarNodo(39);
		arbolBinario.agregarNodo(5);
		arbolBinario.agregarNodo(45);
		arbolBinario.agregarNodo(3);
		arbolBinario.agregarNodo(10);
		arbolBinario.agregarNodo(40);
		
		
		arbolBinario.printBinaryTree(arbolBinario.getRaiz(), 0);
		System.out.println(arbolBinario.mayoresNoHojas(40));
		




	}
	


}
