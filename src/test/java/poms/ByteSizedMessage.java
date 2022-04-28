package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByteSizedMessage {

    private WebDriver driver;

    private By title = By.id("title");
    private By userId = By.id("userid");
    private By textArea = By.id("textarea");
    private By button = By.id("submitButton");

    public ByteSizedMessage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    public WebElement titleSelector ;

    @FindBy(id = "userid")
    public WebElement useridSelector;

    @FindBy(id = "testarea")
    public WebElement testAreaSelector;

    @FindBy(id = "submitButton")
    public WebElement clickSubmitButton;

    public void typeInTitle(String input){
        driver.findElement(title).sendKeys(input);
    }
    public void typeInUserId(String input){
        driver.findElement(userId).sendKeys(input);
    }
    public void typeInTestArea(String input){
        driver.findElement(textArea).sendKeys(input);
    }

    public void clickSubmitButton(){
        driver.findElement(button).click();
    }
}
