package net.serenity.bdd.step;

import net.serenity.bdd.pages.UserManagementPage;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.steps.ScenarioSteps;

public class AdminSteps extends ScenarioSteps {

    UserManagementPage userManagementPage;

    public void open_username_link(BeanMatcher... matchers){
        userManagementPage.clickOnFirstRowMatching(matchers);
    }
}
