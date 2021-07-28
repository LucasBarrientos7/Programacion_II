package Centro;
import java.util.HashMap;

public class Centro {

	private HashMap<Integer, String> especialidades;
	private HashMap<Integer, Especialidad> pacientes;
	
	// 1:
	public Centro() {
		especialidades = new HashMap<Integer, String>();
		pacientes = new HashMap<Integer, Especialidad>();
	}
	
	// 2:
	public void ingresarPaciente(Integer nroHistorial) {
		if (!pacientes.containsKey(nroHistorial)) {
			pacientes.put(nroHistorial, null);
		} else {
			throw new RuntimeException("El paciente ingresado ya existe.");
		}
	}

	// 3:
	public void ingresarEspecialidad(Integer codigo, String NombreMedico) {
		if (!especialidades.containsKey(codigo)) {
			especialidades.put(codigo, NombreMedico);
		} else {
			throw new RuntimeException("La especialidad ingresada ya existe.");
		}
	}
	
	// 4:
	public void registrarPaciente(Paciente paciente) {
		Integer atencion = paciente.pedirTurno().darCodigo();
		if (!especialidades.containsKey(atencion)) {
			throw new RuntimeException("La especialidad solicitada no existe");
		} else {
			pacientes.put(paciente.darNroHistorial(), paciente.pedirTurno());
		}
	}
	
	// 5:
	public Conjunto<Especialidad> listaAtencionesPaciente(Integer nroHistorial) {
		Paciente paciente = new Paciente(nroHistorial, null);
		return paciente.atencionesDelPaciente();
	}
	
	// 6:
	public Integer cantidadAtencionesDeUnaEspecialidad(Integer nroHistorial) {
		Conjunto<Especialidad> listaAtenciones = new Conjunto<Especialidad>();
		Especialidad atencion;
		for (int i = 0; i < listaAtencionesPaciente(nroHistorial).tamanio(); i++) {
			atencion = listaAtencionesPaciente(nroHistorial).dameUno();
			if (!listaAtenciones.pertenece(atencion)) {
				listaAtenciones.agregar(atencion);
			}
		}
		return listaAtenciones.tamanio();
	}
	
	
	
	
	
	
	
}
