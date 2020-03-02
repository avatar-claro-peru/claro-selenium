package pe.com.claro.website.app.domain;

import java.util.Date;
import java.util.Set;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;
import pe.com.claro.website.app.domain.DetalleOrden;

public class Orden extends BaseCommandTO {

	private String idPedido;
	private Double monto;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private String numeroLinea;
	private String numeroDocumento;
	private Integer tipoDocumento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String codigoTopeConsumo;
	private Set<DetalleOrden> listaDetallesOrden;
	
	private DetalleOrden detalleOrden; 

	public String getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getNumeroLinea() {
		return numeroLinea;
	}
	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getCodigoTopeConsumo() {
		return codigoTopeConsumo;
	}
	
	/**
	 * @return the codigoTopeConsumo
	 */

	public Set<DetalleOrden> getListaDetallesOrden() {
		return listaDetallesOrden;
	}
	public void setListaDetallesOrden(Set<DetalleOrden> listaDetallesOrden) {
		this.listaDetallesOrden = listaDetallesOrden;
	}
	/**
	 * @param codigoTopeConsumo the codigoTopeConsumo to set
	 */
	public void setCodigoTopeConsumo(String codigoTopeConsumo) {
		this.codigoTopeConsumo = codigoTopeConsumo;
	}
	
	public DetalleOrden getDetalleOrden() {
		return detalleOrden;
	}
	public void setDetalleOrden(DetalleOrden detalleOrden) {
		this.detalleOrden = detalleOrden;
	}
	@Override
	public String toString() {
		return "Orden [idPedido=" + idPedido + ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", monto=" + monto + ", numeroLinea=" + numeroLinea
				+ ", numeroDocumento=" + numeroDocumento + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				 + "]";
	}
}
