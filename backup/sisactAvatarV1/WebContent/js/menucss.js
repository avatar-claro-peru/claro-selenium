/*
 Menu Simple en CSS
 Copyright (C) 2006 - UniversidadPeru.com
 http://www.universidadperu.com
 Se permite su uso y modificación, siempre que se mantenga esta nota en el archivo
*/

function toggle(menu)
{
document.getElementById("submenu1").style.display = 'none';
document.getElementById("submenu2").style.display = 'none';
document.getElementById("submenu3").style.display = 'none';

if (menu) {
document.getElementById(menu).style.display = 'block';
}
}


function esconder(elemento)
{
document.getElementById(elemento).style.display = 'none';
}

function mostrar(elemento)
{
document.getElementById(elemento).style.display = 'block';
}

