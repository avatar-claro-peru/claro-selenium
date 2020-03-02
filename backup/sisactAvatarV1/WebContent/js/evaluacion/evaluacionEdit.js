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
		btnUpdate.obj.action="evaluacion.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado guardar los datos de la evaluacion,\n desea continuar?';
		btnUpdate.obj.validator=v;
	}


	var btnCancelar = new getObj('btn_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doEjecutarConfirm;
		btnCancelar.obj.action="evaluacion.htm";
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
	
	
	
}		
	
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
	var v = new validator('formEvaluacionEdit', d_fields, o_config);
	var v1 = new validator('formEvaluacionEdit', d_fields, o_config);


