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
	<div id="content"><h1><br>Su operaci&oacute;n ha sido completada con &eacute;xito</h1>
		Espere un momento...<br/></div>
</body>
</html>