package net.serenity.bdd.junit.cucumber.steps;

import net.serenity.bdd.junit.cucumber.model.LoginData;
import net.serenity.bdd.junit.cucumber.pages.AccountsPage;
import net.serenity.bdd.junit.cucumber.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by arun on 25/05/2017.
 */
public class LoginTestSteps extends ScenarioSteps {

    LoginPage LP;
    AccountsPage AP;

    @Step
    public void openHomePage(){
        LP.openHomePage_PO();
    }
    @Step
    public void performLogin(LoginData dp) {
        LP.performLogin(dp);
    }
    @Step
    public void isInboxPresent() {
        System.out.println(AP.isInBoxLinkPresent());
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
    public void errorMessageIsPresent(LoginData dp){
        LP.errorMessageVidisblr(dp);
    }

    @Step
    public void LoginBtnClick(){
        LP.clickLoginBtn();
    }

    @Step
    public void enterLoginInfo(LoginData dp){
        LP.enterLoginInfo(dp);
    }
}
