package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {

    @Test
    public void task1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(4000);


        driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
      //  driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"API Demos\")")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();

        WebElement checkbox=driver.findElement(By.id("android:id/checkbox"));
        WebElement wifiSettings=driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']"));

        Thread.sleep(2000);
        if (!wifiSettings.isEnabled()){
            checkbox.click();
        }
        wifiSettings.click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/edit")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();


































    }

}
