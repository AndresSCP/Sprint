package modelo;

/**
 * Definicion:  de la Clase: Clase para mantener los Clientes que recibirán los usuarios que se capacitaran
 * @Version: 1.0
 * @Autor: Grupo Java (Jose Zamora, David, Andres, Matias)
 *
 */


public class Cliente extends Usuario {
    // Creación de los atributos de la Clase Cliente
	
	private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
	
    
    
    
    public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Cliente(Integer run, String nombre, String fechaNac, Integer tipo) {
		super(run, nombre, fechaNac, tipo);
		// TODO Auto-generated constructor stub
	}




	// Constructor de la Clase
	public Cliente( Integer run, String nombre,String fechaNac,Integer tipo,String nombres, String apellidos, String telefono,
    		String afp, int sistemaSalud, String direccion, String comuna, int edad) {
		super(run,nombre,fechaNac,tipo);
		this.nombres = nombres;
    	this.apellidos = apellidos;
    	this.telefono = telefono;
    	this.afp = afp;
    	this.sistemaSalud = sistemaSalud;
    	this.direccion = direccion;
    	this.comuna = comuna;
    	this.edad = edad;
        
    }

	
   

    public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		
            if (nombres.length() >=5 || nombres.length() <= 50) {
                this.nombres = nombres;
            } else {
                System.out.println("Ingrese nombre valido, mínimo 5 caracteres y máximo 30");
            }
    }



	/**
     * Devuelve los apellidos del Cliente.
     *
     * @return los apellidos del Cliente.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del Cliente.
     *
     * @param apellidos  los nuevos apellidos del Cliente.
     */
    public void setApellidos(String apellidos) {
    	
    	if (apellidos.length() < 5 || apellidos.length() > 30 || apellidos.isEmpty()) {
    		System.out.println("Ingrese Apellidos que este dentro del rango minimo 5 maximo 30, no debe estar vacio");
			
    	}else if (apellidos.length() > 4 && apellidos.length() < 31 ) {
    		this.apellidos = apellidos;
       }
    }	
    	

    /**
     * Devuelve el telefono del Cliente.
     *
     * @return el telefono del Cliente.
     */
    public String getTelefono() {
            return telefono;
    }

    /**
     * Establece el telefono del Cliente.
     *
     * @param telefono el nuevo telefono del Cliente.
     */
    public void setTelefono(String telefono) {
    	    		
    	if(telefono == "") {
    		System.out.println("Ingrese un telefono valido");
			
    	}else {
    		this.telefono = telefono;
       
    	} 
   	
    }

    /**
     * Devuelve el AFP del Cliente.
     *
     * @return el AFP del Cliente.
     */
    public String getAfp() {
        return afp;
    }

    /**
     * Establece el AFP del Cliente.
     *
     * @param afp  el nuevo AFP del Cliente.
     */
    public void setAfp(String afp) {
    	if (afp.length() >= 4 && afp.length() <= 30 ) {
    		this.afp = afp;
        } else {
            System.out.println("Ingrese una afp valida, que sea mayor que 4 y menor a 30 caracteres");}
        	
    }

    /**
     * Devuelve el Sistema de Salud del Cliente.
     *
     * @return el Sistema de Salud del Cliente.
     */
    public int getSistemaSalud() {
        return sistemaSalud;
    }

    /**
     * Establece el requerimiento para asignar un valor a sistemaSalud(el valor
     * ingresado debe ser 1 o 2) y si no se cumple, retorna un mensaje de error
     *
     * @param sistemaSalud  el nuevo sistema de salud del Cliente.
     */
    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
        } else {
            System.out.println("Valor incorrecto. Por favor ingrese 1 o 2.");
        }
    }

    /**
     * Devuelve la dirección del Cliente.
     *
     * @return la dirección del Cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del Cliente.
     *
     * @param direccion  la nueva dirección del Cliente.
     */
    public void setDireccion(String direccion) {
    	if (direccion.length() < 70) {
        this.direccion = direccion;
    	}else {
    		System.out.println("La direccion debe tener menos de 70 caracteres ");
    	}
    }

    /**
     * Devuelve la comuna del Cliente.
     *
     * @return la comuna del Cliente.
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna del Cliente.
     *
     * @param comuna La nueva comuna del Cliente.
     */
    public void setComuna(String comuna) {
    	if (comuna.length() < 51) {
    		this.comuna = comuna;
    	}else {
    		System.out.println("La comuna debe tener menos de 50 caracteres");
    	}
    }

    /**
     * Devuelve la edad del Cliente.
     *
     * @return la edad del Cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del Cliente.
     *
     * @param edad la nueva edad del Cliente.
     */
    public void setEdad(int edad) {
    	if ( edad < 0 || edad > 150) {
    		System.out.println("Ingrese Edad entre 0 y 150 años");
    	}
    	else if(edad >= 0 && edad < 151) {
    		this.edad = edad;
      	}
  
    }
    

    /**
     * Devuelve una representación en cadena de la instancia de la clase Cliente
     *
     * @return Una representación en cadena de la instancia de la clase Cliente
     */
	@Override
	public String toString() {
		
		return " Cliente " + "\nrun= " + super.getRunUsuario() +   "\nUsername= " + super.getNombreUsuario() 
				+ "\nfecha de Nacimiento= "+ super.getFechaNacimientoUsuario()+ "\nnombres= " + nombres + "\napellidos= "
				+ apellidos + "\ntelefono= " + telefono + "\nafp= " + afp + "\nsistemaSalud= " + sistemaSalud 
				+ "\ndireccion= " + direccion + "\ncomuna= " + comuna + "\nedad= " 	+ edad ;
	}
 

}