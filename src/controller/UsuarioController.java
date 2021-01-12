package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.lang.*;
import dao.DbConnection;
import dao.LibroDao;
import dao.UsuarioDao;
import model.Libro;
import model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        
        switch (action) {
    	case "lista": this.verTodas(request, response);break;
    	case "borra": this.borraRegistro(request, response, id);break;
    	//case "edita": this.editaUsuario(request, response, id);break;
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub   doGet(request, response);
		Usuario usr = new Usuario(0);
		
		String nombreUsr = request.getParameter("nombre");
		usr.setNombre(nombreUsr);
		String mailUsr = request.getParameter("mail");
		usr.setMail(mailUsr);
		String passwordUsr = request.getParameter("password");
		usr.setPassword(passwordUsr);
		String estadoUsr = request.getParameter("estado");
		usr.setEstado(estadoUsr);
		
		System.out.println(usr);
		
		
		DbConnection conn = new DbConnection();		
		
		UsuarioDao usuarioDao = new UsuarioDao(conn);
		
		boolean status = usuarioDao.insert(usr);
		
		String msg = "";
		if(status) {
			msg = "Usuario guardado con éxito.";
		}else {
			msg = "Se ha producido un error, no se ha guardado el usuario.";
		}
		//se produce la desconexión con la base de datos
		
		conn.disconnect();
		RequestDispatcher rd;
		
		request.setAttribute("message", msg);
		
		// se envia la respuesta a la vista mensaje.jsp
		rd = request.getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
	}
	
	// MÉTODO PARA LISTAR TODOS LOS USUARIOS /////////////////////////////////////////////////////////////////
	
		 protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        DbConnection conn = new DbConnection();
		        UsuarioDao usuarioDao = new UsuarioDao(conn);
		        List<Usuario> lista = usuarioDao.getAll();
		        System.out.println("esta es la lista del metodo vertodas");
		        System.out.println(lista);
		        conn.disconnect();
		        // Compartimos la variable lista, para poder accederla desde la vista
		        request.setAttribute("usuarios", lista);
		        System.out.println("usuarios,lista es correcto");
		        System.out.println(lista);
		        RequestDispatcher rd;
		        rd = request.getRequestDispatcher("/vistaUsuarios.jsp");
		        rd.forward(request, response);	       
		    }
		 
		// MÉTODO PARA BORRAR TODOS LOS LIBROS /////////////////////////////////////////////////////////////////
		 
		 protected void borraRegistro(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		        DbConnection conn = new DbConnection();
		        UsuarioDao usrdao = new UsuarioDao(conn);
		        usrdao.borrar(id);
		        conn.disconnect();
		        verTodas(request, response);
		    } 
		 

}
