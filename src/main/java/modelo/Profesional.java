package modelo;

import java.util.Date;

// Clase PRofesional que extiende de clase Usuario
public class Profesional extends Usuario {

	private String tituloProfesional;
	private String FechaIngreso;
	private String proyecto;

	
	//Constructor Vacio
	public Profesional() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Constructor con los parametros
	public Profesional(Integer run, String tituloProfesional, String fechaIngreso, String proyecto, String nombre,
			String fechaNac, Integer tipo) {
		super(run, nombre, fechaNac, tipo);
		// TODO Auto-generated constructor stub

		this.tituloProfesional = tituloProfesional;
		this.FechaIngreso = fechaIngreso;
		this.proyecto = proyecto;

	}
	// Getter and Setter
	public String getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public String getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	// Metodo ToString 
	@Override
	public String toString() {
		return "Profesional [ tituloProfesional=" + tituloProfesional + ", FechaIngreso=" + FechaIngreso + ", proyecto="
				+ proyecto + ", getTituloProfesional()=" + getTituloProfesional() + ", getFechaIngreso()="
				+ getFechaIngreso() + ", getProyecto()=" + getProyecto() + ", getNombre()=" + getNombreUsuario()
				+ ", getFechaNac()=" + getFechaIngreso() + ", getTipo()=" + getTipoUsuario() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}