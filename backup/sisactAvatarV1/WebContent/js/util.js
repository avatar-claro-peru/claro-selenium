// Funcion que obtiene el objeto

function getObj(name)
{

  if (document.getElementById)
  {
  	this.obj = document.getElementById(name);
  	
  	if(!this.obj)
  		return false;
  		
	this.style = document.getElementById(name).style;
  }
  else if (document.all)
  {
	this.obj = document.all[name];
	this.style = document.all[name].style;
  }
  else if (document.layers)
  {

   	this.obj = document.layers[name];
   	this.style = document.layers[name];
  }
}

function getObjName(frm,name)
{	
	var objs= document.forms[frm].elements[name];
	if(!objs)
		return false;

	if(objs.length){
		for (var i = 0; i < objs.length; i++)
				this[i]={'obj':objs[i],'style':objs[i].style};
		this.length=objs.length;
	}
	else{
		this[0]={'obj':objs,'style':objs.style};
		this.length=1;
	}
}

function getObjTag(name)
{	
	var objs= document.getElementsByTagName(name);
	if(!objs)
		return false;
	
	if(objs.length){
		for (var i = 0; i < objs.length; i++)
				this[i]={'obj':objs[i],'style':objs[i].style};
		this.length=objs.length;
	}
	else{
		this[0]={'obj':objs,'style':objs.style};
		this.length=1;
	}
	
}


//Funciones generales
	function doListEspecialidades(){
		
		var windowOpts = "width=650,height=450,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";
	    var action = "especialidad.htm?metodo=doListEspecialidades";
		window.open(action,'Especialidades',windowOpts);
	}
	
	function doListEspecialistas(){
	
		var windowOpts = "width=650,height=450,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";
	    var action = "especialista.htm?metodo=doListEspecialistas"; 
		window.open(action,'Especialistas',windowOpts);
	}
	
	
  	function doListServicios(){

		var windowOpts = 'width=550,height=550,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1';
	    var action = 'servicio.htm?metodo=doListServiciosDisponibles';
		window.open(action,'servicio',windowOpts);
	}
	
	
	function calendario(){
		var windowOpts = 'width=200,height=270,left=760,top=195,directories=no,status=no,location=no,toolbar=no,resizable=1';
	    var action = 'calendario.htm?metodo=doViewCalendario';

		window.open(action,'calendario',windowOpts);
	}
	
	

	function limpiar(){
		
		for (var i=0;i<this.array.length;i++) {
			input=this.array[i];
			
			if (input.type == 'checkbox') // checkbox
				input.checked=false;
			else if (input.value && !input.options) // text, password, hidden
				input.value='';
			else if (input.options) // select
				input.selectedIndex=0;
			else if (input.length > 0) // radiobuton
				for (var index = 0; index < input.length; index++)
					input[index].checked=false;
		}
	}
	
	function doEjecutar(){
		
		var b;

		if(this.validator)
			b=this.validator.exec();
		else
			b=true;
		if (b){
			var objForm = document.forms[0];
			objForm.metodo.value = this.metodo;
			objForm.action = this.action;
			
			if(!this.sub){
				
				objForm.submit();}
		}
		else{
			return false;
		}
	}
	
	function doEjecutarConfirm(){
		var b;
		if(this.validator)
			b=this.validator.exec();
		else
			b=true;
		
		if (b){
			confirmSweet(this.msg,this.metodo,this.action);	
			return false;
		}
		else{
			return false;
		}
		
	}
	
	function confirmSweet(msg,metodo,action)
	{
		swal({   title: "Esta seguro de realizar la acción?",  
			text: msg,   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "Si",
			closeOnConfirm: true },

			function(){submitSweet(metodo,action);}
			);
	}
	
	function submitSweet(metodo,action){
		var objForm = document.forms[0];
		objForm.metodo.value = metodo;
		objForm.action = action;
		objForm.submit();
	}
	
	
	function doCancel()
	{
		if ( confirm("Esta opciï¿½n cerrarï¿½; esta ventana") ) {
			window.close();
		}
	}

	// citaEdit
	
	function doSearchPaciente(){
	
		var windowOpts = "width=650,height=450,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";   
	    var action = "paciente.htm?metodo=doBackPaciente";    
		window.open(action,'Pacientes',windowOpts);
	}
	
	function doSearchTurno(){
	
		var windowOpts = "width=650,height=450,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";
	    var action = "servicioProgramado.htm?metodo=doBackTurnosDisponibles";
		window.open(action,'ServiciosProgramados', windowOpts);
			  
	}
	
	//parte diario
	function doSearchServicioProgramado()
	{
		var windowOpts = "width=650,height=450,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";
	    var action = "servicioProgramado.htm?metodo=doBackServicioProgramado";
	    
		window.open(action,'ServiciosProgramados' , windowOpts);		  
	}
	
	// formato cajas d texto
	
	//Funcion q modifica el formato
 	function forma(){	
		cad=trim(this.value);
		this.value=cad.toUpperCase();
	}

	//Funcion q llama a la q valida codigo
	function validaCodigo()	{	
	
		fncEsCodigoUni(this.value);
		
	}
	
	
	
 //verifica si es un codigo uni
 
