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
import pe.com.claro.website.seguridad.dao.OpcionDAO;
import pe.com.claro.website.seguridad.domain.Opcion;

/**
 * @author lucio
 * 
 */
@SuppressWarnings("unchecked")
public class OpcionDAOiBatis extends SqlMapClientDaoSupport implements OpcionDAO {
	
	private static Log log = LogFactory.getLog(OpcionDAOiBatis.class);
	
	//private Class domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "Opcion";
	/*
	private Class getGenericClass() {
		log.info("Clase:" + this.getClass().getName());
		return GenericUtil.getGenericClass(this.getClass());
	}*/


	/** Metodo para actualizar */
	public void update(Opcion to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, to);

	}

	/** Metodo para seleccionar por ID */
	public Opcion selectById(Integer id) {
		Opcion domain = (Opcion) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(Opcion domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */

	public List listarAll(Opcion to) {

		Opcion domain = setCriteriaList(to);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST, domain);
	}

	/** Criteria para listar */
	public Opcion setCriteriaList(Opcion to) {
		return null;
	}

	/** Metodo para guardar */
	public void registrar(Opcion to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	@Override
	public List<Opcion> listarByPerfilId(Integer id) {
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_PERFIL;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_PERFIL, id);
	}
}
