package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.TestRunner;

public class LoginSteps {
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        TestRunner.driver.get("C:\\Users\\Yeonghwan Choi\\Desktop\\P2_project\\Byte-Sized\\frontend\\html\\login.html");
//        throw new io.cucumber.java.PendingException();
    }
    @When("I type in joejoe")
    public void i_type_in_joejoe() {
        TestRunner.byteSizedHome.sendKeysToUsername("joejoe");
//        throw new io.cucumber.java.PendingException();
    }

    @When("I type in password")
    public void i_type_in_password() {
        TestRunner.byteSizedHome.sendKeysToPassword("password");
//        throw new io.cucumber.java.PendingException();
    }
    @When("I click the button")
    public void i_click_the_button() {
        TestRunner.byteSizedHome.clickLogin();
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        TestRunner.driver.switchTo().alert().accept();
//        TestRunner.wait.until(ExpectedConditions.titleIs("Byte-Sized Shopping"));
        //        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be redirected to BYTE-SIZED shopping homepage")
    public void i_should_be_redirected_to_byte_sized_shopping_homepage() {
        Assert.assertEquals("Byte-Sized Shopping", TestRunner.driver.getTitle());
    }
}







