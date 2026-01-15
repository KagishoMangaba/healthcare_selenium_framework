package org.kagisho.pages;

import org.kagisho.base.InputUtil;
import org.kagisho.base.PageInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageInteractions {


    private InputUtil inputUtil;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.inputUtil = new InputUtil(driver);
        PageFactory.initElements(driver, this);


    }

    @FindBy(id = "txt-username")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "btn-login")
    WebElement loginBtn;

    @FindBy(xpath = "//p[@class='lead text-danger']")
    WebElement loginErrorMessage;


    public void enterUsername(String username) {
        inputUtil.writeText(usernameInput , username);
    }

    public void enterPassword(String password) {
        inputUtil.writeText(passwordInput , password);

    }

    public void enterCredentials(String username , String password) {
      enterUsername(username);
      enterPassword(password);


    }

    public AppointmentPage clickLoginBtn() {
        loginBtn.click();
        return new AppointmentPage(driver);

    }


    public String getErrorMessage() {
        waitForElementToAppear(By.xpath("//p[@class='lead text-danger']"));
        return loginErrorMessage.getText();

    }


}
