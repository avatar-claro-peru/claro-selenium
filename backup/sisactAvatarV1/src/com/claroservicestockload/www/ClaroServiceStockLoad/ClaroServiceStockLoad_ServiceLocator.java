/**
 * ClaroServiceStockLoad_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicestockload.www.ClaroServiceStockLoad;

public class ClaroServiceStockLoad_ServiceLocator extends org.apache.axis.client.Service implements com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_Service {

    public ClaroServiceStockLoad_ServiceLocator() {
    }


    public ClaroServiceStockLoad_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClaroServiceStockLoad_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for processClaroServiceStockLoad
    private java.lang.String processClaroServiceStockLoad_address = "http://localhost/webapp/wcs/services/processClaroServiceStockLoad";

    public java.lang.String getprocessClaroServiceStockLoadAddress() {
        return processClaroServiceStockLoad_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String processClaroServiceStockLoadWSDDServiceName = "processClaroServiceStockLoad";

    public java.lang.String getprocessClaroServiceStockLoadWSDDServiceName() {
        return processClaroServiceStockLoadWSDDServiceName;
    }

    public void setprocessClaroServiceStockLoadWSDDServiceName(java.lang.String name) {
        processClaroServiceStockLoadWSDDServiceName = name;
    }

    public com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType getprocessClaroServiceStockLoad() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(processClaroServiceStockLoad_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getprocessClaroServiceStockLoad(endpoint);
    }

    public com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType getprocessClaroServiceStockLoad(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoadSOAPStub _stub = new com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoadSOAPStub(portAddress, this);
            _stub.setPortName(getprocessClaroServiceStockLoadWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setprocessClaroServiceStockLoadEndpointAddress(java.lang.String address) {
        processClaroServiceStockLoad_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoadSOAPStub _stub = new com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoadSOAPStub(new java.net.URL(processClaroServiceStockLoad_address), this);
                _stub.setPortName(getprocessClaroServiceStockLoadWSDDServiceName());
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
        if ("processClaroServiceStockLoad".equals(inputPortName)) {
            return getprocessClaroServiceStockLoad();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ClaroServiceStockLoad");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "processClaroServiceStockLoad"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("processClaroServiceStockLoad".equals(portName)) {
            setprocessClaroServiceStockLoadEndpointAddress(address);
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
