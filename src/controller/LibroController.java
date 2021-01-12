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
import model.Libro;

/**
 * Servlet implementation class LibroController
 */
@WebServlet("/libro")
public class LibroController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public LibroController() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub       response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        
        switch (action) {
    	case "lista": this.verTodas(request, response);break;
    	case "borra": this.borraRegistro(request, response, id);break;    	
    	case "edita": this.editaRegistro(request, response, id);break;
    	
    }
        //if ("ver".equals(action)) {
            //this.verDetalle(request, response);
       // } else
        /*
        if ("lista".equals(action)) {
            this.verTodas(request, response);
            System.out.println("pasa el if del doget del controladodr");
        }else if ("borra".equals(action)) {
            this.borraRegistro(request, response, id);
       } 
        //else if ("enviar".equals(action)) {
            //this.mostrarFormulario(request, response);
       // }
		
		*/
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Libro lbr = new Libro(0);
		
		String tituloLbr = request.getParameter("titulo");
		lbr.setTitulo(tituloLbr);
		String autorLbr = request.getParameter("autor");
		lbr.setAutor(autorLbr);
		String editorialLbr = request.getParameter("editorial");
		lbr.setEditorial(editorialLbr);
		
		System.out.println(lbr);
		
		//ahora se procesan los datos para insertar en la base de datos
		
		DbConnection conn = new DbConnection();	
		
		LibroDao libroDao = new LibroDao(conn);	
System.out.println("entra la conexion de la base de datos");
		boolean status = libroDao.insert(lbr);
System.out.println("pasa por el metodo insert");
		// creamos el mensaje para el usuario
		
		String msg = "";
		if(status) {
			msg = "Libro guardado con éxito.";
		}else {
			msg = "Se ha producido un error, no se ha guardado el libro.";
		}
		//se produce la desconexión con la base de datos
		
		conn.disconnect();
		RequestDispatcher rd;
		
		request.setAttribute("message", msg);
		
		// se envia la respuesta a la vista mensaje.jsp
		rd = request.getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);		
	}
	
	// MÉTODO PARA LISTAR TODOS LOS LIBROS /////////////////////////////////////////////////////////////////
	
	 protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        DbConnection conn = new DbConnection();
	        LibroDao libroDao = new LibroDao(conn);
	        List<Libro> lista = libroDao.getAll();
	        System.out.println("esta es la lista del metodo vertodas");
	        System.out.println(lista);
	        conn.disconnect();
	        // Compartimos la variable lista, para poder accederla desde la vista
	        request.setAttribute("libros", lista);
	        System.out.println("libros,lista es correcto");
	        System.out.println(lista);
	        RequestDispatcher rd;
	        rd = request.getRequestDispatcher("/vistaLibros.jsp");
	        rd.forward(request, response);	       
	    }
	 
	// MÉTODO PARA BORRAR TODOS LOS LIBROS /////////////////////////////////////////////////////////////////
	 
	 protected void borraRegistro(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
	        DbConnection conn = new DbConnection();
	        LibroDao ldao = new LibroDao(conn);
	        ldao.borrar(id);
	        conn.disconnect();
	        verTodas(request, response);
	    } 
	 
	// MÉTODO PARA EDITAR LIBROS /////////////////////////////////////////////////////////////////////////////////////
		
		protected void editaRegistro(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
	        DbConnection conn = new DbConnection();
	        LibroDao lbrDao = new LibroDao(conn);
	        Libro lbr = lbrDao.buscarId(id);
	        conn.disconnect();
	        request.setAttribute("id", lbr);
	   System.out.print(lbr);
	        RequestDispatcher rd;
	        rd = request.getRequestDispatcher("/formEditLibro.jsp");
	        rd.forward(request, response);
	    }
	 

}
