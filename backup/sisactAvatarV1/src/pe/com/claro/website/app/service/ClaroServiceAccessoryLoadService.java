package pe.com.claro.website.app.service;

import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.MostrarExecuteAccessoryProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteAccessoryProcessType;

public interface ClaroServiceAccessoryLoadService {
	
	public MostrarCheckProcessStatusAccessoryType checkProcessStatusService(ObtenerCheckProcessStatusAccessoryType getCheckProcessStatusElement) throws Exception;
	
	public MostrarExecuteAccessoryProcessType executeAccessoryProcessService(ObtenerExecuteAccessoryProcessType getExecuteAccessoryProcessElement) throws Exception;

}
