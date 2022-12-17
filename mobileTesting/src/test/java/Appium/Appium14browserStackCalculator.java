package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium14browserStackCalculator {

    @Test
    public void browserstackIos() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "gkhanaar_KMm3nN");
        caps.setCapability("browserstack.key", "nZtYn4hGrx9MT1nuwm7p");

        // Set URL of the application under test
        caps.setCapability("app", "bs://ea8d84711750a5bf5d90112e41e7b9e6909b8b6b");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "My application");
        caps.setCapability("build", "new");
        caps.setCapability("name", "calculator");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here
        Thread.sleep(3000);
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("equals").click();

        Assert.assertEquals
                (driver.findElementById("com.google.android.calculator:id/result_final").getText(),"10");

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();






























































    }

}
