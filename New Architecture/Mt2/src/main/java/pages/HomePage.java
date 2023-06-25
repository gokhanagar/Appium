package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class HomePage {
    ElementHelper elementHelper;

    By popupCloseIcon = By.id("trendyol.com:id/imageViewTooltipClose");
    By searchArea = By.id("trendyol.com:id/search_view_inner_container");

    public HomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickPopupClose() {
        elementHelper.click(popupCloseIcon);
    }

    public void checkSearchArea() {
        elementHelper.checkElement(searchArea);
    }

    public void clickSearchArea() {
        elementHelper.click(searchArea);
    }


}
