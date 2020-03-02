<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SISACT AVATAR</title>
<%@ include file = "../../modulos/include/main.jsp"%>
	
	<META HTTP-EQUIV="Refresh" CONTENT="1; URL=<%=request.getContextPath()%>/<tiles:insert attribute='url'/>&id=${id}">
                                                                         
</head>
<body>
	<div id="header"><tiles:insert name="header" /></div>
    <div id="fecha">Usuario:${session.paciente.nombres} ${session.paciente.apellidos}<script type="text/javascript" src="js/fechahoy.js"></script></div>	
    <div id="menu"><tiles:insert name="menu" /></div>
    <div id="content"><h1><br>Su operaci&oacute;n ha sido completada con &eacute;xito</h1>
		Espere un momento para ser redireccionado...<br/></div>
	<div id="footer"><tiles:insert name="footer" /></div>
</body>
</html>