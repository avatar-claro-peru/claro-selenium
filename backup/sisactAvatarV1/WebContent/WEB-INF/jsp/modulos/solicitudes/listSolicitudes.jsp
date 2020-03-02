<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="apple-touch-icon" href="imagenes/portal/favicon.ico" />
<link rel="shortcut icon" href="imagenes/portal/favicon.ico" />
<script type="text/javascript" src="js/solicitud/solicitudBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formSolicitudBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="idClient"/>  
<input type="hidden" name="valor" /> 
<input type="hidden" name="cliente" value="" > 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Solicitudes</h3>

<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
</c:if>
		
<p align="LEFT">


<p align="LEFT">
<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Buscar Solicitud</b>
		</td>
	</tr>
</table>
<table class="searchLayout">
	<tr>
		<td>DNI del cliente</td>
		<td>
		<input type="text" name="cliente.num_doc" value="" id="txtClienteDniId"> 
		</td>
	</tr>
	<tr>
		<td>Nro de celular del cliente</td>
		<td>
		<input type="text" name="telefono" value="" id="txtTelefonoId"> 
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="bot.buscar"/>" class="orange" id="btn_buscar"></td>
		<td><input type="button" value="<spring:message code="bot.limpiar"/>" class="orange" id="btn_limpiar"></td>
	</tr>
</table>
	
<c:if test="${not empty lista}">
	<display:table name="lista" id="solicitud" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="solicitud.htm">
		<display:column title="ID SOLICITUD" property="id" />	
		<display:column title="NOMBRE" property="cliente.nombre" />
		<display:column title="NRO DOC" property="cliente.num_doc" />
		<display:column title="TELEFONO" property="telefono" />
		<display:column title="TOKEN" property="token" />
		<display:column title="CODIGO SMS" property="codigoSMS" />
		<display:column title="ESTADO" property="estado" />	
		<display:column title="INTENTOS FALLIDOS" property="intentosFallidos" />
	</display:table>
</c:if>

<c:if test="${empty lista}">
	<p>&ensp;</p>
	<table class="searchLayout">
		<tr>
			<td colspan="4"><b>No hay registros.</b>
			</td>
		</tr>
	</table>
</c:if>
</form>
</body>
</html>