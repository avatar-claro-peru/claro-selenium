/**
 * 
 */
package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.TopeConsumoDAO;
import pe.com.claro.website.app.domain.TopeConsumo;


/**
 * @author lucio
 * 
 */
public class TopeConsumoDAOiBatis extends SqlMapClientDaoSupport implements TopeConsumoDAO {

	private static Log log = LogFactory.getLog(TopeConsumoDAOiBatis.class);

	// private Usuario domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "TopeConsumo";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */

	/** Metodo para actualizar */
	public void update(TopeConsumo to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, to);

	}

	/** Metodo para seleccionar por ID */
	public TopeConsumo selectById(Integer idTopeConsumo) {
		TopeConsumo domain = (TopeConsumo) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, idTopeConsumo);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(TopeConsumo domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */
	public List listarAll(TopeConsumo to) {
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST, to);
	}

	/** Metodo para guardar */
	public void registrar(TopeConsumo to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	@SuppressWarnings("unchecked")
	public List<TopeConsumo> listarForName(TopeConsumo topeConsumo) {
		List<TopeConsumo> listTopesConsumo = null;
		listTopesConsumo = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_NAME, topeConsumo);
		return listTopesConsumo;
	}

	@SuppressWarnings("unchecked")
	public List<TopeConsumo> listarForTipoNumero(TopeConsumo topeConsumo) {
		List<TopeConsumo> listTopesConsumo = null;
		listTopesConsumo = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_TIPO_NUMERO, topeConsumo);
		return listTopesConsumo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopeConsumo> listarByTipoPlanId(Integer id) {
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_TIPO_PLAN;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_TIPO_PLAN, id);
	}
	
}
