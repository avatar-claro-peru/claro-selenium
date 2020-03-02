package pe.com.claro.BSS_ClaroSyncOrder;

public class BSS_ClaroSyncOrderProxy implements pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder {
  private String _endpoint = null;
  private pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder bSS_ClaroSyncOrder = null;
  
  public BSS_ClaroSyncOrderProxy() {
    _initBSS_ClaroSyncOrderProxy();
  }
  
  public BSS_ClaroSyncOrderProxy(String endpoint) {
    _endpoint = endpoint;
    _initBSS_ClaroSyncOrderProxy();
  }
  
  private void _initBSS_ClaroSyncOrderProxy() {
    try {
      bSS_ClaroSyncOrder = (new pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder_v1Locator()).getBSS_ClaroSyncOrderSOAP();
      if (bSS_ClaroSyncOrder != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bSS_ClaroSyncOrder)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bSS_ClaroSyncOrder)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bSS_ClaroSyncOrder != null)
      ((javax.xml.rpc.Stub)bSS_ClaroSyncOrder)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.claro.BSS_ClaroSyncOrder.BSS_ClaroSyncOrder getBSS_ClaroSyncOrder() {
    if (bSS_ClaroSyncOrder == null)
      _initBSS_ClaroSyncOrderProxy();
    return bSS_ClaroSyncOrder;
  }
  
  public pe.com.claro.esb.data.bss.sendEventStatus.SendEventStatusResponse sendEventStatus(pe.com.claro.esb.data.bss.sendEventStatus.SendEventStatusRequest sendEventStatusRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroSyncOrder == null)
      _initBSS_ClaroSyncOrderProxy();
    return bSS_ClaroSyncOrder.sendEventStatus(sendEventStatusRequest);
  }
  
  
}