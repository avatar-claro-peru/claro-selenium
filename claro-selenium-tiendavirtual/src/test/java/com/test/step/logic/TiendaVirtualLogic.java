package com.test.step.logic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

import cucumber.api.DataTable;

public class TiendaVirtualLogic {

	public static WebDriver driver = Hook.getDriver();
	public static WebDriverWait wait = new WebDriverWait(TiendaVirtualLogic.driver, 120);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static void clickUserButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("Header_GlobalLogin_signInQuickLink"));
		button.click();
	}

	public static void completeLoginForm(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement id = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
		WebElement pass = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));

		id.sendKeys(dat.get(0).get(0));
		pass.sendKeys(dat.get(0).get(1));
	}

	public static void clickOnLoginButton() throws InterruptedException {
			WebElement button = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_links_2"));
			button.click();
			Thread.sleep(5000);
	}

	public static void clickImagenEquipo() throws InterruptedException {
		WebElement button = driver.findElement(By.id("catalogEntry_img24596"));
		button.click();
		Thread.sleep(5000);
	}

	public static void seleccionarModalidad() throws InterruptedException {
		WebElement button = driver.findElement(By.id("conditionModality"));
		button.findElement(By.xpath("//option[@class ='Prepago Linea nueva']")).click();
		Thread.sleep(5000);
	}

	public static void clickAddCarrito() throws InterruptedException {
		WebElement button = driver.findElement(By.id("productPageAdd2Cart"));
		button.click();
		Thread.sleep(5000);
		
	}

	public static void clickGoCarrito() throws InterruptedException {
		WebElement button = driver.findElement(By.id("GotoCartButton2"));
		button.click();
		Thread.sleep(5000);
	}

	public static void clickContinuar() throws InterruptedException {
		WebElement button = driver.findElement(By.id("shopcartCheckout"));
		button.click();
		Thread.sleep(5000);
	}

	public static void completaInfoCompra() throws InterruptedException {
		WebElement button = driver.findElement(By.id("departamentoSelections"));
		button.findElement(By.xpath("//option[@class ='AMAZONAS']")).click();
		Thread.sleep(3000);
		
		WebElement button2 = driver.findElement(By.id("provinceClaroSelections"));
		button2.findElement(By.xpath("//option[@class ='ABANCAY']")).click();
		Thread.sleep(3000);
		
		WebElement button3 = driver.findElement(By.id("distritoClaroSelections"));
		button3.findElement(By.xpath("//option[@class ='ABANCAY']")).click();
		Thread.sleep(3000);
		
		WebElement button4 = driver.findElement(By.id("centroPobladoClaroSelections"));
		button4.findElement(By.xpath("")).click();
		Thread.sleep(3000);
	}

	public static void clickCentroPoblado() {
		// TODO Auto-generated method stub
		
	}

	public static void clickCrearCuenta() throws InterruptedException {
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_links_3"));
		button.click();
	}

	public static void completeDatosPersonales(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement nombres = driver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1"));
		WebElement apePaterno = driver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1"));
		WebElement apeMaterno = driver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_middleName_1"));
		WebElement tipoDocumento = driver.findElement(By.id("demographicField6"));
		WebElement nroDocumento = driver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_demographicField7_In_Register_1"));
		WebElement telPrincipal = driver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1"));
		
		nombres.sendKeys(dat.get(0).get(0));
		apePaterno.sendKeys(dat.get(0).get(1));
		apeMaterno.sendKeys(dat.get(0).get(2));
		tipoDocumento.sendKeys("DNI");
		tipoDocumento.click();
		Thread.sleep(3000);
		nroDocumento.sendKeys(dat.get(0).get(3));
		telPrincipal.sendKeys(dat.get(0).get(4));
	}
	
	public static void completeDatosCuenta(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement correo = driver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1"));
		WebElement pass = driver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1"));
		WebElement confirmPass = driver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1"));
		
		correo.sendKeys(dat.get(0).get(0));
		pass.sendKeys(dat.get(0).get(1));
		confirmPass.sendKeys(dat.get(0).get(2));
	}

	public static void clickCrearCuentaButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("WC_UserRegistrationAddForm_links_1"));
		button.click();
		Thread.sleep(3000);
	}
	
	public static void clickMiCuenta() throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("//*[@class = 'panel loggedInContractSelectPanel']")).findElement(By.id("myAccountQuickLink"));
		button.click();
	}

	public static void clickMenuHistorialPedidos() throws InterruptedException {
		WebElement button = driver.findElement(By.id("li_MyAccount_8"));
		button.click();
		Thread.sleep(6000);
	}

	public static void clickPerfilButton() throws InterruptedException {
		WebElement button = driver.findElement(By.id("Header_GlobalLogin_signOutQuickLinkUser"));
		button.click();
	}

}