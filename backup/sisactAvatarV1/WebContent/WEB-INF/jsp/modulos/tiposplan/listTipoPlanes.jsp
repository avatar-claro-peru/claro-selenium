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
<script type="text/javascript" src="js/tipoplan/tipoPlanListar.js"></script> 
<title></title>
</head>
<body>
<form name="formTopeConsumoListar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="idClient"/>  
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Tipos de Plan</h3>

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
		<td colspan="4"><b><spring:message code="mod.tipo.plan.frama.registrar" /></b>
		</td>
	</tr>
</table>

<table class="searchLayout">			
	<tr>
		<td align="right">
		<input type="button" style="width: 190px;padding:5px;" value="Agregar Tipo de Plan" class="orange"
			id="btn_nuevo"></td>
	</tr>
</table>

<c:if test="${not empty lista}">
	<display:table name="lista" id="tipoplan" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="tipoPlan.htm">
		
		<display:column title="ID" property="id" />
		<display:column title="CODIGO PLAN" property="codigoTipoPlan" />
		<display:column title="DESCRIPCIÓN DE PLAN" property="descripcionTipoPlan" />
		<display:column title="ESTADO DE PLAN" property="estadoTipoPlan" />
				
		<display:column title="EDITAR">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="${tipoplan.id}" onclick="doEdit(${tipoplan.id});"/>
		</display:column>
		
		<display:column title="ASOCIAR CON TOPES DE CONSUMO">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/phone.png" title="Editar" alt="${tipoplan.id}" onclick="doOpciones(${tipoplan.id});"/>
		</display:column>
		
		<display:column title="ELIMINAR">
			<img id="img_delete" style="cursor: pointer;" src="imagenes/portal/icoTash.gif" title="Eliminar" alt="${tipoplan.id}" onclick="doDelete(${tipoplan.id});"/>
		</display:column>
	</display:table>
</c:if>

<c:if test="${empty lista}">
	<p>&ensp;</p>
	<table class="searchLayout">
		<tr>
			<td colspan="4"><b>Aún no has registrado tipos de plan.</b>
			</td>
		</tr>
	</table>
</c:if>
</form>
</body>
</html>