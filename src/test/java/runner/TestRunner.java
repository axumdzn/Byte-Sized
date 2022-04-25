package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"srctest/resources/features/ByteSizedLinks.feature"},
        glue = {"steps/ByteSizedSteps.java"},
        plugin = {""}

)
public class TestRunner
{

}
