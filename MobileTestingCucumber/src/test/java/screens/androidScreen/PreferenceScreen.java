package screens.androidScreen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PreferenceScreen {

    public PreferenceScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);

    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
    public MobileElement preferenceScreenTitle;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
    public MobileElement preferenceDependencies;

    public boolean isPreferenceScreenDisplayed() {

        try {
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return preferenceScreenTitle.isDisplayed();
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='9. Switch']")
    public MobileElement switchButton;



































































}
