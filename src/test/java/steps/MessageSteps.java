package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.TestRunner;



public class MessageSteps {

    @Given("I am on the message page")
    public void i_am_on_the_message_page() {
        TestRunner.driver.get("C:\\Users\\Yeonghwan Choi\\Desktop\\P2_project\\Byte-Sized\\frontend\\html\\message.html");

    }

    @When("I type in hey you there")
    public void i_type_in_hey_you_there() {
        TestRunner.byteSizedMessage.typeInTitle("I type in hey you there");

    }
    @When("I type in {string}")
    public void i_type_in(String string) {
        TestRunner.byteSizedMessage.typeInUserId(string);
    }

    @When("I type in your food is too expensive")
    public void i_type_in_your_food_is_too_expensive() {
        TestRunner.byteSizedMessage.typeInTestArea("food is too expensive");

    }

    @When("I click a submit button")
    public void i_click_a_submit_button() {
        TestRunner.byteSizedMessage.clickSubmitButton();

    }

    @Then("I should be able to see the alert message")
    public void i_should_be_able_to_see_the_alert_message() {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("message sent successfully",TestRunner.driver.switchTo().alert().getText());

    }
}