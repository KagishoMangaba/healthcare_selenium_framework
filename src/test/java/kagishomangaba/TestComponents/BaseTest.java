package kagishomangaba.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.kagisho.factory.DriverFactory;
import org.kagisho.managers.BrowserManager;
import org.kagisho.pages.LandingPage;
import org.kagisho.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        BrowserManager.launchBrowser();
        driver = DriverFactory.getDriver();
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception ignored) {}

    }

}
