package serenity.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import serenity.steps.serenity.CursistSteps;

public class RegistreerSteps {
    CursistSteps cursist;

    @Given("^the gebruiker is op de registreer pagina$")
    public void theGebruikerIsOpDeRegistreerPagina() throws Throwable {
        cursist.isOnRegistreerPage();
    }

    @When("^de gebruiker gebrukersnaam en email invoerd$")
    public void deGebruikerGebrukersnaamEnEmailInvoerd() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^dan komt hij op de activeer pagina$")
    public void danKomtHijOpDeActiveerPagina() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
