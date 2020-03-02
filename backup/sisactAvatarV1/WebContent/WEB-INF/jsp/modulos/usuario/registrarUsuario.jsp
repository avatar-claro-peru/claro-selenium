<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="mod.tit.editar"/></title>
<script type="text/javascript" src="js/usuario/usuarioEdit.js"></script>
</head>
<body>
<form  method="post" name="formUsuarioEdit">
<input type="hidden" name="metodo" />
<input type="hidden" name="id" value="${usuario.id}"/>
<c:if test="${not empty usuario.id}">
<input type="hidden" name="username" value="${usuario.username}"/>
</c:if>
<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty usuario.id}">
		Crear Usuario
	</c:if>
	<c:if test="${not empty usuario.id}">
		Actualizar Usuario
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
	<p>&ensp;</p>
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
			<td id="t_codigoParm" style="text-align: right;">ID </td> 
			<td><input  id="t_codigoParm" type="text" name="id" value="${usuario.id}" maxlength="10" size="10" 
			disabled="disabled"
			> </td> 
		</tr>
		<tr> 
			<td id="t_loginParm" style="text-align: right;">Login </td> 
			<td><input type="text" id="t_loginParm" name="username" value="${usuario.username}" maxlength="50" size="30"
			<c:if test="${not empty usuario.id}">disabled="disabled"</c:if>
			> </td> 
		</tr>
		<tr> 
			<td id="t_passParm" style="text-align: right;">Password </td> 
			<td><input type="password" id="t_passParm" name="password" value="" maxlength="50" size="30"> </td> 
		</tr>		
		<tr> 
			<td id="t_passconfirParm" style="text-align: right;">Confirmar Password </td> 
			<td><input type="password" id="t_passConfirParm" name="password2" value="" maxlength="50" size="30"> </td> 
		</tr>
		<tr> 
			<td id="t_valorParm" style="text-align: right;">Estado</td> 
			<td>
				<select id="cboEstadoParametro" name="estado">
					<option value="1" <c:if test="${usuario.estado=='1'}">selected="selected"</c:if>>Activo</option>
					<option value="0" <c:if test="${usuario.estado=='0'}">selected="selected"</c:if>>Inactivo</option>
				</select>
			</td> 
		</tr>
	</table>
	<p align="center" style="width: 92%;">
		<c:if test="${empty usuario.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty usuario.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
	
</form>
</body>
</html>