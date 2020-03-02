/**
 * GetExecuteStockProcessType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicestockload.www.ClaroServiceStockLoad;

public class GetExecuteStockProcessType  implements java.io.Serializable {
    private java.lang.String userId;

    private java.lang.String password;

    private com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType[] listaRequestOpcional;

    public GetExecuteStockProcessType() {
    }

    public GetExecuteStockProcessType(
           java.lang.String userId,
           java.lang.String password,
           com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType[] listaRequestOpcional) {
           this.userId = userId;
           this.password = password;
           this.listaRequestOpcional = listaRequestOpcional;
    }


    /**
     * Gets the userId value for this GetExecuteStockProcessType.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this GetExecuteStockProcessType.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the password value for this GetExecuteStockProcessType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this GetExecuteStockProcessType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the listaRequestOpcional value for this GetExecuteStockProcessType.
     * 
     * @return listaRequestOpcional
     */
    public com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType[] getListaRequestOpcional() {
        return listaRequestOpcional;
    }


    /**
     * Sets the listaRequestOpcional value for this GetExecuteStockProcessType.
     * 
     * @param listaRequestOpcional
     */
    public void setListaRequestOpcional(com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType[] listaRequestOpcional) {
        this.listaRequestOpcional = listaRequestOpcional;
    }

    public com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType getListaRequestOpcional(int i) {
        return this.listaRequestOpcional[i];
    }

    public void setListaRequestOpcional(int i, com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType _value) {
        this.listaRequestOpcional[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetExecuteStockProcessType)) return false;
        GetExecuteStockProcessType other = (GetExecuteStockProcessType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.listaRequestOpcional==null && other.getListaRequestOpcional()==null) || 
             (this.listaRequestOpcional!=null &&
              java.util.Arrays.equals(this.listaRequestOpcional, other.getListaRequestOpcional())));
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
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getListaRequestOpcional() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaRequestOpcional());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaRequestOpcional(), i);
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
        new org.apache.axis.description.TypeDesc(GetExecuteStockProcessType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetExecuteStockProcessType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaRequestOpcional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "listaRequestOpcional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "RequestOpcionalType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
