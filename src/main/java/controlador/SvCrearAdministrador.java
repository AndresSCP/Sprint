package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import interfaces.IAdministrativoDao;
import modelo.Administrativo;
import modelo.AdministrativoDaoImpl;

/**
 * Servlet implementation class SvCrearAdministrador
 */
@WebServlet("/SvCrearAdministrador")
public class SvCrearAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCrearAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//Obtengo los valores que vienen del post del formulario crearUsuario.jsp
		String area = request.getParameter("area");
		String exPrevia = request.getParameter("exPrevia");
		String email = request.getParameter("email");
        
        //Creo el usuario y le asigno los valores recibidos por post
        Administrativo administrativo = new Administrativo();

        administrativo.setArea(area);
		administrativo.setExpPrevia(exPrevia);
		administrativo.setEmail(email);

        //Creo el objeto Dao que tendra los metodos CRUD entre ellos Insertar
		try {
			IAdministrativoDao  dao = new AdministrativoDaoImpl();
			dao.registrarAdministrativo(administrativo);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
		} catch (Exception  e) {
			 System.out.println(e.getMessage());
       }
	}

}
