package pe.com.claro.website.app.domain.service;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class ObtenerExecutePriceProcessType  extends BaseCommandTO{
	private java.lang.String userId;
	private java.lang.String password;

	
	
	public ObtenerExecutePriceProcessType(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public ObtenerExecutePriceProcessType() {
	}

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}
}
