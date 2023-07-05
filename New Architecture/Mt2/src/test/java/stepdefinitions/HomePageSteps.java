package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasketPage;
import pages.HomePage;
import utils.DriverManager;

public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("taps Popup Close Button on Home Page")
    public void shouldPopupCloseButtonOnHomePage() {
        homePage.clickPopupClose();
    }

    @Then("should see the Home Page")
    public void shouldSeeTheHomePage() {
        homePage.checkSearchArea();
    }

    @When("taps Search Area on Home Page")
    public void tapsSearchAreaOnHomePage() {
        homePage.clickSearchArea();
    }

}