window.onload =load;
function doEdit(id){
		var objForm = document.forms[0];
		
		objForm.id.value = id;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doEditView";
			objForm.action = "orden.htm";
			objForm.submit();
		} 
		else{
			alert("Debe seleccionar una orden");
		}
		
	}

//lsoto: 30-01-20 : Implementación del historial de SyncOrder por orden - INICIO
function doListarDetalle(id){
	var objForm = document.forms[0];
	
	objForm.id.value = id;
	if(objForm.id.value != ''){
		objForm.metodo.value = "doListarDetalleView";
		objForm.action = "orden.htm";
		objForm.submit();
	} 
	else{
		alert("Debe seleccionar una orden");
	}
	
}
//lsoto: 30-01-20 : Implementación del historial de SyncOrder por orden - FIN

function load(){
	
	var btnSearch = new getObj('btn_buscar');
	if(btnSearch.obj){
		btnSearch.obj.onclick=doEjecutar;
		btnSearch.obj.action="orden.htm";
		btnSearch.obj.metodo="doBuscar";
		btnSearch.obj.sub=true;
		btnSearch.obj.validator=v;
	}
	
	var btnUpdate= new getObj('btn_actualizar');
	if(btnUpdate.obj){
		btnUpdate.obj.onclick=doEjecutarConfirm;
		btnUpdate.obj.action="orden.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado actualizar los datos de la orden,\n desea continuar?';
		btnUpdate.obj.validator=v;
	}
	
	// para limpiar
	var l = {};
	var i=0;
	
	txt_dni = new getObj('t_dni');
	if(txt_dni.obj){l[i]=txt_dni.obj;i++;}
	
	
	l.length=i;
	
	var btnLimpiar = new getObj('btn_limpiar');
	if(btnLimpiar.obj){
		
		btnLimpiar.obj.onclick=limpiar;
		btnLimpiar.obj.array=l;
	}	
}


var a_fields = {'id' : {'l': 'id','r': false,'f': 'intPos'}
}
o_config = {'alert' : 1	}

// validator constructor call
var v = new validator('formOrdenBuscar', a_fields, o_config);