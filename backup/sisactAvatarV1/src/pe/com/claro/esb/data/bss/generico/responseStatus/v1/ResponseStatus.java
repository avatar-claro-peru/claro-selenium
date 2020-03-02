/**
 * ResponseStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.generico.responseStatus.v1;

public class ResponseStatus  implements java.io.Serializable {
    private int estado;

    private java.lang.String codigoRespuesta;

    private java.lang.String descripcionRespuesta;

    private java.lang.String ubicacionError;

    private java.util.Calendar fecha;

    private java.lang.String origen;

    public ResponseStatus() {
    }

    public ResponseStatus(
           int estado,
           java.lang.String codigoRespuesta,
           java.lang.String descripcionRespuesta,
           java.lang.String ubicacionError,
           java.util.Calendar fecha,
           java.lang.String origen) {
           this.estado = estado;
           this.codigoRespuesta = codigoRespuesta;
           this.descripcionRespuesta = descripcionRespuesta;
           this.ubicacionError = ubicacionError;
           this.fecha = fecha;
           this.origen = origen;
    }


    /**
     * Gets the estado value for this ResponseStatus.
     * 
     * @return estado
     */
    public int getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this ResponseStatus.
     * 
     * @param estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }


    /**
     * Gets the codigoRespuesta value for this ResponseStatus.
     * 
     * @return codigoRespuesta
     */
    public java.lang.String getCodigoRespuesta() {
        return codigoRespuesta;
    }


    /**
     * Sets the codigoRespuesta value for this ResponseStatus.
     * 
     * @param codigoRespuesta
     */
    public void setCodigoRespuesta(java.lang.String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }


    /**
     * Gets the descripcionRespuesta value for this ResponseStatus.
     * 
     * @return descripcionRespuesta
     */
    public java.lang.String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }


    /**
     * Sets the descripcionRespuesta value for this ResponseStatus.
     * 
     * @param descripcionRespuesta
     */
    public void setDescripcionRespuesta(java.lang.String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }


    /**
     * Gets the ubicacionError value for this ResponseStatus.
     * 
     * @return ubicacionError
     */
    public java.lang.String getUbicacionError() {
        return ubicacionError;
    }


    /**
     * Sets the ubicacionError value for this ResponseStatus.
     * 
     * @param ubicacionError
     */
    public void setUbicacionError(java.lang.String ubicacionError) {
        this.ubicacionError = ubicacionError;
    }


    /**
     * Gets the fecha value for this ResponseStatus.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ResponseStatus.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the origen value for this ResponseStatus.
     * 
     * @return origen
     */
    public java.lang.String getOrigen() {
        return origen;
    }


    /**
     * Sets the origen value for this ResponseStatus.
     * 
     * @param origen
     */
    public void setOrigen(java.lang.String origen) {
        this.origen = origen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseStatus)) return false;
        ResponseStatus other = (ResponseStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.estado == other.getEstado() &&
            ((this.codigoRespuesta==null && other.getCodigoRespuesta()==null) || 
             (this.codigoRespuesta!=null &&
              this.codigoRespuesta.equals(other.getCodigoRespuesta()))) &&
            ((this.descripcionRespuesta==null && other.getDescripcionRespuesta()==null) || 
             (this.descripcionRespuesta!=null &&
              this.descripcionRespuesta.equals(other.getDescripcionRespuesta()))) &&
            ((this.ubicacionError==null && other.getUbicacionError()==null) || 
             (this.ubicacionError!=null &&
              this.ubicacionError.equals(other.getUbicacionError()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.origen==null && other.getOrigen()==null) || 
             (this.origen!=null &&
              this.origen.equals(other.getOrigen())));
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
        _hashCode += getEstado();
        if (getCodigoRespuesta() != null) {
            _hashCode += getCodigoRespuesta().hashCode();
        }
        if (getDescripcionRespuesta() != null) {
            _hashCode += getDescripcionRespuesta().hashCode();
        }
        if (getUbicacionError() != null) {
            _hashCode += getUbicacionError().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getOrigen() != null) {
            _hashCode += getOrigen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "ResponseStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "codigoRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "descripcionRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacionError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "ubicacionError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/responseStatus/v1/", "origen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
