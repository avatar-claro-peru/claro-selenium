package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

import com.test.step.logic.StockOnlineLogic;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StockOnlineSteps {

	public WebDriver driver2;

	public StockOnlineSteps() {
		this.driver2 = Hook.getDriver();
	}

	@When("^hace clic en boton Agregar$")
	public void hace_clic_en_boton_Agregar() throws Throwable {
		StockOnlineLogic.clickAddButton();
	}

	@And("^rellena el formulario de Crear Trackingstock$")
	public void rellena_el_formulario_de_Crear_Trackingstock(DataTable dt) throws Throwable {
		StockOnlineLogic.completeStockFormRegister(dt);
	}

	@And("^hace clic en boton Guardar$")
	public void hace_clic_en_boton_Guardar() throws Throwable {
		StockOnlineLogic.clickSaveButton();
	}

	@Then("^Se registra correctamente$")
	public void se_registra_correctamente() throws Throwable {
//		Thread.sleep(4000);
	}

	@Given("^hace clic en boton Editar$")
	public void hace_clic_en_boton_Editar(DataTable dt) throws Throwable {
		StockOnlineLogic.clickEditButton(dt);
	}

	@When("^rellena el formulario de Editar Trackingstock$")
	public void rellena_el_formulario_de_Editar_Trackingstock(DataTable dt) throws Throwable {
		StockOnlineLogic.completeStockFormUpdate(dt);
	}

	@And("^hace clic en boton Actualizar$")
	public void hace_clic_en_boton_Actualizar() throws Throwable {
		StockOnlineLogic.clickUpdateButton();
	}

	@Then("^Se actualiza correctamente$")
	public void se_actualiza_correctamente() throws Throwable {
//		Thread.sleep(4000);
	}

	@Given("^hace clic en boton Eliminar$")
	public void hace_clic_en_boton_Eliminar(DataTable dt) throws Throwable {
		StockOnlineLogic.clickDeleteButton(dt);
//		Thread.sleep(4000);
	}

	@Then("^Se elimina correctamente$")
	public void se_elimina_correctamente() throws Throwable {
//		Thread.sleep(4000);
		driver2.quit();
	}

}