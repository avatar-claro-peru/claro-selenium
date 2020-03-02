<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Procesar Orden</title>
<script type="text/javascript" src="js/ordenes/ordenBuscar.js"></script>
</head>
<body>


<form name="formOrdenBuscar" method="post">
<input type="hidden" name="metodo" />
<input type="hidden" name="valor" />
<%-- <input type="hidden" name="id" value="${ordenes.id}"/> --%>
<%String idPedido = String.valueOf(request.getAttribute("Estados")); %>
<%int contadorEstados = idPedido.length(); %>

<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
<%-- 		<c:if test="${empty ordenes.id }"> --%>
			
<%-- 		</c:if> --%>
<%-- 		<c:if test="${not empty ordenes.id}"> --%>
			Resultado Servicio
<%-- 		</c:if> --%>
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
			<td colspan="4"><b>Pedido: ${ordenes.idPedido}</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">	
	
			<tr>
				<td width="140">Numero de Pedido :</td>
				<td><span>${ordenes.idPedido}</span></td>
			</tr>
	
			<tr>
				<td width="140">Numero de documento :</td>
				<td><span>${ordenes.numeroDocumento}</span></td>
			</tr>
 	
 			<tr>
				<td width="140">Nombre :</td>
				<td><span>${ordenes.nombre}</span></td>
			</tr>
			
			<tr>
				<td width="140">Apellido Paterno :</td>
				<td><span>${ordenes.apellidoPaterno}</span></td>
			</tr>
			
			<tr>
				<td width="140">Apellido Materno :</td>
				<td><span>${ordenes.apellidoMaterno}</span></td>
			</tr>
			
			<tr>
				<td width="140">Numero de linea :</td>
				<td><span>${ordenes.numeroLinea}</span></td>
			</tr>
			
			<tr>
				<td width="140">Monto :</td>
				<td><span>${ordenes.monto}</span></td>
			</tr>
 				
	</table>
	
	<table class="detailTitle">
		<tr>
			<td colspan="3"><b>Respuesta Servicio:</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">
 			<tr> 
 				<td>Response:</td> 
				<td>
						<c:if test="${respuestaServicio.codigoRespuesta  == '-1'}"><span>Error Técnico</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '0'}"><span>Se actualizó la Orden</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '1'}"><span>Credenciales Incorrectas</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '2'}"><span>No existe el número de rden con estado C</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '3'}"><span>No Existe Orden con estado C y subestado GG</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '4'}"><span>No Existe Orden con estado C y subestado C V</span></c:if>
						<c:if test="${respuestaServicio.codigoRespuesta  == '5'}"><span>Id del Evento no Existe</span></c:if>
 				</td> 
	</tr> 			
	</table>
</form>
</body>
</html>