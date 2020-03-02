/**
 * 
 */
package pe.com.claro.website.seguridad.dao;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Opcion;

/**
 * @author lucio
 * 
 */
public interface OpcionDAO  {

	public void registrar(Opcion opcion);

	public void update(Opcion opcion);

	public Opcion selectById(Integer id);

	public void eliminar(Integer id);

	public List<Opcion> listarAll(Opcion opcion);

	public List<Opcion> listarByPerfilId(Integer id);
}
