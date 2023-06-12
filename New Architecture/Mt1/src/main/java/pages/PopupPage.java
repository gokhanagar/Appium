package pages;

import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class PopupPage {

    ElementHelper elementHelper;

    public PopupPage(WebDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }


}
