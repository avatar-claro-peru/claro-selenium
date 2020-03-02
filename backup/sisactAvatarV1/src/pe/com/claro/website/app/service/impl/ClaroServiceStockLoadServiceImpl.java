package pe.com.claro.website.app.service.impl;

import java.net.HttpURLConnection;
import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_SOAP11BindingStub;
import pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_v1Locator;
import pe.com.claro.esb.data.bss.CheckStockProcess.CheckProcessRequest;
import pe.com.claro.esb.data.bss.CheckStockProcess.CheckProcessResponse;
import pe.com.claro.esb.data.bss.ExecuteStockProcess.ExecuteProcessRequest;
import pe.com.claro.esb.data.bss.ExecuteStockProcess.ExecuteProcessResponse;
import pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional;
import pe.com.claro.esb.data.bss.generico.util.ClaroGenericHandler;
import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.MostrarExecuteStockProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteStockProcessType;
import pe.com.claro.website.app.service.ClaroServiceStockLoadService;

public class ClaroServiceStockLoadServiceImpl implements ClaroServiceStockLoadService {

	private static Log log = LogFactory.getLog(ClaroServiceStockLoadServiceImpl.class);

	@Override
	public MostrarCheckProcessStatusStockType checkProcessStatusService(ObtenerCheckProcessStatusStockType tipo) throws Exception {
		/* Lista de salida */
		log.info("entro al metodo checkProcessStatusService inicio");
		MostrarCheckProcessStatusStockType checkProcessStatusType = null;
		try {

			log.info(" connexion al servidor remoto ");
			BSS_ClaroStockLoad_v1Locator locator = new BSS_ClaroStockLoad_v1Locator();
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroStockLoad_SB11Address());
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			log.info("ResponseCoede =" + conn.getResponseCode());
			
			log.info(" Creando metodo para invocar ");
			log.info("url: " + url);
			log.info("locator:" + locator);
			BSS_ClaroStockLoad_SOAP11BindingStub soapstub = new BSS_ClaroStockLoad_SOAP11BindingStub(url, locator);
			
			CheckProcessRequest checkProcessRequest = new CheckProcessRequest();
			CheckProcessResponse processResponse = new CheckProcessResponse();

			log.info(" parametros de entrada ");
			log.info("tipo.getUserId():" + tipo.getUserId());
			log.info("tipo.getPassword():" + tipo.getPassword());
			
			RequestOpcionalTypeRequestOpcional[] ropc = new RequestOpcionalTypeRequestOpcional[1];
			RequestOpcionalTypeRequestOpcional listaOpc = new RequestOpcionalTypeRequestOpcional();
			listaOpc.setCampo("Campo");
			listaOpc.setValor("Valor");
			ropc[0] = listaOpc;
			
//			seteando el headerReqeust
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestStock(soapstub);
			
			checkProcessRequest.setUser(tipo.getUserId());
			checkProcessRequest.setPassword(tipo.getPassword());
			checkProcessRequest.setListaRequestOpcional(ropc);
			
			// Falta implementar la lista opcional.
			
			log.info(" ejecutar metodo del servicio ");
			processResponse = soapstub.checkStockLoad(checkProcessRequest);
			
//			log.info(" mostrar por consola los valores que retorna el servicio ");
			checkProcessStatusType = new MostrarCheckProcessStatusStockType();
			
			// Seteamos la respuesta del servicio
			log.info("========================== RESPONSE SERVICE WEB ==========================");
			checkProcessStatusType.setIdEvent(processResponse.getResponseData().getIdEvent());
			log.info("setIdEvent: " + processResponse.getResponseData().getIdEvent());
			
			checkProcessStatusType.setCodeReply(processResponse.getResponseStatus().getCodigoRespuesta());
			log.info("setCodeReply: " + processResponse.getResponseStatus().getCodigoRespuesta());
			
			checkProcessStatusType.setMessageReply(processResponse.getResponseStatus().getDescripcionRespuesta());
			log.info("setMessageReply: " + processResponse.getResponseStatus().getDescripcionRespuesta());

		} catch (RemoteException e) {
			e.printStackTrace();
			log.info(" error: " + e.getMessage());
			throw new AbstractException(Constante.ERROR_PROCESS_LOAD_STOK_PRECIOS + e.getMessage());
			
		}
		log.info("entro al metodo checkProcessStatusService fin");
		return checkProcessStatusType;
	}

	@Override
	public MostrarExecuteStockProcessType executeStockProcessService(ObtenerExecuteStockProcessType tipo) throws Exception {
		log.info("entro al metodo executeStockProcessService inicio");
		/* Lista de salida */
		MostrarExecuteStockProcessType checkProcessStatusType = null;
		try {

			/* connexion al servidor remoto */
			BSS_ClaroStockLoad_v1Locator locator = new BSS_ClaroStockLoad_v1Locator();
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroStockLoad_SB11Address());
			
//			/* Creando metodo para invocar */
			BSS_ClaroStockLoad_SOAP11BindingStub soapstub = new BSS_ClaroStockLoad_SOAP11BindingStub(url, locator);
			
			ExecuteProcessResponse executeResponse = new ExecuteProcessResponse();
			ExecuteProcessRequest executeProcessRequest = new ExecuteProcessRequest();;

			log.info(" parametros de entrada ");
			log.info("tipo.getUserId():" + tipo.getUserId());
			log.info("tipo.getPassword():" + tipo.getPassword());
			
			RequestOpcionalTypeRequestOpcional[] ropc = new RequestOpcionalTypeRequestOpcional[1];
			RequestOpcionalTypeRequestOpcional listaOpc = new RequestOpcionalTypeRequestOpcional();
			listaOpc.setCampo("Campo");
			listaOpc.setValor("Valor");
			ropc[0] = listaOpc;
			
			
//			seteando el headerReqeust
			ClaroGenericHandler claroGenericHandler = new ClaroGenericHandler();
			claroGenericHandler.setHandleResquestStock(soapstub);
			
			executeProcessRequest.setUser(tipo.getUserId());
			executeProcessRequest.setPassword(tipo.getPassword());
			executeProcessRequest.setListaRequestOpcional(ropc);

			
			/* ejecutar metodo del servicio */
			executeResponse = soapstub.executeStockLoad(executeProcessRequest);
			
			checkProcessStatusType = new MostrarExecuteStockProcessType();

			log.info("========================== RESPONSE SERVICE WEB ==========================");
			checkProcessStatusType.setIdEvent(executeResponse.getResponseData().getIdEvent());
			log.info("setIdEvent: " + executeResponse.getResponseData().getIdEvent());

			checkProcessStatusType.setCodeReply(executeResponse.getResponseStatus().getCodigoRespuesta());
			log.info("setCodeReply: " + executeResponse.getResponseStatus().getCodigoRespuesta());

			checkProcessStatusType.setMessageReply(executeResponse.getResponseStatus().getDescripcionRespuesta());
			log.info("setMessageReply: " + executeResponse.getResponseStatus().getDescripcionRespuesta());

		} catch (RemoteException e) {
			throw new AbstractException(Constante.ERROR_PROCESS_LOAD_STOK_PRECIOS + e.getMessage());

		}
		log.info("entro al metodo executeStockProcessService fin");
		return checkProcessStatusType;

	}
	

}
