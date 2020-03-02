/**
 * 
 */
package pe.com.claro.website.seguridad.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.seguridad.dao.UsuarioPerfilDAO;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.domain.UsuarioPerfil;
import pe.com.claro.website.seguridad.service.UsuarioPerfilService;

/**
 * @author lucio
 * 
 */
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

	private static Log log = LogFactory.getLog(UsuarioPerfilServiceImpl.class);

	private UsuarioPerfilDAO dao;

	@Override
	public void eliminarByUsuarioId(Usuario command) {

		getDao().eliminarByUsuarioId(command.getId());

	}

	@Override
	public void registrarUsuarioPerfil(Integer id, int[] idRoles) {
		UsuarioPerfil usuarioPerfil;
		Usuario usuario;
		Perfil perfil;
		
		usuario=new Usuario();
		usuario.setId(id);
		
		for (int i = 0; i < idRoles.length; i++) {
			perfil=new Perfil();
			perfil.setId(idRoles[i]);
			
			usuarioPerfil=new UsuarioPerfil();
			usuarioPerfil.setUsuario(usuario);
			usuarioPerfil.setPerfil(perfil);
			
			getDao().registrar(usuarioPerfil);
		}
		
	}

	public UsuarioPerfilDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioPerfilDAO dao) {
		this.dao = dao;
	}

}
