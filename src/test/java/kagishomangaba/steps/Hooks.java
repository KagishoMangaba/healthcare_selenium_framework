package kagishomangaba.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import kagishomangaba.TestComponents.TestContent;
import org.kagisho.factory.DriverFactory;
import org.kagisho.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    @Before
    public void setUp() {
        Properties prop = ConfigLoader.getProperties();
        String browser = prop.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));


        DriverFactory.createLocalDriver(browser, headless);


        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));


        if (!headless) {
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }


}
