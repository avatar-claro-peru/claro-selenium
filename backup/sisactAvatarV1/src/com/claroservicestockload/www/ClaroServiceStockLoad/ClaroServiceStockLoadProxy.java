package com.claroservicestockload.www.ClaroServiceStockLoad;

public class ClaroServiceStockLoadProxy implements com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType {
  private String _endpoint = null;
  private com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType claroServiceStockLoad_PortType = null;
  
  public ClaroServiceStockLoadProxy() {
    _initClaroServiceStockLoadProxy();
  }
  
  public ClaroServiceStockLoadProxy(String endpoint) {
    _endpoint = endpoint;
    _initClaroServiceStockLoadProxy();
  }
  
  private void _initClaroServiceStockLoadProxy() {
    try {
      claroServiceStockLoad_PortType = (new com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_ServiceLocator()).getprocessClaroServiceStockLoad();
      if (claroServiceStockLoad_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)claroServiceStockLoad_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)claroServiceStockLoad_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (claroServiceStockLoad_PortType != null)
      ((javax.xml.rpc.Stub)claroServiceStockLoad_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType getClaroServiceStockLoad_PortType() {
    if (claroServiceStockLoad_PortType == null)
      _initClaroServiceStockLoadProxy();
    return claroServiceStockLoad_PortType;
  }
  
  public void checkProcessStatus(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement) throws java.rmi.RemoteException{
    if (claroServiceStockLoad_PortType == null)
      _initClaroServiceStockLoadProxy();
    claroServiceStockLoad_PortType.checkProcessStatus(headerRequest, getCheckProcessStatusElement, headerResponse, showCheckProcessStatusElement);
  }
  
  public void executeStockProcess(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetExecuteStockProcessType getExecuteStockProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowExecuteStockProcessTypeHolder showExecuteStockProcessElement) throws java.rmi.RemoteException{
    if (claroServiceStockLoad_PortType == null)
      _initClaroServiceStockLoadProxy();
    claroServiceStockLoad_PortType.executeStockProcess(headerRequest, getExecuteStockProcessElement, headerResponse, showExecuteStockProcessElement);
  }
  
  
}