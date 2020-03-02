/**
 * 
 */
package pe.com.claro.website.seguridad.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.app.dao.TipoPlanxTopeConsumoDAO;
import pe.com.claro.website.app.domain.TopeConsumo;
import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.domain.TipoPlanxTopeConsumo;
import pe.com.claro.website.seguridad.service.TopeConsumoTipoPlanOpcionService;

/**
 * @author lucio
 * 
 */
public class TopeConsumoTipoPlanOpcionServiceImpl implements TopeConsumoTipoPlanOpcionService {

	private static Log log = LogFactory.getLog(TopeConsumoTipoPlanOpcionServiceImpl.class);

	private TipoPlanxTopeConsumoDAO dao;

	public TipoPlanxTopeConsumoDAO getDao() {
		return dao;
	}

	public void setDao(TipoPlanxTopeConsumoDAO dao) {
		this.dao = dao;
	}

	@Override
	public void eliminarByTopeConsumoId(TipoPlan command) {
		getDao().eliminarByTopeConsumoId(command.getId());
		
	}

	@Override
	public void registrarTipoPlanxTopeConsumo(Integer id, int[] idTopesConsumo) {
		TipoPlanxTopeConsumo tipoPlanxTopeConsumo;
		TopeConsumo topeConsumo;
		TipoPlan tipoPlan;
		
		tipoPlan=new TipoPlan();
		tipoPlan.setId(id);
		
		for (int i = 0; i < idTopesConsumo.length; i++) {
			topeConsumo=new TopeConsumo();
			topeConsumo.setId(idTopesConsumo[i]);
			
			tipoPlanxTopeConsumo=new TipoPlanxTopeConsumo();
			tipoPlanxTopeConsumo.setTopeConsumo(topeConsumo);
			tipoPlanxTopeConsumo.setTipoPlan(tipoPlan);
			
			getDao().registrarTipoPlanxTopeConsumo(tipoPlanxTopeConsumo);
		}	
	}
}
