package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.IUsuarioDao;
import modelo.UsuarioDaoImpl;
import modelo.Usuario;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/SvCrearUsuario")
public class SvCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo los valores que vienen del post del formulario crearUsuario.jsp
		String runCompleto = request.getParameter("run");
		String runSinDigito = runCompleto.substring(0, runCompleto.length() - 2);
		Integer run = Integer.parseInt(runSinDigito);
		String nombre = request.getParameter("nombre");
        String fechaNac = request.getParameter("fechaNac");
        Integer tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
        
        //Creo el usuario y le asigno los valores recibidos por post
        Usuario user = new Usuario();

        user.setRunUsuario(run);
		user.setNombreUsuario(nombre);
		user.setFechaNacimientoUsuario(fechaNac);
		user.setTipoUsuario(tipoUsuario);
        

        //Creo el objeto Dao que tendra los metodos CRUD entre ellos Insertar
		try {
			IUsuarioDao  dao = new UsuarioDaoImpl();
			dao.addUsuario(user);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
