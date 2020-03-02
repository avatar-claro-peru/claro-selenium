<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="apple-touch-icon" href="imagenes/portal/favicon.ico" />
<link rel="shortcut icon" href="imagenes/portal/favicon.ico" />
<title>SISACT AVATAR</title>
<%@ include file = "../../modulos/include/main.jsp"%>
</head>
<body>
	<div id="header"><tiles:insert name="header" /></div>
		
	<div id="fecha">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<authz:authentication operation="perfilUsuario" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Nombre : 
	<authz:authentication operation="nameCompleto" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Fecha:<script type="text/javascript" src="js/fechahoy.js"></script>
	<div class="user_logout">
   	 <a href="<c:url value="/logout.jsp"/>">Salir</a>
    </div>
    </div>

<div id="menu"><tiles:insert name="menu" /></div>
<div id="content"><tiles:insert name="content" /></div>
<div id="footer"><tiles:insert name="footer" /></div>

</body>
</html>
