package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;


public class Appium06NativeChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");


        AndroidDriver<MobileElement> driver =
                new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(9000);
        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<==== app acildigindaki tur");

        //burada uygulamamnin hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        /*
        Set<String> butunTurler = driver.getContextHandles();
        for(String tur: butunTurler){
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }
         */

        System.out.println(driver.getContext() + "<==== degisimden sonraki tur");
        Thread.sleep(7000);

        MobileElement homeScreenLogo = driver.findElementByXPath("//android.view.View[@content-desc=\"Amazon\"]");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");
        //System.out.println(driver.getCurrentUrl()+ " =====url");

        Thread.sleep(3000);
        MobileElement sigInButton = driver.findElementByCssSelector("android.view.View[content-desc=\"Sign in ›\"]");
        sigInButton.click();

        Thread.sleep(5000);
        MobileElement welcomeText = driver.findElementByCssSelector("android.view.View[text='Welcome']");
        Assert.assertEquals(welcomeText.getText(), "Welcome");
        System.out.println("test bitti");

        Thread.sleep(5000);
        //close session
        //driver.closeApp();


    }


}