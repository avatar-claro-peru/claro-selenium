/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import pe.com.claro.website.seguridad.domain.Perfil;


/**
 * @author lucio
 *
 */
public interface PerfilOpcionService{

	public void eliminarByPerfilId(Perfil command);

	public void registrarPerfilOpcion(Integer id, int[] idOpciones);

}
