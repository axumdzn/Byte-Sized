package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.ByteSizedHome;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ByteSizedLinks.feature"},
        glue = {"steps/ByteSizedSteps"}
        //plugin = {""}

)
public class TestRunner
{

    public static WebDriver driver;
    public static ByteSizedHome byteSizedHome; //field represents POM
    //public static DelayDisappearHome ddHome;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup()
    {//below sets your driver as a chrome driver
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        byteSizedHome = new ByteSizedHome(driver);
        //ddHome = new DelayDisappearHome(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));//keep seconds short
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }

    @AfterClass
    public static  void teardown()
    {
        driver.quit();
    }



}
