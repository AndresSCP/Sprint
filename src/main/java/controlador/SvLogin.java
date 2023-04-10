package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class SvLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//este código de Servlet se utiliza para obtener los valores de entrada del usuario de un formulario web y validar esas credenciales en el servidor.	
        String username = request.getParameter("inputUsuario");
        String password = request.getParameter("password");

        boolean validCredentials = validateCredentials(username, password);

        if (validCredentials) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Crear una cookie de sesión con un tiempo de vida de 30 minutos
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(1800);
            response.addCookie(cookie);

            response.sendRedirect("SvInicio");
        } else {
            request.setAttribute("mensajeError", "Credenciales inválidas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

	//en esta solicitud GET se utiliza para cerrar la sesión actual del usuario y redirigirlo a la página de inicio de sesión.
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        //Si la sesión no es nula (es decir, si existe una sesión), se invalida la sesión utilizando el método invalidate() de HttpSession.
        if (session != null) {
            session.invalidate();
        }
        //Se redirige al usuario a la página de inicio de sesión "login.jsp
        response.sendRedirect("login.jsp");

    }

    // Metodo para validad credenciales
    private boolean validateCredentials(String username, String password) {
        if (username.equals("admin") && password.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
