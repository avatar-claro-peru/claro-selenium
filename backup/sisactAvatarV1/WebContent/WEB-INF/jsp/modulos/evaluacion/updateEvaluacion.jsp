<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/commons/tagLib.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Procesar Evaluacion</title>
<script type="text/javascript" src="js/evaluacion/evaluacionEdit.js"></script>
</head>
<body>

<form name="formEvaluacionEdit" method="post">
<input type="hidden" name="metodo" />  
<input type="hidden" name="valor" /> 
<input type="hidden" name="id" value="${evaluacion.id}"/>
<input type="hidden" name="ordenId" value="${evaluacion.ordenId}"/>
<input type="hidden" name="secuencia" value="${evaluacion.secuencia}"/>
<input type="hidden" name="tipoOperacion" value="${evaluacion.tipoOperacion}"/>
<input type="hidden" name="idPadre" value="${evaluacion.idPadre}"/>

<!-- lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO -->
<input type="hidden" name="cuotainicial_tv" value="${evaluacion.cuotainicial_tv}"/>
<input type="hidden" name="valorcuota_tv" value="${evaluacion.valorcuota_tv}"/>
<input type="hidden" name="valorequipo_tv" value="${evaluacion.valorequipo_tv}"/>
<input type="hidden" name="modalidadventa" value="${evaluacion.modalidadventa}"/>
<!-- lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN -->

<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO -->
<input type="hidden" name="campania" value="${evaluacion.campania}"/>
<input type="hidden" name="listaprecios" value="${evaluacion.listaprecios}"/>
<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN -->

<!-- lsoto: 24-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: INCIO -->
<input type="hidden" name="codigoMaterialChip" value="${evaluacion.codigoMaterialChip}"/>
<input type="hidden" name="codigoMaterialItem" value="${evaluacion.codigoMaterialItem}"/>
<!-- lsoto: 24-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: FIN -->

