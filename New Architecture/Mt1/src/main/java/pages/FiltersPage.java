package pages;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class FiltersPage {

    ElementHelper elementHelper;

    By priceTab = AppiumBy.androidUIAutomator("new UiSelector().text(\"Fiyat\")");
    By mostTab = By.id("com.sahibinden:id/maxAmountEditText");
    By okTab = By.id("android:id/button1");
    By resultsTab = By.id("com.sahibinden:id/search_button");



    public FiltersPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }


    public void clickPrice() {
        elementHelper.click(priceTab);
    }

    public void sendPrice(String price) {
        elementHelper.sendKeys(mostTab,price);
    }

    public void clickOk() {
        elementHelper.click(okTab);
    }

    public void clickResults() {
        elementHelper.click(resultsTab);
    }

}