/**
 * CheckProcessResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.CheckStockProcess;

public class CheckProcessResponse  implements java.io.Serializable {
    private pe.com.claro.esb.data.bss.generico.responseStatus.v1.ResponseStatus responseStatus;

    private pe.com.claro.esb.data.bss.generico.responseData.v1.ResponseData responseData;

    private pe.com.claro.esb.data.bss.generico.opcionales.v1.ResponseOpcionalTypeResponseOpcional[] listaResponseOpcional;

    public CheckProcessResponse() {
    }

    public CheckProcessResponse(
           pe.com.claro.esb.data.bss.generico.responseStatus.v1.ResponseStatus responseStatus,
           pe.com.claro.esb.data.bss.generico.responseData.v1.ResponseData responseData,
           pe.com.claro.esb.data.bss.generico.opcionales.v1.ResponseOpcionalTypeResponseOpcional[] listaResponseOpcional) {
           this.responseStatus = responseStatus;
           this.responseData = responseData;
           this.listaResponseOpcional = listaResponseOpcional;
    }


    /**
     * Gets the responseStatus value for this CheckProcessResponse.
     * 
     * @return responseStatus
     */
    public pe.com.claro.esb.data.bss.generico.responseStatus.v1.ResponseStatus getResponseStatus() {
        return responseStatus;
    }


    /**
     * Sets the responseStatus value for this CheckProcessResponse.
     * 
     * @param responseStatus
     */
    public void setResponseStatus(pe.com.claro.esb.data.bss.generico.responseStatus.v1.ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }


    /**
     * Gets the responseData value for this CheckProcessResponse.
     * 
     * @return responseData
     */
    public pe.com.claro.esb.data.bss.generico.responseData.v1.ResponseData getResponseData() {
        return responseData;
    }


    /**
     * Sets the responseData value for this CheckProcessResponse.
     * 
     * @param responseData
     */
    public void setResponseData(pe.com.claro.esb.data.bss.generico.responseData.v1.ResponseData responseData) {
        this.responseData = responseData;
    }


    /**
     * Gets the listaResponseOpcional value for this CheckProcessResponse.
     * 
     * @return listaResponseOpcional
     */
    public pe.com.claro.esb.data.bss.generico.opcionales.v1.ResponseOpcionalTypeResponseOpcional[] getListaResponseOpcional() {
        return listaResponseOpcional;
    }


    /**
     * Sets the listaResponseOpcional value for this CheckProcessResponse.
     * 
     * @param listaResponseOpcional
     */
    public void setListaResponseOpcional(pe.com.claro.esb.data.bss.generico.opcionales.v1.ResponseOpcionalTypeResponseOpcional[] listaResponseOpcional) {
        this.listaResponseOpcional = listaResponseOpcional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckProcessResponse)) return false;
        CheckProcessResponse other = (CheckProcessResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseStatus==null && other.getResponseStatus()==null) || 
             (this.responseStatus!=null &&
              this.responseStatus.equals(other.getResponseStatus()))) &&
            ((this.responseData==null && other.getResponseData()==null) || 
             (this.responseData!=null &&
              this.responseData.equals(other.getResponseData()))) &&
            ((this.listaResponseOpcional==null && other.getListaResponseOpcional()==null) || 
             (this.listaResponseOpcional!=null &&
              java.util.Arrays.equals(this.listaResponseOpcional, other.getListaResponseOpcional())));
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
        if (getResponseStatus() != null) {
            _hashCode += getResponseStatus().hashCode();
        }
        if (getResponseData() != null) {
            _hashCode += getResponseData().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckProcessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/CheckStockProcess/", "CheckProcessResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/CheckStockProcess/", "responseStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "ResponseStatus"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/CheckStockProcess/", "responseData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseData/v1/", "ResponseData"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaResponseOpcional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/CheckStockProcess/", "listaResponseOpcional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/opcionales/v1/", ">ResponseOpcionalType>responseOpcional"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/opcionales/v1/", "responseOpcional"));
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
