package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

import java.util.List;

public class ResultsPage {

    ElementHelper elementHelper;

    By shareIcon = By.id("com.sahibinden:id/action_share");
    By filterButton = By.id("com.sahibinden:id/tvFilter");
    By orderButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sırala\")");//(//*[@resource-id="com.sahibinden:id/layout_options_menu_view_relative_layout_sort"]/android.widget.TextView)
    By locationButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Devam Et\")");
    By firsrCarPrice = By.id("com.sahibinden:id/price");

    public ResultsPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkShareIcon() {
        elementHelper.checkElement(shareIcon);
    }


    public void clickFilter() {
        elementHelper.click(filterButton);
    }

    public void clickOrderTab() {
        elementHelper.click(orderButton);
    }

    public void clickDevam() {
        elementHelper.click(locationButton);
    }

    public String getTextPrice() {
        List<String> priceText = List.of(elementHelper.getText(firsrCarPrice).split(" "));
        System.out.println(priceText.get(0));
        return priceText.get(0);
    }
}
