/**
 * BSS_ClaroPriceLoad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.BSS_ClaroPriceLoad.v1;

public interface BSS_ClaroPriceLoad extends java.rmi.Remote {
    public pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessResponse checkPriceProcess(pe.com.claro.esb.data.bss.checkPriceProcessStatus.CheckPriceProcessRequest checkPriceProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
    public pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessResponse executePriceProcess(pe.com.claro.esb.data.bss.executePriceProcess.ExecutePriceProcessRequest executePriceProcessRequest) throws java.rmi.RemoteException, pe.com.claro.esb.data.bss.generico.claroFault.v1.ClaroFault;
}
