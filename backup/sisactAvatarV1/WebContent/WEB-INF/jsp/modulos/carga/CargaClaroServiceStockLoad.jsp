<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Método CheckProcessStatus</title>
</head>
<body>
<h3 style="padding: 20px 20px 20px 50px;">Servicio Web Claro Service Stock Load</h3>
<p align="LEFT">
<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Método CheckProcessStatus</b>
		</td>
	</tr>
</table>

<form action="cargasClaroServiceStockLoad.htm?metodo=doCheckProcessStatus" id="CheckProcessStatus" method="post">
<table class="searchLayout">
	<tr>
		<td width="140">userId:</td>
		<td> <input type="text" name="userId"></td>
		
	</tr>
	<tr>
		<td >Password: </td>
		<td><input type="text" name="password"></td>
		
	</tr>	
	<tr>
			<td colspan="2"><input type="submit" value="CheckProcessStatus"></td>		
	</tr>
</table>
</form>
</br>
<table class="detailTitle">
	<tr>
		<td colspan="4"><b>Método ExecuteStockProcess</b>
		</td>
	</tr>
</table>

<form action="cargasClaroServiceStockLoad.htm?metodo=doExecuteStockProcess" id="CheckProcessStatus" method="post">
<table class="searchLayout">
	<tr>
		<td width="140">userId:</td>
		<td> <input type="text" name="userId"></td>
		
	</tr>
	<tr>
		<td >Password: </td>
		<td><input type="text" name="password"></td>
		
	</tr>	
	<tr>
			<td colspan="2"><input type="submit" value="ExecuteStockProcess"></td>		
	</tr>
</table>
</form>	
</body>
</html>

	
</body>
</html>