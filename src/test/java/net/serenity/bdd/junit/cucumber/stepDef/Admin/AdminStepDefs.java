package net.serenity.bdd.junit.cucumber.stepDef.Admin;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import net.serenity.bdd.junit.cucumber.steps.AdminOperateSteps;
import net.thucydides.core.annotations.Steps;

public class AdminStepDefs {

    @Steps
    AdminOperateSteps  ao_steps;

    @When("^Navigate to specific tab \"([^\"]*)\" -> \"([^\"]*)\"->\"([^\"]*)\"$")
    public void navigateToSpecificTab(String firstLinkName,
                                      String secLinkName,
                                      String thirdLinkName) throws Throwable {
        ao_steps.novigate_to_specific_tab(firstLinkName,secLinkName,thirdLinkName);
    }
}
