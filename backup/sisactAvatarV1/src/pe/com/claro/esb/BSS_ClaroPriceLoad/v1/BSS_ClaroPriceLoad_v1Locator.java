/**
 * BSS_ClaroPriceLoad_v1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.BSS_ClaroPriceLoad.v1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BSS_ClaroPriceLoad_v1Locator extends org.apache.axis.client.Service implements pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad_v1 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(BSS_ClaroPriceLoad_v1Locator.class);
	
    public BSS_ClaroPriceLoad_v1Locator() {
    }


    public BSS_ClaroPriceLoad_v1Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BSS_ClaroPriceLoad_v1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BSS_ClaroPriceLoadSOAP
    private java.lang.String BSS_ClaroPriceLoadSOAP_address = "http://localhost/webapp/wcs/services/BSS_ClaroPriceLoadSOAP";

    public java.lang.String getBSS_ClaroPriceLoadSOAPAddress() {
        log.info("getBSS_ClaroPriceLoadSOAPAddress inicio");
		String endPoint = null;
		String so = System.getProperty("os.name").toUpperCase();
		log.info("so:" + so);
		if (so.indexOf("WINDOWS") >= 0) {
			endPoint = Messages.getString("endpointPriceWindows");
		} else {
			endPoint = Messages.getString("endpointPriceLinux");
		}
		log.info("endPoint:" + endPoint);
		BSS_ClaroPriceLoadSOAP_address = endPoint;
		log.info("getBSS_ClaroPriceLoadSOAPAddress fin");
		return endPoint;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BSS_ClaroPriceLoadSOAPWSDDServiceName = "BSS_ClaroPriceLoadSOAP";

    public java.lang.String getBSS_ClaroPriceLoadSOAPWSDDServiceName() {
        return BSS_ClaroPriceLoadSOAPWSDDServiceName;
    }

    public void setBSS_ClaroPriceLoadSOAPWSDDServiceName(java.lang.String name) {
        BSS_ClaroPriceLoadSOAPWSDDServiceName = name;
    }

    public pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad getBSS_ClaroPriceLoadSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BSS_ClaroPriceLoadSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBSS_ClaroPriceLoadSOAP(endpoint);
    }

    public pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad getBSS_ClaroPriceLoadSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub _stub = new pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub(portAddress, this);
            _stub.setPortName(getBSS_ClaroPriceLoadSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBSS_ClaroPriceLoadSOAPEndpointAddress(java.lang.String address) {
        BSS_ClaroPriceLoadSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub _stub = new pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoadSOAPStub(new java.net.URL(BSS_ClaroPriceLoadSOAP_address), this);
                _stub.setPortName(getBSS_ClaroPriceLoadSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BSS_ClaroPriceLoadSOAP".equals(inputPortName)) {
            return getBSS_ClaroPriceLoadSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://claro.com.pe/esb/BSS_ClaroPriceLoad/v1/", "BSS_ClaroPriceLoad_v1");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://claro.com.pe/esb/BSS_ClaroPriceLoad/v1/", "BSS_ClaroPriceLoadSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BSS_ClaroPriceLoadSOAP".equals(portName)) {
            setBSS_ClaroPriceLoadSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
