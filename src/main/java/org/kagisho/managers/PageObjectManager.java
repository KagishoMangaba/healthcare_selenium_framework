package org.kagisho.managers;

import org.kagisho.pages.AppointmentPage;
import org.kagisho.pages.ConfirmationPage;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private LandingPage landingPage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AppointmentPage getAppointmentPage() {
        if (appointmentPage == null) {
            appointmentPage = new AppointmentPage(driver);
        }
        return appointmentPage;
    }

    public ConfirmationPage getConfirmationPage() {
        if (confirmationPage == null) {
            confirmationPage = new ConfirmationPage(driver);
        }
        return confirmationPage;
    }
}
