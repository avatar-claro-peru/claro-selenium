package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.EvaluacionDAO;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.domain.Evaluacion;

@SuppressWarnings("unchecked")
public class EvaluacionDAOiBatis extends SqlMapClientDaoSupport implements EvaluacionDAO{
	
	private String nombreClass = "Evaluacion";
	
	private static Log log = LogFactory.getLog(EvaluacionDAOiBatis.class);
	
	@Override
	public List<Evaluacion> listarTodo(Evaluacion param) {

		 String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		Evaluacion domain = setCriteriaList(param);
		List<Evaluacion> list=(List<Evaluacion>)getSqlMapClientTemplate().
		queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST, param);
		return list;
	}
	
	private Evaluacion setCriteriaList(Evaluacion to) {
		if (to != null) {
			if (to.getOrdenId() == null) {
				to.setOrdenId("%%");
			} else {
				to.setOrdenId("%" + to.getOrdenId() + "%");
			}
		}
		return to;
	}

	public List<Evaluacion> listarCamposPorParam(Integer paramID) {
		List<Evaluacion> list=(List<Evaluacion>)getSqlMapClientTemplate().
		queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST_FIELDS_BY_PARAM, paramID);
		return list;
	}
	
	@Override
	public void registrar(Evaluacion param) {
		getSqlMapClientTemplate().insert(getNombreClass()+"."+ConstantesSisactAvatarMap.INSERT, param);
	}	
	@Override
	public void actualizar(Evaluacion param) {
		getSqlMapClientTemplate().update(getNombreClass()+"."+ConstantesSisactAvatarMap.UPDATE, param);
	}
	@Override
	public void eliminar(Evaluacion param) {
		getSqlMapClientTemplate().delete(getNombreClass()+"."+ConstantesSisactAvatarMap.DELETE, param);
	}
	@Override
	public Evaluacion seleccionarPorId(Integer id) {
		Evaluacion domain=(Evaluacion)getSqlMapClientTemplate().
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
	public Evaluacion selectById(Integer id) {
		Evaluacion domain=(Evaluacion)getSqlMapClientTemplate().
		queryForObject(getNombreClass()+"."+ConstantesSisactAvatarMap.SELECTBYID,id);
		return domain;
	}

	
}
