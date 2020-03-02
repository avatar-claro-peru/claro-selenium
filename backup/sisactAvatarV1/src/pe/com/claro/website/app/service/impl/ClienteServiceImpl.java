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
import pe.com.claro.website.app.dao.ClienteDAO;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.service.ClienteService;


/**
 * @author lucio
 *
 */
public class ClienteServiceImpl implements ClienteService {

	private static Log log = LogFactory.getLog(ClienteServiceImpl.class);
	
	private ClienteDAO dao;

	/**
	 * @return
	 */
	protected ClienteDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(Cliente to) throws AbstractException {
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
	public List<Cliente> listarAll(Cliente to) throws AbstractException {
		List<Cliente> list = null;
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
	public void registrar(Cliente to) throws AbstractException {
		log.info("registrar inicio");
		try {
			
			if (findByTipoNumero(to) == null) {
				log.info("registrar registrando el usuario");
				getDao().registrar(to);
			}else {
				log.info("registrar el usuario ya existe");
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("Cliente ya esta registrado, existe el tipo y numero registrado.");
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
	public Cliente selectById(Integer id) throws AbstractException {
		Cliente domain = null;

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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
//	public UserDetails loadUserByUsername(String nombre)
//			throws UsernameNotFoundException, DataAccessException{
//		log.info("Ingreso loadUserByUsername ");
//		List<Cliente> usuario=null;
//		try {
//			cliente = findByFilter(new Cliente(nombre));
//			//validacion de la contrasenia
//			if(usuario.size() == 0)
//			return null;
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return cliente.get(0);
//	}

	
//	private List<Cliente> findByFilter(Cliente cliente) {
//		List<Cliente> list=getDao().listarForName(cliente);
//		return list;
//	}


	public Cliente findByNombre(Cliente cliente) {
		Cliente domain=null;
		List<Cliente> list=getDao().listarForName(cliente);
		if (list.size()>0) {
			domain=list.get(0);
		}
		return domain;
	}

	public Cliente findByTipoNumero(Cliente cliente) {
		log.info("findByTipoNumero inicio");
		Cliente domain=null;
		List<Cliente> list=getDao().listarForTipoNumero(cliente);
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
