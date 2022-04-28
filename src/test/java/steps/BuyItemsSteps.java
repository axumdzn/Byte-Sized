package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.TestRunner;

import java.time.Duration;

public class BuyItemsSteps {

    @Given("I am logged in")
    public void i_am_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("C:\\Users\\kennf\\code\\revature\\Byte-Sized\\frontend\\html\\login.html");
        TestRunner.byteSizedHome.sendKeysToUsername("joejoe");
        TestRunner.byteSizedHome.sendKeysToPassword("password");
        TestRunner.byteSizedHome.clickLogin();
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        TestRunner.driver.switchTo().alert().accept();
        TestRunner.wait.until(ExpectedConditions.titleIs("Byte-Sized Shopping"));
    }
    @When("I click on an item I want")
    public void i_click_on_an_item_i_want() {
        // Write code here that turns the phrase above into concrete actions

        TestRunner.byteSizedHome.clickAddToCart();
    }
    @When("I click the purchase button")
    public void i_click_the_purchase_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.byteSizedHome.purchase.click();
        Thread.sleep(2000);
    }
    @Then("I get a confirmation message that I bought something")
    public void i_get_a_confirmation_message_that_i_bought_something() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        String answer = TestRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(answer, "Thank you for your purchase");
    }

}
