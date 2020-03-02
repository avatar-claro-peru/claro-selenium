package pe.com.claro.website.app.dao.ibatis;

import pe.com.claro.website.app.dao.TipoPlanxTopeConsumoDAO;
import pe.com.claro.website.app.domain.TipoPlanxTopeConsumo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.com.claro.framework.common.ConstantesSisactAvatarMap;



public class TipoPlanxTopeConsumoDAOiBatis extends SqlMapClientDaoSupport implements TipoPlanxTopeConsumoDAO {

	private static Log log = LogFactory.getLog(TipoPlanxTopeConsumoDAOiBatis.class);
	private String nombreClass = "TipoPlanxTopeConsumo";
	
	public String getNombreClass() {
		return nombreClass;
	}
	
	public void setNombreClass(String nombreClass) {
		this.nombreClass = nombreClass;
	}
	
	@Override
	public void registrarTipoPlanxTopeConsumo(TipoPlanxTopeConsumo to) {
		String ruta = getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT, to);
	}
	
	@Override
	public void eliminarByTopeConsumoId(Integer id) {
		getSqlMapClientTemplate().delete(getNombreClass() + "." + ConstantesSisactAvatarMap.DELETE_BY_TOPE_CONSUMO_ID, id);
		
	}	
}