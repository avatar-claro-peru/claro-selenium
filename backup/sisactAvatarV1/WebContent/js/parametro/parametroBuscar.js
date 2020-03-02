window.onload =load;	

var txt_nombre,txt_descripcion;

function load(){

	window.name = "searchParametro";
	
	var btnNew = new getObj('btn_crear');
	if(btnNew.obj){
		btnNew.obj.onclick=doEjecutar;
		btnNew.obj.action="parametro.htm";
		btnNew.obj.metodo="doNuevoView";
	}

	var btnEdit = new getObj('btn_editar');
	if(btnEdit.obj){
		btnEdit.obj.onclick=doEdit;
	}
	
	var btnNewCampo = new getObj('btn_agregarCampo');
	if(btnNewCampo.obj){
		btnNewCampo.obj.onclick=doInsertField;
	}
	
	var btnGestVal = new getObj('btn_gestValores');
	if(btnGestVal.obj){
		btnGestVal.obj.onclick=doGestValor;
	}
	
	function doGestValor(){		
		var objForm = document.forms[0];
		objForm.idParametro.value = objForm.cboParametro.value;
		//alert(objForm.id.value);
		if(objForm.idParametro.value != ''){
			objForm.metodo.value = "doListar";
			objForm.action = "parametroDetalle.htm";
			objForm.submit();
		} 
		else{
			alert("Debe seleccionar un Parametro.");
		}
		
	}
	
	function doInsertField(){
		var objForm = document.forms[0];
		objForm.id.value = objForm.cboParametro.value;
		objForm.idPadre.value = objForm.cboParametro.value;
		objForm.nombre.value = objForm.t_nombreCampo.value;
		//alert(objForm.id.value);
		//alert(objForm.nombre.value);
		if(objForm.id.value != ''){
			if(objForm.nombre.value != ''){
				objForm.metodo.value = "doSaveField";
				objForm.action = "parametro.htm";
				objForm.submit();
			} 
			else{
				alert("Debe insertar el nombre del nuevo Campo.");
			}
		}
		else{
			alert("Debe seleccionar un Parametro.");
		}
			
	}
	
	var btnDelete= new getObj('btn_eliminar');
	if(btnDelete.obj){
		btnDelete.obj.onclick=doDelete;
	}
	var btnListarValores= new getObj('btn_listarValores');
	if(btnListarValores.obj){
		btnListarValores.obj.onclick=doListarValores;
	}
//	var cboParam = new getObj('cboParametro');
//	if(cboParam.obj){
//		alert('cboParametro');
//		cboParam.obj.onChange=doChange;
//	}
			
}
	

	function doEdit(img){		
		var objForm = document.forms[0];
		objForm.id.value = img.alt;
		if(objForm.id.value != ''){
			objForm.metodo.value = "doEditView";
			objForm.action = "parametro.htm";
			objForm.submit();
		} 
		else{
			alert("Hubo un error con el Id");
		}
		
	}

	function doDelete(img){		
		var objForm = document.forms[0];
		objForm.id.value = img.alt;
		if(objForm.id.value != ''){
			if(confirm('Se solicito la eliminacion de un Parametro, \n desea continuar ?')){
				objForm.metodo.value = "doEliminarParametro";
				objForm.action = "parametro.htm";
				objForm.submit();
			}
		} 
		else{
			alert("Debe seleccionar un Parametro.");
		}
		
	}
	
	function doListarValores(){		
		var objForm = document.forms[0];
		objForm.id.value = objForm.cboParametro.value;
		//alert(objForm.id.value);
		if(objForm.id.value != ''){
			var windowOpts = "width=660,height=250,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";   
		    var action = "parametroDetalle.htm?metodo=doListarValores&id="+objForm.id.value;    
			window.open(action,'listarValParam',windowOpts);
		} 
		else{
			alert("Debe seleccionar un Parametro.");
		}
		
	}
	
	function doChange(){
		var objForm = document.forms[0];
		objForm.id.value = objForm.cboParametro.value;
		//alert(objForm.id.value);
		if(objForm.id.value != ''){
			objForm.metodo.value = "doListarFields";
			objForm.action = "parametro.htm";
			objForm.submit();
		} 
	}
	
	function doDeleteField(img){
		var objForm = document.forms[0];
		if(confirm('Desea eliminar el presente campo?')){
			var data = img.alt.split('*');
			objForm.id.value = data[1];
			objForm.idCampo.value = data[0]; 	//data[0] -> idCampo
			objForm.idPadre.value = data[1];	//data[1] -> idPadre
			//alert(objForm.idCampo.value);
			//alert(objForm.idPadre.value);
			objForm.metodo.value = "doDeleteField";
			objForm.action = "parametro.htm";
			objForm.submit();
		}
			
	}
	
	function doEditField(img){		
		if(img.alt != ''){
			var data = img.alt.split('*');//	data[0] -> idCampo;	data[1] -> idPadre
			var windowOpts = "width=660,height=250,scrollbars=yes,directories=no,status=no,location=no,toolbar=no,resizable=1";   
		    var action = "parametro.htm?metodo=doEditFieldView&idCampo="+data[0]+"&idPadre="+data[1];    
			window.open(action,'editaCampo',windowOpts);
		}			
	}
	
	var a_fields = {'nombre' : {'l': 'Nombre','r': false,'f': 'alphaEsp'},
				'descripcion' : {'l':'Descripcion','r':false,'f': 'alphaEsp'}
				},
			 	b_fields = {
			"ids" : {'l':'Option','r':true,'f': 'bool'} //12
		 	},
		o_config = {'alert' : 1	}

	// validator constructor call
//	var v = new validator('formTipoClienteBuscar', a_fields, o_config);
//	var v1 = new validator('formTipoClienteBuscar', b_fields, o_config);

