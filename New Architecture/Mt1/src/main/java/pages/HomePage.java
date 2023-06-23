package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementHelper;

public class HomePage {

    //konum iznine izin ver ek olarak
    ElementHelper elementHelper;

    By homelogo = By.id("com.sahibinden:id/action_account");
    By tabs=By.id("com.sahibinden:id/main_page_category_name");

    public HomePage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkInHomePage() {
        elementHelper.checkElement(homelogo);
    }

    public void clickTab(String tab) {
        elementHelper.clickElementWithText(tabs,tab);
    }

}