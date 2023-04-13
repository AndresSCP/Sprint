package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactoServletJSP
 */
@WebServlet("/SvContacto")
public class SvContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvContacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener la sesión actual
        HttpSession session = request.getSession();

        // Obtener un atributo de sesión
        String username = (String) session.getAttribute("username");

        //Verificar que la session este activa
        if (session.getAttribute("username") != null) {
        	// Llamamos a la página JSP del formulario de contacto
            request.getRequestDispatcher("formContacto.jsp").forward(request, response);
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
	    // Obtener los valores de los campos del formulario
	    String nombre = request.getParameter("nombre");
	    String email = request.getParameter("email");
	    String asunto = request.getParameter("asunto");
	    String mensaje = request.getParameter("mensaje");
	    
	    // Imprimir los valores en la consola de Java
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Email: " + email);
	    System.out.println("Asunto: " + asunto);
	    System.out.println("Mensaje: " + mensaje);

	    // Redireccionar a una página de confirmación o agradecimiento
	    request.getSession().setAttribute("mensaje", "Los datos fueron registrados satisfactoriamente.");
	    request.getRequestDispatcher("formContacto.jsp").forward(request, response);
	}

}
