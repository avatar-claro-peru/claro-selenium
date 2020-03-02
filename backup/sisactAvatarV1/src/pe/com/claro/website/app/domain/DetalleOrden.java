package pe.com.claro.website.app.domain;

import java.util.Date;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class DetalleOrden extends BaseCommandTO{
	
	private Integer ordenId;
	private String estadoPrinc;
	private String codMssap;
	private String codPvu;
	private String serieChip;
	private String serieEquipo;
	private String codigoOficina;
	private String codigoSolicitud;
	//lsoto: 04-02-20 Incluir la fecha de registro del detalle de la orden - INICIO
	private Date fechaRegistro;
	//lsoto: 04-02-20 Incluir la fecha de registro del detalle de la orden - FIN

	public DetalleOrden() {
	}

	public DetalleOrden(	Integer idDetalleOrden,
						Integer ordenId,
						String estadoPrinc,
						String codMssap,
						String codPvu,
						String serieChip,
						String serieEquipo,
						String codigoOficina,
						String codigoSolicitud,
						Date fechaRegistro
						) {
		super();
		this.setId(idDetalleOrden);
		this.ordenId = ordenId;
		this.estadoPrinc = estadoPrinc;
		this.codMssap = codMssap;
		this.codPvu = codPvu;
		this.serieChip = serieChip;
		this.serieEquipo = serieEquipo;
		this.codigoOficina = codigoOficina;
		this.codigoSolicitud = codigoSolicitud;
		this.fechaRegistro = fechaRegistro;
	}

	public int getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}

	public String getEstadoPrinc() {
		return estadoPrinc;
	}

	public void setEstadoPrinc(String estadoPrinc) {
		this.estadoPrinc = estadoPrinc;
	}

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
	
	public String getDescripcionEstadoPintcipal() {

		if(getEstadoPrinc().equals("1")){
			return "Venta está correcta";
		} else if(getEstadoPrinc().equals("2")){			
			return "Venta tiene errores";
		}else if(getEstadoPrinc().equals("3")){
			return "Venta cancelada";
		}else if(getEstadoPrinc().equals("4")){
			return "Pago exitoso";
		}else {
			return "Evento no definido";
		}
	}

	//lsoto: 04-02-20 Incluir la fecha de registro del detalle de la orden - INICIO
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	//lsoto: 04-02-20 Incluir la fecha de registro del detalle de la orden - FIN	
}