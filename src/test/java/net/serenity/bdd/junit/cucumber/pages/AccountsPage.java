package net.serenity.bdd.junit.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
//import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class AccountsPage extends PageObject {
	
	
	@FindBy(id="welcome")
	private WebElement InboxLink;

	
	//thirdPartyFrame_home
	
	
	public boolean isInBoxLinkPresent(){
		return(InboxLink.isDisplayed());
	}
}
