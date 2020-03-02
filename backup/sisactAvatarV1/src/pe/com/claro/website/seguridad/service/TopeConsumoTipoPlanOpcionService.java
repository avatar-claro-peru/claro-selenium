/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import pe.com.claro.website.app.domain.TipoPlan;
//import pe.com.claro.website.app.domain.TopeConsumo;
//import pe.com.claro.website.seguridad.domain.Perfil;

/**
 * @author Leonardo Soto
 * 
 */
public interface TopeConsumoTipoPlanOpcionService {

	public void eliminarByTopeConsumoId(TipoPlan command);

	public void registrarTipoPlanxTopeConsumo(Integer id, int[] idTopesConsumo);
}
