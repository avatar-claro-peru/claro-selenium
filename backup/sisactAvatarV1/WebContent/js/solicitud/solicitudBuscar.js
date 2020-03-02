window.onload =load;	

var txt_dni,txt_primerNombre,txt_segundoNombre,txt_apellidoPaterno,txt_apellidoMaterno;

function load(){
	
	var btnLimpiar = document.getElementById("btn_limpiar");
	btnLimpiar.onclick = function() {fnLimpiar()};
	
	function fnLimpiar(){
		document.getElementById("txtClienteDniId").value="";
		document.getElementById("txtTelefonoId").value="";
	}
	
	var btnSearch = new getObj('btn_buscar');
	if(btnSearch.obj){
		btnSearch.obj.onclick=doEjecutar;
		btnSearch.obj.action="solicitud.htm";
		btnSearch.obj.metodo="doBuscar";
		btnSearch.obj.sub=true;
		btnSearch.obj.validator=v;
	}
		
	var btnCancel = new getObj('btn_cancel');
	if(btnCancel.obj)btnCancel.obj.onclick=doCancel;
	
		// para limpiar
	var l = {};
	var i=0;

	txt_dni = new getObj('t_dni');
	if(txt_dni.obj){l[i]=txt_dni.obj;i++;}
	
	l.length=i;
		
}
	
	var a_fields = {'id' : {'l': 'id','r': false,'f': 'intPos'}
				}
		o_config = {'alert' : 1	}

	// validator constructor call
	var v = new validator('formSolicitudBuscar', a_fields, o_config);

