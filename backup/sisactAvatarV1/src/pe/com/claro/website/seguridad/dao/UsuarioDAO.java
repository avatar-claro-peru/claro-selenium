/**
 * 
 */
package pe.com.claro.website.seguridad.dao;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Usuario;


/**
 * @author lucio
 *
 */
public interface UsuarioDAO  {
	/* comunes */ 
	public void registrar(Usuario Usuario);

	public void update(Usuario Usuario);

	public Usuario selectById(Integer id);

	public void eliminar(Integer id);

	public List<Usuario> listarAll(Usuario Usuario);
	/* comunes */
	
	public List<Usuario> listarForName(Usuario usuario);

	public Usuario listarForNombre(Usuario usuario);
	
	

}
