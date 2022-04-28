package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runner.TestRunner;

public class MessageSteps {

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("ByteSizeMessage.html");
    }

    @When("I click the remove button")
    public void i_click_the_remove_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The item should be removed")
    public void the_item_should_be_removed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("I am on the seller's page")
    public void i_am_on_the_seller_s_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Byte-Sized Shopping Page", title);
    }

    @Then("I should see the seller's products")
    public void i_should_see_the_seller_s_products() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see the seller's rating")
    public void i_should_see_the_seller_s_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
