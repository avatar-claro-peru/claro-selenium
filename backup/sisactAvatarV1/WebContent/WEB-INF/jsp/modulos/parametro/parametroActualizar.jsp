<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="mod.tit.editar"/></title>
<!-- <script type="text/javascript" src="js/parametro/parametroCampoEdit.js"></script> -->
</head>
<body>

<form  method="post" name="formParametroEdit" action="parametro.htm?metodo=doUpdate">
<input type="hidden" name="metodo" />
<input type="hidden" name="idCampo" value="${parametro.idCampo}"/>
<%-- <input type="hidden" name="idPadre" value="${parametro.idPadre}"/> --%>
<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
			Actualizar parámetro
<%-- 		<spring:message code="mod.parametro.tit.actualizarCampo"/>	 --%>
	</h3>


	<table class="detailTitle" >
	<tr> 
		<td colspan="4">
		<b><spring:message code="mod.parametro.frame.principal"/></b>
		</td>
	</tr>
	</table>
	<table class="searchLayout">
		<tr> 
			<td id="t_idPadreParm" style="text-align: right;">IdPadre : </td> 
			<td><input type="text" id="t_idPadreParm" name="idPadre" value="${parametro.idPadre}" maxlength="50" size="30" > </td> 
		</tr>
		<tr> 
			<td id="t_nombreParm" style="text-align: right;">Nombre : </td> 
			<td><input type="text" id="t_nombreParm" name="nombre" value="${parametro.nombre}" maxlength="50" size="30"> </td> 
		</tr>
	</table>
	<p align="center" style="width: 100%;">	
		<input type="submit" type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
<!-- 		<input type="button" value="Cancelar" class="orange"  id="btn_cancelar" >  -->
	</p>
	
</form>
</body>
</html>