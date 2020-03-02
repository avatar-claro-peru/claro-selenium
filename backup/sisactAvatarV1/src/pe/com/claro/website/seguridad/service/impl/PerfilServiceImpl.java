/**
 * 
 */
package pe.com.claro.website.seguridad.service.impl;

import java.util.List;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.seguridad.dao.PerfilDAO;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.service.PerfilService;


/**
 * @author lucio
 *
 */
public class PerfilServiceImpl implements PerfilService {
	private PerfilDAO dao;

	/**
	 * @return
	 */
	protected PerfilDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(PerfilDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(Perfil to) throws AbstractException {
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
	public List<Perfil> listarAll(Perfil to) throws AbstractException {
		List<Perfil> list = null;
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
	public void registrar(Perfil to) throws AbstractException {
		try {
			getDao().registrar(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#buscarPorId(java
	 * .lang.String)
	 */
	public Perfil selectById(Integer id) throws AbstractException {
		Perfil domain = null;

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

	@Override
	public List<Perfil> listarRolesByUsuario(Usuario command) throws Exception {
		List<Perfil> list = null;
		try {
			list = getDao().listarByUsuarioId(command.getId());
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}
}
