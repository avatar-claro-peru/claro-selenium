/**
 * BSS_ClaroPromotionalAccessoryLoad_port.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.BSS_ClaroPromotionalAccessoryLoad.v1;

public interface BSS_ClaroPromotionalAccessoryLoad_port extends java.rmi.Remote {
    public pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessResponse checkPromotionalAccessoryLoad(pe.com.claro.esb.data.bss.CheckAccesoryProcess.CheckProcessRequest checkProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
    public pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessResponse executePromotionalAccessoryLoad(pe.com.claro.esb.data.bss.ExecuteAccesoryProcess.ExecuteProcessRequest executeProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
}
