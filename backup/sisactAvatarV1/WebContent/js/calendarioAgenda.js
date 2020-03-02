var idContenedor = "miCalendario" //id del contenedor donde se insertarï¿½ el calendario
var idCampofecha = "fechaCalendario" //id para el campo donde se mostrarï¿½ la fecha
var fSalidaNombreMes = false //true escribe el mes por su nombre; false por su nï¿½mero
var fMesAbreviado = true // abrevia el nombre del mes a sus 3 primeras letras
var separadorFecha = "/" //separador para la fecha de salida
var calendarioCursor = 'pointer'
var calendarioPaddingCelda = 3; //Corrige la posiciï¿½n del cuadro que marca el dï¿½a seleccionado en caso de haberse aplicado un padding a las celdas

/*No tocar nada a partir de aquï¿½ */
var hoy = new Date()
var mes = hoy.getMonth()
var dia = 1
var anio = hoy.getFullYear()
var diasSemana = new Array ('L','M','M','J','V','S','D')
var meses = new Array('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre')
var tunIex=navigator.appName=="Microsoft Internet Explorer"?true:false;
if(tunIex && navigator.userAgent.indexOf('Opera')>=0){tunIex = false}
tunOp = navigator.userAgent.indexOf('Opera')>=0 ? true: false;
var tunSel = false
var anCelda, alCelda

function tunCalendario(){
    
	dia2 = dia
	tab = document.createElement('table')
	tab.id = 'calendario'
	document.getElementById(idContenedor).appendChild(tab)
	tcabeza = document.createElement('thead')
	tab.appendChild(tcabeza)
         
	fCalendario = document.createElement('input')
	fCalendario.type = "hidden"
	fCalendario.className = "selectores"
	fCalendario.id = idCampofecha
	fCalendario.name = idCampofecha        
	fCalendario.readOnly = true
	document.getElementById(idContenedor).appendChild(fCalendario)
        fCalendario.visibility = true 
        //fCalendario.visibility = false 
        
	fi2 = document.createElement('tr')
	fi2b = document.createElement('th')
	fi2b.colSpan = 7
	fi2.id = 'mesCalendario'
	fi2b.appendChild(document.createTextNode(meses[mes] + "  -  " + anio))
	fi2.appendChild(fi2b)
	tcabeza.appendChild(fi2)
	fi = document.createElement('tr')
	tcabeza.appendChild(fi)
        // Cabecera del Calendario
        // LUN MAR MIE JUEV VIE SAB DOM
	for(m=0;m<7;m++){
	    ce = document.createElement('th')
	    ce.appendChild(document.createTextNode(diasSemana[m]))
	    fi.appendChild(ce)
	}
         
	var escribe = false
	var escribe2 = true
	fecha = new Date(anio,mes,dia)
        //alert(fecha) 
	var d = fecha.getDay()-1 
	if(d<0){d = 6}
	tcuerpo = document.createElement('tbody')
	tab.appendChild(tcuerpo)
         
	while(escribe2){
	fi = document.createElement('tr')
	co = 0
		for(t=0;t<7;t++){
			ce = document.createElement('td')
			if(escribe && escribe2){
			fecha2 = new Date(anio,mes,dia)
				if(fecha2.getMonth() != mes){escribe2 = false;}
				else{
				ce.appendChild(document.createTextNode(dia));
				dia++;
				co++;
				ce.style.cursor = calendarioCursor
				ce.onclick = marcaCalendario
				}
			}
			if(d == t && !escribe){
			ce.appendChild(document.createTextNode(dia))
			dia++;co++
			escribe = true
			ce.style.cursor = calendarioCursor
			ce.onclick = marcaCalendario
			}
			else{
			  ce.appendChild(document.createTextNode(" "))
			}
			fi.appendChild(ce)
			if(hoy.getDate()+1 == dia && mes == hoy.getMonth() && anio == hoy.getFullYear()){ce.className = "Hoy"}
		}
		
		if(co>0){tcuerpo.appendChild(fi)}
		
		}
	dia = dia2
}

