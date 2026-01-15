package org.kagisho.base;

import org.kagisho.utilities.ConfigLoader;
import org.kagisho.utilities.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageInteractions {


    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageInteractions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        int explicitWait = Integer.parseInt(
                ConfigLoader.getProperties().getProperty("explicitWait")
        );
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }




    public WebElement waitForElementToBeClickable(WebElement element, String elementName) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            LoggerUtil.info(elementName + " is clickable.");
            return el;
        } catch (StaleElementReferenceException e) {
            LoggerUtil.warn(elementName + " became stale. Retrying...");
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException(elementName + " was not clickable within timeout", e);
        }
    }



    public void waitForElementToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    public void waitForWebElementToAppear(WebElement findBy) {
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }


    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }




    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateToUrl(String url) {
        driver.get(url);

    }





}
