/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pe.com.claro.website.admin.util.coneccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TestConexion {

	public static void main(String[] args) {
		Transaction t = new Transaction();
		try {
			Connection con = t.getConnection();
			System.out.println(con);
			
			try {
				PreparedStatement prepare = con.prepareStatement("select * from Parametro ");				
//				prepare.setInt(1, new Integer(1));
				ResultSet resultado = prepare.executeQuery();
				
				while (resultado.next()) {
					System.out.println(resultado.getString(1));
					System.out.println(resultado.getString(2));
					System.out.println(resultado.getString(3));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (TransactionException e) {
			System.out.println(e);
		} finally {
			t.close();
		}
	}
}