function marcaCalendario(){
    
    //alert("hola");
    //return;
    
    salidaMes = mes +1
    if(fSalidaNombreMes){
            salidaMes = meses[mes] 
            if(fMesAbreviado){
              salidaMes = salidaMes.substring(0,3)
            }
    }

    //alert(salidaMes)
    /*
    var tmpfecha="";
    var fecha1 = "";
    tmpfecha = this.firstChild.nodeType == 1 ? this.firstChild.nextSibling.nodeValue : this.firstChild.nodeValue;
    tmpfecha = tmpfecha + separadorFecha + salidaMes + separadorFecha + anio
    */
    document.getElementById(idCampofecha).value = this.firstChild.nodeType == 1 ? this.firstChild.nextSibling.nodeValue : this.firstChild.nodeValue;
    document.getElementById(idCampofecha).value += separadorFecha + salidaMes + separadorFecha + anio

      //alert("#"+fecha1+"#")
    //document.getElementById(idCampofecha).value = fecha1

    // alert(document.getElementById(idCampofecha).value)  

    /*
    ceSe = document.createElement('div')
    ceSe.id = "tunSeleccionado"
    with(ceSe.style){
            borderWidth = "3px"
            borderStyle = "solid"
            borderColor = "#0000ff"
            width = this.scrollWidth  + "px"
            height = this.scrollHeight + "px"
            position = "absolute"
            zIndex = "1000"
            }
            if(tunSel){
                    tunSel.removeChild(tunSel.firstChild)
            }
    tunSel = this
    
    //this.appendChild(ceSe)
    this.insertBefore(ceSe,this.firstChild)
    with(ceSe.style){
            width = this.scrollWidth  + "px"
            marginLeft = "-" + (calendarioPaddingCelda + 1) + "px"
            marginTop = "-" + (calendarioPaddingCelda + 1) + "px"
    }
    */

      tmpfecha = document.getElementById(idCampofecha).value;
      //alert("tmpfecha:"+tmpfecha)
      ubicacion = "<%=ubicacion%>";      
      //alert("formulario:"+formulario)
      //alert("ubicacion:"+ubicacion)
      d="";
      m="";
      if(tmpfecha.length<10){
        tmp =  tmpfecha.split('/');  
        if(tmp[0].length<2){ d = "0"+tmp[0];}
        else{d = tmp[0];}
        if(tmp[1].length<2){ m = "0"+tmp[1];}
        else{m=tmp[1];}
        fecha1 = d+"/"+m+"/"+tmp[2];    
      }else{
        fecha1 = tmpfecha
      }
      //alert("fecha1:"+fecha1)
      document.getElementById('idFechaId').value=fecha1;
      prueba();
      //control = opener.document.getElementById("fin")
      //alert(control.value)
      //opener.document.getElementById(ubicacion).value=fecha1;
      //eval("opener.document."+formulario+".getElementById('"+ubicacion+"').value='"+tmpfecha+"'")
      //window.close();
}

function borra(){
	//alert("inc 5");
    document.getElementById(idContenedor).removeChild(document.getElementById('calendario'))
    //alert("inc 6:"+document.getElementById('fechaCalendario').value);
    //alert('Campo:'+idCampofecha);
    //document.getElementById(idContenedor).removeChild(document.getElementById(idCampofecha))
    //alert("inc 7");
}

function establecerFecha(){
    tunFe = new Date()
    document.getElementById('tunMes').options[tunFe.getMonth()].selected = true
    document.getElementById('tunAnio').value = tunFe.getFullYear()
}
//alert("establecer fecha")

function IncYear(){  
   //alert("inc year inicio");   
   //alert('Anio selecc:'+document.getElementById('tunAnio').value)
   var vlr = parseInt(document.getElementById('tunAnio').value,10);
   if(vlr>=9999){
     return;
   }
   //alert("inc 1");
   document.getElementById('tunAnio').value = vlr + 1;
   //alert("inc 2");
   anio=document.getElementById('tunAnio').value;
   //alert("inc 3");
   borra();tunCalendario();
  // alert("inc 4");
   //alert('inc year fin '+anio);   
}

function DecYear(){
   //alert("dec year inicio");   
   var vlr = parseInt(document.getElementById('tunAnio').value,10);      
   if(vlr<=2000){     
     return;
   }    
   document.getElementById('tunAnio').value = vlr - 1;
   anio=document.getElementById('tunAnio').value;
   borra();tunCalendario();
   //alert('dec fin '+anio);
}