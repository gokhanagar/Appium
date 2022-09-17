package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07Chrome {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        desiredCapabilities.setCapability("chromedriverExecutable","C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\driver\\chromedriver.exe");

        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

//http://localhost:4723/wd/hub
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        /*
         Calisma:
         “https://amazon.com" git
         sign in tikla
         Verify “Welcome” text from sign in page
          */
        Thread.sleep(4000);
        driver.get("https://www.amazon.com/");
        System.out.println("1 "+driver.getContext());

//getContextHandles() mevcut olab app turlerini Set konteynira ekliyoruz
        Set contextNames = driver.getContextHandles();
        //burda mevcut app tururnu(context) bir bir yazdiriyoruz
        for (Object contextName : contextNames) {
            System.out.println(contextName);//NATIVE_APP   CHROMIUM
            Thread.sleep(3000);
          if (contextName.toString().contains("NATIVE_APP")){
              //alttaki kodda hangi app turunde calisacaksak onu set ediyoruz
              driver.context((String) contextName);
              Thread.sleep(10000);
          }
        }
        //artik set ettigimiz context ile test devam ediyiruz.
        System.out.println("2 "+driver.getContext());
        Thread.sleep(3000);
        /*driver.findElement(By.className("android.view.View")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Willkommen']")).isDisplayed());

        System.out.println("3 "+driver.getContext());//
        driver.quit();
         */
    }



















    }
