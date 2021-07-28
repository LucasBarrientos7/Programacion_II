package Centro;
public class Paciente {

	
	private int nroHistorial;
	private Especialidad atencion;
	private Conjunto<Especialidad> atenciones;

	public Paciente(Integer nroHistorial, Especialidad atencion) {
		this.nroHistorial = nroHistorial;
		this.atencion = atencion;
		this.atenciones = new Conjunto<>();
	}
	
	public Integer atencionesRealizadas() {
		return atenciones.tamanio();
	}

	public Integer darNroHistorial() {
		return this.nroHistorial;
	}
	
	public Especialidad pedirTurno() {
		return this.atencion;
	}
	
	public Conjunto<Especialidad> atencionesDelPaciente(){
		Conjunto<Especialidad> todasLasAtenciones = new Conjunto<Especialidad>();
		for (int i = 0; i < atencionesRealizadas(); i++) {
			todasLasAtenciones.agregar(atenciones.dameUno());
		}
		return todasLasAtenciones;
	}
	
}
