package SistemaNotas_Entregable;

public class Alumno {

	private int nroLibreta;
	private String nombre, apellido;
	private Diccionario<String, Double> MateriasAprobadas;
	
	// CASO 2 PROMEDIO EN O(1)
	private double sumaNotas;
	
	public Alumno(int nroLibreta, String nombre, String apellido) {
		this.nroLibreta = nroLibreta;
		this.nombre = nombre;
		this.apellido = apellido;
		MateriasAprobadas = new Diccionario<>();
	}
	
	/** Ingresa una nueva nota al diccionario de materias aprobadas del Alumno */
	
	public void notaAprobadaDelAlumno(String nombreMateria, Double nota) {
		if (!MateriasAprobadas.pertenece(nombreMateria)) {
			if (nota >= 4) {
				MateriasAprobadas.agregar(nombreMateria, nota);
			} else {
				throw new RuntimeException("La materia ingresada no esta aprobada");
			}
		} else {
			MateriasAprobadas.definir(nombreMateria, nota);
		}
	}
	
	/** Devuelve el promedio de las materias aprobadas por el alumno */
	
	public double promedioDelAlumno() {
		//recorro las materias y consulto la nota
		// sumo todas las notas y lo divido pos la cantidad
		
		Conjunto<String> claves = MateriasAprobadas.claves();
		double sumaNotas = 0;
		// Usando un For es O(n)
		for (int i = 0; i < claves.tamanio(); i++) {
			String nomMateria = claves.dameUno();
			MateriasAprobadas.obtener(nomMateria);
			sumaNotas = sumaNotas + MateriasAprobadas.obtener(nomMateria);
		}
		return sumaNotas / cantidadMateriasAprobadasDelAlumno();
	}
	
	/** Retorna la cantidad de Materias aprobadas por el Alumno */
	
	public int cantidadMateriasAprobadasDelAlumno() {
		return MateriasAprobadas.tamanio();
	}
	
	
	
}
