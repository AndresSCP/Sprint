package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.IProfesionalDao;
import modelo.ProfesionalDAOImpl;
import modelo.Profesional;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
