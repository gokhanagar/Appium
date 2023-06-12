package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultsPage;
import utils.DriverManager;

public class ResultsPageSteps {
    ResultsPage resultsPage = new ResultsPage(DriverManager.getDriver());

    @Then("should see Results on Result Page")
    public void should_see_results_on_result_page() {
        resultsPage.checkShareIcon();

    }

    @When("taps filters on Result Page")
    public void tapsFiltersOnResultPage() {
        resultsPage.clickFilter();
    }

    @When("taps order on Results Page")
    public void tapsOrderOnResultsPage() {
        resultsPage.clickOrderTab();
    }

    @When("taps devam et Result Page")
    public void tapsDevamEtResultPage() {
        resultsPage.clickDevam();
    }

    @Then("should see first car price lower than of equals {string} on Results Page")
    public void shouldSeeFirstCarPriceLowerThanOfEqualsOnResultsPage(String price) {
        Assert.assertTrue(resultsPage.getTextPrice().equals(price));
    }
}