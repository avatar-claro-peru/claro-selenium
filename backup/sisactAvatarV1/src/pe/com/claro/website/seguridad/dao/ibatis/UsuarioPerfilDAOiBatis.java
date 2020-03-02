/**
 * 
 */
package pe.com.claro.website.seguridad.dao.ibatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.seguridad.dao.UsuarioPerfilDAO;
import pe.com.claro.website.seguridad.domain.UsuarioPerfil;

/**
 * @author lucio
 * 
 */
public class UsuarioPerfilDAOiBatis extends SqlMapClientDaoSupport implements UsuarioPerfilDAO {

	private static Log log = LogFactory.getLog(UsuarioPerfilDAOiBatis.class);

	private String nombreClass = "UsuarioPerfil";

	@Override
	public void registrar(UsuarioPerfil to) {
		String ruta = getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(getNombreClass() + "." + ConstantesSisactAvatarMap.INSERT, to);
	}

	@Override
	public void eliminarByUsuarioId(Integer id) {
		getSqlMapClientTemplate().delete(getNombreClass() + "." + ConstantesSisactAvatarMap.DELETE_BY_USUARIO_ID, id);
	}

	public String getNombreClass() {
		return nombreClass;
	}

}
