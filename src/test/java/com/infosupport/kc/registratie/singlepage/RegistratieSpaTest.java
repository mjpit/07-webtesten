
package com.infosupport.kc.registratie.singlepage;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.google.common.base.Predicate;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RegistratieSpaTest {

	private WebDriver webDriver;
	private WebDriverWait waiter;
	private JavascriptExecutor javascriptExecutor;
	@Before
	public void before() {

		//webDriver = new HtmlUnitDriver(true);

		System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver");
		ChromeOptions co = new ChromeOptions();
		co.setExperimentalOption("useAutomationExtension", false);
		co.addArguments("--start-maximized");
		co.addArguments("--headless");

		webDriver = new ChromeDriver();


		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability("ignoreProtectedModeSettings", true );
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://localhost:8080/registreer.html");
		capabilities.setCapability("allow-blocked-content", true);
		capabilities.setCapability("allowBlockedContent", true);

		System.setProperty("webdriver.ie.driver", "C:\\Users\\pit0m01\\Downloads\\IEDriverServer.exe");
		webDriver = new InternetExplorerDriver();
		webDriver.manage().window().maximize();*/



		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		waiter =  new WebDriverWait(webDriver, 5);
	}
	@After
	public void after() {
		webDriver.quit();
	}

	@Test
	public void registreer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);
		
		assertEquals("Activeer cursist", webDriver.getTitle());
		assertThat(webDriver.getTitle(), is(equalTo("Activeer cursist")));
		assertThat(webDriver.getTitle(), is(notNullValue()));
	}

	@Test
	public void activeer() throws Exception {
		String naam = Long.toString(System.currentTimeMillis());

		registreerHappyFlow(naam);

		ActiveerPage activeerPage = new ActiveerPage(webDriver);
		activeerPage.setGebruikersnaam(naam);
		activeerPage.setActievatiecode(naam);
		activeerPage.submit();
		AccountPage accountPage = new AccountPage(webDriver);

		//Variatie wait stap met javascriptExecutor
		waiter.until(webDriver1 -> {return "#account".equals(javascriptExecutor.executeScript("return currentPage();"));});
		
		assertEquals(naam, accountPage.getGebruikersNaam());

	}
	
	private void registreerHappyFlow(String naam) {
		

		webDriver.get("http://localhost:8080/registreer.html");
		
		RegistreerPage registreerPage = new RegistreerPage(webDriver);

		registreerPage.setGebruikersnaam(naam);

		registreerPage.setEmail(naam);

		registreerPage.submit();

		//Mogelijk ewait stap
		//waiter.until(ExpectedConditions.not(ExpectedConditions.titleContains("Registreer cursist")));

		//Variatie wait stap
		waiter.until(webDriver1 -> {return (!webDriver.getTitle().equals("Registreer cursist"));});


		
		
		assertEquals("Activeer cursist", webDriver.getTitle());
	}
	
	@Test
	public void legeRegistratie() throws Exception {
		webDriver.get("http://localhost:8080/registreer.html");
		RegistreerPage registreerPage = new RegistreerPage(webDriver);
		registreerPage.submit();
		
		//WebElement foutmelding = webDriver.findElement(By.className("label-important"));
		//waiter.until(ExpectedConditions.textToBePresentInElement(foutmelding, "Ongeldige registratie"));
		
		//waiter.until(registreerPage.isFoutmeldingAanwezig());
		//waiter.until(new OngeldigeRegistratie());
		String foutlabel = registreerPage.getFoutmelding();
		assertEquals("Ongeldige registratie", foutlabel);
	}
	
	/*class OngeldigeRegistratie implements Predicate<WebDriver>{
	
	public boolean apply(WebDriver webDriver) {
		WebElement foutlabel = webDriver.findElement(By.className("label-important"));
		return "Ongeldige registratie".equals(foutlabel.getText());
		
	}

	}*/
	
}
