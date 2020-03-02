package pe.com.claro.website.app.service.impl;

import java.net.HttpURLConnection;
import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub;
import pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_v1Locator;
import pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessRequest;
import pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessResponse;
import pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessRequest;
import pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessResponse;
import pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
import pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional;
import pe.com.claro.esb.data.bss.generico.util.ClaroGenericHandler;
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.MostrarExecuteAccessoryProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteAccessoryProcessType;
import pe.com.claro.website.app.service.ClaroServiceAccessoryLoadService;

/**
 * The Class ClaroServiceAccessoryLoadServiceImpl.
 * 
 * @author Elmer Terrones Fernandez
 * @company AVATAR
 * @since 21/12/2017
 * @project Platform Migration - E-Commerce Platform for Claro
 */
public class ClaroServiceAccessoryLoadServiceImpl implements ClaroServiceAccessoryLoadService {
	
	private static Log LOGGER = LogFactory.getLog(ClaroServiceAccessoryLoadServiceImpl.class);

	@Override
	public MostrarCheckProcessStatusAccessoryType checkProcessStatusService(ObtenerCheckProcessStatusAccessoryType getCheckProcessStatusElement) throws Exception {		
		LOGGER.info("checkProcessStatusService: inicio");
		
		MostrarCheckProcessStatusAccessoryType checkProcessStatusAccessoryType = new MostrarCheckProcessStatusAccessoryType();
		String userId = null;
		String password = null;
		RequestOpcionalTypeRequestOpcional[] requestOpcionals = null;
		CheckProcessRequest checkProcessRequest = new CheckProcessRequest();
		CheckProcessResponse processResponse = new CheckProcessResponse();
		
		try {
			
			userId = getCheckProcessStatusElement.getUserId();
			password = getCheckProcessStatusElement.getPassword();

			LOGGER.info("Connexion al servidor remoto");
			BSS_ClaroPromotionalAccessoryLoad_v1Locator locator = new BSS_ClaroPromotionalAccessoryLoad_v1Locator();
			LOGGER.info("locator:" + locator);
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroPromotionalAccessoryLoad_SOAP11Address());
			LOGGER.info("url:" + url);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			LOGGER.info("ResponseCode: " + conn.getResponseCode());
			
			BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub soapstub = new BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub(url, locator);

			requestOpcionals = new RequestOpcionalTypeRequestOpcional[1];
			RequestOpcionalTypeRequestOpcional itemOpc = new RequestOpcionalTypeRequestOpcional();
			itemOpc.setCampo("Campo");
			itemOpc.setValor("Valor");
			requestOpcionals[0] = itemOpc;
			
			LOGGER.info("Setear Header::");
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestPromotionalAccessory(soapstub);
			
			LOGGER.info("Setear Body::");		
			checkProcessRequest.setUser(userId);
			LOGGER.info("setUser: " + userId);
			checkProcessRequest.setPassword(password);
			LOGGER.info("setPassword: " + password);
			checkProcessRequest.setListaRequestOpcional(requestOpcionals);
			LOGGER.info("setListaRequestOpcional: " + requestOpcionals.toString());
			
			LOGGER.info("Ejecutar metodo del servicio: checkPromotionalAccessoryLoad");
			processResponse = soapstub.checkPromotionalAccessoryLoad(checkProcessRequest);
			
			LOGGER.info("========================== RESPONSE SERVICE WEB ==========================");
			
			checkProcessStatusAccessoryType.setIdEvent(processResponse.getResponseData().getIdEvent());
			LOGGER.info("IdEvent: " + processResponse.getResponseData().getIdEvent());
			
			checkProcessStatusAccessoryType.setCodeReply(processResponse.getResponseStatus().getCodigoRespuesta());
			LOGGER.info("CodeReply: " + processResponse.getResponseStatus().getCodigoRespuesta());
			
			checkProcessStatusAccessoryType.setMessageReply(processResponse.getResponseStatus().getDescripcionRespuesta());
			LOGGER.info("MessageReply: " + processResponse.getResponseStatus().getDescripcionRespuesta());

		} catch (RemoteException e) {
			
			if (e instanceof ClaroFault) {

				ClaroFault cf = (ClaroFault) e;

				checkProcessStatusAccessoryType.setIdEvent(null);
				LOGGER.info("ClaroFault_IdEvent: null");
				checkProcessStatusAccessoryType.setCodeReply(cf.getCodigoError());
				LOGGER.info("ClaroFault_CodeReply: " + cf.getCodigoError());
				checkProcessStatusAccessoryType.setMessageReply(cf.getDescripcionError());
				LOGGER.info("ClaroFault_MessageReply: " + cf.getDescripcionError());

			}
			
		}
		
