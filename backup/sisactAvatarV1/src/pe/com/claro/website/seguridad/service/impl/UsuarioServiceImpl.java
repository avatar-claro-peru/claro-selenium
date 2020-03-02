/**
 * 
 */
package pe.com.claro.website.seguridad.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.seguridad.dao.UsuarioDAO;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.encriptacion.HashPassWord;
import pe.com.claro.website.seguridad.service.UsuarioService;

/**
 * @author lucio
 * 
 */
public class UsuarioServiceImpl implements UsuarioService {

	private static Log log = LogFactory.getLog(UsuarioServiceImpl.class);

	private UsuarioDAO dao;

	/**
	 * @return
	 */ 
	protected UsuarioDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(Usuario to) throws AbstractException {
		try {
			log.info("generando la contraseña");
			if (to.getPassword()!=null && to.getPassword()!="") {
				to.setPassword(generatePassword(to.getPassword()));	
			}else {
				Usuario usuarioDb=selectById(to.getId());
				to.setPassword(usuarioDb.getPassword());
			}
			log.info("registrar registrando el usuario");
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
	public List<Usuario> listarAll(Usuario to) throws AbstractException {
		List<Usuario> list = null;
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
	public void registrar(Usuario to) throws AbstractException {
		log.info("registrar inicio");
		try {
			log.info("registrar buscando si el nombre de usuario ya existe");
			if (findByNombre(to) == null) {

				log.info("generando la contraseña");
				to.setPassword(generatePassword(to.getPassword()));
				log.info("registrar registrando el usuario");
				getDao().registrar(to);
			} else {
				log.info("registrar el usuario ya existe");
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("Usuario ya esta registrado.");
			}

		} catch (Exception e) {
			log.info("registrar excepción");
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}

		log.info("registrar fin");
	}

	private String generatePassword(String password) {
		log.info("generatePassword inicio");
		HashPassWord hashPWD;
		String claveMd5Inicial = null;
		
		try {
			
			hashPWD = new HashPassWord();
			claveMd5Inicial = hashPWD.passWord(password, hashPWD.getSaltString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		log.info("generatePassword fin");
		return claveMd5Inicial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#buscarPorId(java
	 * .lang.String)
	 */
	public Usuario selectById(Integer id) throws AbstractException {
		log.info("selectById inicio");
		Usuario domain = null;

		try {
			domain = getDao().selectById(id);
			log.info("selectById domain:" + domain);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_SELECT_BYID);
		}
		log.info("selectById fin");
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#eliminar(java.lang
	 * .Object)
	 */
	public void eliminar(Usuario to) throws AbstractException {
		log.info("eliminar inicio");
		try {
			//No se puede eliminar la cuenta de administrador que esta logeado			
			Usuario usuarioSesion = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println("getUsername:"+usuarioSesion.getUsername());
			Usuario usuarioEliminar = selectById(to.getId());
			
			if (usuarioSesion.getUsername().equals(usuarioEliminar.getUsername())) {
				log.info("eliminar seteando error, no se puede eliminar el usuario logeado.");
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("No se puede eliminar el usuario logeado.");
			}else {
				getDao().eliminar(to.getId());
			}
			
			
		} catch (Exception e) {
			log.info("e:" + e.getMessage());
			throw new AbstractException(Constante.KEY_DELETE_ERROR);
		}
		log.info("eliminar fin");
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
	 * @see
	 * org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java
	 * .lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		log.info("Ingreso loadUserByUsername ");
		List<Usuario> usuario = null;
		try {
			usuario = findByFilter(new Usuario(username));
			// validacion de la contrasenia
			if (usuario.size() == 0)
				return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario.get(0);
	}

	private List<Usuario> findByFilter(Usuario usuario) {
		List<Usuario> list = getDao().listarForName(usuario);
		return list;
	}

	public Usuario findByNombre(Usuario usuario) {
		log.info("findByNombre inicio");
		Usuario domain = null;
		List<Usuario> list = getDao().listarForName(usuario);
		log.info("findByNombre domain:" + list.size());
		if (list.size() > 0) {
			domain = list.get(0);
		}
		log.info("findByNombre domain:" + domain);
		log.info("findByNombre fin");
		return domain;
	}

}
