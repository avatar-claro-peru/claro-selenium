/**
 * 
 */
package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.TipoPlanDAO;
import pe.com.claro.website.app.domain.TipoPlan;


/**
 * @author lucio
 * 
 */
public class TipoPlanDAOiBatis extends SqlMapClientDaoSupport implements TipoPlanDAO {

	private static Log log = LogFactory.getLog(TipoPlanDAOiBatis.class);

	// private Usuario domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "TipoPlan";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */

	/** Metodo para actualizar */
	public void update(TipoPlan to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, to);

	}

	/** Metodo para seleccionar por ID */
	public TipoPlan selectById(Integer idTipoPlan) {
		TipoPlan domain = (TipoPlan) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, idTipoPlan);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(TipoPlan domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */
	public List listarAll(TipoPlan to) {
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST, to);
	}

	/** Metodo para guardar */
	public void registrar(TipoPlan to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPlan> listarForName(TipoPlan tipoPlan) {
		List<TipoPlan> listTipoPLan = null;
		listTipoPLan = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_NAME, tipoPlan);
		return listTipoPLan;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPlan> listarForTipoNumero(TipoPlan tipoPlan) {
		List<TipoPlan> listTipoPLan = null;
		listTipoPLan = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_TIPO_NUMERO, tipoPlan);
		return listTipoPLan;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPlan> listarByTopeConsumoID(Integer id) {
		log.info("Inicia consulta a la db para obtener la lista de topes de consumo asociados a un planes registrados.");
		List<TipoPlan> list = (List<TipoPlan>) getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LISTAR_BY_TOPE_CONSUMO_ID, id);
		return list;
	}

}
