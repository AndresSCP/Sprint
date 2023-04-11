package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.ICapacitacionDao;
import modelo.Capacitacion;
import modelo.CapacitacionDaoImpl;



/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/SvCrearCapacitacion")
public class SvCrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SvCrearCapacitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Obtener la sesión actual
		HttpSession session = request.getSession();

		// Obtener un atributo de sesión
		String username = (String) session.getAttribute("username");

		// Verificar que la session este activa
		if (session.getAttribute("username") != null) {
			// Llamamos a la página JSP del formulario de contacto
			request.getRequestDispatcher("CreacionDeCapacitacion.jsp").forward(request, response);
		} else {
			// Se redirige la pagina a login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener los parámetros del formulario
		String nombreCapacitacion = request.getParameter("nombreCapacitacion");
		long rut = Long.parseLong(request.getParameter("rut"));
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		String duracion = request.getParameter("duracion");
		String cantidadAsistentesStr = request.getParameter("cantidadAsistentes");
		int cantidadAsistentes = 0;
		if(cantidadAsistentesStr != null && !cantidadAsistentesStr.isEmpty()) {
		   cantidadAsistentes = Integer.parseInt(cantidadAsistentesStr);
		}

		// Crear el objeto de tipo Capacitacion con los parámetros recibidos
		Capacitacion nuevaCapacitacion = new Capacitacion();
	    nuevaCapacitacion.setNombreCapacitacion(nombreCapacitacion);
		nuevaCapacitacion.setRut(rut);
		nuevaCapacitacion.setDia(dia);
		nuevaCapacitacion.setHora(hora);
		nuevaCapacitacion.setLugar(lugar);
		nuevaCapacitacion.setDuracion(duracion);
		nuevaCapacitacion.setCantidadAsistentes(cantidadAsistentes);

		// Registrar la capacitación en la base de datos a través del DAO
		ICapacitacionDao capacitacionDao = new CapacitacionDaoImpl();
		boolean registroExitoso = capacitacionDao.registrar(nuevaCapacitacion);

		// Redirigir al usuario a una página de confirmación (o mostrar un mensaje en la
		// misma página)
		if (registroExitoso) {
			request.getSession().setAttribute("mensaje", "Los datos fueron registrados satisfactoriamente.");
			response.sendRedirect("CreacionDeCapacitacion.jsp");
		} else {
			response.sendRedirect("CreacionDeCapacitacion.jsp");
		}

	}
     	
}
