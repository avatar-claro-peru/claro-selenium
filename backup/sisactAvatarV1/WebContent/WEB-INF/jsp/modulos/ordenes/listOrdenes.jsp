
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
<script type="text/javascript" src="js/ordenes/ordenBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formOrdenBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="idClient"/>  
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Ordenes</h3>

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
		<td colspan="4"><b><spring:message code="mod.evaluacion.frama.buscar" /></b>
		</td>
	</tr>
</table>
<table class="searchLayout">
	<tr>
		<td>Indentificador Orden</td>
		<td><input type="text" id="t_dni" name="idPedido" ></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="bot.buscar"/>" class="orange" id="btn_buscar"></td>
		<td><input type="button" value="<spring:message code="bot.limpiar"/>" class="orange" id="btn_limpiar"></td>
	</tr>
</table>
	
<c:if test="${not empty lista}">
	<display:table name="lista" id="orden" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="evaluacion.htm">
		<display:column title="NRO ORDEN" property="idPedido" />
		<display:column title="MONTO" property="monto" />
		<display:column title="NUMERO LINEA" property="numeroLinea" />
		<display:column title="DOCUMENTO" property="numeroDocumento" />
		
		<%-- lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - INICIO --%>
		<display:column title="DETALLE DE ORDEN">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Ver Detalle" alt="${orden.id}" onclick="doListarDetalle(${orden.id});"/>
		</display:column>
		<%-- lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - FIN --%>
		
		<display:column title="EDITAR">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="${orden.id}" onclick="doEdit(${orden.id});"/>
		</display:column>
		
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