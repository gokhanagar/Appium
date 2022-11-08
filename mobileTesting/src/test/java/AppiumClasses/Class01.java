package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Class01 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //desiredCapabilities.setCapability("platformName","Android");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\gestureTool.apk");

                                                             //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(3000);

        driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton"));

        driver.findElement(By.xpath("//*[@text='Add gesture']"));

        driver.findElement(By.xpath("(//android.widget.Button)[1]"));

        driver.findElement(By.xpath("//android.widget.Button[@text='Add gesture']")).click();







    }






























}
