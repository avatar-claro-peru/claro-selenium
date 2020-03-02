package pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1;

public class BSS_ClaroPromotionalAccessoryLoad_portProxy implements pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port {
  private String _endpoint = null;
  private pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port bSS_ClaroPromotionalAccessoryLoad_port = null;
  
  public BSS_ClaroPromotionalAccessoryLoad_portProxy() {
    _initBSS_ClaroPromotionalAccessoryLoad_portProxy();
  }
  
  public BSS_ClaroPromotionalAccessoryLoad_portProxy(String endpoint) {
    _endpoint = endpoint;
    _initBSS_ClaroPromotionalAccessoryLoad_portProxy();
  }
  
  private void _initBSS_ClaroPromotionalAccessoryLoad_portProxy() {
    try {
      bSS_ClaroPromotionalAccessoryLoad_port = (new pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_v1Locator()).getBSS_ClaroPromotionalAccessoryLoad_SOAP11();
      if (bSS_ClaroPromotionalAccessoryLoad_port != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bSS_ClaroPromotionalAccessoryLoad_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bSS_ClaroPromotionalAccessoryLoad_port)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bSS_ClaroPromotionalAccessoryLoad_port != null)
      ((javax.xml.rpc.Stub)bSS_ClaroPromotionalAccessoryLoad_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1.BSS_ClaroPromotionalAccessoryLoad_port getBSS_ClaroPromotionalAccessoryLoad_port() {
    if (bSS_ClaroPromotionalAccessoryLoad_port == null)
      _initBSS_ClaroPromotionalAccessoryLoad_portProxy();
    return bSS_ClaroPromotionalAccessoryLoad_port;
  }
  
  public pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessResponse checkPromotionalAccessoryLoad(pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessRequest checkProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroPromotionalAccessoryLoad_port == null)
      _initBSS_ClaroPromotionalAccessoryLoad_portProxy();
    return bSS_ClaroPromotionalAccessoryLoad_port.checkPromotionalAccessoryLoad(checkProcessRequest);
  }
  
  public pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessResponse executePromotionalAccessoryLoad(pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessRequest executeProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroPromotionalAccessoryLoad_port == null)
      _initBSS_ClaroPromotionalAccessoryLoad_portProxy();
    return bSS_ClaroPromotionalAccessoryLoad_port.executePromotionalAccessoryLoad(executeProcessRequest);
  }
  
  
}