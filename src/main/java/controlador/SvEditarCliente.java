package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.IClienteDAO;

import modelo.DaoClienteImp;
import modelo.Usuario;
import modelo.Cliente;

/**
 * Servlet implementation class SvEditarCliente
 */
@WebServlet("/SvEditarCliente")
public class SvEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvEditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo el valor del rut que viene del post de la lista de clientes
		//Y cada uno delos posibles campos que hayan sido modificado posiblemente modificados
		String runCompleto = request.getParameter("run");
		String runSinDigito = runCompleto.substring(0, runCompleto.length() - 2);
		Integer run = Integer.parseInt(runSinDigito);
		String nombre = request.getParameter("nombre");
        String fechaNac = request.getParameter("fechaNac");
       // Integer tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
      
        //Obtengo los datos del Cliente 
        String nombreCli = request.getParameter("nombreCli");
        String apellidoCli = request.getParameter("apellidoCli");
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        Integer sistSalud = Integer.parseInt(request.getParameter("sistSalud"));
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        
        Integer edad = 0;
        if (request.getParameter("edad")!= null) { 
        	
        	edad = Integer.parseInt(request.getParameter("edad"));
       }else {
    	   edad = 1;
       }
        
        
	
        //Creo el Cliente y le asigno los valores recibidos por post de editarCliente.jsp
        //Usuario user = new Usuario();
        Cliente client = new Cliente();
        //Datos a actualizar en el Usuario
       /* user.setRunUsuario(run);
        user.setNombreUsuario(nombre);
        user.setFechaNacimientoUsuario(fechaNac);
        user.setTipoUsuario(tipoUsuario);*/
        //Datos a Actualizar en el Cliente y en la super clase que integra al cliente
        client.setRunUsuario(run);
        client.setNombreUsuario(nombre);
        client.setFechaNacimientoUsuario(fechaNac);
        client.setTipoUsuario(1);
        client.setNombres(nombreCli);
        client.setApellidos(apellidoCli);
        client.setTelefono(telefono);
        client.setAfp(afp);
        client.setSistemaSalud(1);
        client.setDireccion(direccion);
        client.setComuna(comuna);
        client.setEdad(24);
        
        
				
		try {
			IClienteDAO  daoCli = new DaoClienteImp();
			
			daoCli.updateCliente(client);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
		} catch (Exception  e) {
			 System.out.println(e.getMessage());
		}
		
		// Obtener la sesión actual
        HttpSession session = request.getSession();

        // Obtener un atributo de sesión
        String username = (String) session.getAttribute("username");

        //Verificar que la session este activa
        if (session.getAttribute("username") != null) {
        	// Llamamos a la página JSP del formulario de Crear Usuario
        	request.getSession().setAttribute("mensaje", "Los datos fueron modificados satisfactoriamente.");
            request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
        }else{
        	//Se redirige la pagina a login
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