<br> 
	<h3 style="padding: 20px 20px 20px 50px;">
	<c:if test="${empty evaluacion.id}">
		Crear Cliente
	</c:if>
	<c:if test="${not empty evaluacion.id}">
		Procesar Evaluacion
	</c:if>
	</h3>

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

	<table class="detailTitle">
		<tr>
			<td colspan="4"><b>Evaluacion  Orden: ${evaluacion.ordenId}</b></td>
			<td colspan="4"><b>Tipo Operacion: ${evaluacion.modalidadVentaNombre}</b></td>
			<td colspan="4"><b>OrderItems: ${evaluacion.idPadre}</b></td>
		</tr>
	</table>
	
	<% // lsoto: 17-07-19: Mostrar un formulario dependiendo de tipo de venta asociado a la tienda virtual: INCIO  %>
	
	<%/*
	a.codeResponse
		0: Terminó
		1: No termina.
		Valores negativos: Error en el servicio"
	b.flagCambioCampana
	c.flag Campaña
		0= valor de la misma campana
		1= cambio de campaña
	d.codigoPreEval
		0: Pasó la pre evaluación
		1 o 2: No paso la pre evaluación"
	e.codCampana
	f.codigoLP
	g.cantidadDeAplicacionesRenta
		0: no hay rentas adelantadas
		>0: cantidad de rentas"
	h.cuotaInicial
	i.valorCuota
	j.valorEquipo
	*/%>
	<c:if test="${evaluacion.tipo_venta == 1}">
	
	<table id="formulario_evaluacion_prepago" class="searchLayout">			
			<!-- lsoto: 11-09-19: Inclusión del ID de evaluación en la página de edición de evaluación: INICIO -->
			<tr>
				<td width="130">ID de Evaluación:</td>
				<td><input type="text" name="id_evaluacion" value="${evaluacion.id}" disabled="disabled"></td>
			</tr>
			<!-- lsoto: 11-09-19: Inclusión del ID de evaluación en la página de edición de evaluación: FIN -->
			
			<tr>
				<td width="130">Tipo de venta :</td>
				<td><input type="text" name="tipo_venta" value="Prepago" disabled="disabled"></td>
			</tr>
			
			<tr>
				<td width="130">Modalidad de venta :</td>
				<td><input type="text" name="" value="" disabled="disabled"></td>
			</tr>
			
			<tr>
				<td width="130">Código de chip :</td>
				<td><input type="text" name="" value="" disabled="disabled"></td>
			</tr>
			
			<tr>
				<td width="130">Config escenario Trama Error :</td>
				<td>
					<input name="flagErrorInterno" value="1" type="checkbox"
					<c:if test="${evaluacion.flagErrorInterno eq '1'}">
					checked="checked"
					</c:if>
					 >Trama Error.
				</td>
			</tr>					
			<tr>
				<td>Eval Cantidad Lineas:</td>
				<td>
					<select name="estadoCantidadLineas" disabled="disabled">
						<option value="0" <c:if test="${evaluacion.estadoCantidadLineas == '0'}">selected="selected"</c:if>>Pendiente</option>
						<option value="1" <c:if test="${evaluacion.estadoCantidadLineas == '1'}">selected="selected"</c:if>>No Supero Lineas</option>
						<option value="2" <c:if test="${evaluacion.estadoCantidadLineas == '2'}">selected="selected"</c:if>>Supero Lineas</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="130">Eval SEC Pendiente :</td>
				<td>
					<select name="estadoSecPendiente" disabled="disabled">
						<option value="0" <c:if test="${evaluacion.estadoSecPendiente == '0'}">selected="selected"</c:if>>Pendiente</option>
						<option value="1" <c:if test="${evaluacion.estadoSecPendiente == '1'}">selected="selected"</c:if>>No tiene SEC Pendiente</option>
						<option value="2" <c:if test="${evaluacion.estadoSecPendiente == '2'}">selected="selected"</c:if>>Tiene SEC Pendiente</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="130">Eval renovable :</td>
				<td>
					<select name="estadoRenovacion">
						<option value="0" <c:if test="${evaluacion.estadoRenovacion == '0'}">selected="selected"</c:if>>Pendiente</option>
						<option value="1" <c:if test="${evaluacion.estadoRenovacion == '1'}">selected="selected"</c:if>>Paso Renovacion</option>
						<option value="2" <c:if test="${evaluacion.estadoRenovacion == '2'}">selected="selected"</c:if>>No Paso Renovacion</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="130">Eval Consulta Previa :</td>
				<td>
					<select name="estadoConsultaPrevia">
						<option value="0" <c:if test="${evaluacion.estadoConsultaPrevia == '0'}">selected="selected"</c:if>>Pendiente</option>
						<option value="1" <c:if test="${evaluacion.estadoConsultaPrevia == '1'}">selected="selected"</c:if>>Paso Portabilidad</option>
						<option value="2" <c:if test="${evaluacion.estadoConsultaPrevia == '2'}">selected="selected"</c:if>>No paso Portabilidad</option>
					</select>
				</td>
			</tr>	

			<tr>
				<td width="130">Mensaje Error Consulta Previa:</td>
				<td>
					<select name="msgConsultaPrevia"> 
						<c:forEach var="row" items="${msgPortabilidad}">
							<option value="${row.id}" <c:if test="${row.id==evaluacion.msgConsultaPrevia}">selected="selected"</c:if>    >${row.descripcion}</option>
						</c:forEach>
					</select>
				</td>
			</tr>	
	</table>
	</c:if>	
	<c:if test="${evaluacion.tipo_venta == 2}">
	<table id="formulario_evaluacion_postpago" class="searchLayout">
			<!-- lsoto: 11-09-19: Inclusión del ID de evaluación en la página de edición de evaluación: INICIO -->
			<tr>
				<td width="130">ID de Evaluación:</td>
				<td>${evaluacion.id}</td>
			</tr>
			
			<tr>
				<td width="130">ID de Orden:</td>
				<td>${evaluacion.ordenId}</td>
			</tr>
			<!-- lsoto: 11-09-19: Inclusión del ID de evaluación en la página de edición de evaluación: FIN -->
					
			<tr>
				<td width="130">Tipo de venta:</td>
				<td>Postago</td>
			</tr>
			
			<tr>
				<td width="130">Modalidad de venta :</td>
