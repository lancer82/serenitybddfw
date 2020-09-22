package net.serenity.bdd.junit.cucumber.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by arun on 25/05/2017.
 */
@At("https://opensource-demo.orangehrmlive.com/")
public class LoginPage extends PageObject {

    @FindBy(id="txtUsername")
    private WebElement  loginEmailField;

    @FindBy(id="txtPassword")
    private WebElement  loginPasswordField;

    @FindBy(id="btnLogin")
    private WebElement  loginSubmitButton;

    @FindBy(xpath="//*[@id=\"divLogo\"]/img")
    private WebElement loginOrangeLogo;

    @FindBy(id="spanMessage")
    private WebElement errorInfo;

    EnvironmentVariables environmentVariables;

    public void openHomePage_PO(){
        open();
    }

    public void performLogin(String username, String password) {
        loginEmailField.sendKeys(username);
        loginPasswordField.sendKeys(password);
        loginSubmitButton.click();
    }

    public void verifyLoginPage(){
        loginEmailField.isDisplayed();
        loginPasswordField.isDisplayed();
        loginSubmitButton.isDisplayed();
    }

    public void orangeLogoDisplayed(){
        loginOrangeLogo.isDisplayed();
    }

    public void errorMessageVidisblr(String errorMessage){
        assertThat(errorInfo.getText()).containsOnlyOnce(errorMessage);
    }

    public void enterLoginInfo(String username,String password){
        loginEmailField.sendKeys(username);
        loginPasswordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginSubmitButton.click();
    }
}
