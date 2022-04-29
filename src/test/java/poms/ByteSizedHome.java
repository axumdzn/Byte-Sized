package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByteSizedHome
{
    private WebDriver driver;

    private By usernameField = By.id("username-field");
    private By passwordField = By.id("password-field");
    private By loginButton = By.xpath("/html/body/div/div[2]/form/button");

    public ByteSizedHome(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "purchase")
    public WebElement purchase;
    @FindBy(className = "shop-item-button")
    public WebElement addItem;

    @FindBy(className = "btn-danger")
    public WebElement removeItem;

    @FindBy()
    public WebElement messageSeller;

    @FindBy
    public WebElement viewStats;

    @FindBy(id = "username-field")
    public WebElement userNameSelector;

    @FindBy(id = "password-field")
    public WebElement passWordSelector;

    @FindBy(id = "login")
    public WebElement clickSubmitButton;


    public void sendKeysToUsername(String input){
        driver.findElement(usernameField).sendKeys(input);
    }
    public void sendKeysToPassword(String input){
        driver.findElement(passwordField).sendKeys(input);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    private By addToCart = By.id("button1");

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    private By purchaseBtn = By.id("purchase");

    public void clickPurchase(){
        driver.findElement(purchaseBtn).click();
    }
}
