package pe.com.claro.website.app.domain.service;

import java.util.Calendar;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class MostrarSendEventStatusType extends BaseCommandTO{
	
	private int estado;
	private String codigoRespuesta;
	private String idEvento;
	private Calendar fecha;
	private String descripciónRespuesta;

	public int getEstado() {
		return estado;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getDescripciónRespuesta() {
		return descripciónRespuesta;
	}

	public void setDescripciónRespuesta(String descripciónRespuesta) {
		this.descripciónRespuesta = descripciónRespuesta;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "MostrarSendEventStatusType [estado=" + estado + ",idEvento="+idEvento+ "]";
	}
	
	
	
}