<%-- 				<td><input type="text" name="getModalidadVentaNombre" value="${evaluacion.modalidadVentaNombre}" disabled="disabled"></td> --%>
				<td>${evaluacion.modalidadVentaNombre}</td>
			</tr>
			
			<tr>
				<td width="130">Código del Item :</td>
				<td>${evaluacion.codigoMaterialItem}</td>
			</tr>
			
			<tr>
				<td width="130">Código de Chip :</td>
				<td>${evaluacion.codigoMaterialChip}</td>
			</tr>
			<!-- jcisneros_031219: Inclusion de la descripcion del tope de consumo al realizar una evaluacion INICIO -->
			<tr>
				<td width="130">Descripci&oacute;n Tope Consumo :</td>
				<td>${evaluacion.descripcionTopeConsumo}</td>
			</tr>
			<!-- jcisneros_031219: Inclusion de la descripcion del tope de consumo al realizar una evaluacion FIN -->
			<tr>
				<td width="250">Código de respuesta de la Evaluación:</td>
				<td>
					<select name="codeResponse">
						<option value="0" <c:if test="${evaluacion.codeResponse == '0'}">selected="selected"</c:if> >Terminó (0)</option>
						<option value="1" <c:if test="${evaluacion.codeResponse == '1'}">selected="selected"</c:if> >No termina (1)</option>
						<option value="2" <c:if test="${evaluacion.codeResponse == '2'}">selected="selected"</c:if> >Rechazado por la evaluación (2)</option>
						<option value="3" <c:if test="${evaluacion.codeResponse == '3'}">selected="selected"</c:if> >Rechazado por la pre-evaluación (3)</option>
						<option value="-1" <c:if test="${evaluacion.codeResponse == '-1'}">selected="selected"</c:if> >Error en el servicio (-1)</option>
						<option value="4" <c:if test="${evaluacion.codeResponse == '4'}">selected="selected"</c:if> >Escenario 15 (4)</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td width="130">¿Cambió la campaña?:</td>
				<td>
					<select name="flagCambioCampana">
						<option value="0" <c:if test="${evaluacion.flagCambioCampana == '0'}">selected="selected"</c:if> >No, no cambió</option>
						<option value="1" <c:if test="${evaluacion.flagCambioCampana == '1'}">selected="selected"</c:if> >Sí, sí cambió</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td width="130">Código de respuesta de la pre-evaluación:</td>
				<td>
					<select name="codigoPreEval">
						<option value="0" <c:if test="${evaluacion.codigoPreEval == '0'}">selected="selected"</c:if> >Pasó la pre-evaluación (0)</option>
						<option value="1" <c:if test="${evaluacion.codigoPreEval == '1'}">selected="selected"</c:if> >No paso por deudas (1)</option>
						<option value="2" <c:if test="${evaluacion.codigoPreEval == '2'}">selected="selected"</c:if> >No paso por otros motivos (2)</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td width="130">Código de campaña:</td>
				<td>
<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO -->
					<input type="text" name="codCampana" value="${evaluacion.codCampana}" > (${evaluacion.campania})
<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN -->
				</td>
			</tr>						

			<tr>
				<td width="130">Código de Lista de precios:</td>
				<td>
<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO -->
					<input type="text" name="codigoLP" value="${evaluacion.codigoLP}" > (${evaluacion.listaprecios})
<!-- lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN -->
				</td>
			</tr>
			
			<tr>
				<td width="130">¿Cuántas rentas adelantadas?:</td>
				<td>
					<select name="cantidadDeAplicacionesRenta">
						<option value="0" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '0'}">selected="selected"</c:if> >0</option>
						<option value="1" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '1'}">selected="selected"</c:if> >1</option>
						<option value="2" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '2'}">selected="selected"</c:if> >2</option>
						<option value="3" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '3'}">selected="selected"</c:if> >3</option>
						<option value="4" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '4'}">selected="selected"</c:if> >4</option>
						<option value="5" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '5'}">selected="selected"</c:if> >5</option>
						<option value="6" <c:if test="${evaluacion.cantidadDeAplicacionesRenta == '6'}">selected="selected"</c:if> >6</option>
					</select>
				</td>
			</tr>
<!-- 		lsoto: 07-09-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO -->			
			<tr>
				<td width="130">Cuota Inicial que devuelve el Servicio:</td>
				<td><input type="text" name="cuotaInicial" value="${evaluacion.cuotaInicial}" > (${evaluacion.cuotainicial_tv})</td>
			</tr>
			
			<tr>
				<td width="130">Precio x Cuota que devuelve el Servicio:</td>
				<td><input type="text" name="valorCuota" value="${evaluacion.valorCuota}" > (${evaluacion.valorcuota_tv})</td>
			</tr>
			
			<tr>
				<td width="130">Precio Total que devuelve el Servicio:</td>
				<td><input type="text" name="valorEquipo" value="${evaluacion.valorEquipo}" > (${evaluacion.valorequipo_tv})</td>
			</tr>
			
<!-- 		lsoto: 07-09-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN -->
			
	</table>
	</c:if>
	<% // lsoto: 17-07-19: Mostrar un formulario dependiendo de tipo de venta asociado a la tienda virtual: FIN  %>
	
	<p align="center" style="width: 92%;">
		<c:if test="${empty evaluacion.id}">
			<input type="button" value="Guardar" class="orange"  id="btn_guardar"> 
		</c:if>
		<c:if test="${not empty evaluacion.id}">		
			<input type="button" value="Actualizar" class="orange"  id="btn_actualizar"> 
		</c:if>		
			<input type="button" value="Cancelar" class="orange"  id="btn_cancelar"> 
	</p>
</form>
</body>
</html>