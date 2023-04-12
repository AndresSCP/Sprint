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
import modelo.Cliente;
import modelo.DaoClienteImp;
import modelo.Usuario;
import modelo.UsuarioDaoImpl;



/**
 * Servlet implementation class SvEditarCliente
 */
@WebServlet("/SvObtenerCliente")
public class SvObtenerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvObtenerCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer rut = Integer.parseInt(request.getParameter("rut"));
		System.out.println("El rut es:" + rut);
				
		try {
  			//Consulto los datos de ese rut para asignarlos a los campos de Crear-Editar
  			IClienteDAO daoCli = new DaoClienteImp();
  			//busco los datos del Cliente con el rut seleccionado en la lista
  			// y los devuelvo en un objeto que contiene todos los datos de la lista atraves de un reques
  			Cliente cliente =  daoCli.obtenerClientePorId(rut);
  			request.setAttribute("cliente",cliente);
  		} catch (Exception  e) {
  			 System.out.println(e.getMessage());
        }
		HttpSession session = request.getSession();

        // Obtener un atributo de sesión
        String username = (String) session.getAttribute("username");

        //Verificar que la session este activa
        if (session.getAttribute("username") != null) {
        	// Llamamos a la página JSP del formulario de Crear Usuario
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
