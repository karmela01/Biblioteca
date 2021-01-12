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
import dao.UsuarioDao;
import model.Libro;
import model.Usuario;

/**
 * Servlet implementation class BusquedaUsuarioController
 */
@WebServlet("/buscarUsuario")
public class BusquedaUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaUsuarioController() {
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
	        List<Usuario> lista = null;
	        System.out.println(lista);
	        DbConnection conn = new DbConnection();
	        // Con nuestro objeto DAO, hacemos la busqueda de servidores
	        UsuarioDao usuarioDao = new UsuarioDao(conn);
	        lista = usuarioDao.getByQuery(q);
	  System.out.println("esta es la lista del controlador " + lista);
	        conn.disconnect();
	        RequestDispatcher rd;
	        request.setAttribute("usuarios", lista);
	  System.out.println("usuarios");
	        rd = request.getRequestDispatcher("/vistaUsuarios.jsp");
	        System.out.println(response);
	        rd.forward(request, response);
	        
	}

}
