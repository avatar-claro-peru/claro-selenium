/**
 * 
 */
package pe.com.claro.website.seguridad.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.framework.common.General;
import pe.com.claro.framework.common.GenericUtil;
import pe.com.claro.website.seguridad.dao.UsuarioDAO;
import pe.com.claro.website.seguridad.domain.Usuario;

/**
 * @author lucio
 * 
 */
public class UsuarioDAOiBatis extends SqlMapClientDaoSupport implements UsuarioDAO {

	private static Log log = LogFactory.getLog(UsuarioDAOiBatis.class);

	//private Usuario domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "Usuario";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */


	/** Metodo para actualizar */
	public void update(Usuario to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, to);

	}

	/** Metodo para seleccionar por ID */
	public Usuario selectById(Integer id) {
		log.info("selectById ingreso");
		Usuario domain = (Usuario) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id);
		log.info("selectById domain:"+domain);
		setDomainAditional(domain);
		log.info("selectById salio");
		return domain;
	}

	protected void setDomainAditional(Usuario domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */

	public List listarAll(Usuario to) {

		Usuario domain = setCriteriaList(to);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST, domain);
	}

	/** Criteria para listar */
	public Usuario setCriteriaList(Usuario to) {
		return null;
	}

	/** Metodo para guardar */
	public void registrar(Usuario to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	public List<Usuario> listarForName(Usuario usuario) {
		List<Usuario> listUsuarios = null;
		listUsuarios = getSqlMapClientTemplate().queryForList(nombreClass + "." +ConstantesSisactAvatarMap.LIST_FOR_NAME, usuario);
		return listUsuarios;
	}

	public Usuario listarForNombre(Usuario usuario) {
		Usuario domain = null;
		domain = (Usuario) getSqlMapClientTemplate().queryForObject(nombreClass + "." +ConstantesSisactAvatarMap.LIST_FOR_NAME, usuario);
		return domain;
	}

}
