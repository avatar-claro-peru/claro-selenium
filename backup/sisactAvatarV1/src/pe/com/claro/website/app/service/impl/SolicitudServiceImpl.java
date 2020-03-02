package pe.com.claro.website.app.service.impl;
import java.util.ArrayList;
import java.util.List;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.SolicitudDAO;
import pe.com.claro.website.app.domain.Solicitud;
import pe.com.claro.website.app.service.SolicitudService;

public class SolicitudServiceImpl implements SolicitudService{

	
	private SolicitudDAO dao;

	@Override
	public List<Solicitud> listarTodo(Solicitud solicitud) throws Exception {
		List<Solicitud> lista = null;
		try {
			lista = new ArrayList<Solicitud>();
			lista = getDao().listarTodo(solicitud);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return lista;
	}	
	
	public SolicitudDAO getDao() {
		return dao;
	}

	public void setDao(SolicitudDAO dao) {
		this.dao = dao;
	}


}
