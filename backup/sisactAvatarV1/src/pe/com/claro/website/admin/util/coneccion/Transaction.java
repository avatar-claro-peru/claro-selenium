/*
 * Created on 14/04/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package pe.com.claro.website.admin.util.coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * @modelguid {DEFD4B7C-EEE3-466F-98F2-AFC969CCCAFA}
 */
public class Transaction {
	
	static String driverName = Messages.getString("driverName"); //$NON-NLS-1$
	static String ubicacionBaseDatos = Messages.getString("ubicacionBaseDatos"); //$NON-NLS-1$
	static String url = Messages.getString("url") + ":" + ubicacionBaseDatos; //$NON-NLS-1$
	static String user = Messages.getString("user"); //$NON-NLS-1$
	static String password= Messages.getString("password"); //$NON-NLS-1$
	
	/** @modelguid {10838535-4FA9-447C-B26A-EEE0AE28DE5E} */
	private Connection con = null;

	/** @modelguid {C37A8FD4-E8CD-4054-B517-F8F16C5E8977} */
	public Transaction() {
	}
	
		

	static public Connection getJDBCConnection() throws TransactionException {
		try {		
			//localizar el driver y llevarlo a memoria
			Class.forName(driverName).newInstance();
		} catch (Exception e) {
			//este error ocurre si no se encuentra el driver
			throw new TransactionException(Messages.getString("msg01")); //$NON-NLS-1$
		}
		try {
			//solicitar la conexi�n
			Connection connection = null;
			//connection = DriverManager.getConnection(url);
			connection = DriverManager.getConnection(url, user,password);
			return connection;
		} catch (SQLException e1) {
			//si no pudo conectarse
			throw new TransactionException(e1);
		}		
	}


	public Connection getConnection() throws TransactionException {
        //patr�n SINGLETOM
		if (con == null) {
			con = getJDBCConnection();
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				throw new TransactionException(e);
			}
		}
		return con;
	}


	public void commit() throws TransactionException {
		try {
			if (con != null)
				con.commit();
		} catch (SQLException e) {
			throw new TransactionException(e);
		}

	}


	public void rollback() {
		try {
			if (con != null)
				con.rollback();
		} catch (SQLException ignored) {
			ignored.printStackTrace();
		}
	}


	public void close() {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException ignored) {
			ignored.printStackTrace();
		}
	}
}
