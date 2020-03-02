
window.onload =load;	
	
// varib limpiardd
	
var txtCodigo,txtNombre;
 
function load(){
		
	var btnUpdate= new getObj('btn_actualizar');
	if(btnUpdate.obj){
		btnUpdate.obj.onclick=doEjecutarConfirm;
		btnUpdate.obj.action="perfil.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado actualizar el Usuario,\n desea continuar?';
	}
	
	
	var btnGuardar = new getObj('btn_guardar');
	if(btnGuardar.obj){
		btnGuardar.obj.onclick=doEjecutarConfirm;
		btnGuardar.obj.action="perfil.htm";
		btnGuardar.obj.metodo="doSave";
		btnGuardar.obj.msg='Se ha solicitado guardar un Usuario,\n desea continuar?';
		btnGuardar.obj.validator=v;
		btnGuardar.obj.sub=false;
	}

	var btnCancelar = new getObj('btn_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doEjecutar;
		btnCancelar.obj.action="perfil.htm";
		btnCancelar.obj.metodo="doListar"; 
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

	txtNombre = new getObj('t_nombre');
	if(txtNombre.obj){l[i]=txtNombre.obj;i++;}
	
	
	var btnLimpiar = new getObj('bt_limpiar');
	if(btnLimpiar.obj){
		btnLimpiar.obj.onclick=limpiar;
		btnLimpiar.obj.array=l;
	}
	
}	

	
	var a_fields = {
	"nombre" : {'l':'nombre','r':true,'f': 'nomb'}
 	},
 	c_fields = {
	"nombre" : {'l':'Nombre del Tipo de Cliente','r':true,'f': 'alphaEsp'},
	"descripcion" : {'l':'Descripcion del Tipo del Cliente','r':true,'f': 'alphaEsp'},
	"cantidasLibrosPermitido" : {'l':'Cantidad de Libros Permitidos','r':true,'f': 'intPos'},
	"diasPrestamo" : {'l':'Dias de prestamo','r':true,'f': 'intPos'},
	"diasCastigo" : {'l':'Dias de castigo ','r':true,'f': 'intPos'},
	"modalidad.id" : {'l':'Modalidad','r':true,'f': 'intPos'},
	"estadoReserva" : {'l':'Estado de la Reserva','r':true,'f': 'intPos'}
	
 	},
 	d_fields = {
	"id" : {'l':'id_tipo_cliente','r':true,'f': 'unsigned'}
 	},
 	o_config = {
		'alert' : 1}

	// validator constructor call
	var v = new validator('formPerfilEdit', a_fields, o_config);
	var v1 = new validator('formPerfilEdit', d_fields, o_config);
	var v5 = new validator('formPerfilEdit', c_fields, o_config);


