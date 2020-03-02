package com.claroservicepriceload.www.ClaroServicePriceLoad;

public class ClaroServicePriceLoadProxy implements com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType {
  private String _endpoint = null;
  private com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType claroServicePriceLoad_PortType = null;
  
  public ClaroServicePriceLoadProxy() {
    _initClaroServicePriceLoadProxy();
  }
  
  public ClaroServicePriceLoadProxy(String endpoint) {
    _endpoint = endpoint;
    _initClaroServicePriceLoadProxy();
  }
  
  private void _initClaroServicePriceLoadProxy() {
    try {
      claroServicePriceLoad_PortType = (new com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_ServiceLocator()).getprocessClaroServicePriceLoad();
      if (claroServicePriceLoad_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)claroServicePriceLoad_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)claroServicePriceLoad_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (claroServicePriceLoad_PortType != null)
      ((javax.xml.rpc.Stub)claroServicePriceLoad_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType getClaroServicePriceLoad_PortType() {
    if (claroServicePriceLoad_PortType == null)
      _initClaroServicePriceLoadProxy();
    return claroServicePriceLoad_PortType;
  }
  
  public void checkProcessStatus(com.claroservicepriceload.www.ClaroServicePriceLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException{
    if (claroServicePriceLoad_PortType == null)
      _initClaroServicePriceLoadProxy();
    claroServicePriceLoad_PortType.checkProcessStatus(getCheckProcessStatusElement, headerRequest, showCheckProcessStatusElement, headerResponse);
  }
  
  public void executePriceProcess(com.claroservicepriceload.www.ClaroServicePriceLoad.GetExecutePriceProcessType getExecutePriceProcessElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowExecutePriceProcessTypeHolder showExecutePriceProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException{
    if (claroServicePriceLoad_PortType == null)
      _initClaroServicePriceLoadProxy();
    claroServicePriceLoad_PortType.executePriceProcess(getExecutePriceProcessElement, headerRequest, showExecutePriceProcessElement, headerResponse);
  }
  
  
}