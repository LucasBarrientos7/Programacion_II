import Empresa.Fecha;

public class Alumno extends Persona implements Comparable<Alumno>{

	private String carrera;
	private int materiasAprobadas;
	private int nroLibreta;
	
	public Alumno(int nroLibreta, String nombre, String apellido, Fecha fecha, String carrera) {
		super(nombre, apellido, fecha);
		this.carrera = carrera;
		this.nroLibreta = nroLibreta;
	}
	
	public int consultarLibreta() {
		return nroLibreta;
	}
	
	public int consultarCantidadDeMateriasAprobadas() {
		return materiasAprobadas;
	}
	
	@Override
	public String tosString() {
		return "{ " + nroLibreta + " }: ";
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Alumno)) {
			return false;
		}
		Alumno temp = (Alumno)o;
			return nroLibreta == temp.consultarLibreta();
	}

	@Override
	public int compareTo(Alumno o) {
		return consultarLibreta() - o.consultarLibreta();
	}
	
}
