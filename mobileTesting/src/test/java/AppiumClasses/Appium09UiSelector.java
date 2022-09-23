package AppiumClasses;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium09UiSelector {

    @Test
    public void Task2() throws InterruptedException, MalformedURLException {


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

        // resourceId ile
        // driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")")).click();

        // className
        //   driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")")).click();

        //className text ile beraber
        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")")).click();

        //className() index ile
        //  driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)")).click();

        /*
        List<WebElement> buttons = driver.findElements
                (new AppiumBy.ByAndroidUIAutomator
                        ("UiSelector().className(\"android.widget.Button\")"));

        for(WebElement button : buttons){

            if(button.getText().equals("Test")){

                button.click();
            }
        }
        */


        // driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"load\")")).click();

        //Thread.sleep(2000);

        //driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")")).click();

        //UiSelector ile kullanilabilecek methodlar

        System.out.println(driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)")).getAttribute("checkable"));

        System.out.println(driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").clickable(true)")).getAttribute("clickable"));


        
    }

}
