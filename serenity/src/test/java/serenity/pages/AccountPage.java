package serenity.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends PageBase{



	@FindBy (css="body > div > h1")
	private  WebElement accountmelding;


	private WebDriver webDriver;
	private JavascriptExecutor javascriptExecutor;

	public AccountPage(WebDriver webDriver) {
		super(webDriver);
		javascriptExecutor = (JavascriptExecutor) webDriver;



	}
	

	
	public String getGebruikersNaam(){
        return accountmelding.getText().replace("Welkom ", "");
	}



	public ExpectedCondition<Boolean> isAccountPageTitle() {
		return ExpectedConditions.titleIs("Account page");
		
	}


}
