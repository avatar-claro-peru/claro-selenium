package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Solicitud;

public interface SolicitudService {
	public List<Solicitud> listarTodo(Solicitud solicitud) throws Exception;
}
