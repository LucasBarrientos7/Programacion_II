package CentroExpress;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import Estudio;
import Paciente;
import CentroExpress.CentroExpress.Atencion;

public class CentroExpress {

	HashMap<Integer, Paciente> pacientes;
	LinkedList<Atencion> atenciones;
	LinkedList<Estudio> estudios;
	
	public CentroExpress() {
		pacientes = new HashMap<>();
		atenciones = new LinkedList<Atencion>();
		estudios = new LinkedList<Estudio>();
	}
	
	// 1)
	public void ingresarEstudio(String nombre, int codigo, int costo) {
	}
	
	// 2)
	public void ingresarNuevaAtencion(String nombre, String nombreDelEstudio, Fecha fecha) {
	}
	
	// 3)
	public Map<Integer, Fecha> obtenerEstudiosRealizadosPorElPaciente(Paciente paciente) {
		// Devuelve una lista en donde se presenta el 
		// codigo de estudio y fecha en la que se atendió
		return null;
	}
	
	// 4)
	public Map<Integer, Integer> listaDeAtenciones(Fecha fecha){
		// Devuelve una lista en donde se presenta el 
		// numero de historia Clinica y el codigo del estudio
		return null;
	}
	
	// 5)
	public int montoTotalPagadoDelPaciente(Paciente paciente) {	
	}
	
}
