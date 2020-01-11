package net.serenity.bdd.junit.cucumber.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.serenity.bdd.junit.cucumber.step.AdminSteps;
import net.serenity.bdd.junit.cucumber.step.PublicModuleSteps;
import net.thucydides.core.annotations.Steps;


import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;

public class AdminStepDef {

    @Steps
    PublicModuleSteps pm_steps;

    @Steps
    AdminSteps adminSteps;

    @When("^Navigate to specific tab \"([^\"]*)\" -> \"([^\"]*)\"->\"([^\"]*)\"$")
    public void navigateToSpecificTab(String firstLinkName,
                                      String secLinkName,
                                      String thirdLinkName) throws Throwable {
        pm_steps.novigate_to_specific_tab(firstLinkName,secLinkName,thirdLinkName);
    }

    @And("^Click the \"([^\"]*)\" link$")
    public void clickTheLink(String userName) throws Throwable {
        adminSteps.open_username_link(the("Username",is(userName)));
    }
}