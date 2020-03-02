package pe.com.claro.website.app.service.impl;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub;
import pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad_v1Locator;
import pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessRequest;
import pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessResponse;
import pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessRequest;
import pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessResponse;
import pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
import pe.com.claro.esb.data.bss.generico.util.ClaroGenericHandler;
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.MostrarExecutePriceProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.ObtenerExecutePriceProcessType;
import pe.com.claro.website.app.service.ClaroServicePriceLoadService;

public class ClaroServicePriceLoadServiceImpl implements ClaroServicePriceLoadService {

	private static Log WCLogger = LogFactory.getLog(ClaroServicePriceLoadServiceImpl.class);

	@Override
	public MostrarCheckProcessStatusPriceType checkProcessStatusService(ObtenerCheckProcessStatusPriceType tipo) throws Exception {

		MostrarCheckProcessStatusPriceType checkProcessStatusType = null;

		try {

			/* connexion al servidor remoto */
			BSS_ClaroPriceLoad_v1Locator locator = new BSS_ClaroPriceLoad_v1Locator();
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroPriceLoadSOAPAddress());

			/* Creando metodo para invocar */
			BSS_ClaroPriceLoadSOAPStub soapstub = new BSS_ClaroPriceLoadSOAPStub(url, locator);

			CheckPriceProcessRequest checkPriceProcessRequest = new CheckPriceProcessRequest();
			checkPriceProcessRequest.setUser(tipo.getUserId());
			checkPriceProcessRequest.setPassword(tipo.getPassword());
			
//			seteando el headerReqeust
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestPrice(soapstub);

			CheckPriceProcessResponse checkPriceProcessResponse = soapstub.checkPriceProcess(checkPriceProcessRequest);

			checkProcessStatusType = new MostrarCheckProcessStatusPriceType();
			checkProcessStatusType.setIdEvent(checkPriceProcessResponse.getResponseData().getIdEvent());
			checkProcessStatusType.setCodeReply(checkPriceProcessResponse.getResponseStatus().getCodigoRespuesta());
			checkProcessStatusType.setMessageReply(checkPriceProcessResponse.getResponseStatus().getDescripcionRespuesta());

		} catch (RemoteException e) {

			if (e instanceof ClaroFault) {

				ClaroFault cf = (ClaroFault) e;

				checkProcessStatusType = new MostrarCheckProcessStatusPriceType();
				checkProcessStatusType.setIdEvent(null);
				checkProcessStatusType.setCodeReply(cf.getCodigoError());
				checkProcessStatusType.setMessageReply(cf.getDescripcionError());

			}			
		}

		return checkProcessStatusType;

	}

	@Override
	public MostrarExecutePriceProcessType executePriceProcessService(ObtenerExecutePriceProcessType tipo) throws Exception {

		MostrarExecutePriceProcessType executePriceType = null;
		try {

			// connexion al servidor remoto
			BSS_ClaroPriceLoad_v1Locator locator = new BSS_ClaroPriceLoad_v1Locator();
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroPriceLoadSOAPAddress());

			BSS_ClaroPriceLoadSOAPStub soapstub = new BSS_ClaroPriceLoadSOAPStub(url, locator);

			ExecutePriceProcessRequest executePriceProcessRequest = new ExecutePriceProcessRequest();
			executePriceProcessRequest.setUser(tipo.getUserId());
			executePriceProcessRequest.setPassword(tipo.getPassword());
			
//			seteando el headerReqeust
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestPrice(soapstub);
			
			ExecutePriceProcessResponse executePriceProcessResponse = soapstub.executePriceProcess(executePriceProcessRequest);

			executePriceType = new MostrarExecutePriceProcessType();
			executePriceType.setIdEvent(executePriceProcessResponse.getResponseData().getIdEvent());
			executePriceType.setCodeReply(executePriceProcessResponse.getResponseStatus().getCodigoRespuesta());
			executePriceType.setMessageReply(executePriceProcessResponse.getResponseStatus().getDescripcionRespuesta());

		} catch (RemoteException e) {

			if (e instanceof ClaroFault) {

				ClaroFault cf = (ClaroFault) e;

				executePriceType = new MostrarExecutePriceProcessType();
				executePriceType.setIdEvent(null);
				executePriceType.setCodeReply(cf.getCodigoError());
				executePriceType.setMessageReply(cf.getDescripcionError());

			}

		}

		return executePriceType;

	}

}
