package pe.com.claro.website.app.domain.service;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class MostrarExecuteStockProcessType extends BaseCommandTO{
	private java.lang.String idEvent;
	private java.lang.String codeReply;
	private java.lang.String messageReply;

	public MostrarExecuteStockProcessType() {
	}

	public java.lang.String getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(java.lang.String idEvent) {
		this.idEvent = idEvent;
	}

	public java.lang.String getCodeReply() {
		return codeReply;
	}

	public void setCodeReply(java.lang.String codeReply) {
		this.codeReply = codeReply;
	}

	public java.lang.String getMessageReply() {
		return messageReply;
	}

	public void setMessageReply(java.lang.String messageReply) {
		this.messageReply = messageReply;
	}
}
