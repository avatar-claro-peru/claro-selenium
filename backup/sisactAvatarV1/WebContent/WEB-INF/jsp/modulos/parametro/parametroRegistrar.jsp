<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="mod.tit.editar"/></title>
<script type="text/javascript" src="js/parametro/parametroEdit.js"></script>
</head>
<body>
<form  method="post" name="formParametroEdit">
<input type="hidden" name="metodo" />
<input type="hidden" name="id" value="${parametro.id}"/>
<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty parametro.id}">
		Crear Parametro
	</c:if>
	<c:if test="${not empty parametro.id}">
		Actualizar parametro
	</c:if>
	</h3>

	<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
	<p>&ensp;</p>
	</c:if>
	
	<c:if test="${!empty mensajeError}">
	<table class="titleMessageError">
		<tr>
			<td colspan="4"><b>${mensajeError}</b>
			</td>
		</tr>
	</table>
	</c:if>

	<table class="detailTitle" >
	<tr> 
		<td colspan="4">
		<b><spring:message code="mod.parametro.frame.principal"/></b>
		</td>
	</tr>
	</table>
	<table class="searchLayout">
		<tr> 
			<td id="t_codigoParm" style="text-align: right;">Codigo </td> 
			<td><input  id="t_codigoParm" type="text" name="codigo" value="${parametro.id}" maxlength="10" size="10" disabled="disabled"> </td> 
		</tr>
		<tr> 
			<td id="t_nombreParm" style="text-align: right;">Nombre </td> 
			<td><input type="text" id="t_nombreParm" name="nombre" value="${parametro.nombre}" maxlength="50" size="50"> </td> 
		</tr>
		<tr> 
			<td id="t_descripcionParm" style="text-align: right;">Descripcion </td> 
			<td><input type="text" id="t_nombreParm" name="descripcion" value="${parametro.descripcion}" maxlength="50" size="30"> </td> 
		</tr>
		<tr> 
			<td id="t_valorParm" style="text-align: right;">valor </td> 
			<td><input type="text" id="t_valorParm" name="valor" value="${parametro.valor}" maxlength="50" size="30"> </td> 
		</tr>
		<c:if test="${not empty parametro.id}">
		<tr> 
		<td id="t_valorParm" style="text-align: right;">Estado</td> 
		<td>
			<select id="cboEstadoParametro" name="estado">
						<option value="1" 
						<c:if test="${parametro.estado=='1'}">selected="selected"</c:if>
						>Activo</option>
						<option value="0" 
						<c:if test="${parametro.estado=='0'}">selected="selected"</c:if>
						>Inactivo</option>
					</select>
		</td> 
		</tr>
		</c:if>
	</table>
	<p align="center" style="width: 92%;">
		<c:if test="${empty parametro.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty parametro.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
	
</form>
</body>
</html>