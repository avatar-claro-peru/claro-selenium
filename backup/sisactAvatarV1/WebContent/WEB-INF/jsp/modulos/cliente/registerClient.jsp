<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Client</title>
<script type="text/javascript" src="js/cliente/clienteEdit.js"></script>
</head>
<body>

<form name="formClienteEdit" method="post">
<input type="hidden" name="metodo" />  
<input type="hidden" name="valor" /> 
<input type="hidden" name="id" value="${cliente.id}"/>
<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty cliente.id}">
		Crear Cliente
	</c:if>
	<c:if test="${not empty cliente.id}">
		Actualizar Cliente
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
			<td colspan="4"><b>Cliente</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">			
			<tr>
				<td width="140">Nombre :</td>
				<td><input type="text" name="nombre" value="${cliente.nombre}" ></td>
			</tr>
			<tr>
				<td>Tipo de documento :</td>
				<td>   
				<%--//lsoto: 07-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: INICIO--%>
					<!-- INICIO - MLL -->
					<input type="radio" id="rbn_dni" <c:if test="${cliente.tipo_doc eq '2'}">checked="checked"</c:if> name="tipo_doc" onclick="getRadioVal(this.value);" value="2"> DNI<br>
	  				<input type="radio" id="rbn_ce" <c:if test="${cliente.tipo_doc eq '3'}">checked="checked"</c:if> name="tipo_doc" onclick="getRadioVal(this.value);" value="3"> CE<br>
	  				<input type="radio" id="rbn_ruc" <c:if test="${cliente.tipo_doc eq '4'}">checked="checked"</c:if> name="tipo_doc" onclick="getRadioVal(this.value);" value="4"> RUC<br>
	  				<input type="radio" id="rbn_pasaporte" <c:if test="${cliente.tipo_doc eq '7'}">checked="checked"</c:if> name="tipo_doc" onclick="getRadioVal(this.value);" value="7"> Pasaporte<br>
	  				<!-- FIN - MLL -->
				<%--//lsoto: 07-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: FIN--%>
				</td>
			</tr>
			<tr>
				<td width="130">Numero de documento :</td>
				<td><input type="text" id="textbox_num_doc" name="num_doc" value="${cliente.num_doc}" maxlength="16"></td>
			</tr>
			<tr>
				<td width="130">Correo :</td>
				<td><input type="text" name="correo" value="${cliente.correo}"></td>
			</tr>
			<tr>
				<td width="130">Estado :</td>
				<td>
					<select name="estado">
						<option value="1" <c:if test="${cliente.estado == '1'}">selected="selected"</c:if>>Activado</option>
						<option value="0" <c:if test="${cliente.estado == '0'}">selected="selected"</c:if>>Bloqueado</option>
					</select>
				</td>
			</tr>	
			<%-- lsoto: 04-07-19: Agregar el campo para el servicio de pre-evaluación: INICIO --%>
			<tr>
				<td width="150">Resultado pre-evaluación :</td>
				<td>
				<!-- INICIO - MLL -->
					<select name="pre_evaluacion">
						<option id="id_ErrorServicio" value="1" <c:if test="${cliente.pre_evaluacion == '1'}">selected="selected"</c:if>>Error en servicio de Pre-evaluación (1)</option>
						<option id="id_PreEva_Exitosa" value="2" <c:if test="${cliente.pre_evaluacion == '2'}">selected="selected"</c:if>>Pre-evaluación exitosa (2)</option>
						<option id="id_PreEva_RecXDeuda" value="3" <c:if test="${cliente.pre_evaluacion == '3'}">selected="selected"</c:if>>Pre-evaluación rechazada por deuda (3)</option>
						<option id="id_PreEva_RecXOtros" value="4" <c:if test="${cliente.pre_evaluacion == '4'}">selected="selected"</c:if>>Pre-evaluación rechazada por otros motivos (4)</option>
					</select>
				<!-- FIN - MLL -->
				</td>
			</tr>	
			<%-- lsoto: 04-07-19: Agregar el campo para el servicio de pre-evaluación: FIN --%>
					
	</table>
	<p align="center" style="width: 92%;">
		<c:if test="${empty cliente.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty cliente.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
</form>
</body>
</html>