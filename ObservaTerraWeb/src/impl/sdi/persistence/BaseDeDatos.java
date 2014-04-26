package impl.sdi.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 * Base de datos dónde se establece la conexión y se desconecta
 * 
 */
public class BaseDeDatos {

	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	
	public BaseDeDatos() {
		con = null;
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost";
			// Obtenemos la conexiÃ³n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver no encontrado", e);
		} catch (SQLException e) {
			throw new RuntimeException("Error al conectar", e);
		}
	}
	/**
	 * Conecta a la base de datos
	 */
	public boolean desconectarBD(){
		if (con != null) {
			try {
				con.close();
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
		else{
			return true;
		}
	}

}
