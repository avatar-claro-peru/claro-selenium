/**
 * ClaroServiceStockLoad_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicestockload.www.ClaroServiceStockLoad;

public interface ClaroServiceStockLoad_PortType extends java.rmi.Remote {
    public void checkProcessStatus(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement) throws java.rmi.RemoteException;
    public void executeStockProcess(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetExecuteStockProcessType getExecuteStockProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowExecuteStockProcessTypeHolder showExecuteStockProcessElement) throws java.rmi.RemoteException;
}
