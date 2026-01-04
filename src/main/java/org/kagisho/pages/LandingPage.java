package org.kagisho.pages;

import org.kagisho.base.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    private WebDriver driver;

    @FindBy(id = "btn-make-appointment")
    WebElement makeAppointmentBtn;

    @FindBy(id = "menu-toggle")
    WebElement openMenu;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homebtn;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement navigateToLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutBtn;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage() {
        openMenu.click();
        waitForElementToBeClickable(navigateToLogin);
        navigateToLogin.click();
        return new LoginPage(driver);
    }

    public void logOut() {
        openMenu.click();
        waitForElementToBeClickable(logoutBtn);
        logoutBtn.click();
    }

    public LandingPage goToHomePage() {
        openMenu.click();
        waitForElementToBeClickable(homebtn);
        return new LandingPage(driver);
    }

    public LoginPage clickMakeAppointment() {
        makeAppointmentBtn.click();
        return new LoginPage(driver);
    }


    public void goTo() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }


}
