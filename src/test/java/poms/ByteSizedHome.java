package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByteSizedHome
{
    private WebDriver driver;

    public ByteSizedHome(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "")
    public WebElement cancelItem;

    @FindBy
    public WebElement messageSeller;

    @FindBy
    public WebElement viewStats;

    @FindBy
    public WebElement viewAllSellersProducts;

}
