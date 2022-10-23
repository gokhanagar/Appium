package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DuolingoTest1 {


    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\Duolingo.apk");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


        WebElement getStarted = driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        Thread.sleep(3000);
        getStarted.click();

        WebElement italy=driver.findElement(By.xpath("//android.widget.TextView[@text='Italian']"));
        String italyStr= italy.getText();
        System.out.println("italyStr = " + italyStr);

        WebElement german = driver.findElement(By.xpath("//android.widget.TextView[@text='German']"));
        german.click();
        Thread.sleep(10000);

        WebElement other = driver.findElement(By.cssSelector(
                "android.widget.LinearLayout[id='com.duolingo:id/motivationCard']"));

        other.click();
        Thread.sleep(4000);

        WebElement regular = driver.findElement(By.cssSelector("android.widget.LinearLayout[id='com.duolingo:id/xpGoalOptionRegular']"));
        regular.click();
        Thread.sleep(4000);

        WebElement con = driver.findElement(By.cssSelector("android.widget.TextView[id='com.duolingo:id/xpGoalContinueButton']"));
        con.click();
        Thread.sleep(4000);

        WebElement someGerman = driver.findElement(By.cssSelector("android.widget.TextView[id='com.duolingo:id/placementHeader']"));
        someGerman.click();
        Thread.sleep(4000);

        WebElement startTest = driver.findElement(By.cssSelector("android.widget.TextView[id='com.duolingo:id/primaryButton']"));
        startTest.click();


        
    }
}