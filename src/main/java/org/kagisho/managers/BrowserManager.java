package org.kagisho.managers;

import org.kagisho.factory.DriverFactory;
import org.kagisho.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

public class BrowserManager {

    public static void launchBrowser() {
        Properties prop = ConfigLoader.getProperties();

        String browser = prop.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));


        DriverFactory.createLocalDriver(browser , headless);

        WebDriver driver = DriverFactory.getDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if(!headless) {
            driver.manage().window().maximize();
        }
    }
}
