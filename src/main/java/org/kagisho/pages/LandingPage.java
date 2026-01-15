package org.kagisho.pages;

import org.kagisho.base.PageInteractions;
import org.kagisho.utilities.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageInteractions {


    @FindBy(id = "btn-make-appointment")
    WebElement makeAppointmentBtn;

    @FindBy(id = "menu-toggle")
    WebElement openMenu;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homebtn;

    @FindBy(xpath = "//a[normalize-space()='History']")
    WebElement historyButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement navigateToLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutBtn;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage() {
        openMenu.click();
        waitForElementToBeClickable(navigateToLogin , "Login button" );
        navigateToLogin.click();
        return new LoginPage(driver);
    }



    public void logOut() {
        openMenu.click();
        waitForElementToBeClickable(logoutBtn , "Logout button");
        logoutBtn.click();
    }

    public LandingPage goToHomePage() {
        openMenu.click();
        waitForElementToBeClickable(homebtn , "Home button");
        return new LandingPage(driver);
    }

    public LoginPage clickMakeAppointment() {
        makeAppointmentBtn.click();
        return new LoginPage(driver);
    }


    public void goTo() {
        driver.get(ConfigLoader.getProperties().getProperty("url"));
    }


}
