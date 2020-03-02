<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/linea/linea.js"></script>
<title>Update Line</title>
</head>
<body>
		
		<div class="content-registerCliente">
		<h3 style="padding: 20px 20px 20px 50px;">Actualizar Linea</h3>
			
			<form name="formLineRegister" id="updateLine" method="post">

			<input type="hidden" name="metodo" />  
			<input type="hidden" name="valor" /> 
			<input type="hidden" name="idClient" value="${line.idClient}">
			<input type="hidden" name="numberLine" value="${line.numberLine}">
			
			<table class="searchLayout">			
				<tr>
					<td width="500">
						<table align="left">
							<tr>
								<td width="140">Número de Linea :</td>
								<td><input type="text" name="numberLineNew" maxlength="15" value="${line.numberLine}"></td>
							</tr>
							<tr>
								<td>Estado :</td>
								<td>   
									<select name="state">
										<option value="1" <c:if test="${line.state eq '1'}">selected="selected"</c:if>>Activado</option>
										<option value="0" <c:if test="${line.state eq '0'}">selected="selected"</c:if>>Bloqueado</option>
									</select>
								</td>
							</tr>
							<tr>
								<td width="130">Modalidad :</td>
								<td>
									<select name="modality">
										<option value="S" <c:if test="${line.modality eq 'S'}">selected="selected"</c:if>>Renovable</option>
										<option value="N" <c:if test="${line.modality eq 'N'}">selected="selected"</c:if>>No renovable</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Actualizar" id="bt_actualizar"></td>
							</tr>			
						</table>
					</td>
				</tr>
				</table>
			
			</form>
		</div>

</body>
</html>