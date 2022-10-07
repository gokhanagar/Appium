package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium05Chrome {


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

        Actions action = new Actions(driver);
        driver.get("https://www.kulturyolufestivalleri.com");
        System.out.println("1." + driver.getContext());


        Thread.sleep(3000);
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
        System.out.println("2." + driver.getContext());

        WebElement searchBar = driver.findElement(By.xpath("//input[@class='header-search-bar']"));


        action.click(searchBar).sendKeys("yuzme").perform();
        Thread.sleep(5000);

        WebElement etkinlikBulunamadiYazisi = driver.findElement(By.xpath("//*[text()='Etkinlik bulunamadı.']"));
        Assert.assertEquals("Etkinlik bulunamadı.", etkinlikBulunamadiYazisi.getText());

        Thread.sleep(5000);
        action.doubleClick(searchBar).sendKeys(Keys.DELETE).sendKeys("konser").perform();
        Thread.sleep(3000);

        WebElement konser = driver.findElement(By.xpath("(//ul)[4]"));

        Assert.assertTrue(konser.isDisplayed());
        Thread.sleep(3000);

        WebElement cancelButton = driver.findElement(By.xpath("//em[@class='icon icon-close-circle']"));
        cancelButton.click();


    }


}
