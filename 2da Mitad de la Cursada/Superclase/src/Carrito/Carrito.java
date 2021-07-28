package Carrito;

import java.util.HashMap;

public class Carrito {

	private HashMap<Item, Integer> items;
	
	public Carrito() {
		items = new HashMap<>();
	}
	
	public float calcularTotal() {
		float total = 0;
		for (Item i : items.keySet()) {
			total += i.calcularPrecio() * items.get(i);
		}
		return total;
	}
	
	public void agregarItem(Item i) {
		int cantidad;
		cantidad = items.getOrDefault(i, 0);
		cantidad ++;
		items.put(i, cantidad);
	}
	
	public void eliminarItem(Item i) {
		
	}
}
