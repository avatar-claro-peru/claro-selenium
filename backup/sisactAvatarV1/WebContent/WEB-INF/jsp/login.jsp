<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springmodules.org/tags/commons-validator" prefix="html" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SISACT-AVATAR</title>
<link type="text/css" href="styles/structure.css" rel="stylesheet" />
<link type="text/css" href="styles/menu.css" rel="stylesheet" />
<link type="text/css" href="styles/content.css" rel="stylesheet" />
<link rel="apple-touch-icon" href="imagenes/portal/favicon.ico" />
<link rel="shortcut icon" href="imagenes/portal/favicon.ico" />
  
<style type="text/css">
<!--
.Estilo1 {font-family: Arial, Helvetica, sans-serif}
-->
</style>
</head>
<body>
<div id="header"><br>
<H2>
<Center>SisAct Avatar</Center>
</H2>
</div>
<div id="fecha"><script type="text/javascript"
	src="js/fechahoy.js"></script></div>
<br>
<br>
<br>
<form action="j_acegi_security_check" name="form" method="post">
<input type="hidden" name="metodo">
<table border="0" align="center" width="80%">	
	<tr>
		<td width="373">
		<table width="80%" height="120" align="right" bgcolor="#FFE8E8" bordercolor="#FF9B9B">
			<tr>
				<td align="right">Usuario:</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td align="right">Contraseña:</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					name="login" value="Ingresar" align="center" class="orange"
					size="20" /></td>
				<!--  	<td align="left"><input type="button" name="login" value="  Cancelar  " class="orange" size="20" /> </td> 		-->
			</tr>
			<%
			if (request.getParameter("login_error") != null) {
			%>
			<tr>
				<td>
				<div style="color: red;">* Username y/o Password invalidos.</div>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		</td>
	</tr>
</table>
</form>
<br>
<br>
</body>
</html>
