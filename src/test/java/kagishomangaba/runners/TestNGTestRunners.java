package kagishomangaba.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "kagishomangaba.steps",
        monochrome = true,

        plugin = {"pretty", "html:target/cucumber.html"}
)


public class TestNGTestRunners extends AbstractTestNGCucumberTests {

}
