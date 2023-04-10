package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.IClienteDAO;
import interfaces.IUsuarioDao;
import modelo.DaoClienteImp;
import modelo.Usuario;
import modelo.UsuarioDaoImpl;
import modelo.Cliente;

/**
 * Servlet implementation class svCrearCliente
 */
@WebServlet("/SvCrearCliente")
public class SvCrearCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCrearCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo los valores que vienen del post del formulario crearUsuario.jsp
		String runCompleto = request.getParameter("run");
		String runSinDigito = runCompleto.substring(0, runCompleto.length() - 2);
		Integer run = Integer.parseInt(runSinDigito);
		String nombre = request.getParameter("nombre");
        String fechaNac = request.getParameter("fechaNac");
        Integer tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
        //Obtengo los datos del Cliente 
        String nombreCli = request.getParameter("nombreCli");
        String apellidoCli = request.getParameter("apellidoCli");
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        Integer sistSalud = Integer.parseInt(request.getParameter("sistSalud"));
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        Integer edad = Integer.parseInt(request.getParameter("edad"));
	
        //Creo el Cliente y le asigno los valores recibidos por post
        Usuario user = new Usuario();
        Cliente client = new Cliente();
        
        user.setRunUsuario(run);
        user.setNombreUsuario(nombre);
        user.setFechaNacimientoUsuario(fechaNac);
        user.setTipoUsuario(tipoUsuario);
        
        client.setRunUsuario(run);
        client.setNombreUsuario(nombre);
        client.setFechaNacimientoUsuario(fechaNac);
        client.setTipoUsuario(tipoUsuario);
        client.setNombres(nombreCli);
        client.setApellidos(apellidoCli);
        client.setTelefono(telefono);
        client.setAfp(afp);
        client.setSistemaSalud(sistSalud);
        client.setDireccion(direccion);
        client.setComuna(comuna);
        client.setEdad(edad);
        
      //Creo los objetos Dao que tendra los metodos CRUD entre ellos Insertar
  		try {
  			IUsuarioDao  dao = new UsuarioDaoImpl();
  			dao.addUsuario(user);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
  			IClienteDAO daoCli = new DaoClienteImp();
  			daoCli.addCliente(client);
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
        	request.getSession().setAttribute("mensaje", "Los datos fueron registrados satisfactoriamente.");
            request.getRequestDispatcher("CrearUsuario.jsp").forward(request, response);
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
