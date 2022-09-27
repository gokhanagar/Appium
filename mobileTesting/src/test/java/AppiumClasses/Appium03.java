package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void test() throws InterruptedException, MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\gestureTool.apk");

        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);

        //id ile bulduk
        //driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton")).click();

        //id bu sekilde de yazilabilir
        //driver.findElement(By.id("id/addButton")).click();

        //xpath index +ile bulduk
        //  driver.findElement(By.xpath("//android.widget.Button[2]")).click();

        //xpath text
        driver.findElement(By.xpath("//android.widget.Button[@text='Add gesture']")).click();


    }


    @Test
    public void Task1() throws InterruptedException, MalformedURLException {

        /*
        launch GestureTool app
        click test button
        verify title "Test a gesture"
        close app
         */

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\gestureTool.apk");

        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);

        //click test button
        driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton")).click();

        //verify title "Test a gesture"
        Thread.sleep(3000);
        String expectedTitle = "Test a gesture";
        String actualTitle = driver.findElement(By.id("android:id/title")).getText();

        Assert.assertEquals(expectedTitle, actualTitle);

        //close app
        driver.quit();

    }


    @Test
    public void Task2() throws InterruptedException, MalformedURLException {

        /*
            launch GestureTool app
            click addGesture button
            send text to name box "testing"
            click done
            verify testing gesture is created
        */

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\gestureTool.apk");

        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);

        //click add gesture
        driver.findElement(By.xpath("//android.widget.Button[@text='Add gesture']")).click();
        Thread.sleep(3000);

        //search button

        driver.findElement(By.id("com.davemac327.gesture.tool:id/gesture_name")).sendKeys("test");

        driver.findElement(By.id("com.davemac327.gesture.tool:id/gestures_overlay")).click();
        Thread.sleep(3000);

        //click done
        driver.findElement(By.id("com.davemac327.gesture.tool:id/done")).click();
        Thread.sleep(3000);

        String expectedText = "test";
        String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text ='test']")).getText();

        Assert.assertEquals(expectedText, actualText);


    }


}
