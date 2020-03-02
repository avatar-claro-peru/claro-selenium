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
<script type="text/javascript" src="js/evaluacion/evaluacionBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formEvaluacionBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="idClient"/>  
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Evaluaciones</h3>

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
		<td><input type="text" id="t_dni" name="ordenId" ></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="bot.buscar"/>" class="orange" id="btn_buscar"></td>
		<td><input type="button" value="<spring:message code="bot.limpiar"/>" class="orange" id="btn_limpiar"></td>
	</tr>
</table>
	
<c:if test="${not empty lista}">
	<display:table name="lista" id="evaluacion" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="evaluacion.htm">
		<display:column title="ID EVALUACION" property="id" />	
		<display:column title="ORDEN ID" property="ordenId" />
<!-- 	lsoto: 08-09-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO -->
		<display:column title="MODALIDAD DE VENTA" property="modalidadVentaNombre" />
<!-- 	lsoto: 08-09-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN -->
<!-- 	lsoto: 09-09-19: Cambio del modo como se visualiza el estado de la evaluación de número a texto: INICIO -->
		<display:column title="ESTADO" property="estadoDescripcion" />
<!-- 	lsoto: 09-09-19: Cambio del modo como se visualiza el estado de la evaluación de número a texto: FIN -->
		<display:column title="SECUENCIA" property="secuencia" />	
		<display:column title="TIPO DE VENTA" property="nombreTipoVenta" />
		<display:column title="EDITAR">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="${evaluacion.id}" onclick="doEdit(${evaluacion.id});"/>
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