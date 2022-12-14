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

public class Appium07WebAppChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        String filePath = System.getProperty("user.dir");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");

        //chrome driver versiyonunuzu burdan indirebilrisiniz
        //https://chromedriver.storage.googleapis.com/index.html
        //sonrasinda driver in absolute path bir alt satirda tanimliyorsunuz
        capabilities.setCapability("chromedriverExecutable",filePath + "\\src\\driver\\chromedriver.exe");

        AndroidDriver<MobileElement> driver =
                new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(9000);
        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<==== app acildigindaki durumu");

        //burada uygulamamnin hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz

        Set<String> butunTurler = driver.getContextHandles();
        for(String tur: butunTurler){
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }

        System.out.println(driver.getContext() + "<==== app sonraki durumu");
        Thread.sleep(7000);

        MobileElement anaSayfaLogo = driver.findElementByCssSelector("a[id='nav-logo-sprites']");
        Assert.assertTrue(anaSayfaLogo.isDisplayed());

        MobileElement signInButton = driver.findElementByCssSelector("a[class='nav-a nav-show-sign-in']");
        signInButton.click();
        Thread.sleep(2000);
        MobileElement emailNumber = driver.findElementByCssSelector("label[for='ap_email_login']");
        Assert.assertTrue(emailNumber.isDisplayed());







































































    }
}
