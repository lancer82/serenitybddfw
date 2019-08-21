package net.serenity.bdd.junit.cucumber.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenity.bdd.junit.cucumber.features.steps.serenity.LoginTestSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;


/**
 * Created by arunkumar on 24-05-2017.
 */
public class LoginStepDef {


    @Steps
    LoginTestSteps LT_steps;


    @Given("^I use Valid \"([^\"]*)\" and Valid \"([^\"]*)\"$")
    public void i_use_Valid_and_Valid(String userName, String passWord) throws Throwable {
        LT_steps.openHomePage();
        LT_steps.performLogin(userName,passWord);
    }

    @When("^I perform Login Action$")
    public void i_perform_Login_Action() throws Throwable {

    }

    @Then("^I should see my Overview page\\.$")
    public void i_should_see_my_Account_Mails() throws Throwable {
       LT_steps.isLogoPresent();
    }

    @Given("^Orangehrm has launched$")
    public void orangehrmHasLaunched() {
        LT_steps.openHomePage();
    }

    @When("^Orangehrm Website is launched$")
    public void orangehrmWebsiteIsLaunched() {
        LT_steps.isLoginPage();
    }

    @Then("^Orangehrm Login page is displayed$")
    public void orangehrmLoginPageIsDisplayed() {
        LT_steps.verifyLogoDisplayed();
    }

    @When("^I enter Invalid username \"([^\"]*)\"and\"([^\"]*)\"$")
    public void iEnterInvalidUsernameAnd(String username, String password) throws Throwable {
        LT_steps.enterLoginInfo(username,password);
    }

    @And("^I tap on the Login button$")
    public void iTapOnTheLoginButton() {
        LT_steps.LoginBtnClick();
    }


    @Then("^I should see \"([^\"]*)\"$")
    public void iShouldSee(String errorMessage) throws Throwable {
        LT_steps.errorMessageIsPresent(errorMessage);
    }

    @Given("^Logon on the Orangehrm system$")
    public void logonOnTheOrangehrmSystem() {
        LT_steps.logon_the_orangehrm_system();
        Assert.assertThat(LT_steps.isLogoPresent(),is(true));
    }
}
