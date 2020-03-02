/**
 * 
 */
package pe.com.claro.website.seguridad.dao;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Perfil;


/**
 * @author lucio
 *
 */
public interface PerfilDAO  {

	public void registrar(Perfil perfil);

	public void update(Perfil perfil);

	public Perfil selectById(Integer id);

	public void eliminar(Integer id);

	public List<Perfil> listarAll(Perfil perfil);

	public List<Perfil> listarByUsuarioId(Integer id);
}
