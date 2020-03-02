/**
 * 
 */
package pe.com.claro.website.seguridad.service;

import java.util.List;

import pe.com.claro.website.seguridad.domain.Opcion;
import pe.com.claro.website.seguridad.domain.Perfil;

/**
 * @author lucio
 * 
 */
public interface OpcionService {

	public void registrar(Opcion Opcion) throws Exception;

	public void actualizar(Opcion Opcion) throws Exception;

	public void eliminar(Integer Opcion) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<Opcion> listarAll(Opcion Opcion) throws Exception;

	public Opcion selectById(Integer id) throws Exception;

	public List<Opcion> listarOpcionesByPerfil(Perfil perfil);
}
