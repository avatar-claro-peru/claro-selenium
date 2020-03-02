package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.SolicitudDAO;
import pe.com.claro.website.app.domain.Solicitud;

@SuppressWarnings("unchecked")
public class SolicitudDAOiBatis extends SqlMapClientDaoSupport implements SolicitudDAO{

	private String nombreClass = "Solicitud";
	
	public String getNombreClass() {
		return nombreClass;
	}

	public void setNombreClass(String nombreClass) {
		this.nombreClass = nombreClass;
	}
	
	private static Log log = LogFactory.getLog(OrdenDAOiBatis.class);
	
	@Override
	public List<Solicitud> listarTodo(Solicitud solicitud) {
		// TODO Auto-generated method stub
	 	String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
		log.info("RUTA :" + ruta);
		List<Solicitud> listaSolicitudes = null;
		if(solicitud.getCliente() == null && solicitud.getTelefono() == null){
			listaSolicitudes=(List<Solicitud>)getSqlMapClientTemplate().
					queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST,solicitud);	
		}else{
			if(solicitud.getTelefono()!=null){
				listaSolicitudes=(List<Solicitud>)getSqlMapClientTemplate().
						queryForList(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYNROCEL, solicitud.getTelefono());
			}else{
				listaSolicitudes=(List<Solicitud>)getSqlMapClientTemplate().
						queryForList(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYDNI, solicitud.getCliente().getNum_doc());
			}
					
		}
		return listaSolicitudes;
	}

}
