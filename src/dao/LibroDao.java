  package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import model.Libro;

public class LibroDao {
	
	private DbConnection conn;
	
	public LibroDao(DbConnection conn) {
		this.conn = conn;
	}
	
	public int ejecuta(String consultaSQL ) {
		 int filasAfectadas;
		 try {
			 
			 Statement sentencia = (Statement) conn.getConnection().createStatement();
			 filasAfectadas = sentencia.executeUpdate(consultaSQL);

	        } catch (SQLException e) {
	            System.out.println("Error LibroDao: " + e.getMessage());
	            filasAfectadas = -1;
	        }
		 return filasAfectadas;
	}
	
	// INSERTAR LIBROS //////////////////////////////////////////////////////////////////////////
	
	public boolean insert(Libro lbr) {
		
		 //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			String sql = "insert into libro values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);	
			preparedStatement.setInt(1, lbr.getId());
			preparedStatement.setString(2, lbr.getTitulo());
			preparedStatement.setString(3, lbr.getAutor() );
			preparedStatement.setString(4, lbr.getEditorial());
			preparedStatement.executeUpdate();
			
			return true;
			
		}catch(SQLException e){
			
			System.out.println("Error LibroDao.insert: " + e.getMessage());
			
			return false;
		}	
	}
	
	// LISTAR LIBROS //////////////////////////////////////////////////////////////////////////////////
	
	public List<Libro> getAll(){
		
		try {
			String sql = "select * from libro order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Libro> list = new LinkedList<>();
            Libro lbr;
            while (rs.next()) {
            	lbr = new Libro(rs.getInt("id"));
            	lbr.setTitulo(rs.getString("titulo"));
            	lbr.setAutor(rs.getString("autor"));
            	lbr.setEditorial(rs.getString("editorial"));
            	
                // Add servidor object to the list
                list.add(lbr);
                System.out.println("ha añadido los registros a la lista");
            }
            System.out.println(list);
            return list;
		}
		catch(SQLException e) {
			 System.out.println("Error LibroDao.getAll: " + e.getMessage());
	            return null;
		}
	}
	
	// BORRAR LIBROS ////////////////////////////////////////////////////////////////////////////////////////
	
	public int borrar(int id) {
		String consultaSQL = "delete from libro where id='" + id + "';";
		return ejecuta(consultaSQL);
	}
	
	// EDITAR LIBROS ////////////////////////////////////////////////////////////////////////////////////////
	
	public int actualizar(Libro lbr) {
		String consultaSQL = "update  libro  set titulo ='"+ lbr.getTitulo() +"', autor='"+ lbr.getAutor() +"', editorial='"+ lbr.getEditorial() + "' where id='"+ lbr.getId() + "'";
		//String consultaSQL = "update  DEPART  set dnombre='"+ d.getDNombre() +"', loc='"+ d.getLoc() + "' where dept='"+ d.getDept() + "'";
		
		return ejecuta(consultaSQL);
	}
	
	// BUSCAR LIBROS POR TITULO O EDITORIAL  //////////////////////////////////////////////////////////////////////////////////////
	
	 public List<Libro> getByQuery(String query){

	        try {
	            String sql = "select * from libro where (titulo like ? or editorial like ?) order by titulo desc";
	            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
	            preparedStatement.setString(1, "%" + query + "%");
	            preparedStatement.setString(2, "%" + query + "%");
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Libro> list = new LinkedList<>();
	            Libro lbr;
	            while (rs.next()) {
	            	lbr = new Libro(rs.getInt("id"));
	            	lbr.setTitulo(rs.getString("titulo"));
	            	lbr.setAutor(rs.getString("autor"));
	            	lbr.setEditorial(rs.getString("editorial"));	            	         
	                // Se añade el objeto libro a la lista
	                list.add(lbr);
	                System.out.println("esta es la lista con el objeto libro " + lbr);
	            }
	            return list;

	        } catch (SQLException e) {            
	            System.out.println("Error LibroDao.getByQuery: " + e.getMessage());
	            return null;
	        }
	    }
	 
	 // BUSCAR LIBRO POR ID //////////////////////////////////////////////////////////////////////////
	 
	 public Libro buscarId (int id) {
			String sql = "select * from libro where id='"+ id +"'";
			Libro lbr = null;
			try {
				//PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
				 //ResultSet rs = preparedStatement.executeQuery();
				Statement st = (Statement) conn.getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				rs.first();
				lbr = new Libro(rs.getInt("id"));

		        } catch (SQLException e) {
		            System.out.println("Error LibroDao: " + e.getMessage());
		            
		        }
			return lbr;
			
		}
	
}

