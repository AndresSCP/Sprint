package modelo;

public class Administrativo extends Usuario {
	private String area;
	private String expPrevia;
	private String email;


	/**
	 * 
	 * Constructor por defecto.
	 */
	public Administrativo() {
		
	}

	public Administrativo(Integer run, String nombre, String fechaNac,Integer tipo, String area, String expPrevia, String email) {
		super(run, nombre, fechaNac, tipo);
		this.area = area;
		this.expPrevia = expPrevia;
		this.email = email;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExpPrevia() {
		return expPrevia;
	}

	public void setExpPrevia(String expPrevia) {
		this.expPrevia = expPrevia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Administrativo [area=" + area + ", expPrevia=" + expPrevia + ", email=" + email + "]";
	}
		
}
	


	