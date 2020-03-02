package pe.com.claro.website.seguridad.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseCommandTO {

	private Integer id;
	
	private Integer codigoError;
	
	private String mensajeError;

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public void setCodigoError(Integer codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	

	public String getMensajeError() {
		return this.mensajeError;
	}
	
	public Integer  getCodigoError() {
		if (this.codigoError == null) {
			return 1;
		}
		else {
			return this.codigoError;
		}
	 
	}

	public boolean isSaved(){
		return getId() != null;
	}
}
