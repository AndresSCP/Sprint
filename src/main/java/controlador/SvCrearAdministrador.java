package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import interfaces.IAdministrativoDao;
import interfaces.IUsuarioDao;
import modelo.Administrativo;
import modelo.AdministrativoDaoImpl;
import modelo.Usuario;
import modelo.UsuarioDaoImpl;

/**
 * Servlet implementation class SvCrearAdministrador
 */
@WebServlet("/SvCrearAdministrador")
public class SvCrearAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdministrativoDao administrativoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCrearAdministrador() {
        super();
        this.administrativoDao = new AdministrativoDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
        HttpSession session = request.getSession();

        // Obtener un atributo de sesión
        String username = (String) session.getAttribute("username");

        //Verificar que la session este activa
        if (session.getAttribute("username") != null) {
        	// Llamamos a la página JSP del formulario de Crear Usuario
        	request.getSession().setAttribute("mensaje", "Los datos fueron registrados satisfactoriamente.");
//            request.getRequestDispatcher("ListarAdministrativos.jsp").forward(request, response);
        }else{
        	//Se redirige la pagina a login
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// Obtener la sesión actual
		String runCompleto = request.getParameter("run");
		String runSinDigito = runCompleto.substring(0, runCompleto.length() - 2);
		Integer run = Integer.parseInt(runSinDigito);
		String nombre = request.getParameter("nombre");
		String fechaNac = request.getParameter("fechaNac");
		Integer tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
		
		String area = request.getParameter("area");
		String expPrevia = request.getParameter("exp-previa");
		String email = request.getParameter("email");
		
		
		// Creamos el objeto Administrativo con los datos del formulario
		Usuario user = new Usuario();
		Administrativo administrativo = new Administrativo();
		
		user.setRunUsuario(run);
		user.setNombreUsuario(nombre);
		user.setFechaNacimientoUsuario(fechaNac);
		user.setTipoUsuario(tipoUsuario);
		
		administrativo.setRunUsuario(run);
		administrativo.setNombreUsuario(nombre);
		administrativo.setFechaNacimientoUsuario(fechaNac);
		administrativo.setTipoUsuario(tipoUsuario);
		administrativo.setArea(area);
		administrativo.setExpPrevia(expPrevia);
		administrativo.setEmail(email);
		
		//Creo los objetos Dao que tendra los metodos CRUD entre ellos Insertar
		try {
			IUsuarioDao  dao = new UsuarioDaoImpl();
			dao.addUsuario(user);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
			IAdministrativoDao daoAdm = new AdministrativoDaoImpl();
			daoAdm.registrarAdministrativo(administrativo);
		} catch (Exception  e) {
			System.out.println(e.getMessage());
		}
}
}
