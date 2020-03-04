@web

Feature: Iniciar sesion en Tienda Virtual de Claro Peru
	Como usuario Avatar quiero loguearme para realizar unas pruebas automatizadas
	
	Scenario: Registrar Usuario
		Given el usuario ingreso a la pagina "https://desarrollo.avatar.com/tienda/es/claro/celulares/todos"
		When hace clic en ícono Usuario
		And hace clic en Crear una cuenta
		And ingresa sus datos personales
 			| miguel | llamocca | campos | 44444447 | 999999997 |
 		And ingresa sus datos de la cuenta
 			| mllamocca7@avatar.com | avatar123 | avatar123 |
 		And hace clic en boton Crear cuenta
		And hace clic en ícono Usuario Perfil
 		And selecciona opcion Mi cuenta
 		And hace clic en menú Historial de pedidos
 		Then Se muestra todos los pedidos
	
	Scenario: Realizar Compra
		Given el usuario ingreso a la pagina "https://desarrollo.avatar.com/tienda/es/claro/celulares/todos"
		When hace clic en ícono Usuario
		And ingresa credenciales en login
 			| mllamocca@avatar.com | avatar123 |
 		And hace clic en boton Inicia sesion
 		And selecciona equipo
 		And selecciona modalidad
 		And hace clic en boton Agregar al carrito
 		And hace clic en boton Ir al carrito
 		And hace clic en boton Continuar
 		And indica el lugar a utilizar la linea
 		And indica el direccion de entrega
 		And hace clic en boton Seleccionar
 		And acepta el uso de datos personales
 		And hace clic en boton Finalizar pedido
 		Then Se realiza compra correctamente