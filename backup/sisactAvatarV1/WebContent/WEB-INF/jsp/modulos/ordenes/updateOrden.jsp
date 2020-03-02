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
<input type="hidden" name="detalleOrden" />
<input type="hidden" name="detalleOrden.ordenId" value="${ordenes.id}" />
<input type="hidden" name="id" value="${ordenes.id}"/>
<%String idPedido = String.valueOf(request.getAttribute("Estados")); %>
<%int contadorEstados = idPedido.length(); %>

<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
		<c:if test="${empty ordenes.id }">
			Crear Orden
		</c:if>
		<c:if test="${not empty ordenes.id}">
			Procesar Orden
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
			<td colspan="4"><b>Pedido: ${ordenes.idPedido}</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">	
	
			<tr>
				<td width="140">Numero de Pedido :</td>
				<td><span>${ordenes.idPedido}</span></td>
				<input type="hidden" name="idPedido" value="${ordenes.idPedido}">
			</tr>
	
			<tr>
				<td width="140">Numero de documento :</td>
				<td><span>${ordenes.numeroDocumento}</span></td>
				<input type="hidden" name="numeroDocumento" value="${ordenes.numeroDocumento}">
			</tr>
 	
 			<tr>
				<td width="140">Nombre :</td>
				<td><span>${ordenes.nombre}</span></td>
				<input type="hidden" name="nombre" value="${ordenes.nombre}">
			</tr>
			
			<tr>
				<td width="140">Apellido Paterno :</td>
				<td><span>${ordenes.apellidoPaterno}</span></td>
				<input type="hidden" name="apellidoPaterno" value="${ordenes.apellidoPaterno}">
			</tr>
			
			<tr>
				<td width="140">Apellido Materno :</td>
				<td><span>${ordenes.apellidoMaterno}</span></td>
				<input type="hidden" name="apellidoMaterno" value="${ordenes.apellidoMaterno}">
			</tr>
			
			<tr>
				<td width="140">Numero de linea :</td>
				<td><span>${ordenes.numeroLinea}</span></td>
				<input type="hidden" name="numeroLinea" value="${ordenes.numeroLinea}" >
			</tr>
			
			<tr>
				<td width="140">Monto :</td>
				<td><span>${ordenes.monto}</span></td>
				<input type="hidden" name="monto" value="${ordenes.monto}">
			</tr>
			
			<tr>
				<td width="140">C&oacute;digo Tope Consumo :</td>
				<td><span>${ordenes.codigoTopeConsumo}</span></td>
			</tr>
 				
	</table>
	
	<table class="detailTitle">
		<tr>
			<td colspan="3"><b>Historial Estados (Ultimos 9 estados):</b>			
			</td>
		</tr>
	</table>
	<table class="searchLayout">
		<tr>
			<td>
			<%for(int i= 0; i<contadorEstados;i++){ 
				 String estadoChar = String.valueOf(idPedido.charAt(i)) ;%>
				 <lu>
				 <%if(estadoChar.equals("1")){%>
					 <li>Venta correcta</li>
				 <% }if(estadoChar.equals("2")){%>
					 <li>Venta tiene errores</li>
				 <% }if(estadoChar.equals("3")){%>
					 <li>se cancelo Venta</li>	 	 
				 <% }if(estadoChar.equals("4")){%>
					 <li>Pago Exitoso</li>	 
					<%}%>
				</lu>
				<%
			} %>
			</td>
		</tr>
		
	</table>
	
	<table class="detailTitle">
		<tr>
			<td colspan="3"><b>Actualizar Estado:</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">
 		<tr> 
 			<td>Estado:</td> 
			<td>
			<%--lsoto: 21-10-19: Inclusión de los campos que se reciben al consumir el servicio SyncOrder: INICIO--%>
				<select name="detalleOrden.estadoPrinc" onchange="showAdditionalFields(this.value);" > 
					<option value="1" <c:if test="${detalleOrden.estadoPrinc  == '1'}">selected="selected"</c:if>>[Código 1] Notificar que la venta esta correcta</option> 
					<option value="2" <c:if test="${detalleOrden.estadoPrinc  == '2'}">selected="selected"</c:if>>[Código 2] Notificar que la venta tiene errores</option> 
					<option value="3" <c:if test="${detalleOrden.estadoPrinc  == '3'}">selected="selected"</c:if>>[Código 3] Notificar que se ha cancelado la venta</option> 
					<option value="4" <c:if test="${detalleOrden.estadoPrinc  == '4'}">selected="selected"</c:if>>[Código 4] Notificar que se realizó el pago con éxito</option>
					<option value="5" <c:if test="${detalleOrden.estadoPrinc  == '5'}">selected="selected"</c:if>>[Código 5] Id evento no definido</option> 
				</select>
			<%--lsoto: 21-10-19: Inclusión de los campos que se reciben al consumir el servicio SyncOrder: FIN--%>
 			</td> 
		</tr>
		<%--lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO--%>
		<tr>
			<td>Código MSSAP:</td><td><input type="text" id="codMssap" name="detalleOrden.codMssap" value=""></td>
		</tr>			
		
		<tr>
			<td>Código PVU:</td><td><input type="text" id="codPvu"  name="detalleOrden.codPvu" value=""></td>
		</tr>
		
		<tr>
			<td>Serie Chip:</td><td><input type="text" id="serieChip"  name="detalleOrden.serieChip" value=""></td>
		</tr>
		
		<tr>
			<td>Serie Equipo:</td><td><input type="text" id="serieEquipo"  name="detalleOrden.serieEquipo" value=""></td>
		</tr>
		
		<tr>
			<td>Código Oficina:</td><td><input type="text" id="codigoOficina"  name="detalleOrden.codigoOficina" value=""></td>
		</tr>
		
		<tr>
			<td>Código Solicitud:</td><td><input type="text" id="codigoSolicitud"  name="detalleOrden.codigoSolicitud" value=""></td>
		</tr>
		<%--lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN--%>
			
	</table>
	<p align="center" style="width: 92%;">
		<c:if test="${empty ordenes.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty ordenes.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
</form>
</body>
</html>