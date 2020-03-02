window.onload =load;	
	
// varib limpiar
	
var 
txt_telefono3,
txt_telefono2,
txt_telefono1,
txt_referencia,
txt_numerovia,
txt_nombrezona,
txt_nombrevia,
txt_cuspp,
txt_unidad,
txt_asignacionFamiliar,
txt_areaTrabajo,
txt_domicilio,
txt_numeroHijos,
txt_apellidoMaterno,
txt_apellidoPaterno,
txt_segundoNombre,
txt_primerNombre,
txt_dni;

function load(){


	var btnUpdate= new getObj('btn_actualizar');
	if(btnUpdate.obj){
		btnUpdate.obj.onclick=doEjecutarConfirm;
		btnUpdate.obj.action="clientes.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado actualizar los datos del cliente,\n desea continuar?';
		btnUpdate.obj.validator=v;
	}
	
	
	var btnGuardar = new getObj('btn_guardar');
	if(btnGuardar.obj){
		btnGuardar.obj.onclick=doEjecutarConfirm;
		btnGuardar.obj.action="clientes.htm";
		btnGuardar.obj.metodo="doSave";
		btnGuardar.obj.msg='Se ha solicitado guardar los datos del cliente,\n desea continuar?';
		btnGuardar.obj.validator=v;
		//btnGuardar.obj.sub=false;
	}

	var btnCancelar = new getObj('btn_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doEjecutarConfirm;
		btnCancelar.obj.action="clientes.htm";
		btnCancelar.obj.metodo="doListar";
		btnCancelar.obj.msg='Se ha solicitado cancelar,\n desea continuar?';
	}
	
	var refs= new getObjTag('label'); 
	if(refs)
		for (var i = 0; i < refs.length; i++){
			if(refs[i].obj.id){
				refs[i].obj.onclick= doEdit;
				refs[i].style.cursor='pointer';
			}
		}
	
		
	// para limpiar
	var l = {};
	var i=0;

	txtNomCli = new getObj('t_nomCli');
	if(txtNomCli.obj){l[i]=txtNomCli.obj;i++;}
	
	txtApeCli = new getObj('t_apeCli');
	if(txtApeCli.obj){l[i]=txtApeCli.obj;i++;}
	
	
	l.length=i;
	
	var btnLimpiar = new getObj('bt_limpiar');
	if(btnLimpiar.obj){
		btnLimpiar.obj.onclick=limpiar;
		btnLimpiar.obj.array=l;
	}
	
	//lsoto: 05-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: INICIO
	validarNumeroDocumentoVacio();
	//lsoto: 05-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: FIN

	
}		
	

//lsoto: 05-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: INICIO
function getRadioVal(valor) {
	//2 DNI
	//3 CE
	//4 RUC
	//7 Pasaporte
	document.getElementById("textbox_num_doc").disabled = false;
	document.getElementById("textbox_num_doc").value = "";
	
    if(valor==2){
    	document.getElementById("textbox_num_doc").maxLength = 8;
    }else if(valor==3){
    	document.getElementById("textbox_num_doc").maxLength = 16;
    }else if(valor==4){
    	document.getElementById("textbox_num_doc").maxLength = 11;
    }else{
    	document.getElementById("textbox_num_doc").maxLength = 16;
    }
    
    document.getElementById("textbox_num_doc").focus();
}

function validarNumeroDocumentoVacio() {

	document.getElementById("textbox_num_doc").disabled = true; 
	
	var radios = document.getElementsByName('tipo_doc');

	for (var i = 0; i < radios.length; i++) {
		if (radios[i].type === 'radio' && radios[i].checked) {
			document.getElementById("textbox_num_doc").disabled = false;  
			break;
		}
	}
}
//lsoto: 05-08-19: Validar la cantidad de caracteres que pueden ser ingresados en el campo de número de documento: FIN


	var a_fields = {
	"nombre" : {'l':'nombre','r':true,'f': 'alphaEsp'},
	"tipo_doc" : {'l':'Tipo de Documento','r':true,'f': 'intPos'},
	"num_doc" : {'l':'Numero de documento','r':false,'f': 'integer'},
	"correo" : {'l':'Correo','r':true,'f': 'email'}
 	},
 	d_fields = {
	"id" : {'l':'id_cliente','r':true,'f': 'unsigned'}
 	},
 	o_config = {
		'alert' : 1}

	// validator constructor call
	var v = new validator('formClienteEdit', a_fields, o_config);
	var v1 = new validator('formClienteEdit', d_fields, o_config);


