window.onload =load;	

var txt_dni,txt_primerNombre,txt_segundoNombre,txt_apellidoPaterno,txt_apellidoMaterno;

function load(){
	
	
	var btnNew = new getObj('btn_nuevo');
	if(btnNew.obj){
		btnNew.obj.onclick=doEjecutar;
		btnNew.obj.action="usuario.htm";
		btnNew.obj.metodo="doNuevoView";
	}
	
	var btnDelete= new getObj('btn_eliminar');
	if(btnDelete.obj){
		btnDelete.obj.onclick=doEjecutar;
		btnDelete.obj.action="usuario.htm";
		btnDelete.obj.metodo="doDelete";
	}
	
	var btnDelete= new getObj('btn_actualizarRoles');
	if(btnDelete.obj){
		btnDelete.obj.onclick=doEjecutar;
		btnDelete.obj.action="usuario.htm";
		btnDelete.obj.metodo="doActualizarRoles";
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


	function doEdit(id){
		var objForm = document.forms[0];
		
		objForm.id.value = id;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doEditView";
			objForm.action = "usuario.htm";
			objForm.submit();
		} 
		else{
			swal("Debe seleccionar un Usuario");
		}
		
	}
	
	function doRoles(id){
		var objForm = document.forms[0];
		
		objForm.id.value = id;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doAddRoles";
			objForm.action = "usuario.htm";
			objForm.submit();
		} 
		else{
			swal("Debe seleccionar un Usuario");
		}
		
	}
	
	function doVerLineas(id){
		var objForm = document.forms[0];
		
		objForm.idClient.value = id;
		if(objForm.idClient.value != ''){
			objForm.metodo.value = "doListar";
			objForm.action = "lines.htm";
			objForm.submit();
		} 
		else{
			swal("Debe seleccionar un Usuario");
		}
		
	}
	
	function doDelete(id){		
		var objForm = document.forms[0];
		objForm.id.value = id;
		if(objForm.id.value != ''){
			confirmSweet('Se solicito la eliminacion de un Usuario, \n desea continuar ?',"doDelete","usuario.htm");
			//if(confirm('Se solicito la eliminacion de un Cliente, \n desea continuar ?')){
			//	objForm.metodo.value = "doDelete";
			//	objForm.action = "clientes.htm";
			//	objForm.submit();
			//}
		} 
		else{
			swal("Debe seleccionar un Usuario.");
		}
		
	}
	
	var a_fields = {'dni' : {'l': 'DNI','r': false,'f': 'intPos'},
					'primerNombre' : {'l': 'Primer Nombre','r': false,'f': 'alphaEsp'},
					'segundoNombre' : {'l': 'Segundo Nombre','r': false,'f': 'alphaEsp'},
					'apellidoPaterno' : {'l': 'Apellido Paterno','r': false,'f': 'alphaEsp'},
					'apellidoMaterno' : {'l':'Apellido Materno','r':false,'f': 'alphaEsp'}
				}
		o_config = {'alert' : 1	}

	// validator constructor call
	var v = new validator('formClienteBuscar', a_fields, o_config);
	
	function selectAll(){
		var items=document.getElementsByName('idRol');
		for(var i=0; i<items.length; i++){
			if(items[i].type=='checkbox')
				items[i].checked=true;
		}
	}
	
	function UnSelectAll(){
		var items=document.getElementsByName('idRol');
		for(var i=0; i<items.length; i++){
			if(items[i].type=='checkbox')
				items[i].checked=false;
		}
	}	


