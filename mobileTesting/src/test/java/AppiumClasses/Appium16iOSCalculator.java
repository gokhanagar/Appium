package AppiumClasses;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
public class Appium16iOSCalculator {

    @Test
    public void test() throws InterruptedException {
        Driver.getAppiumDriver();

        Thread.sleep(5000);

        Driver.getAppiumDriver().findElementByAccessibilityId("8").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("5").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("-").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("1").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("2").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("=").click();
        Driver.getAppiumDriver().findElementByAccessibilityId("8").click();

        MobileElement result =
                (MobileElement) Driver.getAppiumDriver().
                        findElementByXPath("//XCUIElementTypeProgressIndicator[@name='Progress]/preceding-sibling::XCUIElementTypeOther");

        Assert.assertEquals(result.getText(),"73");

    }


}