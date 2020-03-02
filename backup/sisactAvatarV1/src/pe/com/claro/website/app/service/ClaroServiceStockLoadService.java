package pe.com.claro.website.app.service;

import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.MostrarExecuteStockProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteStockProcessType;

public interface ClaroServiceStockLoadService {
	
	public MostrarCheckProcessStatusStockType checkProcessStatusService(ObtenerCheckProcessStatusStockType getCheckProcessStatusElement) throws Exception;

	public MostrarExecuteStockProcessType executeStockProcessService(ObtenerExecuteStockProcessType getExecuteStockProcessElement) throws Exception;

}
