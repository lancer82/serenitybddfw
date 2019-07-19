package net.serenity.bdd.junit.cucumber.pages;

import net.serenity.bdd.junit.cucumber.model.LoginData;
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
    private WebElement errorMessage;

    public void openHomePage_PO(){
        open();
    }

    public void performLogin(LoginData dp) {
        loginEmailField.sendKeys(dp.getUserName());
        loginPasswordField.sendKeys(dp.getPassword());
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

    public void errorMessageVidisblr(LoginData dp){
        Assert.assertEquals("the expect is"+dp.getErrorMessage()+"and the actual is"+errorMessage.getText(),dp.getErrorMessage(),errorMessage.getText());
    }

    public void enterLoginInfo(LoginData dp){
        loginEmailField.sendKeys(dp.getUserName());
        loginPasswordField.sendKeys(dp.getPassword());
    }

    public void clickLoginBtn(){
        loginSubmitButton.click();
    }
}
