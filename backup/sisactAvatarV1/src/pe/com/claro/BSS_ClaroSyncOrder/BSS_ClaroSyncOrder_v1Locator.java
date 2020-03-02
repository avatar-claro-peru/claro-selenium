/**
 * BSS_ClaroSyncOrder_v1Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.BSS_ClaroSyncOrder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BSS_ClaroSyncOrder_v1Locator extends org.apache.axis.client.Service implements pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder_v1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(BSS_ClaroSyncOrder_v1Locator.class);

	public BSS_ClaroSyncOrder_v1Locator() {
	}

	public BSS_ClaroSyncOrder_v1Locator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public BSS_ClaroSyncOrder_v1Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for BSS_ClaroSyncOrderSOAP
	private java.lang.String BSS_ClaroSyncOrderSOAP_address = "http://localhost/webapp/wcs/services/BSS_ClaroSyncOrderSOAP";

	public java.lang.String getBSS_ClaroSyncOrderSOAPAddress() {
		log.info("getBSS_ClaroSyncOrderSOAPAddress inicio");
		String endPoint = null;
		String so = System.getProperty("os.name").toUpperCase();
		log.info("so:" + so);
		if (so.indexOf("WINDOWS") >= 0) {
			endPoint = Messages.getString("endpointSyncWindows");
		} else {
			endPoint = Messages.getString("endpointSyncLinux");
		}
		log.info("endPoint:" + endPoint);
		BSS_ClaroSyncOrderSOAP_address = endPoint;
		log.info("getBSS_ClaroSyncOrderSOAPAddress fin");
		return endPoint;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String BSS_ClaroSyncOrderSOAPWSDDServiceName = "BSS_ClaroSyncOrderSOAP";

	public java.lang.String getBSS_ClaroSyncOrderSOAPWSDDServiceName() {
		return BSS_ClaroSyncOrderSOAPWSDDServiceName;
	}

	public void setBSS_ClaroSyncOrderSOAPWSDDServiceName(java.lang.String name) {
		BSS_ClaroSyncOrderSOAPWSDDServiceName = name;
	}

	public pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder getBSS_ClaroSyncOrderSOAP() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(BSS_ClaroSyncOrderSOAP_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getBSS_ClaroSyncOrderSOAP(endpoint);
	}

	public pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder getBSS_ClaroSyncOrderSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrderSOAPStub _stub = new pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrderSOAPStub(portAddress, this);
			_stub.setPortName(getBSS_ClaroSyncOrderSOAPWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setBSS_ClaroSyncOrderSOAPEndpointAddress(java.lang.String address) {
		BSS_ClaroSyncOrderSOAP_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder.class.isAssignableFrom(serviceEndpointInterface)) {
				pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrderSOAPStub _stub = new pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrderSOAPStub(new java.net.URL(BSS_ClaroSyncOrderSOAP_address),
						this);
				_stub.setPortName(getBSS_ClaroSyncOrderSOAPWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("BSS_ClaroSyncOrderSOAP".equals(inputPortName)) {
			return getBSS_ClaroSyncOrderSOAP();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://claro.com.pe/BSS_ClaroSyncOrder/", "BSS_ClaroSyncOrder_v1");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://claro.com.pe/BSS_ClaroSyncOrder/", "BSS_ClaroSyncOrderSOAP"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("BSS_ClaroSyncOrderSOAP".equals(portName)) {
			setBSS_ClaroSyncOrderSOAPEndpointAddress(address);
		} else { // Unknown Port Name
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
