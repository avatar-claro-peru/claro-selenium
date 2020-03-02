package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class TipoPlanxTopeConsumo extends BaseCommandTO {
	
	private TipoPlan tipoPlan;
	private TopeConsumo topeConsumo;
	
	public TipoPlan getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(TipoPlan tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public TopeConsumo getTopeConsumo() {
		return topeConsumo;
	}
	public void setTopeConsumo(TopeConsumo topeConsumo) {
		this.topeConsumo = topeConsumo;
	}
}