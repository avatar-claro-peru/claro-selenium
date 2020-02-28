package com.test.step.logic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

import cucumber.api.DataTable;

public class StockOnlineLogic {

	public static WebDriver driver2 = Hook.getDriver();
	public static WebDriverWait wait2 = new WebDriverWait(StockOnlineLogic.driver2, 120);
	public static JavascriptExecutor js2 = (JavascriptExecutor) driver2;

	public static void clickAddButton() throws InterruptedException {
		WebElement button = driver2.findElement(By.id("btnAgregar"));
		button.click();
		Thread.sleep(4000);
	}

	public static void completeStockFormRegister(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement codigo = driver2.findElement(By.id("txtCodigo"));
		WebElement desLog = driver2.findElement(By.id("txtDesLog"));
		WebElement nroLog = driver2.findElement(By.id("txtNroLog"));
		WebElement stockMaterial = driver2.findElement(By.id("txtStockMaterial"));
		WebElement stockChip = driver2.findElement(By.id("txtStockMaterialChip"));

		codigo.sendKeys(dat.get(0).get(0));
		desLog.sendKeys(dat.get(0).get(1));
		nroLog.sendKeys(dat.get(0).get(2));
		stockMaterial.sendKeys(dat.get(0).get(3));
		stockChip.sendKeys(dat.get(0).get(4));
	}

	public static void clickSaveButton() throws InterruptedException {
		WebElement button = driver2.findElement(By.id("btnGuardar"));
		button.click();
		Thread.sleep(4000);
	}

	public static void clickEditButton(DataTable data) throws InterruptedException {
		Thread.sleep(4000);
		List<List<String>> dat = data.raw();
		WebElement button = null;

		for (int i = 1; i < 100; i++) {
			String id = driver2.findElement(By.id("tbl_trackingstock")).findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
			
			if (id.equalsIgnoreCase(dat.get(0).get(0))) {
				button = driver2.findElement(By.id("tbl_trackingstock")).findElement(By.xpath("//tbody/tr[" + i +"]/td[7]")).findElement(By.id("btnEditar"));
				break;
			}
		}
		button.click();		
	}

	public static void completeStockFormUpdate(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement desLog = driver2.findElement(By.id("frm_update")).findElement(By.id("txtDesLog"));
		WebElement nroLog = driver2.findElement(By.id("frm_update")).findElement(By.id("txtNroLog"));
		WebElement stockMaterial = driver2.findElement(By.id("frm_update")).findElement(By.id("txtStockMaterial"));
		WebElement stockChip = driver2.findElement(By.id("frm_update")).findElement(By.id("txtStockChip"));

		desLog.clear();
		desLog.sendKeys(dat.get(0).get(0));
		nroLog.clear();
		nroLog.sendKeys(dat.get(0).get(1));
		stockMaterial.clear();
		stockMaterial.sendKeys(dat.get(0).get(2));
		stockChip.clear();
		stockChip.sendKeys(dat.get(0).get(3));
	}

	public static void clickUpdateButton() throws InterruptedException {
		WebElement button = driver2.findElement(By.id("btnActualizar"));
		button.click();
		Thread.sleep(4000);
	}

	public static void clickDeleteButton(DataTable data) throws InterruptedException {
		List<List<String>> dat = data.raw();
		WebElement button = null;

		for (int i = 1; i < 100; i++) {
			String id = driver2.findElement(By.id("tbl_trackingstock")).findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
			
			if (id.equalsIgnoreCase(dat.get(0).get(0))) {
				button = driver2.findElement(By.id("tbl_trackingstock")).findElement(By.xpath("//tbody/tr[" + i +"]/td[7]")).findElement(By.id("btnEliminar"));
				break;
			}
		}
		
		button.click();
	}

}