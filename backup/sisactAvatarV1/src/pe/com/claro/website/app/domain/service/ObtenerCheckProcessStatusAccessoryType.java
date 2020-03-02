package pe.com.claro.website.app.domain.service;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class ObtenerCheckProcessStatusAccessoryType extends BaseCommandTO {
	
	private java.lang.String userId;
	private java.lang.String password;	
	
	public ObtenerCheckProcessStatusAccessoryType() {
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
