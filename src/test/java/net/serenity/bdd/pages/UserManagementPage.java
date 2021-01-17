package net.serenity.bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;
import net.thucydides.core.matchers.BeanMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static net.thucydides.core.pages.components.HtmlTable.filterRows;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

import java.util.List;
import java.util.Map;

@At("*/admin/viewSystemUsers")
public class UserManagementPage extends PageObject {

    WebElement resultTable;

    public List<Map<Object, String>> getSearchResults(){
        return rowsFrom(resultTable);
    }

    public void clickOnFirstRowMatching(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(resultTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement detailsLink = targetRow.findElement(By.xpath("//a[contains(@href,'saveSystemUser')]"));
        detailsLink.click();
    }
}
