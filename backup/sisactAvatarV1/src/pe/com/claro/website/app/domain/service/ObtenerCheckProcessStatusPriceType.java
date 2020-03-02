package pe.com.claro.website.app.domain.service;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class ObtenerCheckProcessStatusPriceType extends BaseCommandTO {
	private java.lang.String userId;
	private java.lang.String password;

	public ObtenerCheckProcessStatusPriceType() {
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
