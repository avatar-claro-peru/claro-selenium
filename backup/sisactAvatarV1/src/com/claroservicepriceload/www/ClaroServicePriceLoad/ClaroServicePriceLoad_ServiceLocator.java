/**
 * ClaroServicePriceLoad_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicepriceload.www.ClaroServicePriceLoad;

public class ClaroServicePriceLoad_ServiceLocator extends org.apache.axis.client.Service implements com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_Service {

    public ClaroServicePriceLoad_ServiceLocator() {
    }


    public ClaroServicePriceLoad_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClaroServicePriceLoad_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for processClaroServicePriceLoad
    private java.lang.String processClaroServicePriceLoad_address = "http://localhost/webapp/wcs/services/processClaroServicePriceLoad";

    public java.lang.String getprocessClaroServicePriceLoadAddress() {
        return processClaroServicePriceLoad_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String processClaroServicePriceLoadWSDDServiceName = "processClaroServicePriceLoad";

    public java.lang.String getprocessClaroServicePriceLoadWSDDServiceName() {
        return processClaroServicePriceLoadWSDDServiceName;
    }

    public void setprocessClaroServicePriceLoadWSDDServiceName(java.lang.String name) {
        processClaroServicePriceLoadWSDDServiceName = name;
    }

    public com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType getprocessClaroServicePriceLoad() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(processClaroServicePriceLoad_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getprocessClaroServicePriceLoad(endpoint);
    }

    public com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType getprocessClaroServicePriceLoad(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoadSOAPStub _stub = new com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoadSOAPStub(portAddress, this);
            _stub.setPortName(getprocessClaroServicePriceLoadWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setprocessClaroServicePriceLoadEndpointAddress(java.lang.String address) {
        processClaroServicePriceLoad_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoadSOAPStub _stub = new com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoadSOAPStub(new java.net.URL(processClaroServicePriceLoad_address), this);
                _stub.setPortName(getprocessClaroServicePriceLoadWSDDServiceName());
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
        if ("processClaroServicePriceLoad".equals(inputPortName)) {
            return getprocessClaroServicePriceLoad();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ClaroServicePriceLoad");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "processClaroServicePriceLoad"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("processClaroServicePriceLoad".equals(portName)) {
            setprocessClaroServicePriceLoadEndpointAddress(address);
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
