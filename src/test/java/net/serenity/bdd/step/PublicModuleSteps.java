package net.serenity.bdd.step;

import net.serenity.bdd.pages.AccountsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.io.IOException;

public class PublicModuleSteps extends ScenarioSteps {

    AccountsPage ap;
    @Step
    public void novigate_to_specific_tab(String firstLinkName,
                                         String secLinkName,
                                         String thirdLinkName) throws IOException {
        ap.moveOnAdminTab(firstLinkName,secLinkName,thirdLinkName);
    }

}
