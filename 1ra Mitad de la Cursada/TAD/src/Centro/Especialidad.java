package Centro;

public class Especialidad {

	private Integer codigo;
	private String medico;
	
	public Especialidad(Integer codigo, String medico) {
		this.codigo = codigo;
		this.medico = medico;
	}
	
	public Integer darCodigo() {
		return this.codigo;
	}
	
	public String darMedico() {
		return this.medico;
	}
	
}
