/**
 * ClaroServiceStockLoadSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.claroservicestockload.www.ClaroServiceStockLoad;

public class ClaroServiceStockLoadSOAPStub extends org.apache.axis.client.Stub implements com.claroservicestockload.www.ClaroServiceStockLoad.ClaroServiceStockLoad_PortType {
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
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequestType"), pe.com.claro.HeaderGeneric.HeaderRequestType.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetCheckProcessStatusElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetCheckProcessStatusType"), com.claroservicestockload.www.ClaroServiceStockLoad.GetCheckProcessStatusType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponseType"), pe.com.claro.HeaderGeneric.HeaderResponseType.class, false, true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusElement"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusType"), com.claroservicestockload.www.ClaroServiceStockLoad.ShowCheckProcessStatusType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExecuteStockProcess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderRequestType"), pe.com.claro.HeaderGeneric.HeaderRequestType.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetExecuteStockProcessElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetExecuteStockProcessType"), com.claroservicestockload.www.ClaroServiceStockLoad.GetExecuteStockProcessType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponseType"), pe.com.claro.HeaderGeneric.HeaderResponseType.class, false, true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowExecuteStockProcessElement"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowExecuteStockProcessType"), com.claroservicestockload.www.ClaroServiceStockLoad.ShowExecuteStockProcessType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

    }

    public ClaroServiceStockLoadSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ClaroServiceStockLoadSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ClaroServiceStockLoadSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ClaroFault");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.ClaroFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetCheckProcessStatusType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.GetCheckProcessStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "GetExecuteStockProcessType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.GetExecuteStockProcessType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "RequestOpcionalType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.RequestOpcionalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ResponseOpcionalType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.ResponseOpcionalType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ResponseStatus");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.ResponseStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.ShowCheckProcessStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowExecuteStockProcessType");
            cachedSerQNames.add(qName);
            cls = com.claroservicestockload.www.ClaroServiceStockLoad.ShowExecuteStockProcessType.class;
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

    public void checkProcessStatus(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetCheckProcessStatusType getCheckProcessStatusElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowCheckProcessStatusTypeHolder showCheckProcessStatusElement) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.claroservicestockload.com/ClaroServiceStockLoad/NewOperation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CheckProcessStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {headerRequest, getCheckProcessStatusElement});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) _output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"));
            } catch (java.lang.Exception _exception) {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse")), pe.com.claro.HeaderGeneric.HeaderResponseType.class);
            }
            try {
                showCheckProcessStatusElement.value = (com.claroservicestockload.www.ClaroServiceStockLoad.ShowCheckProcessStatusType) _output.get(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusElement"));
            } catch (java.lang.Exception _exception) {
                showCheckProcessStatusElement.value = (com.claroservicestockload.www.ClaroServiceStockLoad.ShowCheckProcessStatusType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowCheckProcessStatusElement")), com.claroservicestockload.www.ClaroServiceStockLoad.ShowCheckProcessStatusType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void executeStockProcess(pe.com.claro.HeaderGeneric.HeaderRequestType headerRequest, com.claroservicestockload.www.ClaroServiceStockLoad.GetExecuteStockProcessType getExecuteStockProcessElement, pe.com.claro.HeaderGeneric.holders.HeaderResponseTypeHolder headerResponse, com.claroservicestockload.www.ClaroServiceStockLoad.holders.ShowExecuteStockProcessTypeHolder showExecuteStockProcessElement) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.claroservicestockload.com/ClaroServiceStockLoad/NewOperation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ExecuteStockProcess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {headerRequest, getExecuteStockProcessElement});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) _output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse"));
            } catch (java.lang.Exception _exception) {
                headerResponse.value = (pe.com.claro.HeaderGeneric.HeaderResponseType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://claro.com.pe/HeaderGeneric", "HeaderResponse")), pe.com.claro.HeaderGeneric.HeaderResponseType.class);
            }
            try {
                showExecuteStockProcessElement.value = (com.claroservicestockload.www.ClaroServiceStockLoad.ShowExecuteStockProcessType) _output.get(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowExecuteStockProcessElement"));
            } catch (java.lang.Exception _exception) {
                showExecuteStockProcessElement.value = (com.claroservicestockload.www.ClaroServiceStockLoad.ShowExecuteStockProcessType) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.claroservicestockload.com/ClaroServiceStockLoad", "ShowExecuteStockProcessElement")), com.claroservicestockload.www.ClaroServiceStockLoad.ShowExecuteStockProcessType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
