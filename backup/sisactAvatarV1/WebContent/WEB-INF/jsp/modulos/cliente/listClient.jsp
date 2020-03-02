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
<script type="text/javascript" src="js/cliente/clienteBuscar.js"></script> 
<title></title>
</head>
<body>
<form name="formClienteBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id"/> 
<input type="hidden" name="idClient"/>  
<input type="hidden" name="valor" /> 

<h3 style="padding: 20px 20px 20px 50px;">Lista de Clientes</h3>

<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
</c:if>
		
<p align="LEFT">


<p align="LEFT">
<table class="detailTitle">
	<tr>
		<td colspan="4"><b><spring:message code="mod.persona.frama.buscar" /></b>
		</td>
	</tr>
</table>
<table class="searchLayout">
	<tr>
		<td><spring:message code="mod.persona.secc1.dni" /></td>
		<td><input type="text" id="t_dni" name="num_doc" ></td>
	</tr>
	<tr>
		<td>Nombre</td>
		<td><input type="text" id="t_dni" name="nombre" ></td>
	</tr>
	<tr>
		<td><input type="submit" value="<spring:message code="bot.buscar"/>" class="orange" id="btn_buscar"></td>
		<td><input type="button" value="<spring:message code="bot.limpiar"/>" class="orange" id="btn_limpiar"></td>
	</tr>
</table>

<table class="searchLayout">			
	<tr>
		<td align="right">
		<input type="button" style="width: 120px;padding:5px;" value="Agregar Cliente" class="orange"
			id="btn_nuevo"></td>
	</tr>
</table>	
<c:if test="${not empty lista}">
	<display:table name="lista" id="cliente" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="clientes.htm">
		<display:column title="ID CLIENTE" property="id" />
		<display:column title="NOMBRE" property="nombre" />
		<display:column title="TIPO DOC" property="tipoDocumentoDescripcion" />
		<display:column title="NUM DOC" property="num_doc" />
		<display:column title="CORREO" property="correo" />
		<display:column title="ESTADO" property="estadoDescripcion" />
		<%    /* lsoto: 05-07-19: Inclusión del campo de pre-evaluación patra mostrarlo en el listado de clientes: INICIO */%>
		<display:column title="PRE EVALUACIÓN" property="resultadoPre_evaluacion" />
		<%    /* lsoto: 05-07-19: Inclusión del campo de pre-evaluación patra mostrarlo en el listado de clientes: FIN */%>
		<display:column title="EDITAR">
			<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="${cliente.id}" onclick="doEdit(${cliente.id});"/>
		</display:column>
		<display:column title="LINEAS">
			<img id="img_lineas" style="cursor: pointer;" src="imagenes/portal/phone.png" title="Editar" alt="${cliente.id}" onclick="doVerLineas(${cliente.id});"/>
		</display:column>
		<display:column title="ELIMINAR">
			<img id="img_delete" style="cursor: pointer;" src="imagenes/portal/icoTash.gif" title="Eliminar" alt="${cliente.id}" onclick="doDelete(${cliente.id});"/>
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