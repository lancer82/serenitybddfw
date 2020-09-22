package net.serenity.bdd.junit.cucumber.pages;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.Set;

/**
 * @author Thinlk
 * @create 2020-09-22 3:06 PM
 **/
public class SogouPage extends PageObject {

    public void openSogou() {
        EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        String chromeDriverPath= environmentVariables.getProperties().getProperty("drivers.windows.webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito","--ignore-certificate-errors","--test-type","--disable-infobars","--args -disbale-extensions");
        options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension",false);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.sogou.com/");
        Set<String> allWindowsHandle = driver.getWindowHandles();
        if(!allWindowsHandle.isEmpty()){
            for(String windowHandle:allWindowsHandle){
                try{
                    if(driver.switchTo().window(windowHandle).getCurrentUrl().contains("sogou")){
                        driver.findElement(By.id("query")).sendKeys("admin");
                        break;
                    }
                }catch(NoSuchWindowException e){
                    e.printStackTrace();
                }
            }
        }
        //driver.switchTo().window(parentWindowHandle);
        driver.quit();
    }
}
