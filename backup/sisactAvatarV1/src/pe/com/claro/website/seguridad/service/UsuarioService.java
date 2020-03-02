/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import java.util.List;

import org.acegisecurity.userdetails.UserDetailsService;

import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;


/**
 * @author lucio
 *
 */
public interface UsuarioService extends  UserDetailsService {

	/* comunes */
	public void registrar(Usuario usuario) throws Exception;

	public void actualizar(Usuario usuario) throws Exception;

	//public void eliminar(Integer Usuario) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<Usuario> listarAll(Usuario usuario) throws Exception;

	public Usuario selectById(Integer id) throws Exception;
	
	/* comunes */
	
	public Usuario findByNombre(Usuario usuario);
	
	public void eliminar(Usuario usuario) throws Exception;




}
