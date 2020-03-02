package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.SmsDAO;
import pe.com.claro.website.app.domain.Sms;

public class SmsDAOiBatis extends SqlMapClientDaoSupport implements SmsDAO {
	
	private static Log log = LogFactory.getLog(SmsDAOiBatis.class);

	private String nombreClass = "Sms";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */

	/** Metodo para seleccionar por ID */
	public Sms selectById(Integer id_sms) {
		Sms domain = (Sms) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id_sms);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(Sms domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */
	public List listarAll(Integer id) {

		Sms domain = setCriteriaList(id);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST , id);
	}
	
	/** Metodo para listar bajo criterio */
	public List listarByLineaId(Integer id) {

		Sms domain = setCriteriaList(id);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_LINEA;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_BY_ID_LINEA , id);
	}	

	/** Criteria para listar */
	public Sms setCriteriaList(Integer to) {
		return null;
	}

	public String getNombreClass() {
		return nombreClass;
	}

}
