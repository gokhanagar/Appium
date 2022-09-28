package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {

    @Test
    public void Task1() throws InterruptedException, MalformedURLException {

        /*
            install app
            do any mathematical operation
            and verify pre result and final result
        */

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\Calculator.apk");

        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);


        //do any mathematical operation
        WebElement num0 = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
        WebElement num1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement num2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement num3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement num4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        WebElement num5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        WebElement num6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        WebElement num7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        WebElement num8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        WebElement num9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));

        WebElement multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        num1.click();
        num5.click();
        multiply.click();
        num3.click();
        Thread.sleep(5000);

        String expectedPreResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
        Assert.assertEquals(expectedPreResult, "45");
        Thread.sleep(5000);

        equal.click();

        Thread.sleep(5000);
        String actualResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(expectedPreResult, actualResult);
        System.out.println("ex" + expectedPreResult);
        System.out.println("ac" + actualResult);

    }

}