<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Tope de Consumo</title>
<script type="text/javascript" src="js/topeconsumo/topeConsumoEdit.js"></script>
</head>
<body>

<form name="formTopeConsumoEdit" method="post">
<input type="hidden" name="metodo" />  
<input type="hidden" name="valor" /> 
<input type="hidden" name="id" value="${topeConsumo.id}"/>

<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty topeConsumo.id}">
		Crear Tope de Consumo
	</c:if>
	<c:if test="${not empty topeConsumo.id}">
		Actualizar Tope de Consumo
	</c:if>
	</h3>

	<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
	</c:if>
	<c:if test="${!empty mensajeError}">
	<table class="titleMessageError">
		<tr>
			<td colspan="4"><b>${mensajeError}</b>
			</td>
		</tr>
	</table>
	</c:if>	
	<table class="detailTitle">
		<tr>
			<td colspan="4"><b>Tope de Consumo</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">			
			
			<tr>
				<td width="140">Estado del tope de consumo:</td>
				<td>
					<select id="topeEstado" name="topeEstado">
						<option value="3" <c:if test="${topeConsumo.topeEstado == '3'}">selected="selected"</c:if>>Tope de consumo por defecto</option>
						<option value="1" <c:if test="${topeConsumo.topeEstado == '1'}">selected="selected"</c:if>>Tope de consumo seleccionable</option>
						<option value="2" <c:if test="${topeConsumo.topeEstado == '2'}">selected="selected"</c:if>>Otro</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td width="140">Código del tope de consumo :</td>
				<td><input type="text" name="servCodigo" value="${topeConsumo.servCodigo}" /></td>
			</tr>
			
			<tr>
				<td width="140">Descripción del tope de consumo :</td>
				<td><input type="text" name="servDesc" value="${topeConsumo.servDesc}"/></td>
			</tr>
			
			<tr>
				<td width="140">Planes asociados :</td>
				<td>${topeConsumo.planesAsociados}</td>
			</tr>
	
	</table>


	<p align="center" style="width: 92%;">
		<c:if test="${empty topeConsumo.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty topeConsumo.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
</form>
</body>
</html>