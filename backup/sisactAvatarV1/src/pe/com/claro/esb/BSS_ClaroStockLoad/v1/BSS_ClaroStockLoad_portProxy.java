package pe.com.claro.esb.BSS_ClaroStockLoad.v1;

public class BSS_ClaroStockLoad_portProxy implements pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_port {
  private String _endpoint = null;
  private pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_port bSS_ClaroStockLoad_port = null;
  
  public BSS_ClaroStockLoad_portProxy() {
    _initBSS_ClaroStockLoad_portProxy();
  }
  
  public BSS_ClaroStockLoad_portProxy(String endpoint) {
    _endpoint = endpoint;
    _initBSS_ClaroStockLoad_portProxy();
  }
  
  private void _initBSS_ClaroStockLoad_portProxy() {
    try {
      bSS_ClaroStockLoad_port = (new pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_v1Locator()).getBSS_ClaroStockLoad_SB11();
      if (bSS_ClaroStockLoad_port != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bSS_ClaroStockLoad_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bSS_ClaroStockLoad_port)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bSS_ClaroStockLoad_port != null)
      ((javax.xml.rpc.Stub)bSS_ClaroStockLoad_port)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.claro.esb.BSS_ClaroStockLoad.v1.BSS_ClaroStockLoad_port getBSS_ClaroStockLoad_port() {
    if (bSS_ClaroStockLoad_port == null)
      _initBSS_ClaroStockLoad_portProxy();
    return bSS_ClaroStockLoad_port;
  }
  
  public pe.com.claro.esb.data.bss.CheckStockProcess.CheckProcessResponse checkStockLoad(pe.com.claro.esb.data.bss.CheckStockProcess.CheckProcessRequest checkProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroStockLoad_port == null)
      _initBSS_ClaroStockLoad_portProxy();
    return bSS_ClaroStockLoad_port.checkStockLoad(checkProcessRequest);
  }
  
  public pe.com.claro.esb.data.bss.ExecuteStockProcess.ExecuteProcessResponse executeStockLoad(pe.com.claro.esb.data.bss.ExecuteStockProcess.ExecuteProcessRequest executeProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault{
    if (bSS_ClaroStockLoad_port == null)
      _initBSS_ClaroStockLoad_portProxy();
    return bSS_ClaroStockLoad_port.executeStockLoad(executeProcessRequest);
  }
  
  
}