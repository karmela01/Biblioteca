package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import model.Prestamo;

public class PrestamoDao {
	
	private DbConnection conn;
	
	public PrestamoDao(DbConnection conn) {
		
		this.conn = conn;
	}

}
