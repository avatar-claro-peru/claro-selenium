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

<form name="formUsuarioBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id" value="${tipoPlan.id}"/>  
<input type="hidden" name="nombre" /> 
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Topes de consumo</h3>		
<p align="LEFT">

<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Detalles del tipo de plan</b>
		</td>
	</tr>
</table>

<table class="searchLayout">
	<tr>
		<td width="140">ID :</td>
		<td>${tipoPlanSeleccionado.id}</td>
	</tr>
	
	<tr>
		<td width="140">Código :</td>
		<td><u><strong>${tipoPlanSeleccionado.codigoTipoPlan}</strong></td></u>
	</tr>
		
	<tr>
		<td width="140">Estado :</td>
		<td>${tipoPlanSeleccionado.estadoTipoPlan}</td>
	</tr>
		
	<tr>
		<td width="140">Descripción :</td>
		<td>${tipoPlanSeleccionado.descripcionTipoPlan}</td>
	</tr>
</table>


<c:if test="${not empty listTopesConsumo}">
	<table class="detailTitle">
		<tr>
			<td colspan="4"><b>Topes de consumo asociados (Los topes de consumo asociados al tipo de plan muestran el check marcado)</b>
			</td>
		</tr>
	</table>
	
	<table class="searchLayout">
	
		
			<tr> 
				<td id="t_valorParm">Seleccionar</td>  
			</tr>
	
			<c:forEach items="${listTopesConsumo}" var="topeConsumo">
				<c:set var="existe" value="false"/>
				<c:forEach items="${listTopesCoonsumoAsignados}" var="topeConsumoAsignado">
					<c:if test="${topeConsumo.id eq topeConsumoAsignado.id }">
						<c:set var="existe" value="true"/>				
					</c:if>
				</c:forEach>
				<tr> 
					<td>
						<input type="checkbox" name="idTopeConsumo" value="${topeConsumo.id}"
							<c:if test="${existe}">
								checked="checked"
							</c:if>
					 	>${topeConsumo.servCodigo} ${topeConsumo.servDesc}
					</td>
				</tr>
			</c:forEach>
			
			<tr> 
				<td>
					<input type="button" style="width: 150px;padding:5px;" value="Actualizar Opciones" class="orange"	id="btn_actualizarOpciones">
				</td>
			</tr>
	
	
	
	</table>	
</c:if>

<c:if test="${empty listTopesConsumo}">

	<table class="detailTitle">
		<tr>
			<td colspan="4"><b>Topes de consumo asociados</b>
			</td>
		</tr>
	</table>
	
	<table class="searchLayout">
		<tr>
			<td colspan="4"><b>No se han registrado topes de consumo. Registre topes de consumo para asociar al tipo de plan.</b></td>
		</tr>
		
		<tr> 
			<td>
				<input type="button" style="width: 150px;padding:5px;" value="Actualizar Opciones" class="orange" id="btn_actualizarOpciones" disabled="disabled">
			</td>
		</tr>
	</table>
</c:if>

</form>
</body>
</html>