package org.kagisho.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {}

    public static void createLocalDriver(String browser, boolean headless) {
        WebDriver driver;

        if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            if (headless) options.addArguments("--headless=new");
            driver = new EdgeDriver(options);


        } else if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (headless) options.addArguments("--headless=new");
            options.addArguments("--disable-gpu", "--window-size=1920,1080");
            driver = new ChromeDriver(options);



        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driverThreadLocal.set(driver);
    }



    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }


    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}

