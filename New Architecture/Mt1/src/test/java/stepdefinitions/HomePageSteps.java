package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManager;

public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @Given("user should see the Home Page")
    public void user_should_see_the_home_page() {
        homePage.checkInHomePage();
    }

    @When("user taps {string} on Home Page")
    public void userTapsOnHomePage(String tab) {
        homePage.clickTab(tab);

    }

}