function fncEsCodigoUni(codigo) {
	
	var  keyAscii = event.keyCode;
	if(keyAscii!=13){
		var key = String.fromCharCode(event.keyCode); 

		if (codigo.length==8)	{
			var valid = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		 	var keyAj=key.toUpperCase();
	 		event.keyCode=keyAj.charCodeAt(0);
		 	if (valid.indexOf(keyAj) == "-1")	event.keyCode=0;
		}
		else{
			var valid = "0123456789";
			if (valid.indexOf(key) == "-1")	event.keyCode=0;
		}
		return true;
	}
}

function fncEsLetraEsp( ) {
	
	var  keyAscii = event.keyCode;
	if(keyAscii!=13){
		var valid = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ ï¿½ï¿½ï¿½ï¿½ï¿½';
		var key = String.fromCharCode(event.keyCode); 
	 	var keyAj=key.toUpperCase();
		event.keyCode=keyAj.charCodeAt(0);
		if (valid.indexOf(keyAj) == "-1") event.keyCode=0;
			return true;
	}
}


function fncMayus( ) {
	
	var  keyAscii = event.keyCode;
	if(keyAscii!=13){
		var key = String.fromCharCode(event.keyCode); 
	 	var keyAj=key.toUpperCase();
		event.keyCode=keyAj.charCodeAt(0);
	}
}

function trim(lstr)
{
	lstr = String(lstr);
	var long=lstr.length, ini=0, band=true,fin;
		
	while(ini<long && band){
		if(lstr.charAt(ini)!=' ')
			band=false;
		else			
			ini++;
	}
	lstr = lstr.substring(ini,long);
	fin=lstr.length;
	band=true;
	while(fin>0 && band){
		if(lstr.charAt(fin-1)!=' ')
			band=false;
		else			
			fin--;
	}
	lstr = lstr.substring(0,fin);
	return lstr;
}

	function validaDate(fechaFin,fechaInicio){

		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;//January is 0!
		var yyyy = today.getFullYear();
		if(dd<10){dd='0'+dd}
		if(mm<10){mm='0'+mm}
		var diaHoy=new String(dd+'/'+mm+'/'+yyyy);
		var fecFin=new String(fechaInicio);
		var fecInicio=new String(fechaFin);
		
		if(fechaMayorOIgualQue(fecFin,fecInicio)&&fechaMayorOIgualQue(fecInicio,diaHoy)){
			return true;
		}
		else{
			return false;
		}
	}
	
	function validaFechaHoy(fecha){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;//January is 0!
		var yyyy = today.getFullYear();
		if(dd<10){dd='0'+dd}
		if(mm<10){mm='0'+mm}
		var diaHoy=new String(dd+'/'+mm+'/'+yyyy);
		var fechaVal=new String(fecha);
		
		if(fechaMayorOIgualQue(fechaVal,diaHoy)){
		
			return true;
			
		}
		else{
			alert('Ingrese una fecha correcta');
			return false;
		}
	}
	
	function fechaMayorOIgualQue(fec0, fec1){ 
	    var bRes = false; 
	
	    var sDia0 = fec0.substr(0,2); 
	    var sMes0 = fec0.substr(3,2); 
	    var sAno0 = fec0.substr(6,4); 
	    var sDia1 = fec1.substr(0,2); 
	    var sMes1 = fec1.substr(3,2); 
	    var sAno1 = fec1.substr(6,4); 
	    
	    if (sAno0 > sAno1) bRes = true; 
	    else { 
	     if (sAno0 == sAno1){ 
	      if (sMes0 > sMes1) bRes = true; 
	      else { 
	       if (sMes0 == sMes1) 
	        if (sDia0 >= sDia1) bRes = true; 
	      } 
	     } 
	    } 
	    return bRes; 
	}  
	