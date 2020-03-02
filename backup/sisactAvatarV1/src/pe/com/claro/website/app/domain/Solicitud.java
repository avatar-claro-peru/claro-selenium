package pe.com.claro.website.app.domain;

import java.util.Date;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Solicitud extends BaseCommandTO{
	
	private String idCliente;
	private String token;
	private String codigoSMS;
	private Integer telefono;
	private Integer estado;
	private Date fechaGeneracion;
	private Date fechaValidacion;
	private Integer intentosFallidos;
	private Cliente cliente;
	private String dni;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCodigoSMS() {
		return codigoSMS;
	}
	public void setCodigoSMS(String codigoSMS) {
		this.codigoSMS = codigoSMS;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaValidacion() {
		return fechaValidacion;
	}
	public void setFechaValidacion(Date fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}
	public Integer getIntentosFallidos() {
		return intentosFallidos;
	}
	public void setIntentosFallidos(Integer intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	
	@Override
	public String toString() {
		return "Solicitud [idCliente=" + idCliente + ", token=" + token + ", codigoSMS=" + codigoSMS + ", estado=" + estado + ", fechaGeneracion=" + fechaGeneracion
				+ ", fechaValidacion=" + fechaValidacion + ", intentosFallidos=" + intentosFallidos + "]";
	}
}
