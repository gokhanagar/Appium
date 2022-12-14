package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium08UiSelector {

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
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");

        AndroidDriver<MobileElement> driver =
                new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //recource id ile
       // driver.findElementByAndroidUIAutomator
                //("UiSelector().recourceId(\"com.davemac327.gesture.tool:id\")").click();

        //index ile
        //driver.findElementByAndroidUIAutomator
                //("UiSelector().className(\"android.widget.Button\").index(0)").click();

        //text ile
        //driver.findElementByAndroidUIAutomator
                //("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();

        //driver.findElementByAndroidUIAutomator
                //("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();

        /*
        System.out.println(driver.findElementByAndroidUIAutomator
                        ("UiSelector().recourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").
                getAttribute("enabled"));
         */



















    }

































}
