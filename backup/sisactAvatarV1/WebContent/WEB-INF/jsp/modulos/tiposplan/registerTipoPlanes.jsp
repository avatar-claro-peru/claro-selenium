<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Tipo de Plan</title>
<script type="text/javascript" src="js/tipoplan/tipoPlanEdit.js"></script>
</head>
<body>

<form name="formTipoPlanEdit" method="post">
<input type="hidden" name="metodo" />  
<input type="hidden" name="valor" /> 
<input type="hidden" name="id" value="${tipoPlan.id}"/>
<input type="hidden" id="servDesc"  name="servDesc"/>

<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty tipoPlan.id}">
		Crear Tipo de Plan
	</c:if>
	<c:if test="${not empty tipoPlan.id}">
		Actualizar Tipo de Plan
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
			<td colspan="4"><b>Tipo de Plan</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">	
	
			<tr>
				<td width="140">Código de tipo de plan :</td>
				<td><input type="text" name="codigoTipoPlan" value="${tipoPlan.codigoTipoPlan}" ></td>
			</tr>
			
			<tr>
				<td width="140">Descripción de tipo de plan :</td>
				<td><input type="text" name="descripcionTipoPlan" value="${tipoPlan.descripcionTipoPlan}" ></td>
			</tr>
			
			<tr>
				<td width="140">Estado :</td>
				<td>
					<select id="tipoPlanEstado" name="tipoPlanEstado">
						<option value="1" <c:if test="${tipoPlan.tipoPlanEstado == '1'}">selected="selected"</c:if>>Activo</option>
						<option value="0" <c:if test="${tipoPlan.tipoPlanEstado == '0'}">selected="selected"</c:if>>Inactivo</option>
					</select>
				</td>
			</tr>

	</table>


	<p align="center" style="width: 92%;">
		<c:if test="${empty tipoPlan.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty tipoPlan.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
</form>
</body>
</html>