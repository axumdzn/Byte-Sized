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
import poms.ByteSizedMessage;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"steps"},
        plugin = {"pretty","html:src/test/resources/reports/html-e2e-report.html"} //copy path reference of resources folder from content root
)
public class TestRunner
{

    public static WebDriver driver;
    public static ByteSizedHome byteSizedHome; //field represents POM
    public static WebDriverWait wait;
    public static ByteSizedMessage byteSizedMessage;
    @BeforeClass
    public static void setup()
    {
        File file = new File("src/test/resources/chromedriver.exe"); //content root
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

        byteSizedHome = new ByteSizedHome(driver);
        byteSizedMessage = new ByteSizedMessage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));//keep seconds short
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterClass
    public static  void teardown()
    {
        driver.quit();
    }
}
