package pe.com.claro.website.app.dao.ibatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.LineDAO;
import pe.com.claro.website.app.domain.Line;

public class LineDAOiBatis extends SqlMapClientDaoSupport implements LineDAO{
	
	private static Log log = LogFactory.getLog(LineDAOiBatis.class);

	//private Usuario domainClass;
	// private DataFieldMaxValueIncrementer incrementer;

	private String nombreClass = "Line";

	/*
	 * private Class getGenericClass() { log.info("Clase:" +
	 * this.getClass().getName()); return
	 * GenericUtil.getGenericClass(this.getClass()); }
	 */


	/** Metodo para actualizar */
	public void update(Line to) {

		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE_LINES, to);

	}

	/** Metodo para seleccionar por ID */
	public Line selectById(String id_line) {
		Line domain = (Line) getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id_line);
		setDomainAditional(domain);
		return domain;
	}

	protected void setDomainAditional(Line domain) {

	}

	/** Metodo para eliminar */
	public void eliminar(String to) {
		getSqlMapClientTemplate().delete(nombreClass + "." + ConstantesSisactAvatarMap.DELETE_LINES, to);
	}

	/** Metodo para listar bajo criterio */
	public List listarAll(Integer id) {

		Line domain = setCriteriaList(id);
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST_LINES;
		log.info("RUTA :" + ruta);
		return getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_LINES , id);
	}

	/** Criteria para listar */
	public Line setCriteriaList(Integer to) {
		return null;
	}

	/** Metodo para guardar */
	public void registrar(Line to) {
		// to.setId(getIncrementer().nextIntValue());
		String ruta = nombreClass + "." + ConstantesSisactAvatarMap.INSERT_LINES;
		log.info("RUTA :" + ruta);
		getSqlMapClientTemplate().insert(nombreClass + "." + ConstantesSisactAvatarMap.INSERT_LINES, to);

	}

	public String getNombreClass() {
		return nombreClass;
	}

	public List<Line> listarForName(Line line) {
		List<Line> listLines = null;
		listLines = getSqlMapClientTemplate().queryForList(ConstantesSisactAvatarMap.LIST_LINES_LINE, line);
		return listLines;
	}

	public Line listarForNombre(Line line) {
		Line domain = null;
		domain = (Line) getSqlMapClientTemplate().queryForObject(ConstantesSisactAvatarMap.LIST_LINES_LINE, line);
		return domain;
	}
	
	/* lsoto: 29:06:19: Creamos la función para validar si existe la línea ingresada: INICIO*/
	public int encontrarLinea(String numeroLinea){
		int existe=1;
		//  Line domain = null;
		List lista = null;
		lista = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.VALIDATE_LINE_EXISTENCE, numeroLinea);
		if(lista.isEmpty()){
			existe=0;
		}
		return existe;
	}
	/* lsoto: 29:06:19: Creamos la función para validar si existe la línea ingresada: FIN*/
}
