window.onload =load;	

var txt_dni,txt_primerNombre,txt_segundoNombre,txt_apellidoPaterno,txt_apellidoMaterno;

function load(){
	
	var btnNew = new getObj('btn_nuevo');
	if(btnNew.obj){
		btnNew.obj.onclick=doEjecutar;
		btnNew.obj.action="tipoPlan.htm";
		btnNew.obj.metodo="doNuevoView";
	}
	
	var btnDelete= new getObj('btn_eliminar');
	if(btnDelete.obj){
		btnDelete.obj.onclick=doEjecutar;
		btnDelete.obj.action="tipoPlan.htm";
		btnDelete.obj.metodo="doDelete";
	}
	
	var btnDelete= new getObj('btn_actualizarOpciones');
	if(btnDelete.obj){
		btnDelete.obj.onclick=doEjecutar;
		btnDelete.obj.action="tipoPlan.htm";
		btnDelete.obj.metodo="doActualizarTopesConsumo";
	}
	
	var refs= new getObjTag('label'); 
	if(refs)
		for (var i = 0; i < refs.length; i++){
			if(refs[i].obj.id){
				refs[i].obj.onclick= doEdit;
				refs[i].style.cursor='pointer';
			}
		}
		
	
	var btnCancel = new getObj('btn_cancel');
	if(btnCancel.obj)btnCancel.obj.onclick=doCancel;
	
		// para limpiar
	var l = {};
	var i=0;

	txt_dni = new getObj('t_dni');
	if(txt_dni.obj){l[i]=txt_dni.obj;i++;}
	
	txt_primerNombre = new getObj('t_primerNombre');
	if(txt_primerNombre.obj){l[i]=txt_primerNombre.obj;i++;}
	
	txt_segundoNombre = new getObj('t_segundoNombre');
	if(txt_segundoNombre.obj){l[i]=txt_segundoNombre.obj;i++;}
	
	txt_apellidoPaterno = new getObj('t_apellidoPaterno');
	if(txt_apellidoPaterno.obj){l[i]=txt_apellidoPaterno.obj;i++;}
	
	txt_apellidoMaterno = new getObj('t_apellidoMaterno');
	if(txt_apellidoMaterno.obj){l[i]=txt_apellidoMaterno.obj;i++;}
	
	l.length=i;
	
	var btnLimpiar = new getObj('btn_limpiar');
	if(btnLimpiar.obj){
		
		btnLimpiar.obj.onclick=limpiar;
		btnLimpiar.obj.array=l;
	}	
	
}
	
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - INICIO
	function doOpciones(id){
		var objForm = document.forms[0];
		
		objForm.id.value = id;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doAddTopesConsumo";
			objForm.action = "tipoPlan.htm";
			objForm.submit();
		} 
		else{
			swal("Debe seleccionar un tipo de plan");
		}
		
	}
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - FIN
	
	function doEdit(id){
		var objForm = document.forms[0];
		
		objForm.id.value = id;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doEditView";
			objForm.action = "tipoPlan.htm";
			objForm.submit();
		} 
		else{
			alert("Debe seleccionar un Tipo de Plan");
		}
	}
	
	
	function doDelete(id){		
		var objForm = document.forms[0];
		objForm.id.value = id;
		if(objForm.id.value != ''){
			confirmSweet('Se solicito la eliminacion de un Tipo de plan, \n desea continuar ?',"doDelete","tipoPlan.htm");
			//if(confirm('Se solicito la eliminacion de un Cliente, \n desea continuar ?')){
			//	objForm.metodo.value = "doDelete";
			//	objForm.action = "clientes.htm";
			//	objForm.submit();
			//}
		} 
		else{
			swal("Debe seleccionar un Tipo de plan.");
		}
		
	}
	
	var a_fields = {'num_doc' : {'l': 'DNI','r': false,'f': 'intPos'}
				}
		o_config = {'alert' : 1	}

	// validator constructor call
	var v = new validator('formTipoPlanListar', a_fields, o_config);

