/**
 * HeaderResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.generico.claroGenericHeader.v1;

public class HeaderResponseType  implements java.io.Serializable {
    private java.lang.String idTransaccionESB;

    private java.lang.String idTransaccionNegocio;

    private java.util.Calendar fechaInicio;

    private java.util.Calendar fechaFin;

    private java.lang.Object nodoAdicional;

    public HeaderResponseType() {
    }

    public HeaderResponseType(
           java.lang.String idTransaccionESB,
           java.lang.String idTransaccionNegocio,
           java.util.Calendar fechaInicio,
           java.util.Calendar fechaFin,
           java.lang.Object nodoAdicional) {
           this.idTransaccionESB = idTransaccionESB;
           this.idTransaccionNegocio = idTransaccionNegocio;
           this.fechaInicio = fechaInicio;
           this.fechaFin = fechaFin;
           this.nodoAdicional = nodoAdicional;
    }


    /**
     * Gets the idTransaccionESB value for this HeaderResponseType.
     * 
     * @return idTransaccionESB
     */
    public java.lang.String getIdTransaccionESB() {
        return idTransaccionESB;
    }


    /**
     * Sets the idTransaccionESB value for this HeaderResponseType.
     * 
     * @param idTransaccionESB
     */
    public void setIdTransaccionESB(java.lang.String idTransaccionESB) {
        this.idTransaccionESB = idTransaccionESB;
    }


    /**
     * Gets the idTransaccionNegocio value for this HeaderResponseType.
     * 
     * @return idTransaccionNegocio
     */
    public java.lang.String getIdTransaccionNegocio() {
        return idTransaccionNegocio;
    }


    /**
     * Sets the idTransaccionNegocio value for this HeaderResponseType.
     * 
     * @param idTransaccionNegocio
     */
    public void setIdTransaccionNegocio(java.lang.String idTransaccionNegocio) {
        this.idTransaccionNegocio = idTransaccionNegocio;
    }


    /**
     * Gets the fechaInicio value for this HeaderResponseType.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this HeaderResponseType.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the fechaFin value for this HeaderResponseType.
     * 
     * @return fechaFin
     */
    public java.util.Calendar getFechaFin() {
        return fechaFin;
    }


    /**
     * Sets the fechaFin value for this HeaderResponseType.
     * 
     * @param fechaFin
     */
    public void setFechaFin(java.util.Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**
     * Gets the nodoAdicional value for this HeaderResponseType.
     * 
     * @return nodoAdicional
     */
    public java.lang.Object getNodoAdicional() {
        return nodoAdicional;
    }


    /**
     * Sets the nodoAdicional value for this HeaderResponseType.
     * 
     * @param nodoAdicional
     */
    public void setNodoAdicional(java.lang.Object nodoAdicional) {
        this.nodoAdicional = nodoAdicional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HeaderResponseType)) return false;
        HeaderResponseType other = (HeaderResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idTransaccionESB==null && other.getIdTransaccionESB()==null) || 
             (this.idTransaccionESB!=null &&
              this.idTransaccionESB.equals(other.getIdTransaccionESB()))) &&
            ((this.idTransaccionNegocio==null && other.getIdTransaccionNegocio()==null) || 
             (this.idTransaccionNegocio!=null &&
              this.idTransaccionNegocio.equals(other.getIdTransaccionNegocio()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
            ((this.fechaFin==null && other.getFechaFin()==null) || 
             (this.fechaFin!=null &&
              this.fechaFin.equals(other.getFechaFin()))) &&
            ((this.nodoAdicional==null && other.getNodoAdicional()==null) || 
             (this.nodoAdicional!=null &&
              this.nodoAdicional.equals(other.getNodoAdicional())));
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
        if (getIdTransaccionESB() != null) {
            _hashCode += getIdTransaccionESB().hashCode();
        }
        if (getIdTransaccionNegocio() != null) {
            _hashCode += getIdTransaccionNegocio().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getFechaFin() != null) {
            _hashCode += getFechaFin().hashCode();
        }
        if (getNodoAdicional() != null) {
            _hashCode += getNodoAdicional().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HeaderResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "HeaderResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransaccionESB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "idTransaccionESB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransaccionNegocio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "idTransaccionNegocio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "fechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaFin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "fechaFin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodoAdicional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "nodoAdicional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
