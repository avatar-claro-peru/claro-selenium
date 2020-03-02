/**
 * ShowCheckProcessStatusType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicestockload.www.ClaroServiceStockLoad;

public class ShowCheckProcessStatusType  implements java.io.Serializable {
    private java.lang.String idEvent;

    private com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType[] listaResponseOpcional;

    private com.claroservicestockload.www.ClaroServiceStockLoad.ResponseStatus responseStatus;

    private com.claroservicestockload.www.ClaroServiceStockLoad.ClaroFault claroFault;

    public ShowCheckProcessStatusType() {
    }

    public ShowCheckProcessStatusType(
           java.lang.String idEvent,
           com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType[] listaResponseOpcional,
           com.claroservicestockload.www.ClaroServiceStockLoad.ResponseStatus responseStatus,
           com.claroservicestockload.www.ClaroServiceStockLoad.ClaroFault claroFault) {
           this.idEvent = idEvent;
           this.listaResponseOpcional = listaResponseOpcional;
           this.responseStatus = responseStatus;
           this.claroFault = claroFault;
    }


    /**
     * Gets the idEvent value for this ShowCheckProcessStatusType.
     * 
     * @return idEvent
     */
    public java.lang.String getIdEvent() {
        return idEvent;
    }


    /**
     * Sets the idEvent value for this ShowCheckProcessStatusType.
     * 
     * @param idEvent
     */
    public void setIdEvent(java.lang.String idEvent) {
        this.idEvent = idEvent;
    }


    /**
     * Gets the listaResponseOpcional value for this ShowCheckProcessStatusType.
     * 
     * @return listaResponseOpcional
     */
    public com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType[] getListaResponseOpcional() {
        return listaResponseOpcional;
    }


    /**
     * Sets the listaResponseOpcional value for this ShowCheckProcessStatusType.
     * 
     * @param listaResponseOpcional
     */
    public void setListaResponseOpcional(com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType[] listaResponseOpcional) {
        this.listaResponseOpcional = listaResponseOpcional;
    }

    public com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType getListaResponseOpcional(int i) {
        return this.listaResponseOpcional[i];
    }

    public void setListaResponseOpcional(int i, com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType _value) {
        this.listaResponseOpcional[i] = _value;
    }


    /**
     * Gets the responseStatus value for this ShowCheckProcessStatusType.
     * 
     * @return responseStatus
     */
    public com.claroservicestockload.www.ClaroServiceStockLoad.ResponseStatus getResponseStatus() {
        return responseStatus;
    }


    /**
     * Sets the responseStatus value for this ShowCheckProcessStatusType.
     * 
     * @param responseStatus
     */
    public void setResponseStatus(com.claroservicestockload.www.ClaroServiceStockLoad.ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }


    /**
     * Gets the claroFault value for this ShowCheckProcessStatusType.
     * 
     * @return claroFault
     */
    public com.claroservicestockload.www.ClaroServiceStockLoad.ClaroFault getClaroFault() {
        return claroFault;
    }


    /**
     * Sets the claroFault value for this ShowCheckProcessStatusType.
     * 
     * @param claroFault
     */
    public void setClaroFault(com.claroservicestockload.www.ClaroServiceStockLoad.ClaroFault claroFault) {
        this.claroFault = claroFault;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ShowCheckProcessStatusType)) return false;
        ShowCheckProcessStatusType other = (ShowCheckProcessStatusType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idEvent==null && other.getIdEvent()==null) || 
             (this.idEvent!=null &&
              this.idEvent.equals(other.getIdEvent()))) &&
            ((this.listaResponseOpcional==null && other.getListaResponseOpcional()==null) || 
             (this.listaResponseOpcional!=null &&
              java.util.Arrays.equals(this.listaResponseOpcional, other.getListaResponseOpcional()))) &&
            ((this.responseStatus==null && other.getResponseStatus()==null) || 
             (this.responseStatus!=null &&
              this.responseStatus.equals(other.getResponseStatus()))) &&
            ((this.claroFault==null && other.getClaroFault()==null) || 
             (this.claroFault!=null &&
              this.claroFault.equals(other.getClaroFault())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIdEvent() != null) {
            _hashCode += getIdEvent().hashCode();
        }
        if (getListaResponseOpcional() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaResponseOpcional());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaResponseOpcional(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getResponseStatus() != null) {
            _hashCode += getResponseStatus().hashCode();
        }
        if (getClaroFault() != null) {
            _hashCode += getClaroFault().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ShowCheckProcessStatusType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "IdEvent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaResponseOpcional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "listaResponseOpcional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ResponseOpcionalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "responseStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ResponseStatus"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claroFault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "claroFault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ClaroFault"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
