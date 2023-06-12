package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ElementHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementHelper(WebDriver driver) {
        String time = ConfigReader.getProperty("wait");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(time)));
    }

    public WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            return scroll(locator).get(0);
        }
    }

    public List<WebElement> findElements(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        catch (Exception e){
            return scroll(locator);
        }
    }

    public void checkElement(By locator) {
        findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public void clickElementWithText(By locator, String text) {
        int i = 0;
        boolean check = false;
        findElement(locator);
        while (i < 10) {
            List<WebElement> elementList = findElements(locator);
            for (WebElement elem : elementList) {
                if (elem.getText().equals(text)) {
                    check = true;
                    elem.click();
                    break;
                }
            }
            if (check) {
                break;
            } else {
                scrollDown();
                i++;
            }
        }
        Assert.assertTrue(check, "Listede istediğin textteki elamanı bulamadım!!!");
    }

    public List<WebElement> scroll(By by){
        int i = 0;
        String previusPageSource = "";
        while (checkElementEnabled(by) && checkEndOfPage(previusPageSource) && i < 11) {
            i++;
            previusPageSource = driver.getPageSource();
            scrollDown();
        }
        return  driver.findElements(by);
    }

    public boolean checkEndOfPage(String previousPageSource){
        return !previousPageSource.equals(driver.getPageSource());
    }

    public boolean checkElementEnabled(By by){
        return driver.findElements(by).isEmpty();
    }

    public void scrollDown() {//hem android hem de ios için kullanilabilir bu method
        int startX = driver.manage().window().getSize().getWidth() / 2;//kayırmak için x ve y koordinatlari veriliyor
        int startY = driver.manage().window().getSize().getHeight() / 2;
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));//down-> bas
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(List.of(scroll));
    }


    public void scrollUP() {//hem android hem de ios için kullanilabilir bu method
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
        int endx = driver.manage().window().getSize().getWidth() / 2;
        int endY = driver.manage().window().getSize().getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endx, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(List.of(scroll));
    }


}
