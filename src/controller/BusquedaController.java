package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import dao.DbConnection;
import dao.LibroDao;
import model.Libro;


/**
 * Servlet implementation class BusquedaController
 */
@WebServlet("/buscar")
public class BusquedaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaController() {
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
		// TODO Auto-generated method stub		doGet(request, response);
		
		
		  String q = request.getParameter("query");               
	        List<Libro> lista = null;
	        System.out.println(lista);
	        DbConnection conn = new DbConnection();
	        // Con nuestro objeto DAO, hacemos la busqueda de servidores
	        LibroDao libroDao = new LibroDao(conn);
	        lista = libroDao.getByQuery(q);
	        System.out.println(lista);
	        conn.disconnect();
	        RequestDispatcher rd;
	        request.setAttribute("libros", lista);
	        System.out.println("libros");
	        rd = request.getRequestDispatcher("/vistaLibros.jsp");
	        rd.forward(request, response);
		
	}

}
