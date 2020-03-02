package pe.com.claro.website.app.domain.service;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class ObtenerSendEventStatusType extends BaseCommandTO {

	public int estado;
	public String ordenNro;
	public String usuario;
	public String password;
	public String comentario;
	public int cantidadLineas;
	
	//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
	private String codMssap;
	private String codPvu;
	private String serieChip;
	private String serieEquipo;
	private String codigoOficina;
	private String codigoSolicitud;
	//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getOrdenNro() {
		return ordenNro;
	}

	public void setOrdenNro(String ordenNro) {
		this.ordenNro = ordenNro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCantidadLineas() {
		return cantidadLineas;
	}

	public void setCantidadLineas(int cantidadLineas) {
		this.cantidadLineas = cantidadLineas;
	}
	
	//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
	public String getCodMssap() {
		return codMssap;
	}

	public void setCodMssap(String codMssap) {
		this.codMssap = codMssap;
	}

	public String getCodPvu() {
		return codPvu;
	}

	public void setCodPvu(String codPvu) {
		this.codPvu = codPvu;
	}

	public String getSerieChip() {
		return serieChip;
	}

	public void setSerieChip(String serieChip) {
		this.serieChip = serieChip;
	}

	public String getSerieEquipo() {
		return serieEquipo;
	}

	public void setSerieEquipo(String serieEquipo) {
		this.serieEquipo = serieEquipo;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}
	//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN
}