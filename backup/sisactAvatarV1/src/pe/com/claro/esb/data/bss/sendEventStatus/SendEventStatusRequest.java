/**
 * SendEventStatusRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.sendEventStatus;

public class SendEventStatusRequest  implements java.io.Serializable {
    private java.lang.String user;

    private java.lang.String password;

    private java.lang.String orderId;

    private int idEvent;

    private pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional[] listaRequestOpcional;

    public SendEventStatusRequest() {
    }

    public SendEventStatusRequest(
           java.lang.String user,
           java.lang.String password,
           java.lang.String orderId,
           int idEvent,
           pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional[] listaRequestOpcional) {
           this.user = user;
           this.password = password;
           this.orderId = orderId;
           this.idEvent = idEvent;
           this.listaRequestOpcional = listaRequestOpcional;
    }


    /**
     * Gets the user value for this SendEventStatusRequest.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this SendEventStatusRequest.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the password value for this SendEventStatusRequest.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SendEventStatusRequest.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the orderId value for this SendEventStatusRequest.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this SendEventStatusRequest.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the idEvent value for this SendEventStatusRequest.
     * 
     * @return idEvent
     */
    public int getIdEvent() {
        return idEvent;
    }


    /**
     * Sets the idEvent value for this SendEventStatusRequest.
     * 
     * @param idEvent
     */
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }


    /**
     * Gets the listaRequestOpcional value for this SendEventStatusRequest.
     * 
     * @return listaRequestOpcional
     */
    public pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional[] getListaRequestOpcional() {
        return listaRequestOpcional;
    }


    /**
     * Sets the listaRequestOpcional value for this SendEventStatusRequest.
     * 
     * @param listaRequestOpcional
     */
    public void setListaRequestOpcional(pe.com.claro.esb.data.bss.generico.opcionales.v1.RequestOpcionalTypeRequestOpcional[] listaRequestOpcional) {
        this.listaRequestOpcional = listaRequestOpcional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendEventStatusRequest)) return false;
        SendEventStatusRequest other = (SendEventStatusRequest) obj;
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
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            this.idEvent == other.getIdEvent() &&
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
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
        }
        _hashCode += getIdEvent();
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
        new org.apache.axis.description.TypeDesc(SendEventStatusRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "sendEventStatusRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "orderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEvent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "idEvent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaRequestOpcional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/sendEventStatus", "listaRequestOpcional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/opcionales/v1/", ">RequestOpcionalType>requestOpcional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/opcionales/v1/", "requestOpcional"));
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
