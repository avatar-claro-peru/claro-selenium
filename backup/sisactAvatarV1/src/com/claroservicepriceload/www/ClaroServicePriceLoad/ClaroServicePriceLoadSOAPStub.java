/**
 * ClaroServicePriceLoadSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicepriceload.www.ClaroServicePriceLoad;

public class ClaroServicePriceLoadSOAPStub extends org.apache.axis.client.Stub implements com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroServicePriceLoad_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckProcessStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetCheckProcessStatusElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetCheckProcessStatusType"), com.claroservicepriceload.www.ClaroServicePriceLoad.GetCheckProcessStatusType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequestType"), pe.com.claro.HeaderGeneric.HeaderRequestType.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowCheckProcessStatusElement"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowCheckProcessStatusType"), com.claroservicepriceload.www.ClaroServicePriceLoad.ShowCheckProcessStatusType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponseType"), pe.com.claro.HeaderGeneric.HeaderResponseType.class, false, true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExecutePriceProcess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetExecutePriceProcessElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetExecutePriceProcessType"), com.claroservicepriceload.www.ClaroServicePriceLoad.GetExecutePriceProcessType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequestType"), pe.com.claro.HeaderGeneric.HeaderRequestType.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowExecutePriceProcessElement"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowExecutePriceProcessType"), com.claroservicepriceload.www.ClaroServicePriceLoad.ShowExecutePriceProcessType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponseType"), pe.com.claro.HeaderGeneric.HeaderResponseType.class, false, true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

    }

    public ClaroServicePriceLoadSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ClaroServicePriceLoadSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ClaroServicePriceLoadSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequestType");
            cachedSerQNames.add(qName);
            cls = pe.com.claro.HeaderGeneric.HeaderRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponseType");
            cachedSerQNames.add(qName);
            cls = pe.com.claro.HeaderGeneric.HeaderResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ClaroFault");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.ClaroFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetCheckProcessStatusType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.GetCheckProcessStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "GetExecutePriceProcessType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.GetExecutePriceProcessType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "RequestOpcionalType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.RequestOpcionalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "responseOpcionalType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.ResponseOpcionalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ResponseStatus");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.ResponseStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowCheckProcessStatusType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.ShowCheckProcessStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowExecutePriceProcessType");
            cachedSerQNames.add(qName);
            cls = com.claroservicepriceload.www.ClaroServicePriceLoad.ShowExecutePriceProcessType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void checkProcessStatus(com.claroservicepriceload.www.ClaroServicePriceLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.claroservicepriceload.com/ClaroServicePriceLoad/NewOperation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckProcessStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getCheckProcessStatusElement, headerRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                showCheckProcessStatusElement.value = (com.claroservicepriceload.www.ClaroServicePriceLoad.ShowCheckProcessStatusType) _output.get(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowCheckProcessStatusElement"));
            } catch (java.lang.Exception _exception) {
                showCheckProcessStatusElement.value = (com.claroservicepriceload.www.ClaroServicePriceLoad.ShowCheckProcessStatusType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowCheckProcessStatusElement")), com.claroservicepriceload.www.ClaroServicePriceLoad.ShowCheckProcessStatusType.class);
            }
            try {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) _output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"));
            } catch (java.lang.Exception _exception) {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse")), pe.com.claro.HeaderGeneric.HeaderResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void executePriceProcess(com.claroservicepriceload.www.ClaroServicePriceLoad.GetExecutePriceProcessType getExecutePriceProcessElement, pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicepriceload.www.ClaroServicePriceLoad.holders.ShowExecutePriceProcessTypeHolder showExecutePriceProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.claroservicepriceload.com/ClaroServicePriceLoad/NewOperation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ExecutePriceProcess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getExecutePriceProcessElement, headerRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                showExecutePriceProcessElement.value = (com.claroservicepriceload.www.ClaroServicePriceLoad.ShowExecutePriceProcessType) _output.get(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowExecutePriceProcessElement"));
            } catch (java.lang.Exception _exception) {
                showExecutePriceProcessElement.value = (com.claroservicepriceload.www.ClaroServicePriceLoad.ShowExecutePriceProcessType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.claroservicepriceload.com/ClaroServicePriceLoad", "ShowExecutePriceProcessElement")), com.claroservicepriceload.www.ClaroServicePriceLoad.ShowExecutePriceProcessType.class);
            }
            try {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) _output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"));
            } catch (java.lang.Exception _exception) {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse")), pe.com.claro.HeaderGeneric.HeaderResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
