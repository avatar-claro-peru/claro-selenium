package pe.com.claro.esb.data.bss.generico.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub;
import pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub;
import pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_SOAP11BindingStub;

public class ClaroGenericHandler {
	
	private static Log log = LogFactory.getLog(ClaroGenericHandler.class);
	
	public void setHandleResquestPromotionalAccessory(BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub soapstub) {
		log.info("entro al metodo SetHandleResquest inicio");
		try {
			
			SOAPHeaderElement soapHeader = new SOAPHeaderElement("hrq", "HeaderReqeust");
			soapHeader = processHandler(soapHeader);
			soapstub.setHeader(soapHeader);
			
		} catch (Exception x) {
			x.printStackTrace();
		} 
		log.info("entro al metodo SetHandleResquest fin");
	}
	
	public void setHandleResquestStock(BSS_ClaroStockLoad_SOAP11BindingStub soapstub) {
		log.info("entro al metodo SetHandleResquest inicio");
		try {
			
			SOAPHeaderElement soapHeader = new SOAPHeaderElement("hrq", "HeaderReqeust");
			soapHeader = processHandler(soapHeader);
			soapstub.setHeader(soapHeader);
			
		} catch (Exception x) {
			x.printStackTrace();
		} 
		log.info("entro al metodo SetHandleResquest fin");
	}

	public void setHandleResquestPrice(BSS_ClaroPriceLoadSOAPStub soapstub) {
		log.info("entro al metodo SetHandleResquest inicio");
		try {
			
			SOAPHeaderElement soapHeader = new SOAPHeaderElement("hrq", "HeaderReqeust");
			soapHeader = processHandler(soapHeader);
			soapstub.setHeader(soapHeader);
			
		} catch (Exception x) {
			x.printStackTrace();
		} 
		log.info("entro al metodo SetHandleResquest fin");
		
	}
	
	private SOAPHeaderElement processHandler(SOAPHeaderElement soapHeader) throws SOAPException {
		
		Date fecha = Calendar.getInstance().getTime();
		String ipServer;
		try {
			ipServer = InetAddress.getLocalHost().getHostAddress();
			soapHeader.addChildElement("canal", "hrq").addTextNode("canal");
			soapHeader.addChildElement("idAplicacion", "hrq").addTextNode("app");
			soapHeader.addChildElement("usuarioAplicacion" , "hrq").addTextNode("userApp");
			soapHeader.addChildElement("usuarioSesion" , "hrq").addTextNode("userSession");
			soapHeader.addChildElement("idTransaccionESB" , "hrq").addTextNode("esb");
			soapHeader.addChildElement("idTransaccionNegocio" , "hrq").addTextNode("negocio");
			soapHeader.addChildElement("fechaInicio" , "hrq").addTextNode(fecha.toString());
			soapHeader.addChildElement("nodoAdicional" , "hrq").addTextNode(ipServer);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		return soapHeader;
	}


}
