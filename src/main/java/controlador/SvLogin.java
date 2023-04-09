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

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");

    }

    private boolean validateCredentials(String username, String password) {
        if (username.equals("admin") && password.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
