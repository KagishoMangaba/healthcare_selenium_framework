package kagishomangaba.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import kagishomangaba.TestComponents.TestContent;
import org.kagisho.factory.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        // Pick your browser here; can also read from config
        String browser = "chrome";
        DriverFactory.createLocalDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        DriverFactory.quitDriver();
    }
}
