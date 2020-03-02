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
<script type="text/javascript" src="js/opcion/opcionBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formOpcionBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="nombre" /> 
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Opciones</h3>

<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
</c:if>
		
<p align="LEFT">
<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Opciones</b>
		</td>
	</tr>
</table>
<table class="searchLayout">			
	<tr>
		<td align="right">
		<input type="button" style="width: 120px;padding:5px;" value="Agregar Opcion" class="orange"
			id="btn_nuevo"></td>
	</tr>
</table>	
<c:if test="${not empty lista}">
	<display:table name="lista" id="opcion" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="opcion.htm">
		<display:column title="ID OPCION" property="id" />
		<display:column title="NOMBRE" property="nombre" />
		<display:column title="ESTADO" property="estadoDescripcion"  />
		<display:column title="DESCRIPCION" property="descripcion"  />
		<display:column title="EDITAR">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="${opcion.id}" onclick="doEdit(${opcion.id});"/>
		</display:column>
		<display:column title="ELIMINAR">
			<img id="img_delete" style="cursor: pointer;" src="imagenes/portal/icoTash.gif" title="Eliminar" alt="${opcion.id}" onclick="doDelete(${opcion.id});"/>
		</display:column>
	</display:table>
</c:if>

<c:if test="${empty lista}">
	<p>&ensp;</p>
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