package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class OrderPage {

    ElementHelper elementHelper;

    By asPrice = AppiumBy.androidUIAutomator("new UiSelector().text(\"Fiyata göre (Önce en yüksek)\")");


    public OrderPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickAsPrice() {

        elementHelper.click(asPrice);
    }

}