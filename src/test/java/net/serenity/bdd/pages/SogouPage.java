package net.serenity.bdd.pages;

import net.serenity.bdd.util.ConfUtil;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * @author Thinlk
 * @create 2020-09-22 3:06 PM
 **/
public class SogouPage extends PageObject {

    public void openSogou() {
        String chromeDriverPath = ConfUtil.getConfProp("drivers.windows.webdriver.chrome.driver");
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

    @Test
    public void TestSelenoid() throws IOException, InterruptedException {
        //使用remote driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("84.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );

        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("kw")).sendKeys("豆瓣");
        driver.findElement(By.id("su")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(20000);
        driver.getWindowHandle();
        driver.quit();
    }
}
