package net.serenity.bdd.junit.cucumber.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author Thinlk
 * @create 2020-09-22 3:04 PM
 **/
public final class PageUtil extends PageObject {

    /**
     * Funtion: Navigate to specific page directly via URL
     *
     */
    public void navigateTo(String confEvnAll) {
        String curUrl = ConfUtil.getConfProp(confEvnAll);
        String newUrl = ConfUtil.updateUrl(getDriver().getCurrentUrl(),curUrl);
        this.openUrl(newUrl);
    }


    public String getResponse(String baseUri,String postPath,String postBody) {
        //启用SSL认证
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = "/portalserver";
        RequestSpecification specification = new RequestSpecBuilder().setProxy("intpxy1.hk.hsbc",8080).build();
        if(RestAssured.baseURI.contains("hsbc.com.hk")) {
            return given().spec(specification).cookies(new Cookies(getBrowserCookies()))
                    .header("X-BBXSRF",getBBXSRF()).contentType("application/json")
                    .body(postBody)
                    .when().post(postPath).getBody().asString();
        } else {
            return given().cookies(new Cookies(getBrowserCookies()))
                    .header("X-BBXSRF",getBBXSRF()).contentType("application/json")
                    .body(postBody)
                    .when().post(postPath).getBody().asString();
        }
    }

    public List<io.restassured.http.Cookie> getBrowserCookies() {
        List<io.restassured.http.Cookie> cookies = new ArrayList<>();
        for(org.openqa.selenium.Cookie cookie:getDriver().manage().getCookies()) {
            cookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(),cookie.getValue()).build());
        }
        return cookies;
    }

    public String getBBXSRF() {
        String bbxsrf = getDriver().manage().getCookieNamed("BBXSRF").toString();
        int end = bbxsrf.indexOf("path");
        return bbxsrf.substring(7,end-2);
    }

    public boolean isElementPresent(By locator) {
        return !withTimeoutOf(5,SECONDS).findAll(locator).isEmpty();
    }

    public void removeAttribute(WebElementFacade element, String attribute) {
        evaluateJavascript("arguments[0].removeAttribute(arguments[1],arguments[2])",element,attribute);
    }

    public void setAttribute(WebElementFacade element, String attribute) {
        evaluateJavascript("arguments[0].setAttribute(arguments[1],arguments[2])",element,attribute);
    }

    public void alertClose() {
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void jsClick(WebElementFacade element) {
        evaluateJavascript("arguments[0].click()",element);
    }

    public void setScrollElementTop(WebElementFacade element) {
        evaluateJavascript("arguents[0].scrollIntoView()",element);
    }

    public void setSrcollElementButtom(WebElementFacade element) {
        evaluateJavascript("arguents[0].scrollIntoView(false)",element);
    }

    public void setSrcollTo(int ypos) {
        evaluateJavascript("window.scrollTo(0,argments[0])",ypos);
    }

    public void setScrollWindowButtom() {
        evaluateJavascript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
