package org.kagisho.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputUtil extends PageInteractions {

    public InputUtil(WebDriver driver) {
        super(driver);
    }

    public void writeText(WebElement element, String InputText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(InputText);
    }
}
