package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {

    }

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            String platform = ConfigReader.getProperty("platform");
            DesiredCapabilities dCaps = new DesiredCapabilities();
            switch (platform) {
                case "android":
                    dCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    dCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
                    dCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
                    dCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    dCaps.setCapability(MobileCapabilityType.APP, "C:\\Users\\gokha\\IdeaProjects\\mobileTesting\\src\\Apps\\apidemos.apk");
                    dCaps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "io.appium.android.apis.ApiDemos");

                    try {
                        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dCaps);
                        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:


            }
        }

        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
