package serenity.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("localhost:8080/registreer.html")
public class RegistreerPage extends PageObject {
	
	@FindBy(name = "registratieGebruikersnaam")
	private WebElement gebruikersnaam;
	
	@FindBy(name = "registratieEmail")
	private WebElement inputEmail;
	
	@FindBy(id = "registreer")
	private WebElement submit;

	@FindBy(className = "label-important" )
	private WebElement foutmelding;
	


	//private WebDriverWait wait;

	/*public RegistreerPage(WebDriver webDriver) {
		super(webDriver);
		wait = new WebDriverWait(webDriver, 5);

	}*/
	

	
	public void setGebruikersnaam(String naam) {
		gebruikersnaam.sendKeys(naam);
	}
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void submit() {
		submit.submit();
		waitFor(webDriver1 -> {
			return (!getTitle().equals("Registreer cursist")  || getFoutmelding().equals("Ongeldige registratie") );

		} );
	}



	/*private Predicate<WebDriver> submitGedaan() {
		return new Predicate<WebDriver>() {
			
			@Override
			public boolean apply(WebDriver input) {
				
				return isFoutmeldingAanwezig().apply(input) || isNietMeerZichtbaar().apply(input);
			}
		};
	}*/

	public String getFoutmelding() {

		return foutmelding.getText();
	}


}
