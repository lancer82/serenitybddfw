package net.serenity.bdd.junit.cucumber.features.steps.library;

import net.serenity.bdd.junit.cucumber.pages.UserManagementPage;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.steps.ScenarioSteps;

public class AdminSteps extends ScenarioSteps {

    UserManagementPage userManagementPage;

    public void open_username_link(BeanMatcher... matchers){
        userManagementPage.clickOnFirstRowMatching(matchers);
    }
}
