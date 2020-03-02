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
			Detalle de la Orden
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
				<td width="140">ID Orden :</td>
				<td><span>${ordenes.id}</span></td>
			</tr>
	
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
	</table>
	
	<c:if test="${!empty ordenes.listaDetallesOrden}">
	<display:table name="ordenes.listaDetallesOrden" id="line" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="orden.htm">
		<display:column title="ID" property="id" />
		<display:column title="ESTADO ORDEN" property="descripcionEstadoPintcipal" />
		<display:column title="CÓDIGO MSSAP" property="codMssap" />
		<display:column title="CÓDIGO PVU" property="codPvu" />
		<display:column title="SERIE CHIP" property="serieChip" />
		<display:column title="SERIE EQUIPO" property="serieEquipo" />
		<display:column title="CÓDIGO OFICINA" property="codigoOficina" />
		<display:column title="CÓDIGO SOLICITUD" property="codigoSolicitud" />
		<display:column title="FECHA REGISTRO " property="fechaRegistro" format="{0,date,MM/dd/yyyy HH:mm:ss}" />
	</display:table>
	</c:if>
	<c:if test="${empty ordenes.listaDetallesOrden}">
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