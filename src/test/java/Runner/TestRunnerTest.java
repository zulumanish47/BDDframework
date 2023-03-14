package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/Features"},
        glue={"stepDef"},
        dryRun = false
        //format={"pretty","html:test-outout"}
)

public class TestRunnerTest {}