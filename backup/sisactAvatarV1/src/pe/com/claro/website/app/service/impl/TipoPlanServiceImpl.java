/**
 * 
 */
package pe.com.claro.website.app.service.impl;

import java.util.List;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.TipoPlanDAO;
import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.service.TipoPlanService;;


/**
 * @author lucio
 *
 */
public class TipoPlanServiceImpl implements TipoPlanService {

	private static Log log = LogFactory.getLog(TipoPlanServiceImpl.class);
	
	private TipoPlanDAO dao;

	/**
	 * @return
	 */
	protected TipoPlanDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(TipoPlanDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(TipoPlan to) throws AbstractException {
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
	public List<TipoPlan> listarAll(TipoPlan to) throws AbstractException {
		List<TipoPlan> list = null;
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
	public void registrar(TipoPlan to) throws AbstractException {
		log.info("registrar inicio");
		try {
			
			if (findByTipoNumero(to) == null) {
				log.info("Registrando el tipo de plan");
				getDao().registrar(to);
			}else {
				log.info("El código de tipo de plan ingresado para el tipo de plan ya existe");
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("El código de tipo de plan ingresado para el tipo de plan que se intenta crear, ya existe.");
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
	public TipoPlan selectById(Integer id) throws AbstractException {
		TipoPlan domain = null;

		try {
			domain = getDao().selectById(id);

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
	
	public TipoPlan findByNombre(TipoPlan tipoPlan) {
		TipoPlan domain=null;
		List<TipoPlan> list=getDao().listarForName(tipoPlan);
		if (list.size()>0) {
			domain=list.get(0);
		}
		return domain;
	}

	public TipoPlan findByTipoNumero(TipoPlan tipoPlan) {
		log.info("findByTipoNumero inicio");
		TipoPlan domain=null;
		List<TipoPlan> list=getDao().listarForTipoNumero(tipoPlan);
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

}
