package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import interfaces.IAdministrativoDao;
import modelo.AdministrativoDaoImpl;
import modelo.Administrativo;

/**
 * Servlet implementation class SvListarAdministrativo
 */
@WebServlet("/SvListarAdministrativo")
public class SvListarAdministrativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Administrativo> listaAdm = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvListarAdministrativo() {
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
				IAdministrativoDao DaoAdministrativo = new AdministrativoDaoImpl();
				listaAdm = DaoAdministrativo.listaAdministrativos();
			} catch (Exception  e) {
				System.out.println(e.getMessage());
			}
			/*
			 * System.out.println("El tamaño de la lista miArrayList es: " +
			 * listaAdm.size());
			 * response.getWriter().println("El tamaño de la lista miArrayList es: " +
			 * listaAdm.size());
			 */
			// Establecer el atributo miLista en el objeto request
			request.setAttribute("miListaAdministrativo", listaAdm);
			// Llamamos a la página JSP del formulario de Lista de Clientes
			request.getRequestDispatcher("ListarAdministrativos.jsp").forward(request, response);
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
