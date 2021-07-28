import java.util.ArrayList;

public class ListaOrdenada<T extends Comparable<T>> {

	private ArrayList<T> datos;
	
	public ListaOrdenada() {
		datos = new ArrayList<T>();
	}
	
	// Inserta elem de manera que el arraylist datos
	// quede siempre ordenado de menor a mayor:
	public void agregar(T elem) {
		int i = 0;
		while (i<datos.size() && elem.compareTo(datos.get(i))>0) {
			i++;
		}
		datos.add(i, elem);
	}

	@Override
	public String toString() {
		return "Lista Ordenada con datos: [" + datos + "]";
	}
	
	
	
	
	
	
	
}
