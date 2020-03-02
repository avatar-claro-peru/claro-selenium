package pe.com.claro.esb.BSS_ClaroPriceLoad.v1;

public class BSS_ClaroPriceLoadProxy implements pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad {
  private String _endpoint = null;
  private pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad bSS_ClaroPriceLoad = null;
  
  public BSS_ClaroPriceLoadProxy() {
    _initBSS_ClaroPriceLoadProxy();
  }
  
  public BSS_ClaroPriceLoadProxy(String endpoint) {
    _endpoint = endpoint;
    _initBSS_ClaroPriceLoadProxy();
  }
  
  private void _initBSS_ClaroPriceLoadProxy() {
    try {
      bSS_ClaroPriceLoad = (new pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad_v1Locator()).getBSS_ClaroPriceLoadSOAP();
      if (bSS_ClaroPriceLoad != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bSS_ClaroPriceLoad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bSS_ClaroPriceLoad)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bSS_ClaroPriceLoad != null)
      ((javax.xml.rpc.Stub)bSS_ClaroPriceLoad)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.claro.esb.BSS_ClaroPriceLoad.v1.BSS_ClaroPriceLoad getBSS_ClaroPriceLoad() {
    if (bSS_ClaroPriceLoad == null)
      _initBSS_ClaroPriceLoadProxy();
    return bSS_ClaroPriceLoad;
  }
  
  public pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessResponse checkPriceProcess(pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessRequest checkPriceProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroPriceLoad == null)
      _initBSS_ClaroPriceLoadProxy();
    return bSS_ClaroPriceLoad.checkPriceProcess(checkPriceProcessRequest);
  }
  
  public pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessResponse executePriceProcess(pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessRequest executePriceProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroPriceLoad == null)
      _initBSS_ClaroPriceLoadProxy();
    return bSS_ClaroPriceLoad.executePriceProcess(executePriceProcessRequest);
  }
  
  
}