package net.serenity.bdd.junit.cucumber.pages;

import net.serenity.bdd.junit.cucumber.utils.LoginData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        Assert.assertEquals(errorInfo.getText(),errorMessage);
    }

    public void enterLoginInfo(String username,String password){
        loginEmailField.sendKeys(username);
        loginPasswordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginSubmitButton.click();
    }
}
