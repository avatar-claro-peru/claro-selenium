/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;

/**
 * @author lucio
 * 
 */
public interface PerfilService {
	
	public void registrar(Perfil Perfil) throws Exception;

	public void actualizar(Perfil Perfil) throws Exception;

	public void eliminar(Integer Perfil) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<Perfil> listarAll(Perfil Perfil) throws Exception;

	public Perfil selectById(Integer id) throws Exception;
	
	public List<Perfil> listarRolesByUsuario(Usuario command) throws Exception;
}
