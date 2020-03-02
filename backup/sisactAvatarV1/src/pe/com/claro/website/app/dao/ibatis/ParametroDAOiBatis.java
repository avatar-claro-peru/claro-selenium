package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.ParametroDAO;
import pe.com.claro.website.app.domain.Parametro;

@SuppressWarnings("unchecked")
public class ParametroDAOiBatis extends SqlMapClientDaoSupport implements ParametroDAO{
	
	private String nombreClass = "Parametro";
	
	private static Log log = LogFactory.getLog(ParametroDAOiBatis.class);
	
	@Override
	public List<Parametro> listarTodo(Parametro param) {

		 String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		List<Parametro> list=(List<Parametro>)getSqlMapClientTemplate().
		queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST, param);
		return list;
	}
	
	public List<Parametro> listarCamposPorParam(Integer paramID) {
		List<Parametro> list=(List<Parametro>)getSqlMapClientTemplate().
		queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST_FIELDS_BY_PARAM, paramID);
		return list;
	}
	
	@Override
	public Parametro seleccionarPorNombre(String nombre){
		Parametro parametro=(Parametro)getSqlMapClientTemplate().
		queryForObject(getNombreClass()+"."+ConstantesSisactAvatarMap.SELECTBYNAME,nombre);
		return parametro;
	}
	
	@Override
	public void registrar(Parametro param) {
		getSqlMapClientTemplate().insert(getNombreClass()+"."+ConstantesSisactAvatarMap.INSERT, param);
	}	
	@Override
	public void actualizar(Parametro param) {
		getSqlMapClientTemplate().update(getNombreClass()+"."+ConstantesSisactAvatarMap.UPDATE, param);
	}
	@Override
	public void eliminar(Parametro param) {
		getSqlMapClientTemplate().delete(getNombreClass()+"."+ConstantesSisactAvatarMap.DELETE, param);
	}
	@Override
	public Parametro seleccionarPorId(Integer id) {
		Parametro domain=(Parametro)getSqlMapClientTemplate().
        queryForObject(getNombreClass()+"."+ConstantesSisactAvatarMap.SELECTBYID, id);		
       return domain;
	}
	
	public String getNombreClass() {
		return nombreClass;
	}
	public void setNombreClass(String nombreClass) {
		this.nombreClass = nombreClass;
	}

	@Override
	public Parametro selectById(Integer id) {
		Parametro domain=(Parametro)getSqlMapClientTemplate().
		queryForObject(getNombreClass()+"."+ConstantesSisactAvatarMap.SELECTBYID,id);
		return domain;
	}

	@Override
	public List<Parametro> listarForTipoNumero(Parametro parametro) {
		List<Parametro> listParametros = null;
		listParametros = getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.LIST_FOR_NAME_PARAM, parametro);
		return listParametros;
	}
	
	

	
}
