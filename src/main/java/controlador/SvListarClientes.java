package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.IClienteDAO;
import modelo.Cliente;
import modelo.DaoClienteImp;

/**
 * Servlet implementation class SvListarClientes
 */
@WebServlet("/SvListarClientes")
public class SvListarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> miArrayList = new ArrayList<Cliente>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvListarClientes() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			IClienteDAO DaoCliente = new DaoClienteImp();// Ojo que aqui esta la caida
			miArrayList = DaoCliente.listarCliente();
		 } catch (Exception  e) {
			 System.out.println(e.getMessage());
        }
		
		
		System.out.println("El tamaño de la lista miArrayList Cliente es: " + miArrayList.size());
		response.getWriter().println("El tamaño de la lista miArrayList es: " + miArrayList.size());
		
		// Establecer el atributo miLista en el objeto request
		request.setAttribute("miListaCliente", miArrayList);
		

		// Obtener la sesión actual
        HttpSession session = request.getSession();

        // Obtener un atributo de sesión
        String username = (String) session.getAttribute("username");

        //Verificar que la session este activa
        if (session.getAttribute("username") != null) {
        	// Llamamos a la página JSP del formulario de Lista de Clientes
            request.getRequestDispatcher("ListarCliente.jsp").forward(request, response);
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
