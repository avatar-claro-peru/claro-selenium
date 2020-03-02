<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="mod.tit.buscar" /></title>
<script type="text/javascript" src="js/parametro/parametroBuscar.js">

</script>
</head>
<body>
<form name="formParametroBuscar" method="post">
<input type="hidden" name="metodo" /> 
<input type="hidden" name="id" value="${parametro.id}" />  
<input type="hidden" name="nombre" /> 
<input type="hidden" name="valor" /> 
<br> 

<h3 style="padding: 20px 20px 20px 50px;">Mantenimiendo de parametro</h3>

<c:if test="${!empty mensajeExito}">
	<table class="titleMessage">
		<tr>
			<td colspan="4"><b>${mensajeExito}</b>
			</td>
		</tr>
	</table>
<p>&ensp;</p>
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
		<input type="button" style="width: 120px;padding:5px;" value="Agregar" class="orange"
			id="btn_crear"></td>
	</tr>
</table>
<c:if test="${not empty lista}">
<display:table name="lista" id="parametro" pagesize="50" 
	class="searchLayout" style="padding: 10px;" requestURI="parametro.htm">
	<display:column title="ID" property="id" />
	
	<display:column title="EDITAR">
		<img id="img_editar" style="cursor: pointer;" src="imagenes/admin/icoEdit.gif" title="Editar" alt="${parametro.id}" onclick="doEdit(this);"/>
	</display:column>
	
	<display:column title="NOMBRE CAMPO" property="nombre" />
	<display:column title="VALOR CAMPO" property="valor" />
	<display:column title="DESCRIPCION" property="descripcion" />
	<display:column title="ESTADO" property="estadoDescripcion" />


	<display:column title="ELIMINAR">
		<img id="img_delete" style="cursor: pointer;" src="imagenes/admin/icoTash.gif" title="Eliminar" alt="${parametro.id}" onclick="doDelete(this);"/>
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