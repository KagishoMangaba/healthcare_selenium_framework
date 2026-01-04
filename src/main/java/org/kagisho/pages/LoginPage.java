package org.kagisho.pages;

import org.kagisho.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    @FindBy(id = "txt-username")
    WebElement usernameEle;

    @FindBy(name = "password")
    WebElement passwordEle;

    @FindBy(id = "btn-login")
    WebElement loginBtn;

    @FindBy(xpath = "//p[@class='lead text-danger']")
    WebElement loginErrorMessage;


    public void enterCredentials(String username , String password) {
        usernameEle.sendKeys(username);
        passwordEle.sendKeys(password);

    }

    public String getErrorMessage() {
        waitForElementToAppear(By.xpath("//p[@class='lead text-danger']"));
        return loginErrorMessage.getText();

    }

    public AppointmentPage clickLoginBtn() {
        loginBtn.click();
        return new AppointmentPage(driver);

    }

}
