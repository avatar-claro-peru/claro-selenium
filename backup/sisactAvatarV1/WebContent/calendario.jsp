<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Calendario</title>
  <script type="text/javascript" src="js/calendarioAgenda.js"></script>
  
<style type="text/css"> 
#calendario{ 
	font-family: Tahoma, Arial, Helvetica, sans-serif;
	font-size: 8px; 
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	border-collapse: collapse;
	border-right: 2px solid #999999;
	border-bottom: 2px solid #999999;
}

/*#mesCalendario para configurar aspectos de la caja que muestra el mes y el ano #CC6633*/
#mesCalendario{
	text-align: center;
	color: #CC6633 ;
	background-color: #dbdbdb;
}
#calendario td{
	/*position: static;*/
}
#calendario th, #calendario td{
	border: 1px solid #999999;
		color: #999999 ;
	padding: 3px;
	font-size: 150%;
}
/* #CC6633 */
#calendario th{
	color: #999999 ;
}
/*.diaS para configurar aspectos de la caja que muestra los dias de la semana*/
.diaS{
	color: #ffffff;
	background-color: #666666;

}
/*.celda para configurar aspectos de la caja que muestra los dias del mes*/
.celda {
	background-color: #FFFFFF;
	color: #000000;
	font-weight : normal;
	cursor: default;
}
/*.Hoy para configurar aspectos de la caja que muestra el dia actual*/
.Hoy{
	color: #ffffff;
	background-color: #666666;
	font-weight: normal;
	cursor: default;
}
#miCalendario{
	text-align: center;
}
/*.selectores para configurar aspectos de los campos para el mes y el anio #990000; */
.selectores{
	font-family: verdana;
	font-size: 9px;
	color: #999999; 
	margin-bottom: 2px;
	margin-top: 2px;
}
</style>
</head>

<body onload="tunCalendario();establecerFecha();">
<div id="miCalendario">  
  <select id="tunMes" class="selectores" onchange="mes=this.selectedIndex;borra();tunCalendario()">
    <option value="0" selected>Enero</option>
    <option value="1">Febrero</option>
    <option value="2">Marzo</option>
    <option value="3">Abril</option>
    <option value="4">Mayo</option>
    <option value="5">Junio</option>
    <option value="6">Julio</option>
    <option value="7">Agosto</option>
    <option value="8">Septiembre</option>
    <option value="9">Octubre</option>
    <option value="10">Noviembre</option>
    <option value="11">Diciembre</option>
  </select>
  <input readonly="readonly" type="text" id="tunAnio" class="selectores" onblur="if((!isNaN(this.value))&&(this.value>=2000)){anio=this.value;borra();tunCalendario()}" size="4" maxlength="4" />  
  <input type="button" name="incAnio" id="incAnio" class="selectores" value="+" onclick="IncYear()" >  
  <input type="button" name="decAnio" id="decAnio" class="selectores" value="-" onclick="DecYear()" >
  <input type="hidden" name="fechaCalendario" id="fechaCalendario"  >
</div>
</body>
</html>
     
