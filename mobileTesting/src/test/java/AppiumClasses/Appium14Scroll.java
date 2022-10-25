package AppiumClasses;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;

public class Appium14Scroll extends AppiumBase{

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver driver = androidDriver();

        //bu kod ile cihazin olcusunu almis olduk.
        Dimension dimension = driver.manage().window().getSize();

        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);
























    }




























































}
