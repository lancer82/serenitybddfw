package net.serenity.bdd.junit.cucumber.stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;

/**
 * Created by arun on 25/05/2017.
 */
public class GenericHook extends GenericConstant {

    private EnvironmentVariables environmentVariables;
    @Before
    public void beforeTest(Scenario scenario) throws IOException{

        for(String s:scenario.getSourceTagNames()){
            System.out.println("Tag: " +s);
        }
        String webEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("security.token.url");

    }
}