package pe.com.claro.website.admin.exception;



public class ServiceException extends RuntimeException {

	private String customMsg;

	/**
	 * Exception de Biblioteca
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String message){
		setCustomMsg(message);
	}
	
	public ServiceException(){
		
	}

	public String getCustomMsg() {
		return customMsg;
	}

	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}
	
	
}