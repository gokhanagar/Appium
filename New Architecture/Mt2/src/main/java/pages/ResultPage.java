package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class ResultPage {

    ElementHelper elementHelper;

    By filterIcon = By.id("trendyol.com:id/textViewFilter");
    By order = By.id("trendyol.com:id/layout_search_order");
    By secondProduct = By.id("trendyol.com:id/productCardViewRightProduct");

    public ResultPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkFilterIcon() {
        elementHelper.checkElement(filterIcon);
    }

    public void clickFilter() {
        elementHelper.click(filterIcon);
    }

    public void clickOrder() {
        elementHelper.click(order);
    }

    public void clickSecondProduct() {
        elementHelper.click(secondProduct);
    }


}