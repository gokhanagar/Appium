package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {

    // Kesin bekle
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Visibilty
    public static void waitForVisibilty(WebElement element) {
        new WebDriverWait(Driver.getDriver(), 10).
                until(ExpectedConditions.visibilityOf(element));
    }



}
