package kagishomangaba.TestComponents;

import org.kagisho.factory.DriverFactory;
import org.kagisho.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        Properties prop = new Properties();

        String configPath = Paths.get(
                System.getProperty("user.dir"),
                "src", "main", "java",
                "org", "kagisho", "resources",
                "Globaldata.properties"
        ).toString();

        FileInputStream fis = new FileInputStream(configPath);
        prop.load(fis);

        String browser = prop.getProperty("browser", "chrome");



        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }


}
