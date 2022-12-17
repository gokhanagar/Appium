package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium11 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String filePath = System.getProperty("user.dir");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, filePath + "\\src\\Apps\\apiDemos.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability("noReset","true");

        AndroidDriver<MobileElement> driver =
                new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        System.out.println("App intstalled...");

        //api demos butonuna tikla
        driver.findElementByCssSelector("android.widget.TextView[text='API Demos']").click();
        Thread.sleep(3000);

        //preference butonuna tikladik
        driver.findElementByCssSelector("android.widget.TextView[text='Preference']").click();

        //preference dependencies butonuna bastik
        Thread.sleep(3000);
        driver.findElementByCssSelector("android.widget.TextView[text='3. Preference dependencies']").click();

        //check box check et
        Thread.sleep(3000);
       String isChecked = driver.findElementByAndroidUIAutomator
               ("UiSelector().recourceID(\"android:id/checkbox\").checkable(true)")
               .getAttribute("checked");

        if(isChecked.equals("false")){
            driver.findElementById("android:id/checkbox").click();
        }


        /*
        String checkBox = driver.findElementByCssSelector
                ("android.widget.CheckBox[resource-id='android:id/checkbox']").getAttribute("checked");
        System.out.println(checkBox);

        for(int i = 0; i <1; i++) {
            if (checkBox.equals("false")) {
                driver.findElementByCssSelector
                        ("android.widget.CheckBox[resource-id='android:id/checkbox']").click();

            } else {
                continue;
            }
        }
        */


        //wifi setting tikladik
        Thread.sleep(3000);
        driver.findElementByCssSelector("android.widget.TextView[text='WiFi settings']").click();

        //text penceresi acildigini gorduk
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByCssSelector("android.widget.TextView[resource-id='android:id/alertTitle']").isDisplayed());

        //text yazdiralim
        driver.findElementByCssSelector("android.widget.EditText[resource-id='android:id/edit']").sendKeys("TextAppium");

        //ok butonuna bas
        driver.findElementByCssSelector("android.widget.Button[resource-id='android:id/button1']").click();

        System.out.println("mission completed....");
        Thread.sleep(10000);

        //session kapat
        //  driver.closeApp();










        



























































    }



























































}
