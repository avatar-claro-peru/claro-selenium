/**
 * ClaroFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.generico.claroFault.v1;

public class ClaroFault  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.String idAuditoria;

    private java.lang.String codigoError;

    private java.lang.String descripcionError;

    private java.lang.String ubicacionError;

    private java.util.Calendar fecha;

    private java.lang.Object errorOrigen;

    public ClaroFault() {
    }

    public ClaroFault(
           java.lang.String idAuditoria,
           java.lang.String codigoError,
           java.lang.String descripcionError,
           java.lang.String ubicacionError,
           java.util.Calendar fecha,
           java.lang.Object errorOrigen) {
        this.idAuditoria = idAuditoria;
        this.codigoError = codigoError;
        this.descripcionError = descripcionError;
        this.ubicacionError = ubicacionError;
        this.fecha = fecha;
        this.errorOrigen = errorOrigen;
    }


    /**
     * Gets the idAuditoria value for this ClaroFault.
     * 
     * @return idAuditoria
     */
    public java.lang.String getIdAuditoria() {
        return idAuditoria;
    }


    /**
     * Sets the idAuditoria value for this ClaroFault.
     * 
     * @param idAuditoria
     */
    public void setIdAuditoria(java.lang.String idAuditoria) {
        this.idAuditoria = idAuditoria;
    }


    /**
     * Gets the codigoError value for this ClaroFault.
     * 
     * @return codigoError
     */
    public java.lang.String getCodigoError() {
        return codigoError;
    }


    /**
     * Sets the codigoError value for this ClaroFault.
     * 
     * @param codigoError
     */
    public void setCodigoError(java.lang.String codigoError) {
        this.codigoError = codigoError;
    }


    /**
     * Gets the descripcionError value for this ClaroFault.
     * 
     * @return descripcionError
     */
    public java.lang.String getDescripcionError() {
        return descripcionError;
    }


    /**
     * Sets the descripcionError value for this ClaroFault.
     * 
     * @param descripcionError
     */
    public void setDescripcionError(java.lang.String descripcionError) {
        this.descripcionError = descripcionError;
    }


    /**
     * Gets the ubicacionError value for this ClaroFault.
     * 
     * @return ubicacionError
     */
    public java.lang.String getUbicacionError() {
        return ubicacionError;
    }


    /**
     * Sets the ubicacionError value for this ClaroFault.
     * 
     * @param ubicacionError
     */
    public void setUbicacionError(java.lang.String ubicacionError) {
        this.ubicacionError = ubicacionError;
    }


    /**
     * Gets the fecha value for this ClaroFault.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ClaroFault.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the errorOrigen value for this ClaroFault.
     * 
     * @return errorOrigen
     */
    public java.lang.Object getErrorOrigen() {
        return errorOrigen;
    }


    /**
     * Sets the errorOrigen value for this ClaroFault.
     * 
     * @param errorOrigen
     */
    public void setErrorOrigen(java.lang.Object errorOrigen) {
        this.errorOrigen = errorOrigen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaroFault)) return false;
        ClaroFault other = (ClaroFault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idAuditoria==null && other.getIdAuditoria()==null) || 
             (this.idAuditoria!=null &&
              this.idAuditoria.equals(other.getIdAuditoria()))) &&
            ((this.codigoError==null && other.getCodigoError()==null) || 
             (this.codigoError!=null &&
              this.codigoError.equals(other.getCodigoError()))) &&
            ((this.descripcionError==null && other.getDescripcionError()==null) || 
             (this.descripcionError!=null &&
              this.descripcionError.equals(other.getDescripcionError()))) &&
            ((this.ubicacionError==null && other.getUbicacionError()==null) || 
             (this.ubicacionError!=null &&
              this.ubicacionError.equals(other.getUbicacionError()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.errorOrigen==null && other.getErrorOrigen()==null) || 
             (this.errorOrigen!=null &&
              this.errorOrigen.equals(other.getErrorOrigen())));
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
        if (getIdAuditoria() != null) {
            _hashCode += getIdAuditoria().hashCode();
        }
        if (getCodigoError() != null) {
            _hashCode += getCodigoError().hashCode();
        }
        if (getDescripcionError() != null) {
            _hashCode += getDescripcionError().hashCode();
        }
        if (getUbicacionError() != null) {
            _hashCode += getUbicacionError().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getErrorOrigen() != null) {
            _hashCode += getErrorOrigen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaroFault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "ClaroFault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAuditoria");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "idAuditoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "codigoError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "descripcionError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacionError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "ubicacionError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroFault/v1/", "errorOrigen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
