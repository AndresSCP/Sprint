package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.AdministrativoDaoImpl;
import modelo.Profesional;
import modelo.ProfesionalDAOImpl;
import interfaces.IAdministrativoDao;
import interfaces.IProfesionalDao;

/**
 * Servlet implementation class SvCrearProfesional
 */
@WebServlet("/SvCrearProfesional")
public class SvCrearProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCrearProfesional() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("run") != null && !request.getParameter("run").isEmpty()) {
		    int run = Integer.parseInt(request.getParameter("run"));
		}
		int run = Integer.parseInt(request.getParameter("run"));
		String nombre = request.getParameter("nombre");
		String fechaNac = request.getParameter("fechaNac");
		int tipo = Integer.parseInt(request.getParameter("tipo"));

		String titulo = request.getParameter("titulo");
		String fechaIngreso = request.getParameter("fechaIngreso");
		String proyecto = request.getParameter("proyecto");

		Profesional profesional = new Profesional( run, titulo, fechaIngreso, proyecto, nombre,
				fechaNac, tipo);
		IProfesionalDao  dao = new ProfesionalDAOImpl();
		 dao.insertarProfesional(profesional);

		response.sendRedirect("index.jsp");
	}

}
