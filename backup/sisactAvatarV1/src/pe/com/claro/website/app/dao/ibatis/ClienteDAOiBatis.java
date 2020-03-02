/**
 * 
 */
package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.ClienteDAO;
import pe.com.claro.website.app.domain.Cliente;

/**
 * @author lucio
 * 
 */
public class ClienteDAOiBatis extends SqlMapClientDaoSupport implements ClienteDAO {

	private static Log log = LogFactory.getLog(ClienteDAOiBatis.class);

	// private Usuario domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "Cliente";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */

	/** Metodo para actualizar */
	public void update(Cliente to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, to);

	}

	/** Metodo para seleccionar por ID */
	public Cliente selectById(Integer id_cliente) {
		Cliente domain = (Cliente) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id_cliente);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(Cliente domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(Integer to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE, to);
	}

	/** Metodo para listar bajo criterio */
	public List listarAll(Cliente to) {

		Cliente domain = setCriteriaList(to);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST, domain);
	}

	/** Criteria para listar */
	public Cliente setCriteriaList(Cliente to) {
		if (to != null) {
			if (to.getNum_doc() == null) {
				to.setNum_doc("%%");
			} else {
				to.setNum_doc("%" + to.getNum_doc() + "%");
			}
			if (to.getNombre() == null) {
				to.setNombre("%%");
			} else {
				to.setNombre("%" + to.getNombre() + "%");
			}
		}
		return to;
	}

	/** Metodo para guardar */
	public void registrar(Cliente to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarForName(Cliente cliente) {
		List<Cliente> listUsuarios = null;
		listUsuarios = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_NAME, cliente);
		return listUsuarios;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarForTipoNumero(Cliente cliente) {
		List<Cliente> listUsuarios = null;
		listUsuarios = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_TIPO_NUMERO, cliente);
		return listUsuarios;
	}

}
