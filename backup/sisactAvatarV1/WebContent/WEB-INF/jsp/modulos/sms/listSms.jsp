<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3 style="padding: 20px 20px 20px 50px;">Listado de Sms</h3>

<p align="LEFT">
<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Mensajes</b>
		</td>
	</tr>
</table>
<c:if test="${not empty lista}">
<display:table name="lista" id="sms" pagesize="10" defaultsort="5" defaultorder="descending"
	class="searchLayout" style="padding: 10px;" requestURI="sms.htm">
	<display:column title="Id" property="id" />
	<display:column title="Número de linea" property="idLinea" />
	<display:column title="Fecha de registro" property="dateRegister" />
	<display:column title="Codigo Sms" property="codeSms" />
	<display:column title="Estado" property="state" />
	<display:column title="Eliminar">
		<a href="sms.htm?metodo=doDelete&id=${sms.id}"><img id="img_delete" style="cursor: pointer;" src="imagenes/admin/icoTash.gif" title="Eliminar" /></a>
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

</body>
</html>