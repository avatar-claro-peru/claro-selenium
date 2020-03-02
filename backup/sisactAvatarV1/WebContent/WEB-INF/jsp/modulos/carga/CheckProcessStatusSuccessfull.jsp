<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado CheckProcessStatus</title>
</head>
<body>
<h1>Resultado CheckProcessStatus</h1>

		<div class="content-table">
			<c:if test="${!empty lista}">
			<center>
				<table width="90%">
					<tr style="background-color: gray;">
					  <th>IEvent</th>
					  <th>CodeReply</th>
					  <th>MessageReply</th>				
					</tr>
					<c:forEach items="${lista}" var="chekprocessStatus">
						<tr style="background-color: silver;">
							<td><c:out value="${chekprocessStatus.idEvent}"/></td>
							<td><c:out value="${chekprocessStatus.codeReply}"/></td>
							<td><c:out value="${chekprocessStatus.messageReply}"/></td>
						</tr>
					</c:forEach>
				</table>
			   <c:if test="${!empty mensajeError}">
			             
			       <p>"${mensajeError}"</p>
			      
			   </c:if>	
			   <c:if test="${!empty mensajeExito}">
			   
			        <p>"${mensajeExito}"</p>
			  
			   </c:if>	
				
			</center>
			</c:if>
		</div>
</body>
</html>