package net.serenity.bdd.junit.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arun on 24/05/2017.
 */
//https://github.com/sugatmankar/cucumber-jvm-parallel-plugin
  //  https://github.com/sugatmankar/cucumber-jvm-parallel-plugin/tree/tagwiseOutlinewiseIssueRerun
//https://stackoverflow.com/questions/49132447/rerunning-the-failed-scenario-using-maven-cucumber-serenity?r=SearchResults
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty","html:target/cucumber","json:target/json/cucumber.json","rerun:rerun.txt"},
        tags = "@UnLogin")
public class WebRunner{

}