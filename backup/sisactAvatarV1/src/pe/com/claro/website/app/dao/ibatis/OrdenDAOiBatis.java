package pe.com.claro.website.app.dao.ibatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.com.claro.framework.common.ConstantesSisactAvatarMap;
import pe.com.claro.website.app.dao.OrdenDAO;
import pe.com.claro.website.app.domain.Orden;

@SuppressWarnings("unchecked")
public class OrdenDAOiBatis extends SqlMapClientDaoSupport implements OrdenDAO {

	private String nombreClass = "Orden";
	
	public String getNombreClass() {
		return nombreClass;
	}


	public void setNombreClass(String nombreClass) {
		this.nombreClass = nombreClass;
	}

	private static Log log = LogFactory.getLog(OrdenDAOiBatis.class);
	
	@Override
	public List<Orden> listarTodo(Orden orden) {
		// TODO Auto-generated method stub
		 	String ruta = nombreClass + "." + ConstantesSisactAvatarMap.LIST;
			log.info("RUTA :" + ruta);
			List<Orden> listaOrdenes = null;
			if(orden.getIdPedido() == null){
				listaOrdenes=(List<Orden>)getSqlMapClientTemplate().
						queryForList(getNombreClass()+"."+ConstantesSisactAvatarMap.LIST,orden);	
			}else{
				listaOrdenes=(List<Orden>)getSqlMapClientTemplate().
						queryForList(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYPEDIDOID, orden.getIdPedido());
				orden.setIdPedido(null);
			}
			return listaOrdenes;
	}
	
	@Override
	public Orden seleccionarPorPedidoId(Integer id) {
	   Orden domain=(Orden)getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYPEDIDOID, id);
	   return domain;
	}
	
	@Override
	public Orden selectById(Integer id) {
		 Orden orden=(Orden)getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYID, id);
		 return orden;
	}

	@Override
	public Orden selectByIdOrdenDetalle(Integer id) {
		Orden orden=(Orden)getSqlMapClientTemplate().queryForObject(nombreClass + "." + ConstantesSisactAvatarMap.SELECTBYIDORDENDETALLE, id);
		 return orden;
	}


	@Override
	public List<Orden> listarCamposPorParam(Integer paramID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrar(Orden param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Orden param) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update(nombreClass + "." + ConstantesSisactAvatarMap.UPDATE, param);
	}

	@Override
	public void eliminar(Orden param) {
		// TODO Auto-generated method stub
		
	}



	
}
