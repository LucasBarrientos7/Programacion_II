package Subasta;
import java.util.HashMap;

/*
 * IREP:
 * 
 * El codigo del producto no se repite
 * 
 */

public class Subasta {

	// Parametros:
	
	private HashMap<Integer, Producto> subasta;
	
	/** Constructor del diccionario Subasta */
	
	public Subasta() {
		subasta = new HashMap<Integer, Producto>();
	}
	
	// Metodos:
	
	/** Agrega un producto a la subasta si su valor es mayor a 0 */
	
	public void agregarProducto(Integer codigo, Integer precio) {
		if (!subasta.containsKey(codigo)) {
			if (precio > 0) {
				subasta.put(codigo, new Producto(codigo, precio));
			} else {
				throw new RuntimeException("El precio ingresado no es valido");
			}
		} else {
			throw new RuntimeException("Ya existe un producto con ese codigo");
		}
	}
	
	/** Actualiza el precio de un producto si el precio supera el precio actual */
	
	public void ofertar(Integer codigo, Integer precio) {
		if (subasta.containsKey(codigo)) {
			subasta.get(codigo).actualizarPrecioActual(precio);
		} else {
			throw new RuntimeException("El producto ingresado no se encuentra disponible");
		}
	}
	
	/** Define un producto como vendido */
	
	public void venderProducto(Integer codigo) {
		if (subasta.get(codigo).estaVendido()) {
			subasta.get(codigo).definirVendido();
		}
	}
	
	/** Devuelve el precio actual de un producto */
	
	public Integer consultarPrecioActual(Integer codigo) {
		return subasta.get(codigo).consultarPrecioActual();
	}
	
	/** Devuelve si un producto esta vendido */
	
	public boolean estaVendido(Integer codigo) {
		return subasta.get(codigo).estaVendido();
	}
		
} // Cierre total de la clase
