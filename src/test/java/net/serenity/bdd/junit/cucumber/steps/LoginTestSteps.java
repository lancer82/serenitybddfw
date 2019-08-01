package net.serenity.bdd.junit.cucumber.steps;

import net.serenity.bdd.junit.cucumber.utils.LoginData;
import net.serenity.bdd.junit.cucumber.pages.AccountsPage;
import net.serenity.bdd.junit.cucumber.pages.LoginPage;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * Created by arun on 25/05/2017.
 */
public class LoginTestSteps extends ScenarioSteps {

    LoginPage LP;
    AccountsPage AP;
    private EnvironmentVariables environmentVariables;

    @Step
    public void openHomePage(){
        LP.openHomePage_PO();
    }

    @Step
    public void performLogin(String username,String password) {
        LP.performLogin(username,password);
    }

    @Step
    public boolean isLogoPresent() {
        return AP.isLogoPresent();
    }

    @Step
    public void isLoginPage(){
        LP.verifyLoginPage();
    }

    @Step
    public void verifyLogoDisplayed(){
        LP.orangeLogoDisplayed();
    }

    @Step
    public void errorMessageIsPresent(String errorMessage){
        LP.errorMessageVidisblr(errorMessage);
    }

    @Step
    public void LoginBtnClick(){
        LP.clickLoginBtn();
    }

    @Step
    public void enterLoginInfo(String username,String password){
        LP.enterLoginInfo(username,password);
    }

    @Step
    public void logon_the_orangehrm_system(){
        String username = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("website.username");
        String password = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("website.password");
        LP.openHomePage_PO();
        LP.performLogin(username,password);
    }
}
