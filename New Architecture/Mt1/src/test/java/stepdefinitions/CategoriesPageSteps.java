package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CategoriesPage;
import pages.HomePage;
import utils.DriverManager;

public class CategoriesPageSteps {

    CategoriesPage categoriesPage = new CategoriesPage(DriverManager.getDriver());

    @When("user taps {string} on Categories Page")
    public void user_taps_on_categories_page(String tab) {
        categoriesPage.clickTab(tab);
    }

    @When("user close alert on Categories Page")
    public void userCloseAlertOnCategoriesPage() {
        categoriesPage.closeAlert();
    }

}