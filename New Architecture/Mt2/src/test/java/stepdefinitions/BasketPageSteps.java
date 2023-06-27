package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasketPage;
import utils.DriverManager;

public class BasketPageSteps {

    BasketPage basketPage = new BasketPage(DriverManager.getDriver());

    @Then("should see the Basket Page")
    public void shouldSeeTheBasketPage() {
        basketPage.checkTitle();
    }

    @And("should see Same Product Name on Basket Page")
    public void shouldSeeSameProductNameOnBasketPage() {
        String productName = ProductPageSteps.productName;
        String currentProductName = basketPage.getProductName();
        Assert.assertEquals(currentProductName, productName);
    }

    @When("taps Delete Button on Basket Page")
    public void tapsDeleteButtonOnBasketPage() {
        basketPage.clickDeleteButton();
    }

    @And("taps Delete Popup on Basket Page")
    public void tapsDeletePopupOnBasketPage() {
        basketPage.clickPopupDeleteButton();
    }

    @Then("should see Empty Message {string} on Basket Page")
    public void shouldSeeEmptyMessageOnBasketPage(String message) {
        String currentMessage = basketPage.getEmptyMessage();
        Assert.assertEquals(currentMessage, message);
    }

}
