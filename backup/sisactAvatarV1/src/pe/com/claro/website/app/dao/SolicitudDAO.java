package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Solicitud;

public interface SolicitudDAO {
	public List<Solicitud> listarTodo(Solicitud solicitud);
}
