package Subasta;

/*
 * IREP:
 * 
 * Precio base mayor a cero
 * Precio actual mayor o igual al precio base
 * 
 */

public class Producto {

	// Parametros:
	
	private Integer codigo;
	private Integer precioBase;
	private Integer precioActual;
	private boolean vendido;
	
	/** Constructor del objeto Producto */
	
	public Producto(Integer codigo, Integer precio) {
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.precioActual = precioActual;
		this.vendido = false;
	}

	// Metodos:
	
	/** Actualiza el precio de un producto si este es mayor al precio que estaba antes */
	
	public void actualizarPrecioActual(Integer precio) {
		if (precio > this.precioBase) {
			this.precioBase = precio;
			this.precioActual = this.precioBase;
		} else {
			throw new RuntimeException("El precio ingresado no supera el precio actual del Producto");
		}
	}
	
	/** Devuelve si un producto esta vendido */

	public boolean estaVendido() {
		return this.vendido;
	}
	
	/** Define a un producto como vendido */

	public void definirVendido() {
		this.vendido = true;
	}
	
	/** Devuelve el precio actual de un producto */

	public Integer consultarPrecioActual() {
		return this.precioActual;
	}
	
} // Cierre total de la clase
