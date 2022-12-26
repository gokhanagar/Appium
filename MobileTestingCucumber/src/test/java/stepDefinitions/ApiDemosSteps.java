package stepDefinitions;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import screens.Screens;
import screens.androidScreen.ApiDemosScreen;
import screens.androidScreen.MainScreen;
import screens.androidScreen.PreferenceDependenciesScreen;
import screens.androidScreen.PreferenceScreen;
import utils.Driver;

import java.util.Set;

import static org.apache.commons.io.FileUtils.waitFor;
import static utils.ReusableMethods.*;

public class ApiDemosSteps {

    Screens screens = new Screens();


    @Given("App yuklensin")
    public void appYuklensin() {

        Driver.getAppiumDriver();
    }

    @And("kullanici ana ekranda")
    public void kullaniciAnaEkranda() {
        Assert.assertTrue(screens.mainScreen().isMainScreenDisplayed());
    }

    @And("kullanici API Demos butonuna tikladi")
    public void kullaniciAPIDemosButonunaTikladi() {
        tapOn(screens.mainScreen().apiDemosButton);

    }

    @Then("Kullanici API Demos ekraninda")
    public void kullaniciAPIDemosEkraninda() {
        Assert.assertTrue(screens.apiDemosScreen().apiDemosTitle.isDisplayed());
    }

    @And("kullanici Preference butonuna tikladi")
    public void kullaniciPreferenceButonunaTikladi() {
        screens.apiDemosScreen().preference.click();
    }

    @Then("kullanici Preference ekraninda")
    public void kullaniciPreferenceEkraninda() {
        Assert.assertTrue(screens.preferenceScreen().preferenceScreenTitle.isDisplayed());
    }

    @And("kullanici Preference depenencies tikladi")
    public void kullaniciPreferenceDepenenciesTikladi() {
        screens.preferenceScreen().preferenceDependencies.click();
    }

    @And("kullanici Wifi check box secmis olacak")
    public void kullaniciWifiCheckBoxSecmisOlacak() {
        if (screens.preferenceDependenciesScreen().checkbox.getAttribute("checked").equals("false")) {

            tapOn(screens.preferenceDependenciesScreen().checkbox);

        }
    }

    @And("kullanici Wifi Settings tikladi")
    public void kullaniciWifiSettingsTikladi() throws InterruptedException {

        tapOn(screens.preferenceDependenciesScreen().wifeSettings);

    }

    @Then("Wifi setting popup geldi")
    public void wifiSettingPopupGeldi() {

        Assert.assertTrue(screens.preferenceDependenciesScreen().cancelButton.isDisplayed());
    }

    @And("kullanici {string} yazdi")
    public void kullaniciYazdi(String text) {
        enterText(screens.preferenceDependenciesScreen().textBox, text, true);
    }

    @And("kullanici ok butonuna tikladi")
    public void kullaniciOkButonunaTikladi() {

        tapOn(screens.preferenceDependenciesScreen().okButton);
    }

    @And("kullanici Switches tikladi")
    public void kullaniciSwitchesTikladi() {

        tapOn(screens.preferenceScreen().switchButton);
    }

    @And("kullanici check box tikladi")
    public void kullaniciCheckBoxTikladi() {
        tapOn(screens.switchScreen().checkBox);

    }

    @And("kullanici switch butonuna tikladi")
    public void kullaniciSwitchButonunaTikladi() {
        tapOn(screens.switchScreen().firstSwitch);

    }

    @And("check box secili olmali")
    public void checkBoxSeciliOlmali() {

        if (screens.preferenceDependenciesScreen().checkbox.getAttribute("checked").equals("false")) {
            tapOn(screens.switchScreen().checkBox);
        }

    }

    @And("ilk swicth butonu kapali")
    public void ilkSwicthButonuKapali() {

        if (screens.switchScreen().firstSwitch.getAttribute("checked").equals("true")) {
            tapOn(screens.switchScreen().firstSwitch);
        }

    }

    @And("ikinci switch butonu acik")
    public void ikinciSwitchButonuAcik() {
        if (screens.switchScreen().secondSwitch.getAttribute("checked").equals("false")) {
            tapOn(screens.switchScreen().secondSwitch);
        }

    }

    @And("kullanici {string} butununa tikladi")
    public void kullaniciButununaTikladi(String text) {

        tapOnElementWithText(text);

    }

    @Then("kullanici {string} ekraninda")
    public void kullaniciEkraninda(String text) {

        isElementPresent(text);

    }

    @And("kullici make popup butonuna tikladi")
    public void kulliciMakePopupButonunaTikladi() {

        tapOn(screens.popupMenuScreen().makePopupButton);

    }

    @And("kullanici Search butununa tikladi")
    public void kullaniciSearchButununaTikladi() {

        tapOn(screens.popupMenuScreen().searchButton);

    }

    @Then("popup mesaji onayla")
    public void popupMesajiOnayla() {
        String message = screens.popupMenuScreen().popupMessage.getAttribute("name");
        Assert.assertTrue(message.contains("Search"));
        System.out.println("tam mesaj = " + message);

    }

    @And("kullanici Webview butununa tikladi")
    public void kullaniciWebviewButununaTikladi() throws InterruptedException {

        System.out.println("webview tiklamadan once ===> " + Driver.getAppiumDriver().getContext());
        scrollWithUiScrollable("WebView");

        System.out.println("webview tikladiktan sonra ===> " + Driver.getAppiumDriver().getContext());
        Set<String> allContext = Driver.getAppiumDriver().getContextHandles();

        for (String each : allContext) {

            System.out.println(each);
            if (each.contains("WEBVIEW")) {

                Driver.getAppiumDriver().context("WEBVIEW");
            }
        }

        System.out.println("son durum ===> " + Driver.getAppiumDriver().getContext());


    }


}