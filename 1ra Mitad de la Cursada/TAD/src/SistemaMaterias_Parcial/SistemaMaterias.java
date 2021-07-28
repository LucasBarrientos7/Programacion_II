package SistemaMaterias_Parcial;
import java.util.HashMap;

public class SistemaMaterias {

	HashMap<String, String> alumnos;

	public SistemaMaterias() {
		this.alumnos = new HashMap<String, String>();
	}
	
	public void ingresarAlumno(int nroLibreta, String nombre, String apellido) {
		Alumno nuevoAlumno = new Alumno(nroLibreta, nombre, apellido);
		if (alumnos.containsKey(nuevoAlumno.darLibreta())) {
			throw new RuntimeException("El alumno ya esta registrado");
		} else {
			alumnos.put(nombre, apellido);
		}
	}
	
	public Comision comisionDelAlumno() {
		return null;
	}
	
	public int nroMateriasDelAlumno(Alumno alumno) {
		return alumno.cantidadMaterias();
	}

}
