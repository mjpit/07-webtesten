package com.infosupport.kc.registratie.singlepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveerPage  extends PageBase{

	@FindBy(name = "activatieGebruikersnaam")
	private WebElement gebruikersnaam;

	@FindBy(name = "activatiecode")
	private WebElement actievatiecode;

	@FindBy(id = "activeer")
	private WebElement submit;



	public ActiveerPage(WebDriver webDriver) {
		super(webDriver);

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
