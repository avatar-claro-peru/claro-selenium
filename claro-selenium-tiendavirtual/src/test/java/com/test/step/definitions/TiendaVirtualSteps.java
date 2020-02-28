package com.test.step.definitions;

import org.openqa.selenium.WebDriver;

public class TiendaVirtualSteps {

	public WebDriver driver;

	public TiendaVirtualSteps() {
		this.driver = Hook.getDriver();
	}

}