package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class CategoriesPage {

    ElementHelper elementHelper;

    By tabs=By.id("com.sahibinden:id/util_primary_text");
    By closeTab=By.id("com.sahibinden:id/anchor_view");// xpathle-> //android.widget.FrameLayout/android.widget.ImageView[2]


    public CategoriesPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickTab(String tab) {
        elementHelper.clickElementWithText(tabs,tab);
    }

    public void closeAlert() {
        elementHelper.click(closeTab);
    }
}
