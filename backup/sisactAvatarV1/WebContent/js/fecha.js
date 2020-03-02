date=new Date();

function mois() {
	argnr = mois.arguments.length
	for (var i = 0; i < argnr; i++)
	this[i+1] = mois.arguments[i]
		    		}
	var isnMonths= new mois("enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre");
	var jours= new mois("domingo","lunes","martes","mi&#233;rcoles","jueves","viernes","s&#225;bado");
	
	browserName = navigator.appName;
	browserVer = parseInt(navigator.appVersion);
    if (browserName == "Netscape" && browserVer >= 4 || browserName == "Microsoft Internet Explorer" && browserVer >=4) version = "nsie4";
    else version = "x";
	if (version == "nsie4"){
	
	var Digital=new Date();
	var hours=Digital.getHours();
	var minutes=Digital.getMinutes();
	
	var dn="am";
	if (hours>12){
	dn="pm";
	hours=hours-12;
	}
	if (hours==0) hours=12;
	if (minutes<=9) minutes="0"+minutes;

	document.write (jours[date.getDay() + 1]+ " " +date.getDate() + " de " + isnMonths[date.getMonth() + 1]);
//	document.write (' &nbsp; '+ date.getHours()+ ":" + date.getMinutes());
	document.write (' &nbsp; ' + hours + ":" + minutes + " " + dn);
}
