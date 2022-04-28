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

    @FindBy(className = "shop-item-button")
    public WebElement addItem;

    @FindBy(className = "btn-danger")
    public WebElement removeItem;





}
