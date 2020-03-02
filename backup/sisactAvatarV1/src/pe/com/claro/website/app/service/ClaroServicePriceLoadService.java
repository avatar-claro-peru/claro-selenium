package pe.com.claro.website.app.service;

import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.MostrarExecutePriceProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.ObtenerExecutePriceProcessType;

public interface ClaroServicePriceLoadService {

	public MostrarExecutePriceProcessType executePriceProcessService(ObtenerExecutePriceProcessType getExecutePriceProcessElement) throws Exception;

	public MostrarCheckProcessStatusPriceType checkProcessStatusService(ObtenerCheckProcessStatusPriceType getCheckProcessStatusElement) throws Exception;
	

}
