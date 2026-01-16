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
        return landingPage = (landingPage == null) ? new LandingPage(driver) : landingPage;
    }

    public LoginPage getLoginPage() {
        return loginPage = (loginPage == null) ? new LoginPage(driver) : loginPage;
    }

    public AppointmentPage getAppointmentPage() {
        return appointmentPage = (appointmentPage == null) ? new AppointmentPage(driver) : appointmentPage;
    }

    public ConfirmationPage getConfirmationPage() {
        return confirmationPage = (confirmationPage == null) ? new ConfirmationPage(driver) : confirmationPage;
    }
}
