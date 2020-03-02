package pe.com.claro.website.app.service;

import pe.com.claro.website.app.domain.service.MostrarSendEventStatusType;
import pe.com.claro.website.app.domain.service.ObtenerSendEventStatusType;

public interface ClaroServiceSyncOrderService {
	
	public MostrarSendEventStatusType sendEventStatus(ObtenerSendEventStatusType datosEntrada);
}
