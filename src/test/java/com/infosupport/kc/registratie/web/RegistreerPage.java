package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistreerPage {
	
	@FindBy(name = "registratieGebruikersnaam")
	private WebElement gebruikersnaam;
	
	@FindBy(name = "registratieEmail")
	private WebElement inputEmail;
	
	@FindBy(id = "registreer")
	private WebElement submit;

	@FindBy(className = "label-important" )
	private WebElement foutmelding;
	
	private WebDriver webDriver;
	
	public RegistreerPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void submit() {
		submit.submit();		
	}

	public String getFoutmelding() {

		return foutmelding.getText();
	}
}
