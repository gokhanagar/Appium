package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Appium11 extends AppiumBase {


    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver driver = androidDriver();

        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();

        //check box a gore kosul
//        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
//
//        if (isChecked.equals("false")) {
//            driver.findElementById("android:id/checkbox").click();
//            Thread.sleep(2000);
//        }

        //Wifi settings e gore
        /*
        List<WebElement> list = driver.findElements(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)"));
        if (list.size() > 0) {
            String isEnabled = driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)")).getAttribute("enabled");
            if (isEnabled.equals("false")) {
                driver.findElement(By.id("android:id/checkbox")).click();
            }
        }
        */
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/edit")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();


    }

}
