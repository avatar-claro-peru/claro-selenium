/**
 * 
 */
package pe.com.claro.website.seguridad.dao;

import pe.com.claro.website.seguridad.domain.PerfilOpcion;


/**
 * @author lucio
 *
 */
public interface PerfilOpcionDAO  {

	public void registrar(PerfilOpcion perfilOpcion);

	public void eliminarByPerfilId(Integer id);

}
