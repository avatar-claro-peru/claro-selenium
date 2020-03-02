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
<script type="text/javascript" src="js/perfil/perfilBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formUsuarioBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id" value="${perfil.id}"/>  
<input type="hidden" name="nombre" /> 
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Opciones</h3>		
<p align="LEFT">

<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Opciones asociados</b>
		</td>
	</tr>
</table>

<table class="searchLayout">
	<tr> 
		<td id="t_valorParm">Seleccionar</td>  
	</tr>
	<c:forEach items="${listOpciones}" var="opcion">
		<c:set var="existe" value="false"/>
		<c:forEach items="${listOpcionesAsignados}" var="opcionAsignado">
			<c:if test="${opcion.nombre eq opcionAsignado.nombre }">
				<c:set var="existe" value="true"/>				
			</c:if>
		</c:forEach>
		<tr> 
			<td>
				<input type="checkbox" name="idOpcion" value="${opcion.id}" 
				<c:if test="${existe}">
				checked="checked"
				</c:if>
				 >${opcion.nombre}
			</td>
		</tr>
	</c:forEach>
	<tr> 
		<td>
		<input type="button" style="width: 120px;padding:5px;" value="Marcar Todo" onclick='selectAll()' /> 
		<input type="button" style="width: 120px;padding:5px;" value="Desmarcar Todo" onclick='UnSelectAll()' />
		<input type="button" style="width: 120px;padding:5px;" value="Actualizar Opciones" class="orange"	id="btn_actualizarOpciones">
		</td>
	</tr>
</table>	

</form>
</body>
</html>