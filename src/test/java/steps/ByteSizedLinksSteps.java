package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runner.TestRunner;

public class ByteSizedLinksSteps
{
    @Given("I am on the seller's page")
    public void i_am_on_the_seller_s_page()
    {
        TestRunner.driver.get("C:\\Users\\Yeonghwan Choi\\Desktop\\P2_project\\Byte-Sized\\frontend\\html\\SellerPage.html");
    }
    @When("I click the add to cart button")
    public void i_click_the_add_to_cart_button()
    {
        TestRunner.byteSizedHome.addItem.click();
    }
    @When("I click the remove button")
    public void i_click_the_remove_button()
    {
        TestRunner.byteSizedHome.removeItem.click();
    }
    @Then("The item is removed and I am still on the seller's page")
    public void the_item_is_removed_and_i_am_still_on_the_seller_s_page()
    {
        Assert.assertEquals("Byte-Sized Shopping", TestRunner.driver.getTitle());
    }
    @Then("I should see the seller's products")
    public void i_should_see_the_seller_s_products()
    {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals("Byte-Sized Shopping", TestRunner.driver.getTitle());
    }

}
