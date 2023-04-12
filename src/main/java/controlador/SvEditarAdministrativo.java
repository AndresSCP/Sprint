package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AdministrativoDaoImpl;
import modelo.Administrativo;


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
		/* System.out.println(runUsuario); */
		AdministrativoDaoImpl administrativoDao = new AdministrativoDaoImpl();

		Administrativo administrativo = administrativoDao.obtenerAdministrativoPorId(runUsuario);
			 
		request.setAttribute("administrativo",administrativo);
		
		request.getRequestDispatcher("EditarAdministrativo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int runUsuario = Integer.parseInt(request.getParameter("run"));
		String nombre = request.getParameter("nombreUsuario");
		String fechaNacimiento = request.getParameter("fechaNacimientoUsuario");
		int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
		String area = request.getParameter("area");
		String expPrevia = request.getParameter("expPrevia");
		String email = request.getParameter("email");

		Administrativo administrativo = new Administrativo();
		
		administrativo.setRunUsuario(runUsuario); // obtén el RUN del administrativo que se está editando
		administrativo.setNombreUsuario(nombre);
		administrativo.setFechaNacimientoUsuario(fechaNacimiento);
		administrativo.setTipoUsuario(tipoUsuario);
		administrativo.setArea(area);
		administrativo.setExpPrevia(expPrevia);
		administrativo.setEmail(email);

        AdministrativoDaoImpl dao = new AdministrativoDaoImpl();
        dao.actualizarAdministrativo(administrativo);

		// redirige a la página de confirmación o a la página de detalles del administrativo actualizado
        
        request.getRequestDispatcher("ListarAdministrativos.jsp").forward(request, response);
        }
}



	

