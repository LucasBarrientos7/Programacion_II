package Carrito;

import java.util.ArrayList;

public class Combo extends Item{

	private ArrayList<Producto> productos;
	private float porcentajeDescuento;
	
	public Combo(float p) {
		productos= new ArrayList<>();
		porcentajeDescuento = p;
	}
	
	public void agregarProducto(Producto p) {
		productos.add(p);
	}
	
	public float totalPrecio() {
		float total = 0;
		for (Producto p : productos) {
			total = p.calcularPrecio();
		}
		return total;
	}
	
	@Override
	public float calcularPrecio() {
return totalPrecio()*porcentajeDescuento/100 ;
	}

}
