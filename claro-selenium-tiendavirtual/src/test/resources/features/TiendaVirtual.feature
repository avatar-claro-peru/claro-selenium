@web

Feature: Iniciar sesion en Tienda Virtual de Claro
	Como usuario Avatar quiero loguearme para realizar unas pruebas automatizadas
	
	Scenario: Registrar Trackingstock
		Given el usuario ingreso a la pagina "http://localhost:9080/WebConsultarStockOnlineClaroAvatar/trackingstock"
 		When hace clic en boton Agregar
 		And rellena el formulario de Crear Trackingstock
 			| 123 | Prueba01 | 101 | 10 | 20 |
 		And hace clic en boton Guardar
 		Then Se registra correctamente