/**
 * ClaroServicePriceLoad_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicepriceload.www.ClaroServicePriceLoad;

public interface ClaroServicePriceLoad_PortType extends java.rmi.Remote {
    public void checkProcessStatus(com.claroservicepriceload.www.ClaroServicePriceLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException;
    public void executePriceProcess(com.claroservicepriceload.www.ClaroServicePriceLoad.GetExecutePriceProcessType getExecutePriceProcessElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowExecutePriceProcessTypeHolder showExecutePriceProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException;
}
