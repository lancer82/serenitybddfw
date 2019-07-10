package net.serenity.bdd.junit.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Created by arun on 24/05/2017.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/web",
        plugin = {"pretty","html:target/cucumber/web","json:target/json/web/cucumber.json"})
        //tags = {"@UnLogin"})
public class WebRunner{

}
