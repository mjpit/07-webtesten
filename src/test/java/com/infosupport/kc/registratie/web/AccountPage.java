package com.infosupport.kc.registratie.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {



	@FindBy (css="body > div > h1")
	private  WebElement accountmelding;


	private WebDriver webDriver;

	public AccountPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	

	
	public String getGebruikersNaam(){
		return accountmelding.getText().replace("Welkom ", "");
	}

}
