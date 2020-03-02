/**
 * 
 */
package pe.com.claro.website.seguridad.dao.ibatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.seguridad.dao.PerfilOpcionDAO;
import pe.com.claro.website.seguridad.domain.PerfilOpcion;

/**
 * @author lucio
 * 
 */
public class PerfilOpcionDAOiBatis extends SqlMapClientDaoSupport implements PerfilOpcionDAO {

	private static Log log = LogFactory.getLog(PerfilOpcionDAOiBatis.class);

	private String nombreClass = "PerfilOpcion";

	@Override
	public void registrar(PerfilOpcion to) {
		String ruta = getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT, to);
	}

	@Override
	public void eliminarByPerfilId(Integer id) {
		getSqlMapClientTemplate().delete(getNombreClass() + "." + ConstantesSisactAvatarMap.DELETE_BY_PERFIL_ID, id);
	}

	public String getNombreClass() {
		return nombreClass;
	}

}
