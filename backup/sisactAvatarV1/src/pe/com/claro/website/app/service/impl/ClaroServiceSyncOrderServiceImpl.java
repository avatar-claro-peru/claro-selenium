package pe.com.claro.website.app.service.impl;

import java.net.HttpURLConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrderSOAPStub;
import pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder_v1Locator;
import pe.com.claro.esb.data.bss.generico.claroGenericHeader.v1.HeaderRequestType;
import pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional;
import pe.com.claro.esb.data.bss.sendEventStatus.SendEventStatusRequest;
import pe.com.claro.esb.data.bss.sendEventStatus.SendEventStatusResponse;
import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.domain.service.MostrarSendEventStatusType;
import pe.com.claro.website.app.domain.service.ObtenerSendEventStatusType;
import pe.com.claro.website.app.service.ClaroServiceSyncOrderService;

public class ClaroServiceSyncOrderServiceImpl implements ClaroServiceSyncOrderService {

	private static Log log = LogFactory.getLog(ClaroServiceSyncOrderServiceImpl.class);

	@Override
	public MostrarSendEventStatusType sendEventStatus(ObtenerSendEventStatusType datosEntrada) {
		log.info("entro al metodo sendEventStatus inicio");

		MostrarSendEventStatusType mostrarSendEventStatusType = new MostrarSendEventStatusType();
		try {

			log.info(" connexion al servidor remoto ");
			BSS_ClaroSyncOrder_v1Locator locator = new BSS_ClaroSyncOrder_v1Locator();
			java.net.URL url = new java.net.URL(locator.getBSS_ClaroSyncOrderSOAPAddress());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			log.info("ResponseCoede =" + conn.getResponseCode());

			log.info(" Creando metodo para invocar ");
			log.info("url: " + url);
			log.info("locator:" + locator);

			BSS_ClaroSyncOrderSOAPStub soapstub = new BSS_ClaroSyncOrderSOAPStub(url, locator);

			SendEventStatusRequest sendEventStatusRequest = new SendEventStatusRequest();
			SendEventStatusResponse sendEventStatusResponse = new SendEventStatusResponse();

			log.info(" parametros de entrada ");
			log.info("datosEntrada.getUsuario():" + datosEntrada.getUsuario());
			log.info("datosEntrada.getPassword():" + datosEntrada.getPassword());
			log.info("datosEntrada.getOrdenNro():" + datosEntrada.getOrdenNro());
			log.info("datosEntrada.getEstado():" + datosEntrada.getEstado());
			log.info("datosEntrada.getComentario():" + datosEntrada.getComentario());
			log.info("datosEntrada.getCantidadLineas():" + datosEntrada.getCantidadLineas());

			log.info("creando header y seteando sus valores");
			HeaderRequestType headerRequestType = new HeaderRequestType();
			Calendar calendar = new GregorianCalendar(2013, 1, 28, 13, 24, 56);

			headerRequestType.setCanal("canal");
			headerRequestType.setFechaInicio(calendar);
			headerRequestType.setIdAplicacion("789");
			headerRequestType.setIdTransaccionESB("456");
			headerRequestType.setIdTransaccionNegocio("456");
			headerRequestType.setUsuarioAplicacion(datosEntrada.getUsuario());
			headerRequestType.setUsuarioSesion(datosEntrada.getUsuario());

			log.info(" seteando valores del request");
			sendEventStatusRequest.setIdEvent(datosEntrada.getEstado());
			sendEventStatusRequest.setOrderId(String.valueOf(datosEntrada.getOrdenNro()));
			sendEventStatusRequest.setPassword(datosEntrada.getPassword());
			sendEventStatusRequest.setUser(datosEntrada.getUsuario());
			
			//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
			String codMssap = datosEntrada.getCodMssap();
			String codPvu = datosEntrada.getCodPvu();
			String serieChip = datosEntrada.getSerieChip();
			String serieEquipo = datosEntrada.getSerieEquipo();
			String codigoOficina = datosEntrada.getCodigoOficina();
			String codigoSolicitud = datosEntrada.getCodigoSolicitud();
			//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN

			log.info(" creando y seteando valores del requestListOpcional");
			int qtyOptElements = 8;

			/*
			 * if (!StringUtils.isEmpty(datosEntrada.getComentario())) {
			 * qtyOptElements++; }
			 */

			String number = getNumeroLineas(datosEntrada);
			String comentario = datosEntrada.getComentario();

			RequestOpcionalTypeRequestOpcional[] listaRequestOpcional = new RequestOpcionalTypeRequestOpcional[qtyOptElements];

			RequestOpcionalTypeRequestOpcional listaRequestOpcionalComment = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalComment.setCampo("comment");
			listaRequestOpcionalComment.setValor(comentario);
			listaRequestOpcional[0] = listaRequestOpcionalComment;

			RequestOpcionalTypeRequestOpcional listaRequestOpcionalLines = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalLines.setCampo("lines");
			listaRequestOpcionalLines.setValor(number);
			listaRequestOpcional[1] = listaRequestOpcionalLines;
			
			//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
			//codMssap
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalCodMssap = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalCodMssap.setCampo("codmssap");
			listaRequestOpcionalCodMssap.setValor(codMssap);
			listaRequestOpcional[2] = listaRequestOpcionalCodMssap;
			
			//codPvu
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalCodPvu = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalCodPvu.setCampo("codpvu");
			listaRequestOpcionalCodPvu.setValor(codPvu);
			listaRequestOpcional[3] = listaRequestOpcionalCodPvu;
			
			//serieChip
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalSerieChip = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalSerieChip.setCampo("seriechip");
			listaRequestOpcionalSerieChip.setValor(serieChip);
			listaRequestOpcional[4] = listaRequestOpcionalSerieChip;
			
			//serieEquipo
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalSerieEquipo = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalSerieEquipo.setCampo("serieequipo");
			listaRequestOpcionalSerieEquipo.setValor(serieEquipo);
			listaRequestOpcional[5] = listaRequestOpcionalSerieEquipo;
			
			//codigoOficina
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalCodigoOficina = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalCodigoOficina.setCampo("codoficina");
			listaRequestOpcionalCodigoOficina.setValor(codigoOficina);
			listaRequestOpcional[6] = listaRequestOpcionalCodigoOficina;
			
			//codigoSolicitud
			RequestOpcionalTypeRequestOpcional listaRequestOpcionalCodigoSolicitud = new RequestOpcionalTypeRequestOpcional();
			listaRequestOpcionalCodigoSolicitud.setCampo("codsolicitud");
			listaRequestOpcionalCodigoSolicitud.setValor(codigoSolicitud);
			listaRequestOpcional[7] = listaRequestOpcionalCodigoSolicitud;
			//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN

			sendEventStatusRequest.setListaRequestOpcional(listaRequestOpcional);

			// Falta implementar la lista opcional.

			log.info(" ejecutar metodo del servicio ");

			sendEventStatusResponse = soapstub.sendEventStatus(sendEventStatusRequest);

			log.info(" obteniendo los datos de respuesta y seteandolos al objeto MostrarSendEventStatusType");

			mostrarSendEventStatusType.setCodigoRespuesta(sendEventStatusResponse.getResponseStatus().getCodigoRespuesta());
			mostrarSendEventStatusType.setIdEvento(sendEventStatusResponse.getResponseData().getIdEvent());
			mostrarSendEventStatusType.setFecha(sendEventStatusResponse.getResponseStatus().getFecha());
			mostrarSendEventStatusType.setDescripciónRespuesta(sendEventStatusResponse.getResponseStatus().getDescripcionRespuesta());
			mostrarSendEventStatusType.setEstado(sendEventStatusResponse.getResponseStatus().getEstado());
			//sendEventStatusResponse.getListaResponseOpcional();

			log.info(" fin del metodo  sendEventStatus");

		} catch (Exception e) {
			e.printStackTrace();
			log.info(" error: " + e.getMessage());
			throw new AbstractException(Constante.ERROR_PROCESS_SYNC_ORDER + e.getMessage());
		}
		return mostrarSendEventStatusType;
	}

	private String getNumeroLineas(ObtenerSendEventStatusType datosEntrada) {
		String number = "";
		if (datosEntrada.getCantidadLineas() != 0) {
			String templateNumber = "99999999";
			for (int i = 0; i < datosEntrada.getCantidadLineas(); i++) {
				number = number + templateNumber + i + ",";
			}
			number = number.substring(0, number.length() - 1);
		}
		return number;
	}
}
