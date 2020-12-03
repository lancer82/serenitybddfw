package net.serenity.bdd.junit.cucumber.util;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * @author Thinlk
 * @create 2020-09-22 5:50 PM
 **/
public class ConfUtil {

    /**
     * Function:Get the default customize environment variables with name
     * @param confProp eg: "website.username",“envrionment.” + <envrionment name> + ".webdriver.base.url"
     * @return
     */
    public static String getConfProp(String confProp) {
        EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(confProp);
    }

    public static String updateUrl(String curUrl,String newUrl) {
        StringBuilder url = new StringBuilder().append(curUrl);
        url.delete(curUrl.indexOf("index.php"),curUrl.length());
        url.append(newUrl);
        return url.toString();
    }
}
