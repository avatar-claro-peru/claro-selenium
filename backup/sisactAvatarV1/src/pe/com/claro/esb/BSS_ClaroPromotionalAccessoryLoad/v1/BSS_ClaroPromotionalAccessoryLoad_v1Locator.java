/**
 * BSS_ClaroPromotionalAccessoryLoad_v1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BSS_ClaroPromotionalAccessoryLoad_v1Locator extends org.apache.axis.client.Service implements pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_v1 {

    private static final long serialVersionUID = 1L;
    
    private static Log LOGGER = LogFactory.getLog(BSS_ClaroPromotionalAccessoryLoad_v1Locator.class);

	public BSS_ClaroPromotionalAccessoryLoad_v1Locator() {
    }

    public BSS_ClaroPromotionalAccessoryLoad_v1Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BSS_ClaroPromotionalAccessoryLoad_v1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BSS_ClaroPromotionalAccessoryLoad_SOAP11
    private java.lang.String BSS_ClaroPromotionalAccessoryLoad_SOAP11_address = "http://localhost/webapp/wcs/services/BSS_ClaroPromotionalAccessoryLoad_SOAP11";

    public java.lang.String getBSS_ClaroPromotionalAccessoryLoad_SOAP11Address() {  	
    	LOGGER.info("getBSS_ClaroPromotionalAccessoryLoad_SOAP11Address inicio");
		String endPoint = null;
		String so = System.getProperty("os.name").toUpperCase();
		LOGGER.info("so:" + so);
		if (so.indexOf("WINDOWS") >= 0) {
			endPoint = Messages.getString("endpointPromotionalAccessoryWindows");
		} else {
			endPoint = Messages.getString("endpointPromotionalAccessoryLinux");
		}
		LOGGER.info("endPoint:" + endPoint);
		BSS_ClaroPromotionalAccessoryLoad_SOAP11_address = endPoint;
		LOGGER.info("getBSS_ClaroPromotionalAccessoryLoad_SOAP11Address fin");
		return endPoint;    	
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName = "BSS_ClaroPromotionalAccessoryLoad_SOAP11";

    public java.lang.String getBSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName() {
        return BSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName;
    }

    public void setBSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName(java.lang.String name) {
        BSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName = name;
    }

    public pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port getBSS_ClaroPromotionalAccessoryLoad_SOAP11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BSS_ClaroPromotionalAccessoryLoad_SOAP11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBSS_ClaroPromotionalAccessoryLoad_SOAP11(endpoint);
    }

    public pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port getBSS_ClaroPromotionalAccessoryLoad_SOAP11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub _stub = new pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub(portAddress, this);
            _stub.setPortName(getBSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBSS_ClaroPromotionalAccessoryLoad_SOAP11EndpointAddress(java.lang.String address) {
        BSS_ClaroPromotionalAccessoryLoad_SOAP11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub _stub = new pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_SOAP11BindingStub(new java.net.URL(BSS_ClaroPromotionalAccessoryLoad_SOAP11_address), this);
                _stub.setPortName(getBSS_ClaroPromotionalAccessoryLoad_SOAP11WSDDServiceName());
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
        if ("BSS_ClaroPromotionalAccessoryLoad_SOAP11".equals(inputPortName)) {
            return getBSS_ClaroPromotionalAccessoryLoad_SOAP11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://claro.com.pe/esb/BSS_ClaroPromotionalAccessoryLoad/v1/", "BSS_ClaroPromotionalAccessoryLoad_v1");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://claro.com.pe/esb/BSS_ClaroPromotionalAccessoryLoad/v1/", "BSS_ClaroPromotionalAccessoryLoad_SOAP11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BSS_ClaroPromotionalAccessoryLoad_SOAP11".equals(portName)) {
            setBSS_ClaroPromotionalAccessoryLoad_SOAP11EndpointAddress(address);
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
