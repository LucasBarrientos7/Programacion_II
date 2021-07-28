package CentroExpress;
import Estudio;
import Paciente;

public class Atencion {

	private Estudio estudioDeLaAtencion;
	private Paciente pacienteDeLaAtencion;
	private Fecha fechaDeLaAtencion;
	
	public Atencion(Estudio estudioDeLaAtencion, Paciente pacienteDeLaAtencion, Fecha fechaDeLaAtencion) {
		this.estudioDeLaAtencion = estudioDeLaAtencion;
		this.pacienteDeLaAtencion = pacienteDeLaAtencion;
		this.fechaDeLaAtencion = fechaDeLaAtencion;
	}
	
	
	
}
