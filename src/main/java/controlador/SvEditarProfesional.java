package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.Profesional;
import modelo.ProfesionalDAOImpl;
import modelo.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import interfaces.IProfesionalDao;

/**
 * Servlet implementation class SvEditarProfesional
 */
@WebServlet("/SvEditarProfesional")
public class SvEditarProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List datosPro = new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvEditarProfesional() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		int run = Integer.parseInt(request.getParameter("run"));
		System.out.println(run);
		ProfesionalDAOImpl profesionalDao = new ProfesionalDAOImpl();
		
		try {
			datosPro = profesionalDao.DatosProfesional(run);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("datosPro",datosPro);
		
		request.getRequestDispatcher("EditarProfesional.jsp").forward(request, response);
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo los valores que vienen del post del formulario
		String rut = request.getParameter("run");
		//String runSinDigito = rut.substring(0, rut.length() - 2);
		Integer run = Integer.parseInt(rut);
		String nombre = request.getParameter("nombre");
        String fechaNac = request.getParameter("fechaNac");
        String tipoString = request.getParameter("tipo");
	    Integer tipo =null;
	    if (tipoString != null && !tipoString.isEmpty()) {
	    	tipo = Integer.parseInt(tipoString);
	    }
        
	    // Obtener los valores de Profesional
	   
	   	   
	    String titulo = request.getParameter("titulo");
	    String fechaIn = request.getParameter("fechaIn");
	    String proyecto = request.getParameter("proyecto");
	    
	    Usuario usuario = new Usuario();
	    Profesional profesional = new Profesional();
	    
	    usuario.setRunUsuario(run);
	    usuario.setNombreUsuario(nombre);
	//    usuario.setFechaNacimientoUsuario(fechaNac);
	//    usuario.setTipoUsuario(tipo);
	    profesional.setRunUsuario(run);
	    profesional.setTituloProfesional(titulo);
	    profesional.setFechaIngreso(fechaIn);
	    profesional.setProyecto(proyecto);
	    

	    try {
	    	IUsuarioDao  usrDao = new UsuarioDaoImpl() ;
	    	IProfesionalDao  proDao = new ProfesionalDAOImpl();
	    	proDao.actualizarProfesional(profesional);// Como todos los metodos dao lanzan excepciones deben colocarse en un try catch
	    	usrDao.updateUsuario(usuario);
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
            request.getRequestDispatcher("SvListarProfesional").forward(request, response);
        }else{
        	//Se redirige la pagina a login
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
