<%@ taglib uri="http://acegisecurity.org/authz" prefix="authz" %>
<%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%> 
<div id="mediocol1">&nbsp;</div>

<div id="menulateral">

	<authz:authorize ifAnyGranted="ADMINISTRADOR_USUARIO,ADMINISTRADOR_PERFIL,ADMINISTRADOR_OPCION">
		<h1>Administrador</h1>
		<ul id="adminUsuario">
			<authz:authorize ifAllGranted="ADMINISTRADOR_USUARIO">
				<li><a href="usuario.htm?metodo=doListar">Usuarios</a></li>
			</authz:authorize>
			<authz:authorize ifAllGranted="ADMINISTRADOR_PERFIL">
				<li><a href="perfil.htm?metodo=doListar">Perfiles</a></li>
			</authz:authorize>
			<authz:authorize ifAllGranted="ADMINISTRADOR_OPCION">
				<li><a href="opcion.htm?metodo=doListar">Opciones</a></li>
			</authz:authorize>
		</ul> 
	</authz:authorize>
	<authz:authorize ifAnyGranted="ASESOR_CLIENTE,ASESOR_PARAMETRO,ASESOR_EVALUACION,ASESOR_ORDENES,ASESOR_OPERACIONES">
		<h1>Operación</h1>
		<ul id="cliente">
			<authz:authorize ifAllGranted="ASESOR_CLIENTE">			
				<li><a href="clientes.htm?metodo=doListar">Clientes</a></li>
			</authz:authorize>	
			<authz:authorize ifAllGranted="ASESOR_PARAMETRO">
				<li><a href="parametro.htm?metodo=doListarParametro">Parámetro</a></li>
			</authz:authorize>			
			<authz:authorize ifAllGranted="ASESOR_EVALUACION">
				<li><a href="evaluacion.htm?metodo=doListarEvaluacion">Evaluaciones</a></li>
			</authz:authorize>
			<authz:authorize ifAllGranted="ASESOR_ORDENES">
				<li><a href="orden.htm?metodo=doListarOrdenes">Ordenes</a></li>
			</authz:authorize>
			<authz:authorize ifAllGranted="ASESOR_SOLICITUDES">
				<li><a href="solicitud.htm?metodo=doListarSolicitudes">Solicitudes</a></li>
			</authz:authorize>
			
			<% // lsoto: 31-10-19 : Implementación del servicio de tope de consumo - INICIO  %>
			<authz:authorize ifAllGranted="ASESOR_TOPECONSUMO">
				<li><a href="topeConsumo.htm?metodo=doListar">Topes de consumo</a></li>
			</authz:authorize>	
			<% // lsoto: 31-10-19 : Implementación del servicio de tope de consumo - FIN  %>
			
			<% // lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - INICIO  %>
			<authz:authorize ifAllGranted="ASESOR_TOPECONSUMO">
				<li><a href="tipoPlan.htm?metodo=doListar">Tipos de plan</a></li>
			</authz:authorize>	
			<% // lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - FIN  %>
					
		</ul> 
	</authz:authorize>
	
	<authz:authorize ifAnyGranted="SERVICIO_PRECIO,SERVICIO_STOCK,SERVICIO_ACCESSORY">
		<h1>Servicios</h1>
		<ul id="servicios">
			<authz:authorize ifAllGranted="SERVICIO_PRECIO">
				<li><a href="cargasClaroServicePriceLoad.htm?metodo=claroServicePriceLoadView">ServicePriceLoad</a></li>
			</authz:authorize>	
			<authz:authorize ifAllGranted="SERVICIO_STOCK">
				<li><a href="cargasClaroServiceStockLoad.htm?metodo=claroServiceStockLoadView">ServiceStockLoad</a></li>
			</authz:authorize>	
			<authz:authorize ifAllGranted="SERVICIO_ACCESSORY">
				<li><a href="cargasClaroServiceAccessoryLoad.htm?metodo=claroServiceAccessoryLoadView">ServiceAccessoryLoad</a></li>
			</authz:authorize>		
		</ul> 
	</authz:authorize>	

</div>