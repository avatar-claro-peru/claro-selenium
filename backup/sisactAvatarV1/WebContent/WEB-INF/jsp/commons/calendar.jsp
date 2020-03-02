<html>
<head>
<LINK HREF="<%= request.getContextPath() %>/theme/ing.css" REL="stylesheet" TYPE="text/css">
<title>Ingrese la fecha</title>
<script language="JavaScript">
<!--
// AUTHOR:       Unknown
// MODIFIED BY:  Robert W. Husted
// COMPANY:      Netscape Communications

var styleFlag;

function setDate() {

    styleFlag = document.calControl.style?1:0;
    this.dateField   = opener.dateField;
    this.inDate      = dateField.value;

    var now   = new Date();
    var day   = now.getDate();
    var month = now.getMonth();
    var year  = now.getFullYear();

    if (inDate.indexOf("-")) {
	    var inYear = inDate.substring(0,inDate.indexOf("-"));
	    if (inYear.substring(0,1) == "0" && inYear.length > 1)
		    inYear = inYear.substring(1,inYear.length);
	    inYear = parseInt(inYear);

	    var inMonth   = inDate.substring(inDate.indexOf("-") + 1, inDate.lastIndexOf("-"));
		    if (inMonth.substring(0,1) == "0" && inMonth.length > 1)
			    inMonth = inMonth.substring(1,inMonth.length);
		    inMonth = parseInt(inMonth);

	    var inDay  = parseInt(inDate.substring(inDate.lastIndexOf("-") + 1, inDate.length));
	    if (inDay){
		day = inDay;
	    }
	    if (inMonth){
		month = inMonth-1;
	    }
	    if (inYear){
		year = inYear;
	    }
    }
    this.focusDay = day;
    document.calControl.month.selectedIndex = month;
    document.calControl.year.value = year;
    displayCalendar(day, month, year);
   }

function setDateSlash() {
    styleFlag = document.calControl.style?1:0;
    this.dateField   = null;
    this.inDate      = "";
	if (window.opener && !window.opener.closed) {
	    this.dateField   = window.opener.dateField;
	    this.inDate      = dateField.value;
	}

    var now   = new Date();
    var day   = now.getDate();
    var month = now.getMonth();
    var year  = now.getFullYear();

    if (inDate.indexOf("/")) {

		var inDay = inDate.substring(0,inDate.indexOf("/"));
	    if (inDay.substring(0,1) == "0" && inDay.length > 1)
		    inDay = inDay.substring(1,inDay.length);
	    inDay = parseInt(inDay);

	    var inMonth   = inDate.substring(inDate.indexOf("/") + 1, inDate.lastIndexOf("/"));
		    if (inMonth.substring(0,1) == "0" && inMonth.length > 1)
			    inMonth = inMonth.substring(1,inMonth.length);
		    inMonth = parseInt(inMonth);

	    var inYear  = parseInt(inDate.substring(inDate.lastIndexOf("/") + 1, inDate.length));

	    if (inDay){
		day = inDay;
	    }
	    if (inMonth){
		month = inMonth-1;
	    }
	    if (inYear){
		year = inYear;
	    }
    }
    this.focusDay = day;
    document.calControl.month.selectedIndex = month;
    document.calControl.year.value = year;
    displayCalendar(day, month, year);
  }

function setToday() {
    var now   = new Date();
    var day   = now.getDate();
    var month = now.getMonth();
    var year  = now.getFullYear();

    this.focusDay = day;
    document.calControl.month.selectedIndex = month;
    document.calControl.year.value = year;
    displayCalendar(day, month, year);
    }
function isFourDigitYear(year) {
    if (year.length != 4) {
    alert ("Lo siento, el año debe de ser de 4 dígitos de longitud.");
    document.calControl.year.select();
    document.calControl.year.focus();
    }
    else {return true;
    }
    }
