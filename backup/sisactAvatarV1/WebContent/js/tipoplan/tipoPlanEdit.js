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
		btnUpdate.obj.action="tipoPlan.htm";
		btnUpdate.obj.metodo="doUpdate";
		btnUpdate.obj.msg='Se ha solicitado actualizar los datos del tipo de plan,\n desea continuar?';
		btnUpdate.obj.validator=v;
	}
	
	
	var btnGuardar = new getObj('btn_guardar');
	if(btnGuardar.obj){
		btnGuardar.obj.onclick=doEjecutarConfirm;
		btnGuardar.obj.action="tipoPlan.htm";
		btnGuardar.obj.metodo="doSave";
		btnGuardar.obj.msg='Se ha solicitado guardar los datos del tipo de plan.\n ¿Desea continuar?';
		btnGuardar.obj.validator=v;
		//btnGuardar.obj.sub=false;
	}

	var btnCancelar = new getObj('btn_cancelar');
	if(btnCancelar.obj){
		btnCancelar.obj.onclick=doEjecutarConfirm;
		btnCancelar.obj.action="tipoPlan.htm";
		btnCancelar.obj.metodo="doListar";
		btnCancelar.obj.msg='Se ha solicitado cancelar,\n desea continuar?';
	}
	
	//00218 Tope de consumo exacto
	//00219 Tope de consumo adicional
	//00220 Tope de consumo SMS
	//00221 Tope de consumo telefonía fija
	//00222 Tope de consumo regular
	//00223 Tope de consumo premium
		
	var serviceCode=document.getElementById("servCodigo").value;  

	if(serviceCode=='00218'){
	    document.getElementById("lblServiceDescription").innerText = "Tope de consumo exacto";
	    document.getElementById("servDesc").value="Tope de consumo exacto";
	}else if(serviceCode=='00219'){
	    document.getElementById("lblServiceDescription").innerText = "Tope de consumo adicional";
	    document.getElementById("servDesc").value="Tope de consumo adicional";
	}else if(serviceCode=='00220'){
		document.getElementById("lblServiceDescription").innerText = "Tope de consumo SMS";
    	document.getElementById("servDesc").value="Tope de consumo SMS";
	}else if(serviceCode=='00221'){
		document.getElementById("lblServiceDescription").innerText = "Tope de consumo telefonía fija";
    	document.getElementById("servDesc").value="Tope de consumo telefonía fija";
	}else if(serviceCode=='00222'){
		document.getElementById("lblServiceDescription").innerText = "Tope de consumo regular";
    	document.getElementById("servDesc").value="Tope de consumo regular";
	}else{
		document.getElementById("lblServiceDescription").innerText = "Tope de consumo premium";
    	document.getElementById("servDesc").value="Tope de consumo premium";
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

function setServiceDescription(valor) {
	//00218 Tope de consumo exacto
	//00219 Tope de consumo adicional
	//00220 Tope de consumo SMS
	//00221 Tope de consumo telefonía fija
	//00222 Tope de consumo regular
	//00223 Tope de consumo premium
	
    if(valor=='00218'){
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo exacto";
    	document.getElementById("servDesc").value="Tope de consumo exacto";
    }else if(valor=='00219'){
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo adicional";
    	document.getElementById("servDesc").value="Tope de consumo adicional";
    }else if(valor=='00220'){
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo SMS";
    	document.getElementById("servDesc").value="Tope de consumo SMS";
    }else if(valor=='00221'){
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo telefonía fija";
    	document.getElementById("servDesc").value="Tope de consumo telefonía fija";
    }else if(valor=='00222'){
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo regular";
    	document.getElementById("servDesc").value="Tope de consumo regular";
    }else{
    	document.getElementById("lblServiceDescription").innerText = "Tope de consumo premium";
    	document.getElementById("servDesc").value="Tope de consumo premium";
    }
}

/*	
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
*/
	// validator constructor call
	var v = new validator('formTipoPlanEdit', a_fields, o_config);
	var v1 = new validator('formTipoPlanEdit', d_fields, o_config);


