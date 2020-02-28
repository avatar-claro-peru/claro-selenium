package com.test.step.logic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.step.definitions.Hook;

public class TiendaVirtualLogic {

	public static WebDriver driver = Hook.getDriver();
	public static WebDriverWait wait = new WebDriverWait(TiendaVirtualLogic.driver, 120);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

}