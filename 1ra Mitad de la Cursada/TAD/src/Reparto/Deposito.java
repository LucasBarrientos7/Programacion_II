package Reparto;
import java.util.HashMap;
import java.util.Map;

public class Deposito {

	private Map<Integer, String> paquetes;
	
	public Deposito() {
		paquetes = new HashMap<Integer, String>();
	}
	public void agregarPaquete(int cod, String dest) {
		if (paquetes.containsKey(cod)) {
			throw new RuntimeException("Ya existe el paquete");
		}
		if (dest == null) {
			throw new RuntimeException("El destino no esta disponible");
		}
		paquetes.put(cod, dest);
	}	
	public String quitarPaquete(int cod) {
		return paquetes.remove(cod);
	}
}
