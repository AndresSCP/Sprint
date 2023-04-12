package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import interfaces.IAdministrativoDao;
import modelo.AdministrativoDaoImpl;
import modelo.Administrativo;
import modelo.Usuario;


/**
 * Servlet implementation class SvEditarAdministrativo
 */
@WebServlet("/SvEditarAdministrativo")
public class SvEditarAdministrativo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvEditarAdministrativo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int runUsuario = Integer.parseInt(request.getParameter("runUsuario"));
		System.out.println(runUsuario);
		AdministrativoDaoImpl administrativoDao = new AdministrativoDaoImpl();
		
		Administrativo administrativo = administrativoDao.obtenerAdministrativoPorId(runUsuario);
		
		request.setAttribute("administrativo",administrativo);
		
		request.getRequestDispatcher("ListarAdministrativos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //Obtengo los valores que vienen del post del formulario crearUsuario.jsp
	    String area = request.getParameter("area");
	    String exPrevia = request.getParameter("exPrevia");
	    String email = request.getParameter("email");

	    //Creo el usuario y le asigno los valores recibidos por post
	    Administrativo administrativo = new Administrativo();
	    administrativo.setArea(area);
	    administrativo.setExpPrevia(exPrevia);
	    administrativo.setEmail(email);

	    //Obtengo los valores que vienen del post del formulario crearUsuario.jsp
	    String runCompleto = request.getParameter("run");
	    if (runCompleto == null) {
	        // Manejar el caso en que el campo rut no se haya ingresado
	        // En este ejemplo, redirigimos al usuario de vuelta al formulario con un mensaje de error
	        request.getSession().setAttribute("mensaje", "Debe ingresar un rut");
	        request.getRequestDispatcher("CrearUsuario.jsp").forward(request, response);
	        return;
	    }
	    String runSinDigito = runCompleto.substring(0, runCompleto.length() - 2);
	    Integer run = Integer.parseInt(runSinDigito);
	    String nombre = request.getParameter("nombre");
	    String fechaNac = request.getParameter("fechaNac");
	    String tipoUsuario = request.getParameter("tipo_usuario");
	    int tipoUsuarioInt = Integer.parseInt(tipoUsuario);

	    //Creo el usuario y le asigno los valores recibidos por post
	    Usuario user = new Usuario();
	    user.setRunUsuario(run);
	    user.setNombreUsuario(nombre);
	    user.setFechaNacimientoUsuario(fechaNac);
	    user.setTipoUsuario(tipoUsuarioInt);

	    //Creo el objeto Dao que tendra los metodos CRUD entre ellos Insertar
	    try {
	        IAdministrativoDao dao = new AdministrativoDaoImpl();
	        dao.registrarAdministrativo(administrativo);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}

}
