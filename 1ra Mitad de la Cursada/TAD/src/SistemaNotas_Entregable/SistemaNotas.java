package SistemaNotas_Entregable;
import java.util.HashMap;

public class SistemaNotas {

	// Parametros:
	
	HashMap<Integer, Alumno> alumnos;
	
	// Metodos:
	
	/* Constructor de Alumno */
	
	public SistemaNotas() {
		alumnos = new HashMap<>();
	}
	
	/* Registra un nuevo Alumno al Diccionario */
	
	public void ingresarNuevoAlumno(int nroLibreta, String nombre, String apellido) {
		if (alumnos.containsKey(nroLibreta)) {
			throw new RuntimeException("El alumno ya esta registrado");
		}
		alumnos.put(nroLibreta, new Alumno(nroLibreta, nombre, apellido));
	}
	
	/** Ingresa una nueva nota de una materia aprobada de un Alumno */
	
	public void ingresarNotaMateriaAprobada(int nroLibreta, String nombreMateria, double nota) {
		buscarAlumno(nroLibreta).notaAprobadaDelAlumno(nombreMateria, nota);
	}
	
	/** Devuelve el promedio de notas aprobadas de un Alumno */
	
	public double obtenerPromedio(int nroLibreta) {
		return buscarAlumno(nroLibreta).promedioDelAlumno();
	}
	
	/** Devuelve la cantidad de materias aprobadas del alumno */
	
	public int obtenerCantidadMateriasAprobadas(int nroLibreta) {
		return buscarAlumno(nroLibreta).cantidadMateriasAprobadasDelAlumno();
	}
	
	/** Verifica si encuentra un Alumno en el Diccionario y lo devuelve*/

	private Alumno buscarAlumno(int nroLibreta) {
		if (!alumnos.containsKey(nroLibreta)) {
			throw new RuntimeException("El alumno no esta registrado");
		}
		return alumnos.get(nroLibreta);
	}
	
}
