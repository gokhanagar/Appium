package stepdefinitions;

import io.cucumber.java.en.When;
import pages.FiltersPage;
import utils.DriverManager;

public class FilterPageSteps {
    FiltersPage filtersPage = new FiltersPage(DriverManager.getDriver());

    @When("taps {string} on Filters Page")
    public void tapsOnFiltersPage(String fiyat) {
        filtersPage.clickPrice();

    }

    @When("sendkeys Max Price {string} on Filters Page")
    public void sendkeysMaxPriceOnFiltersPage(String price) {
        filtersPage.sendPrice(price);
    }

    @When("taps {string} button on Filters Page")
    public void tapsButtonOnFiltersPage(String tamam) {
        filtersPage.clickOk();
    }

    @When("taps Show Results Button on Filters Page")
    public void tapsShowResultsButtonOnFiltersPage() {
        filtersPage.clickResults();
    }
}