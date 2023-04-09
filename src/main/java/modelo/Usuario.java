package modelo;


public class Usuario {
	
	private  Integer runUsuario; // RUN del usuario (menor a 99.999.999)
	private  String nombreUsuario; // nombres que identifica al usuario
	private  String fechaNacimientoUsuario; // fecha de nacimiento del usuario
	private  Integer tipoUsuario; // Tipo de Usuario que se crea: 1 Cliente, 2 Profesional, 3 Administrativo
			

	public Usuario() {
		super();
	}

	public Usuario( Integer run, String nombre,String fechaNac,Integer tipo) {
		super();
		this.runUsuario = run;
		this.nombreUsuario = nombre;
		this.fechaNacimientoUsuario = fechaNac;
		this.tipoUsuario = tipo;
	}
	
//	public Usuario( Integer runUsuario, String nombreUsuario, String apellidoUsuario, String fechaNacimientoUsuario) {
//		super();
//		//this.id = id;
//		this.runUsuario = runUsuario;
//		this.nombreUsuario = nombreUsuario;
//		this.apellidoUsuario = apellidoUsuario;
//		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
//		//this.idUsuario = idUsuario;
//	}

	public Integer getRunUsuario() {
		return runUsuario;
	}

	public void setRunUsuario(Integer runUsuario) {
		this.runUsuario = runUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	public void setFechaNacimientoUsuario(String fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [runUsuario=" + runUsuario + ", nombreUsuario=" + nombreUsuario + ", fechaNacimientoUsuario="
				+ fechaNacimientoUsuario + ", tipoUsuario=" + tipoUsuario + "]";
	}

}	
	


