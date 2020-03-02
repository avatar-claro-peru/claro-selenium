/**
 * 
 */
package pe.com.claro.website.seguridad.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.seguridad.dao.PerfilOpcionDAO;
import pe.com.claro.website.seguridad.domain.Opcion;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.PerfilOpcion;
import pe.com.claro.website.seguridad.service.PerfilOpcionService;

/**
 * @author lucio
 * 
 */
public class PerfilOpcionServiceImpl implements PerfilOpcionService {

	private static Log log = LogFactory.getLog(PerfilOpcionServiceImpl.class);

	private PerfilOpcionDAO dao;


	@Override
	public void eliminarByPerfilId(Perfil command) {
		getDao().eliminarByPerfilId(command.getId());
		
	}

	@Override
	public void registrarPerfilOpcion(Integer id, int[] idOpciones) {
		PerfilOpcion perfilOpcion;
		Opcion opcion;
		Perfil perfil;
		
		perfil=new Perfil();
		perfil.setId(id);
		
		for (int i = 0; i < idOpciones.length; i++) {
			opcion=new Opcion();
			opcion.setId(idOpciones[i]);
			
			perfilOpcion=new PerfilOpcion();
			perfilOpcion.setOpcion(opcion);
			perfilOpcion.setPerfil(perfil);
			
			getDao().registrar(perfilOpcion);
		}
		
	}

	public PerfilOpcionDAO getDao() {
		return dao;
	}

	public void setDao(PerfilOpcionDAO dao) {
		this.dao = dao;
	}

}
