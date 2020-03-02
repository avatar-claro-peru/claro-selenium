
window.onload =load;	
	
// varib limpiar
	
var txtCodigo,txtNombre;

function load(){
		
	var btnUpdate= new getObj('btn_actualizar');
	if(btnUpdate.obj){
		btnUpdate.obj.onclick=doEjecutarConfirmPopup;
		btnUpdate.obj.action="parametro.htm";
		btnUpdate.obj.target="searchParametro";
		btnUpdate.obj.metodo="doUpdateField";
		btnUpdate.obj.msg='Se ha solicitado actualizar un Campo del Parametro,\n desea continuar?';
		btnUpdate.obj.validator=v;
		
	}
	
	var btnCancelar = new getObj('btn_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doCancel;
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
	
	
	function doEjecutarConfirmPopup(){
		var b;
		if(this.validator)
			b=this.validator.exec();
		else
			b=true;
		
		if (b){
			if(confirm(this.msg)){
				var objForm = document.forms[0];
				objForm.metodo.value = this.metodo;
				objForm.action = this.action;
				objForm.target = this.target;
				objForm.submit();
				//if (window.opener && !window.opener.closed) {	
				window.close();
				//}
			}
		}
		else{
			return false;
		}
		
	}
	
}	

	
	var a_fields = {
	"nombre" : {'l':'Nombre del Parámetro','r':true,'f': 'nomb'}
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
	var v = new validator('formParametroEdit', a_fields, o_config);
	var v1 = new validator('formParametroEdit', d_fields, o_config);
	var v5 = new validator('formParametroEdit', c_fields, o_config);


