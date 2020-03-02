/**
 * 
 */
package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.DetalleOrdenDAO;
import pe.com.claro.website.app.domain.DetalleOrden;

/**
 * @author Leonardo Soto
 * 
 */
public class DetalleOrdenDAOiBatis extends SqlMapClientDaoSupport implements DetalleOrdenDAO {

	private static Log log = LogFactory.getLog(DetalleOrdenDAOiBatis.class);
	private String nombreClass = "DetalleOrden";

	/** Metodo para guardar */
	public void registrar(DetalleOrden to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleOrden> selectDetalleOrdenxIDOrden(Integer idOrden) {
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST_DETALLE_ORDEN_BY_ID_ORDEN;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_DETALLE_ORDEN_BY_ID_ORDEN, idOrden);
	}
}
