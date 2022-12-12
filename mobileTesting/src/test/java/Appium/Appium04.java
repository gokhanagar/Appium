package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, filePath + "\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");

        AndroidDriver<MobileElement> driver =
                new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("app yuklendi");
        Thread.sleep(3000);
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        Thread.sleep(5000);
        MobileElement okButton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
        okButton.click();
        System.out.println("izinler onaylandi");

        MobileElement homeScreentitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreentitle.isDisplayed());
        System.out.println("Ana sayfa acildi");

        MobileElement addGestureButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGestureButton.click();

        Thread.sleep(3000);
        MobileElement gestureName = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        Actions action= new Actions(driver);
        action.click(gestureName).sendKeys("test").perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).perform();

        driver.hideKeyboard();
        Thread.sleep(1000);
        MobileElement bosluk = driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay");
        bosluk.click();

        MobileElement doneButton = driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(homeScreentitle.isDisplayed());





































    }










































}
