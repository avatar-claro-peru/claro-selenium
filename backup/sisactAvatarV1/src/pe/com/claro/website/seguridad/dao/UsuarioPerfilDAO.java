/**
 * 
 */
package pe.com.claro.website.seguridad.dao;

import pe.com.claro.website.seguridad.domain.UsuarioPerfil;


/**
 * @author lucio
 *
 */
public interface UsuarioPerfilDAO  {

	public void registrar(UsuarioPerfil usuarioPerfil);

	public void eliminarByUsuarioId(Integer id);

}
