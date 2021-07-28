package SistemaMaterias_Parcial;

public class Alumno {

	private int nroLibreta;
	private String nombre, apellido;
	private Comision com;
	private Diccionario<String, String> MateriasAnotadas;
	
	public Alumno(int nroLibreta, String nombre, String apellido) {
		this.apellido = apellido;
		this.nroLibreta = nroLibreta;
		this.nombre = nombre;
		this.MateriasAnotadas = new Diccionario<String, String>();
	}
	
	public void inscribirse(int nroLibreta, String materia, String comision) {
		
	}
	
	public void cambioDeComision(int nroLibreta, String materia, String comision) {
		
	}
	
	public int cantidadMaterias() {
		if (MateriasAnotadas.tamanio()>4) {
			return MateriasAnotadas.tamanio();
		} else {
			return 0;
		}
	}
	
	public int darLibreta() {
		return this.nroLibreta;
	}

}
