package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.domain.Orcomment;

@SuppressWarnings("unchecked")
public class OrcommentDAOiBatis extends SqlMapClientDaoSupport implements OrcommentDAO{
	
	private String nombreClass = "Orcomment";
	
	private static Log log = LogFactory.getLog(OrcommentDAOiBatis.class);
	
	@Override
	public List<Orcomment> findByField(String field) {
		log.info("Inicia consulta a la db para obtener la lista de topes de consumo registrados.");
		List<Orcomment> list = (List<Orcomment>) getSqlMapClientTemplate().queryForList(nombreClass + "." + ConstantesSisactAvatarMap.FINDBYFIELD, field);
		return list;
	}

	
}
