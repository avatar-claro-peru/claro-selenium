package pe.com.claro.website.app.domain;

import java.util.Set;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class TipoPlan extends BaseCommandTO{
	private String codigoTipoPlan;
	private String tipoPlanEstado;
	private String descripcionTipoPlan;
	//private Set<TopeConsumo> opciones;
	private Set<TopeConsumo> topesConsumo;
	

	public TipoPlan() {
	}

	public TipoPlan(	Integer idTipoPlan,
						String codigoTipoPlan,
						String tipoPlanEstado,
						String descripcionTipoPlan) {
		super();
		this.setId(idTipoPlan);
		this.codigoTipoPlan = codigoTipoPlan;
		this.tipoPlanEstado = tipoPlanEstado;
		this.descripcionTipoPlan = descripcionTipoPlan;
	}

	public String getCodigoTipoPlan() {
		return codigoTipoPlan;
	}

	public void setCodigoTipoPlan(String codigoTipoPlan) {
		this.codigoTipoPlan = codigoTipoPlan;
	}

	public String getTipoPlanEstado() {
		return tipoPlanEstado;
	}

	public void setTipoPlanEstado(String tipoPlanEstado) {
		this.tipoPlanEstado = tipoPlanEstado;
	}

	public String getDescripcionTipoPlan() {
		return descripcionTipoPlan;
	}
	
	public String getEstadoTipoPlan() {
		if(getTipoPlanEstado().equals("1")){
			return "ACTIVO";
		} else {			
			return "INACTIVO";
		}
	}

	public void setDescripcionTipoPlan(String descripcionTipoPlan) {
		this.descripcionTipoPlan = descripcionTipoPlan;
	}

	public Set<TopeConsumo> getTopesConsumo() {
		return topesConsumo;
	}

	public void setTopesConsumo(Set<TopeConsumo> topesConsumo) {
		this.topesConsumo = topesConsumo;
	}
}