		LOGGER.info("checkProcessStatusService: fin");
		return checkProcessStatusAccessoryType;		
		
	}

	@Override
	public MostrarExecuteAccessoryProcessType executeAccessoryProcessService(ObtenerExecuteAccessoryProcessType getExecuteAccessoryProcessElement) throws Exception {
		LOGGER.info("executeAccessoryProcessService: inicio");
		
		MostrarExecuteAccessoryProcessType mostrarExecuteAccessoryProcessType = new MostrarExecuteAccessoryProcessType();
		String userId = null;
		String password = null;
		RequestOpcionalTypeRequestOpcional[] requestOpcionals = null;
		ExecuteProcessRequest executeProcessRequest = new ExecuteProcessRequest();
		ExecuteProcessResponse executeProcessResponse = new ExecuteProcessResponse();
		
		try {
			
			userId = getExecuteAccessoryProcessElement.getUserId();
			password = getExecuteAccessoryProcessElement.getPassword();
			
			LOGGER.info("Connexion al servidor remoto");
			BSS_ClaroPromotionalAccessoryLoad_v1Locator locator = new BSS_ClaroPromotionalAccessoryLoad_v1Locator();
			LOGGER.info("locator:" + locator);
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroPromotionalAccessoryLoad_SOAP11Address());
			LOGGER.info("url:" + url);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			LOGGER.info("ResponseCode: " + conn.getResponseCode());			
			
			BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub soapstub = new BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub(url, locator);

			requestOpcionals = new RequestOpcionalTypeRequestOpcional[1];
			RequestOpcionalTypeRequestOpcional objOpc = new RequestOpcionalTypeRequestOpcional();
			objOpc.setCampo("Campo");
			objOpc.setValor("Valor");			
			requestOpcionals[0] = objOpc;
			
			LOGGER.info("Setear Header::");
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestPromotionalAccessory(soapstub);
			
			LOGGER.info("Setear Body::");			
			executeProcessRequest.setUser(userId);
			LOGGER.info("setUser: " + userId);
			executeProcessRequest.setPassword(password);
			LOGGER.info("setPassword: " + password);
			executeProcessRequest.setListaRequestOpcional(requestOpcionals);
			LOGGER.info("setListaRequestOpcional: " + requestOpcionals.toString());
			
			LOGGER.info("Ejecutar metodo del servicio: executePromotionalAccessoryLoad");
			executeProcessResponse = soapstub.executePromotionalAccessoryLoad(executeProcessRequest);
			
			LOGGER.info("========================== RESPONSE SERVICE WEB ==========================");
			
			mostrarExecuteAccessoryProcessType.setIdEvent(executeProcessResponse.getResponseData().getIdEvent());
			LOGGER.info("IdEvent: " + executeProcessResponse.getResponseData().getIdEvent());
			
			mostrarExecuteAccessoryProcessType.setCodeReply(executeProcessResponse.getResponseStatus().getCodigoRespuesta());
			LOGGER.info("CodeReply: " + executeProcessResponse.getResponseStatus().getCodigoRespuesta());
			
			mostrarExecuteAccessoryProcessType.setMessageReply(executeProcessResponse.getResponseStatus().getDescripcionRespuesta());
			LOGGER.info("MessageReply: " + executeProcessResponse.getResponseStatus().getDescripcionRespuesta());			
			
		} catch (Exception e) {
			
			if (e instanceof ClaroFault) {

				ClaroFault cf = (ClaroFault) e;

				mostrarExecuteAccessoryProcessType.setIdEvent(null);
				LOGGER.info("ClaroFault_IdEvent: null");
				mostrarExecuteAccessoryProcessType.setCodeReply(cf.getCodigoError());
				LOGGER.info("ClaroFault_CodeReply: " + cf.getCodigoError());
				mostrarExecuteAccessoryProcessType.setMessageReply(cf.getDescripcionError());
				LOGGER.info("ClaroFault_MessageReply: " + cf.getDescripcionError());

			}
			
		}
		
		LOGGER.info("executeAccessoryProcessService: fin");
		return mostrarExecuteAccessoryProcessType;
				
	}
	
}
