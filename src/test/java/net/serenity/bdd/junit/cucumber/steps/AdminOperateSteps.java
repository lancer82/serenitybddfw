package net.serenity.bdd.junit.cucumber.steps;

import net.serenity.bdd.junit.cucumber.pages.AccountsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.io.IOException;

public class AdminOperateSteps extends ScenarioSteps {

    AccountsPage ap;
    @Step
    public void novigate_to_specific_tab(String firstLinkName,
                                         String secLinkName,
                                         String thirdLinkName) throws IOException {
        ap.moveOnAdminTab(firstLinkName,secLinkName,thirdLinkName);
    }
}
