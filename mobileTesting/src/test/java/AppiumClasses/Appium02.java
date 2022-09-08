package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();



        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\apiDemos.apk");
        desiredCapabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        desiredCapabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");


        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);














    }
































}
