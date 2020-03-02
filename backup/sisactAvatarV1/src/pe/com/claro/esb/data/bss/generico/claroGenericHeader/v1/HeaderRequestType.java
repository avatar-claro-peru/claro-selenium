/**
 * HeaderRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.esb.data.bss.generico.claroGenericHeader.v1;

public class HeaderRequestType  implements java.io.Serializable {
    private java.lang.String canal;

    private java.lang.String idAplicacion;

    private java.lang.String usuarioAplicacion;

    private java.lang.String usuarioSesion;

    private java.lang.String idTransaccionESB;

    private java.lang.String idTransaccionNegocio;

    private java.util.Calendar fechaInicio;

    private java.lang.Object nodoAdicional;

    public HeaderRequestType() {
    }

    public HeaderRequestType(
           java.lang.String canal,
           java.lang.String idAplicacion,
           java.lang.String usuarioAplicacion,
           java.lang.String usuarioSesion,
           java.lang.String idTransaccionESB,
           java.lang.String idTransaccionNegocio,
           java.util.Calendar fechaInicio,
           java.lang.Object nodoAdicional) {
           this.canal = canal;
           this.idAplicacion = idAplicacion;
           this.usuarioAplicacion = usuarioAplicacion;
           this.usuarioSesion = usuarioSesion;
           this.idTransaccionESB = idTransaccionESB;
           this.idTransaccionNegocio = idTransaccionNegocio;
           this.fechaInicio = fechaInicio;
           this.nodoAdicional = nodoAdicional;
    }


    /**
     * Gets the canal value for this HeaderRequestType.
     * 
     * @return canal
     */
    public java.lang.String getCanal() {
        return canal;
    }


    /**
     * Sets the canal value for this HeaderRequestType.
     * 
     * @param canal
     */
    public void setCanal(java.lang.String canal) {
        this.canal = canal;
    }


    /**
     * Gets the idAplicacion value for this HeaderRequestType.
     * 
     * @return idAplicacion
     */
    public java.lang.String getIdAplicacion() {
        return idAplicacion;
    }


    /**
     * Sets the idAplicacion value for this HeaderRequestType.
     * 
     * @param idAplicacion
     */
    public void setIdAplicacion(java.lang.String idAplicacion) {
        this.idAplicacion = idAplicacion;
    }


    /**
     * Gets the usuarioAplicacion value for this HeaderRequestType.
     * 
     * @return usuarioAplicacion
     */
    public java.lang.String getUsuarioAplicacion() {
        return usuarioAplicacion;
    }


    /**
     * Sets the usuarioAplicacion value for this HeaderRequestType.
     * 
     * @param usuarioAplicacion
     */
    public void setUsuarioAplicacion(java.lang.String usuarioAplicacion) {
        this.usuarioAplicacion = usuarioAplicacion;
    }


    /**
     * Gets the usuarioSesion value for this HeaderRequestType.
     * 
     * @return usuarioSesion
     */
    public java.lang.String getUsuarioSesion() {
        return usuarioSesion;
    }


    /**
     * Sets the usuarioSesion value for this HeaderRequestType.
     * 
     * @param usuarioSesion
     */
    public void setUsuarioSesion(java.lang.String usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }


    /**
     * Gets the idTransaccionESB value for this HeaderRequestType.
     * 
     * @return idTransaccionESB
     */
    public java.lang.String getIdTransaccionESB() {
        return idTransaccionESB;
    }


    /**
     * Sets the idTransaccionESB value for this HeaderRequestType.
     * 
     * @param idTransaccionESB
     */
    public void setIdTransaccionESB(java.lang.String idTransaccionESB) {
        this.idTransaccionESB = idTransaccionESB;
    }


    /**
     * Gets the idTransaccionNegocio value for this HeaderRequestType.
     * 
     * @return idTransaccionNegocio
     */
    public java.lang.String getIdTransaccionNegocio() {
        return idTransaccionNegocio;
    }


    /**
     * Sets the idTransaccionNegocio value for this HeaderRequestType.
     * 
     * @param idTransaccionNegocio
     */
    public void setIdTransaccionNegocio(java.lang.String idTransaccionNegocio) {
        this.idTransaccionNegocio = idTransaccionNegocio;
    }


    /**
     * Gets the fechaInicio value for this HeaderRequestType.
     * 
     * @return fechaInicio
     */
    public java.util.Calendar getFechaInicio() {
        return fechaInicio;
    }


    /**
     * Sets the fechaInicio value for this HeaderRequestType.
     * 
     * @param fechaInicio
     */
    public void setFechaInicio(java.util.Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Gets the nodoAdicional value for this HeaderRequestType.
     * 
     * @return nodoAdicional
     */
    public java.lang.Object getNodoAdicional() {
        return nodoAdicional;
    }


    /**
     * Sets the nodoAdicional value for this HeaderRequestType.
     * 
     * @param nodoAdicional
     */
    public void setNodoAdicional(java.lang.Object nodoAdicional) {
        this.nodoAdicional = nodoAdicional;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HeaderRequestType)) return false;
        HeaderRequestType other = (HeaderRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.canal==null && other.getCanal()==null) || 
             (this.canal!=null &&
              this.canal.equals(other.getCanal()))) &&
            ((this.idAplicacion==null && other.getIdAplicacion()==null) || 
             (this.idAplicacion!=null &&
              this.idAplicacion.equals(other.getIdAplicacion()))) &&
            ((this.usuarioAplicacion==null && other.getUsuarioAplicacion()==null) || 
             (this.usuarioAplicacion!=null &&
              this.usuarioAplicacion.equals(other.getUsuarioAplicacion()))) &&
            ((this.usuarioSesion==null && other.getUsuarioSesion()==null) || 
             (this.usuarioSesion!=null &&
              this.usuarioSesion.equals(other.getUsuarioSesion()))) &&
            ((this.idTransaccionESB==null && other.getIdTransaccionESB()==null) || 
             (this.idTransaccionESB!=null &&
              this.idTransaccionESB.equals(other.getIdTransaccionESB()))) &&
            ((this.idTransaccionNegocio==null && other.getIdTransaccionNegocio()==null) || 
             (this.idTransaccionNegocio!=null &&
              this.idTransaccionNegocio.equals(other.getIdTransaccionNegocio()))) &&
            ((this.fechaInicio==null && other.getFechaInicio()==null) || 
             (this.fechaInicio!=null &&
              this.fechaInicio.equals(other.getFechaInicio()))) &&
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
        if (getCanal() != null) {
            _hashCode += getCanal().hashCode();
        }
        if (getIdAplicacion() != null) {
            _hashCode += getIdAplicacion().hashCode();
        }
        if (getUsuarioAplicacion() != null) {
            _hashCode += getUsuarioAplicacion().hashCode();
        }
        if (getUsuarioSesion() != null) {
            _hashCode += getUsuarioSesion().hashCode();
        }
        if (getIdTransaccionESB() != null) {
            _hashCode += getIdTransaccionESB().hashCode();
        }
        if (getIdTransaccionNegocio() != null) {
            _hashCode += getIdTransaccionNegocio().hashCode();
        }
        if (getFechaInicio() != null) {
            _hashCode += getFechaInicio().hashCode();
        }
        if (getNodoAdicional() != null) {
            _hashCode += getNodoAdicional().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HeaderRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "HeaderRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "canal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAplicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "idAplicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioAplicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "usuarioAplicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioSesion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://claro.com.pe/esb/data/bss/generico/claroGenericHeader/v1/", "usuarioSesion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
