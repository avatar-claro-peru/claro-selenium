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
import pe.com.claro.website.app.dao.DetalleOrdenDAO;
import pe.com.claro.website.app.domain.DetalleOrden;
import pe.com.claro.website.app.service.DetalleOrdenService;

/**
 * @author lucio
 *
 */
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

	private static Log log = LogFactory.getLog(DetalleOrdenServiceImpl.class);
	
	private DetalleOrdenDAO dao;
	/**
	 * @return
	 */
	protected DetalleOrdenDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(DetalleOrdenDAO dao) {
		this.dao = dao;
	}

	public void registrar(DetalleOrden to) throws AbstractException {
		log.info("Registrar DetalleOrden inicio..");
		try {
			log.info("Registrando el DetalleOrden");
			getDao().registrar(to);			
		} catch (Exception e) {
			log.info("registrar excepción");
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}
		log.info("registrar fin");
	}
/*
	public List<DetalleOrden> listarAll(Integer id) throws AbstractException {
		List<DetalleOrden> list = null;
		try {
			list = getDao().listarAll(id);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}*/

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleOrden> listarAll(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
