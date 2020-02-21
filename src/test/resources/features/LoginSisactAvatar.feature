@web

Feature: Iniciar sesion en Sisac Avatar 
	Como usuario Avatar quiero loguearme para realizar unas pruebas automatizadas
	
	Scenario: Buscar cliente
		Given el usuario ingreso a la pagina "http://localhost:7070/sisactAvatar/login.htm"
 		When ingresa credenciales en login
 			| administrador | admin |
 		And hace clic en boton ingresar
 		And selecciona la opcion Clientes
 		
 		Given hace clic en boton Agregar Cliente
 		And rellena el formulario de cliente
 			| pedro carranza | 47498487 | jLinares@gmail.com |
 		And hace clic en boton Guardar
 		Then se realiza la operacion correctamente
