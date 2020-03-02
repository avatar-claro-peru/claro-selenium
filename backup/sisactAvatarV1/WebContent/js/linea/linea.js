window.onload =load;	
	
// varib limpiar

function load(){


	var btnUpdate= new getObj('bt_actualizar');
	if(btnUpdate.obj){
		btnUpdate.obj.onclick=doEjecutarConfirm;
		btnUpdate.obj.action="lines.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado actualizar los datos del cliente,\n desea continuar?';
		btnUpdate.obj.validator=v;
	}
	
	
	var btnGuardar = new getObj('bt_registrar');
	if(btnGuardar.obj){
		btnGuardar.obj.onclick=doEjecutarConfirm;
		btnGuardar.obj.action="lines.htm";
		btnGuardar.obj.metodo="doSave";
		btnGuardar.obj.msg='Se ha solicitado guardar los datos del cliente,\n desea continuar?';
		btnGuardar.obj.validator=v;
		//btnGuardar.obj.sub=false;
	}

	var btnCancelar = new getObj('bt_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doEjecutarConfirm;
		btnCancelar.obj.action="persona.htm";
		btnCancelar.obj.metodo="doListar";
		btnCancelar.obj.msg='Se ha solicitado cancelar,\n desea continuar?';
	}
	
}		
	
	var a_fields = {
	"numberLine" : {'l':'Numero de linea','r':true,'f': 'integer'},
	"numberLineNew" : {'l':'Numero de linea','r':true,'f': 'integer'}
 	},
 	d_fields = {
	"idClient" : {'l':'id_cliente','r':true,'f': 'unsigned'}
 	},
 	o_config = {
		'alert' : 1}

	// validator constructor call
	var v = new validator('formLineRegister', a_fields, o_config);
	var v1 = new validator('formLineRegister', d_fields, o_config);


