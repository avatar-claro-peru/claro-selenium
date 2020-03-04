package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

import com.test.step.logic.TiendaVirtualLogic;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TiendaVirtualSteps {

	public WebDriver driver;

	public TiendaVirtualSteps() {
		this.driver = Hook.getDriver();
	}

	@When("^hace clic en Crear una cuenta$")
	public void hace_clic_en_Crear_una_cuenta() throws Throwable {
		TiendaVirtualLogic.clickCrearCuenta();
	}

	@When("^ingresa sus datos personales$")
	public void ingresa_sus_datos_personales(DataTable dt) throws Throwable {
		TiendaVirtualLogic.completeDatosPersonales(dt);
	}

	@When("^ingresa sus datos de la cuenta$")
	public void ingresa_sus_datos_de_la_cuenta(DataTable dt) throws Throwable {
		TiendaVirtualLogic.completeDatosCuenta(dt);
	}

	@When("^hace clic en boton Crear cuenta$")
	public void hace_clic_en_boton_Crear_cuenta() throws Throwable {
		TiendaVirtualLogic.clickCrearCuentaButton();
		Thread.sleep(3000);
	}
	
	@When("^hace clic en ícono Usuario Perfil$")
	public void hace_clic_en_ícono_Usuario_Perfil() throws Throwable {
		TiendaVirtualLogic.clickPerfilButton();
	}

	@When("^selecciona opcion Mi cuenta$")
	public void selecciona_opcion_Mi_cuenta() throws Throwable {
		TiendaVirtualLogic.clickMiCuenta();
	}

	@When("^hace clic en menú Historial de pedidos$")
	public void hace_clic_en_menú_Historial_de_pedidos() throws Throwable {
		TiendaVirtualLogic.clickMenuHistorialPedidos();
	}

	@Then("^Se muestra todos los pedidos$")
	public void se_muestra_todos_los_pedidos() throws Throwable {
	    driver.quit();
	}
	
	@When("^hace clic en ícono Usuario$")
	public void hace_clic_en_ícono_Usuario() throws Throwable {
		TiendaVirtualLogic.clickUserButton();
	}

	@When("^ingresa credenciales en login$")
	public void ingresa_credenciales_en_login(DataTable dt) throws Throwable {
		TiendaVirtualLogic.completeLoginForm(dt);
	}

	@When("^hace clic en boton Inicia sesion$")
	public void hace_clic_en_boton_Inicia_sesion() throws Throwable {
		TiendaVirtualLogic.clickOnLoginButton();
	}

	@When("^selecciona equipo$")
	public void selecciona_equipo() throws Throwable {
		TiendaVirtualLogic.clickImagenEquipo();
	}

	@When("^selecciona modalidad$")
	public void selecciona_modalidad() throws Throwable {
		TiendaVirtualLogic.seleccionarModalidad();
	}

	@When("^hace clic en boton Agregar al carrito$")
	public void hace_clic_en_boton_Agregar_al_carrito() throws Throwable {
		TiendaVirtualLogic.clickAddCarrito();
	}

	@When("^hace clic en boton Ir al carrito$")
	public void hace_clic_en_boton_Ir_al_carrito() throws Throwable {
		TiendaVirtualLogic.clickGoCarrito();
	}

	@When("^hace clic en boton Continuar$")
	public void hace_clic_en_boton_Continuar() throws Throwable {
		TiendaVirtualLogic.clickContinuar();
	}

	@When("^indica el lugar a utilizar la linea$")
	public void indica_el_lugar_a_utilizar_la_linea() throws Throwable {
		TiendaVirtualLogic.completaInfoCompra();
	}

	@When("^indica el direccion de entrega$")
	public void indica_el_direccion_de_entrega() throws Throwable {
		TiendaVirtualLogic.clickCentroPoblado(); 
	}

	@When("^hace clic en boton Seleccionar$")
	public void hace_clic_en_boton_Seleccionar() throws Throwable {

	}

	@When("^acepta el uso de datos personales$")
	public void acepta_el_uso_de_datos_personales() throws Throwable {

	}

	@When("^hace clic en boton Finalizar pedido$")
	public void hace_clic_en_boton_Finalizar_pedido() throws Throwable {

	}

	@Then("^Se realiza compra correctamente$")
	public void se_realiza_compra_correctamente() throws Throwable {

	}
}