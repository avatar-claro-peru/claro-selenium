/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Usuario;


/**
 * @author lucio
 *
 */
public interface UsuarioPerfilService{

	public void eliminarByUsuarioId(Usuario command);

	public void registrarUsuarioPerfil(Integer id, int[] idRoles);


}
