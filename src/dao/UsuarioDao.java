package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import model.Libro;
import model.Usuario;
import model.Usuario;

public class UsuarioDao {
	
	private DbConnection conn;
	
	public UsuarioDao(DbConnection conn) {
		this.conn = conn;
	}
	
	public int ejecuta(String consultaSQL ) {
		 int filasAfectadas;
		 try {			 
			 Statement sentencia = (Statement) conn.getConnection().createStatement();
			 filasAfectadas = sentencia.executeUpdate(consultaSQL);

	        } catch (SQLException e) {
	            System.out.println("Error UsuarioDao: " + e.getMessage());
	            filasAfectadas = -1;
	        }
		 return filasAfectadas;
	}
	
	// INSERTAR USUARIOS ///////////////////////////////////////////////////////////////////////////////
	public boolean insert(Usuario usr) {
		
		try {
			String sql = "insert into usuario values(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);	
			preparedStatement.setInt(1, usr.getId());
			preparedStatement.setString(2, usr.getNombre());
			preparedStatement.setString(3, usr.getMail());
			preparedStatement.setString(4, usr.getPassword());
			preparedStatement.setString(5, usr.getEstado());
			preparedStatement.executeUpdate();
			
			return true;
			
		}
		catch(SQLException e) {
			
			System.out.println("Error UsuarioDao.insert: " + e.getMessage());
			return false;
		}
	}
	
	// LISTAR USUARIOS //////////////////////////////////////////////////////////////////////////////////////
	public List<Usuario> getAll(){
			
			try {
				String sql = "select * from usuario order by nombre desc";
	            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Usuario> list = new LinkedList<>();
	            Usuario usr;
	            while (rs.next()) {
	            	usr = new Usuario(rs.getInt("id"));
	            	usr.setNombre(rs.getString("nombre"));
	            	usr.setMail(rs.getString("mail"));
	            	usr.setEstado(rs.getString("estado"));
	            	
	                // Add servidor object to the list
	                list.add(usr);
	                System.out.println("ha añadido los registros a la lista");
	            }
	            System.out.println(list);
	            return list;
			}
			catch(SQLException e) {
				 System.out.println("Error UsuarioDao.getAll: " + e.getMessage());
		            return null;
			}
		}
	
	
	// BUSCAR USUARIOS POR NOMBRE   //////////////////////////////////////////////////////////////////////////////////////
	
	 public List<Usuario> getByQuery(String query){

	        try {
	            String sql = "select * from usuario where (nombre like ?) order by nombre desc";
	            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
	            preparedStatement.setString(1, "%" + query + "%");	          
	            ResultSet rs = preparedStatement.executeQuery();
	            List<Usuario> list = new LinkedList<>();
	            Usuario usr;
	            while (rs.next()) {
	            	usr = new Usuario(rs.getInt("id"));
	            	usr.setNombre(rs.getString("nombre"));
	            	usr.setMail(rs.getString("mail"));
	            	usr.setEstado(rs.getString("estado"));	            	         
	                // Se añade el objeto libro a la lista
	                list.add(usr);
	                System.out.println("esta es la lista con el objeto libro " + usr);
	            }
	            return list;

	        } catch (SQLException e) {            
	            System.out.println("Error LibroDao.getByQuery: " + e.getMessage());
	            return null;
	        }
	    }
	
	
	
	// BORRAR USUARIOS ////////////////////////////////////////////////////////////////////////////////////////
	
		public int borrar(int id) {
			String consultaSQL = "delete from usuario where id='" + id + "';";
			return ejecuta(consultaSQL);
		}

}
