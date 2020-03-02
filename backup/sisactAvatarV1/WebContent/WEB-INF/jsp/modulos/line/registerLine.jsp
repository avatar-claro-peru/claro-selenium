<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar nueva linea</title>
</head>
<body>
		
		<div class="content-registerCliente">
		
		<div class="title-form">
			Nueva Linea
		</div>
		
			<form action="lines.htm?metodo=doSave" id="saveLine" method="post">
			
			<input type="hidden" name="idClient" value="${param.id_cliente}">
			
			<div class="inputs">
				<label>N�mero de Linea : </label><br>
				<input type="text" name="numberLine" maxlength="9">
			</div>
			<div class="inputs">
				<label>Estado : </label><br>
				
				<select name="state">
					<option value="1">Activado</option>
					<option value="0">Bloqueado</option>
				</select>
			</div>
			
			<div class="button-register">
				<input type="submit" value="Registrar">
			</div>
			
			</form>
		</div>

</body>
</html>