package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveerPage {

	@FindBy(name = "activatieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "activatiecode")
	private WebElement actievatiecode;

	@FindBy(id = "activeer")
	private WebElement submit;

	private WebDriver webDriver;

	public ActiveerPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}
	
	public void setActievatiecode(String naam) {
		actievatiecode.sendKeys("secret-" + naam);
	}
	
	public void submit() {
		submit.submit();		
	}

}
