package net.serenity.bdd.junit.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;



public class AccountsPage extends PageObject {
	
	
	@FindBy(id="welcome")
	private WebElement WelconeLogo;

	public boolean isLogoPresent(){
		return(WelconeLogo.isDisplayed());
	}

	public void moveOnAdminTab(String tabName,String subTabName,String thirdTabName){
		List<WebElementFacade> tabs = findAll("//a[@class='firstLevelMenu']");
		for(WebElementFacade tab:tabs){
			if(tab.getText().equals(tabName)){
				withAction().moveToElement(tab).perform();
				if(!subTabName.isEmpty()){
					List<WebElementFacade> subLinks = findAll("//a[@class='firstLevelMenu']/following-sibling::ul/li");
 					for(WebElementFacade subLink : subLinks){
 						if(subLink.getText().equals(subTabName) && subLink.isVisible()){
							withAction().moveToElement(subLink).perform();
							if(!thirdTabName.isEmpty()){
								List<WebElementFacade> thirdLinks = findAll("//a[@class='arrow']//following-sibling::ul/li");
								for(WebElementFacade thitdLink : thirdLinks) {
									if(thitdLink.getText().equals(thirdTabName) && thitdLink.isVisible()){
										thitdLink.click();
										return;
									}
								}
							}else{
								subLink.click();
								return;
							}
						}
					}
				}else{
					tab.click();
					return;
				}
			}
		}
	}
}
