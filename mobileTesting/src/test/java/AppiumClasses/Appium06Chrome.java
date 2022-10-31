package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06Chrome {

    @Test
    public void Task1() throws InterruptedException, MalformedURLException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        desiredCapabilities.setCapability("chromedriverExecutable", "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\driver\\chromedriver.exe");


        //noReset
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //appium server url
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(3000);


        driver.get("https://www.amazon.com");
        System.out.println("1." + driver.getContext());


        //remote device on chrome https://developer.chrome.com/docx/devtools/remote-debugging/
        //chrome://inspect/#devices

        driver.findElement(By.id("nav-logobar-greeting")).click();
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

        Set contextNames = driver.getContextHandles();
        //burda mevcut app turunu(context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
            Thread.sleep(3000);
            if (contextName.toString().contains("CHROMIUM")) {
                // alttaki kodda hangi app turunde calisacaksak onu set ediyoruz
                driver.context((String) contextName);//WEBAPP DEVAM EDECEGIM
                Thread.sleep(10000);
            }
        }
        //artik set ettigimiz context ile test devam ediyoruz.
        System.out.println("2." + driver.getContext());


    }


}