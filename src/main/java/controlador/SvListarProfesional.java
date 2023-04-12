package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import interfaces.IProfesionalDao;
import modelo.ProfesionalDAOImpl;
import modelo.Profesional;

/**
 * Servlet implementation class SvListarProfesional
 */
@WebServlet("/SvListarProfesional")
public class SvListarProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List listaPro = new ArrayList<>();
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvListarProfesional() {
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
			try {
				IProfesionalDao DaoProfesional = new ProfesionalDAOImpl();
				listaPro = DaoProfesional.obtenerTodosLosProfesionales();
			} catch (Exception  e) {
				System.out.println(e.getMessage());
			}
			System.out.println("El tamaño de la lista miArrayList Pro es: " + listaPro.size());
			response.getWriter().println("El tamaño de la lista miArrayList Pro es: " + listaPro.size());
			// Establecer el atributo miLista en el objeto request
			request.setAttribute("miListaProfesional", listaPro);
			// Llamamos a la página JSP del formulario de Lista de Clientes
			request.getRequestDispatcher("ListarProfesionales.jsp").forward(request, response);
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