function selectDate() {
    var year  = document.calControl.year.value;
    if (isFourDigitYear(year)) {
    var day   = 0;
    var month = document.calControl.month.selectedIndex;
    displayCalendar(day, month, year);
    }
}
function setPreviousYear() {
    var year  = document.calControl.year.value;
    if (isFourDigitYear(year)) {
    var day   = 0;
    var month = document.calControl.month.selectedIndex;
    year--;
    document.calControl.year.value = year;
    displayCalendar(day, month, year);
    }
}
function setPreviousMonth() {
    var year  = document.calControl.year.value;
    if (isFourDigitYear(year)) {
    var day   = 0;
    var month = document.calControl.month.selectedIndex;
    if (month == 0) {
    month = 11;
    if (year > 1000) {
    year--;
    document.calControl.year.value = year;
    }
    }
    else {
    month--;
    }
    document.calControl.month.selectedIndex = month;
    displayCalendar(day, month, year);
    }
}
function setNextMonth() {
var year  = document.calControl.year.value;
if (isFourDigitYear(year)) {
var day   = 0;
var month = document.calControl.month.selectedIndex;
if (month == 11) {
month = 0;
year++;
       document.calControl.year.value = year;
        }
        else {
        month++;
        }
        document.calControl.month.selectedIndex = month;
        displayCalendar(day, month, year);
    }
}
function setNextYear() {
    var year  = document.calControl.year.value;
    if (isFourDigitYear(year)) {
    var day   = 0;
    var month = document.calControl.month.selectedIndex;
    year++;
    document.calControl.year.value = year;
    displayCalendar(day, month, year);
    }
}
function displayCalendar(day, month, year) {
    day     = parseInt(day);
    month   = parseInt(month);
    year    = parseInt(year);
    var i   = 0;
    var now = new Date();
    if (day == 0) {
    var nowDay = now.getDate();
    }
    else {
    var nowDay = day;
    }
    var days         = getDaysInMonth(month+1,year);
    var firstOfMonth = new Date (year, month, 1);
    var startingPos  = firstOfMonth.getDay();
    days += startingPos;

//MAKE BEGINNING NON-DATE BUTTONS BLANK
    for (i = 0; i < startingPos; i++) {
        document.calButtons.elements[i].value = "   ";
        if (styleFlag) document.calButtons.elements[i].style.visibility="hidden";
    }
    // SET VALUES FOR DAYS OF THE MONTH
    for (i = startingPos; i < days; i++)
    {
     document.calButtons.elements[i].value = i-startingPos+1;
     document.calButtons.elements[i].onClick = "returnDate"
     if (styleFlag) document.calButtons.elements[i].style.visibility="visible";
    }
    // MAKE REMAINING NON-DATE BUTTONS BLANK
    for (i=days; i<42; i++)  {
        document.calButtons.elements[i].value = "   ";
        if (styleFlag) document.calButtons.elements[i].style.visibility="hidden";
    }
    // GIVE FOCUS TO CORRECT DAY
    document.calButtons.elements[focusDay+startingPos-1].focus();
}
// GET NUMBER OF DAYS IN MONTH
function getDaysInMonth(month,year)  {
var days;
if (month==1 || month==3 || month==5 || month==7 || month==8 ||
month==10 || month==12)  days=31;
else if (month==4 || month==6 || month==9 || month==11) days=30;
else if (month==2)  {
if (isLeapYear(year)) {days=29;}
else {
days=28;
}
}
return (days);
}
// CHECK TO SEE IF YEAR IS A LEAP YEAR
function isLeapYear (Year) {
    if (((Year % 4)==0) && ((Year % 100)!=0) || ((Year % 400)==0)) {
    return (true);
    }
    else {
    return (false);
    }
}

// SET FORM FIELD VALUE TO THE DATE SELECTED
function returnDate(inDay){

	var day   = inDay;
	var month = (document.calControl.month.selectedIndex)+1;
	var year  = document.calControl.year.value;
	
	if ((""+month).length == 1){
		month="0"+month;
	}
	if ((""+day).length == 1){
		day="0"+day;
	}
	
	if (day != "   ") {
		//dateField.value = year + "-" + month + "-" + day;
		if (window.opener && !window.opener.closed) {
			opener.doCalendarFecha(day + "/" + month + "/" + year);
			window.close();
		}
		window.close();
	}
}

// -->
</script>
</head>
<body class="body1" bgcolor="#FFFFFF" onload="setToday()" text="#000088" link="#CC3333">
<center>
<form name="calControl" onSubmit="return false;">
<table border="0" >
      
<tr><td colspan=7>
<center>
<select name="month" onChange='selectDate()' style="font-family: Verdana; font-size: 8pt; color: #000066; font-weight: bold">
<option>Enero</option>
<option>Febrero</option>
<option>Marzo</option>
<option>Abril</option>
<option>Mayo</option>
<option>Junio</option>
<option>Julio</option>
<option>Agosto</option>
<option>Setiembre</option>
<option>Octubre</option>
<option>Noviembre</option>
<option>Diciembre</option>
</select>
<input name="year" type=text size=4 maxlength=4 onChange="selectDate()" readonly style="font-family: Verdana; font-size: 8pt; color: #000066; font-weight: bold; border: 1 solid #C0C0C0">
</center>
</td>
</tr>
<tr>
<td colspan=7>

<input type=button name="previousYear" class="day" value='&lt;&lt;'    onClick="setPreviousYear()" style="width:26px">
<input type=button name="previousYear" class="day" value=' &lt; '   onClick="setPreviousMonth()" style="width:26px">
<input type=button name="previousYear" class="day" value="Hoy" onClick="setToday()" style="width:35px">
<input type=button name="previousYear" class="day" value=" > "   onClick="setNextMonth()" style="width:26px">
<input type=button name="previousYear" class="day" value=">>"    onClick="setNextYear()" style="width:26px">

</td>
</tr>
</table>
</form><form name="calButtons"> 
<table border="1" bordercolor="#FF6600" cellspacing="0" cellpadding="0" style="font-family: Verdana; font-size: 8pt; font-weight: bold; color: #FF6600; padding: 0" bordercolorlight="#FF6600" bordercolordark="#FFFFFF">
<tr>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Do</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Lu</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Ma</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Mi</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Ju</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Vi</b></font></center></td>
<td><center><font size=-1 face="Arial,Helv,Helvetica" color="#ff6600"><b>Sa</b></font></center></td></tr>
<tr>
<td><input type="button" name="but0" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but1" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but2" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but3" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but4" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but5" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but6" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td></tr>
<tr>
<td><input type="button" name="but7" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but8" class="day" value="    " onClick="returnDate(this.value)" style="width:24px" width=22></td>
<td><input type="button" name="but9" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but10" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but11" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but12" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but13" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td></tr>
<tr>
<td><input type="button" name="but14" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but15" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but16" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but17" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but18" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but19" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but20" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td></tr>
<tr>
<td><input type="button" name="but21" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but22" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but23" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but24" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but25" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but26" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but27" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td></tr>
<tr>
<td><input type="button" name="but28" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but29" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but30" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but31" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but32" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but33" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but34" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td></tr>
<tr>
<td><input type="button" name="but35" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but36" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but37" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but38" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but39" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but40" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
<td><input type="button" name="but41" class="day" value="    " onClick="returnDate(this.value)" style="width:22px" width=22></td>
</tr>


</table>
</form>

</center></body>

</html>