<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springmodules.org/tags/commons-validator" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="apple-touch-icon" href="imagenes/portal/favicon.ico" />
<link rel="shortcut icon" href="imagenes/portal/favicon.ico" />
<script type="text/javascript" src="js/linea/linea.js"></script>
<title>List Line</title>
</head>
<body>
<form name="formLineRegister" id="saveLine" method="post">
	<input type="hidden" name="metodo" />  
	<input type="hidden" name="valor" /> 
	<input type="hidden" name="numberLineNew" value="123">
	<input type="hidden" name="idClient" value="${param.idClient}">
	
	<h3 style="padding: 20px 20px 20px 50px;">Nueva Linea</h3>

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
	
	<p align="LEFT">
	<table class="detailTitle">
		<tr>
			<td colspan="4"><b>Linea</b>
			</td>
		</tr>
	</table>
	<table class="searchLayout">			
	<tr>
		<td width="500">
			<table align="left">
				<tr>
					<td width="140">Número de Linea :</td>
					<%    /* lsoto: 03-07-19: Se reduce la cantidad de caracteres permitidos de 15 a 9 para el campo de número de línea : INCIO */%>
					<td><input type="text" name="numberLine" maxlength="9"></td>
					<%    /* lsoto: 03-07-19: Se reduce la cantidad de caracteres permitidos de 15 a 9 para el campo de número de línea : FIN */%>
				</tr>
				<tr>
					<td>Estado :</td>
					<td>   
							<select name="state">
							<option value="1">Activado</option>
							<option value="0">Bloqueado</option>
						</select>
					</td>
				</tr>
				<%    /* lsoto: 28-06-19: Inclusión del combo con los valores prepago y postpago : INCIO */%>
				<tr>
					<td width="130">Tipo de venta :</td>
					<td>
						<select name="selltype">
							<option value="P">Prepago</option>
							<option value="T">Postpago</option>
						</select>
					</td>
				</tr>				
				<%    /* lsoto: 28-06-19: Inclusión del combo con los valores prepago y postpago : FIN */%>
				<tr>
					<td width="130">Modalidad :</td>
					<td>
						<select name="modality">
							<option value="S">Renovable</option>
							<option value="N">No renovable</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Registrar" id="bt_registrar"></td>
				</tr>			
			</table>
		</td>
	</tr>
	</table>

	<h3 style="padding: 20px 20px 20px 50px;">Lista de Lineas</h3>

	<c:if test="${!empty lista}">
	<display:table name="lista" id="line" pagesize="50" defaultsort="2"
		class="searchLayout" style="padding: 10px;" requestURI="lines.htm">
		<display:column title="ID LINEA" property="id" />
		<display:column title="NUMERO DE LINEA" property="numberLine" />
		<display:column title="ID_CLIENTE" property="idClient" />
		<display:column title="FECHA DE REGISTRO" property="dateRegister" format="{0,date,MM/dd/yyyy HH:mm:ss}" /> 
		<display:column title="FECHA DE ACTUALIZACION" property="dateUpdate" format="{0,date,MM/dd/yyyy HH:mm:ss}" />
		<display:column title="ESTADO" property="estadoDescripcion" />
		<%    /* lsoto: 28-06-19: Inclusión del campo de tipo de venta en el listado de líneas : INICIO */%>
		<display:column title="TIPO DE VENTA" property="tipoVenta" />
		<%    /* lsoto: 28-06-19: Inclusión del campo de tipo de venta en el listado de líneas : FIN */%>
		<display:column title="MODALIDAD" property="estadoRenovacion" />
		<display:column title="MENSAJES">
			<a href="sms.htm?metodo=doListarByLineaId&idLinea=${line.id}">
				<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/sms-icon.png" title="Msg" alt="" />
			</a>
		</display:column>
		<display:column title="EDITAR">
			<a href="lines.htm?metodo=doEditView&numberLine=${line.numberLine}&idClient=${line.idClient}">
				<img id="img_editar" style="cursor: pointer;" src="imagenes/portal/icoEdit.gif" title="Editar" alt="" />
			</a>
		</display:column>
		<display:column title="ELIMINAR">
			<a href="lines.htm?metodo=doDelete&numberLine=${line.numberLine}&idClient=${line.idClient}">
			<img id="img_delete" style="cursor: pointer;" src="imagenes/portal/icoTash.gif" title="Eliminar" alt="" />
			</a>
		</display:column>
	</display:table>
</c:if>
<c:if test="${empty lista}">
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