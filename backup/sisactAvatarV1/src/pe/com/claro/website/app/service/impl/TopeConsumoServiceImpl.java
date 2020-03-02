/**
 * 
 */
package pe.com.claro.website.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import pe.com.claro.framework.common.Messages;
import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.TopeConsumoDAO;
import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.domain.TopeConsumo;
import pe.com.claro.website.app.service.TopeConsumoService;


/**
 * @author lucio
 *
 */
public class TopeConsumoServiceImpl implements TopeConsumoService {

	private static Log log = LogFactory.getLog(TopeConsumoServiceImpl.class);
	
	private TopeConsumoDAO dao;
	/**
	 * @return
	 */
	protected TopeConsumoDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(TopeConsumoDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(TopeConsumo to) throws AbstractException {
		try {
			getDao().update(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#listar(java.lang
	 * .Object)
	 */
	public List<TopeConsumo> listarAll(TopeConsumo to) throws AbstractException {
		List<TopeConsumo> list = null;
		try {
			list = getDao().listarAll(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#registrar(java.
	 * lang.Object)
	 */
	public void registrar(TopeConsumo to) throws AbstractException {
		log.info("registrar inicio");
		try {
			
			if (findByTipoNumero(to) == null) {
				log.info("egistrando el tope de consumo");
				getDao().registrar(to);
			}else {
				log.info("El código de servicio ingresado para el tipo de consumo ya existe");
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("El código de servicio ingresado para el tipo de consumo que se intenta crear, ya existe.");
			}
						
		} catch (Exception e) {
			log.info("registrar excepción");
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}
		log.info("registrar fin");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#buscarPorId(java
	 * .lang.String)
	 */
	public TopeConsumo selectById(Integer id) throws AbstractException {
		TopeConsumo domain = null;
		Set<TipoPlan> lstTipoPlan = new HashSet<>();
		try {
			domain = getDao().selectById(id);
			if (domain != null) {
				lstTipoPlan = domain.getListaPlanesAsociados();
				if (lstTipoPlan != null && !lstTipoPlan.isEmpty()) {
					String planesAsociados = "";
					for (TipoPlan tipoPlan : lstTipoPlan) {
						planesAsociados += tipoPlan.getDescripcionTipoPlan() + " - ";
					}
					domain.setPlanesAsociados(planesAsociados);
				} else {
					domain.setPlanesAsociados(Messages.RESPUESTA.LISTA_PLANES_ASOCIADOS_VACIA);
				}
			}

		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_SELECT_BYID);
		}

		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#eliminar(java.lang
	 * .Object)
	 */
	public void eliminar(Integer to) throws AbstractException {
		try {
			getDao().eliminar(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_DELETE_ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#eliminar(java.lang
	 * .Object)
	 */
	public void eliminarArray(int[] ids) throws AbstractException {
		try {
			for (int i = 0; i < ids.length; i++) {

				getDao().eliminar(ids[i]);
			}

		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_DELETE_ERROR);
		}

	}
	
	public TopeConsumo findByNombre(TopeConsumo topeConsumo) {
		TopeConsumo domain=null;
		List<TopeConsumo> list=getDao().listarForName(topeConsumo);
		if (list.size()>0) {
			domain=list.get(0);
		}
		return domain;
	}

	public TopeConsumo findByTipoNumero(TopeConsumo topeConsumo) {
		log.info("findByTipoNumero inicio");
		TopeConsumo domain=null;
		List<TopeConsumo> list=getDao().listarForTipoNumero(topeConsumo);
		log.info("findByNombre domain:"+list.size());
		if (list.size()>0) {
			domain=list.get(0);
		}
		log.info("findByTipoNumero domain:"+domain);
		log.info("findByTipoNumero fin");
		return domain;
	}
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopeConsumo> listarTopesConsumoByTipoPlan(TipoPlan tipoPlan) {
		List<TopeConsumo> list = null;
		try {
			list = getDao().listarByTipoPlanId(tipoPlan.getId());
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}

}
