/*
 * Created on 17/02/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package pe.com.claro.website.admin.util.coneccion;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * @modelguid {FE8B90A4-67C3-45E5-8D78-3E8A45241C3A}
 */
public class TransactionException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msgError = "La transacci�n ha fallado";

	public TransactionException(String string) {
		super(msgError + " : " + string);
	}

	public TransactionException() {
		super(msgError);
	}

	public TransactionException(Throwable cause) {
		super(msgError + " : " + cause.getMessage());

	}
	
	public String toString(){
		return getMessage();
	}

}
