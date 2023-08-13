package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class SearchPage {

    ElementHelper elementHelper;

    By backIcon = By.id("trendyol.com:id/imageview_action_start");
    By searchArea = By.id("trendyol.com:id/edittext_search_view");

    public SearchPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkBackIcon() {
        elementHelper.checkElement(backIcon);
    }

    public void sendKeysSearchArea(String text) {
        elementHelper.sendKeys(searchArea, text);
        elementHelper.pressSearch();
    }


}