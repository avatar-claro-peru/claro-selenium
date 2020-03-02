package pe.com.claro.website.seguridad.exception;

import javax.xml.rpc.ServiceException;

/**
 * @author lucio
 *
 */
public class MailSenderException extends ServiceException {
	
	public MailSenderException(){
		
	}
	
	public MailSenderException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
