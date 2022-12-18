package Appium;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Task extends BaseClass{

    @Test
    public void test() throws MalformedURLException, InterruptedException {


        AndroidDriver driver = getAndroidDriver();

        System.out.println("App intstalled...");

        //api demos butonuna tikla
        driver.findElementByCssSelector("android.widget.TextView[text='API Demos']").click();
        Thread.sleep(1000);

        //Views butonuna tikladik
        driver.findElementByCssSelector("android.widget.TextView[text='Views']").click();
        Thread.sleep(1000);

        Dimension dimension = driver.manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);

        for(int i=0; i<3; i++){
            touchAction.press(PointOption.point(start_x, start_y)).moveTo(PointOption.point(end_x, end_y)).
                    release().perform();

        }

        //Switches butonuna tikladi
        driver.findElementByCssSelector("android.widget.TextView[text='Switches']").click();




























    }



























}
