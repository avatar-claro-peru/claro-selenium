/**
 * GetExecutePriceProcessType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicepriceload.www.ClaroServicePriceLoad;

public class GetExecutePriceProcessType  implements java.io.Serializable {
    private java.lang.String user;

    private java.lang.String password;

    private com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType[] listaRequestOpcional;

    public GetExecutePriceProcessType() {
    }

    public GetExecutePriceProcessType(
           java.lang.String user,
           java.lang.String password,
           com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType[] listaRequestOpcional) {
           this.user = user;
           this.password = password;
           this.listaRequestOpcional = listaRequestOpcional;
    }


    /**
     * Gets the user value for this GetExecutePriceProcessType.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this GetExecutePriceProcessType.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the password value for this GetExecutePriceProcessType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this GetExecutePriceProcessType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the listaRequestOpcional value for this GetExecutePriceProcessType.
     * 
     * @return listaRequestOpcional
     */
    public com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType[] getListaRequestOpcional() {
        return listaRequestOpcional;
    }


    /**
     * Sets the listaRequestOpcional value for this GetExecutePriceProcessType.
     * 
     * @param listaRequestOpcional
     */
    public void setListaRequestOpcional(com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType[] listaRequestOpcional) {
        this.listaRequestOpcional = listaRequestOpcional;
    }

    public com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType getListaRequestOpcional(int i) {
        return this.listaRequestOpcional[i];
    }

    public void setListaRequestOpcional(int i, com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType _value) {
        this.listaRequestOpcional[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetExecutePriceProcessType)) return false;
        GetExecutePriceProcessType other = (GetExecutePriceProcessType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
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
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetExecutePriceProcessType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetExecutePriceProcessType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaRequestOpcional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "listaRequestOpcional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "RequestOpcionalType"));
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
