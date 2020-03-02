/**
 * RequestOpcionalTypeRequestOpcional.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.generico.opcionales.v1;

public class RequestOpcionalTypeRequestOpcional  implements java.io.Serializable {
    private java.lang.String campo;  // attribute

    private java.lang.String valor;  // attribute

    public RequestOpcionalTypeRequestOpcional() {
    }

    public RequestOpcionalTypeRequestOpcional(
           java.lang.String campo,
           java.lang.String valor) {
           this.campo = campo;
           this.valor = valor;
    }


    /**
     * Gets the campo value for this RequestOpcionalTypeRequestOpcional.
     * 
     * @return campo
     */
    public java.lang.String getCampo() {
        return campo;
    }


    /**
     * Sets the campo value for this RequestOpcionalTypeRequestOpcional.
     * 
     * @param campo
     */
    public void setCampo(java.lang.String campo) {
        this.campo = campo;
    }


    /**
     * Gets the valor value for this RequestOpcionalTypeRequestOpcional.
     * 
     * @return valor
     */
    public java.lang.String getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this RequestOpcionalTypeRequestOpcional.
     * 
     * @param valor
     */
    public void setValor(java.lang.String valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestOpcionalTypeRequestOpcional)) return false;
        RequestOpcionalTypeRequestOpcional other = (RequestOpcionalTypeRequestOpcional) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.campo==null && other.getCampo()==null) || 
             (this.campo!=null &&
              this.campo.equals(other.getCampo()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor())));
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
        if (getCampo() != null) {
            _hashCode += getCampo().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestOpcionalTypeRequestOpcional.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/opcionales/v1/", ">RequestOpcionalType>requestOpcional"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("campo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "campo"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("valor");
        attrField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
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
