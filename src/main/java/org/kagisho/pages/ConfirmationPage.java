package org.kagisho.pages;

import org.kagisho.base.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponents {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Appointment Confirmation']")
    private WebElement appointmentConfirmation;

    @FindBy(id = "facility")
    private WebElement facilityConfirmation;

    @FindBy(id = "program")
    private WebElement programConfirmation;

    @FindBy(id = "visit_date")
    private WebElement dateConfirmation;

    @FindBy(id = "comment")
    private WebElement commentConfirmation;

    // Verification methods
    public boolean isAppointmentConfirmationDisplayed() {
        return appointmentConfirmation.isDisplayed();
    }

    public String getAppointmentConfirmationText() {
        return appointmentConfirmation.getText();
    }

    public String getFacility() {
        return facilityConfirmation.getText();
    }

    public String getProgram() {
        return programConfirmation.getText();
    }

    public String getVisitDate() {
        return dateConfirmation.getText();
    }

    public String getComment() {
        return commentConfirmation.getText();
    }

    // Comprehensive verification method
    public boolean verifyAppointmentDetails(String expectedFacility, String expectedDate, String expectedProgram) {
        return getFacility().equals(expectedFacility)
                && getVisitDate().equals(expectedDate)
                && getProgram().contains(expectedProgram);
    }

    // Verification with program and comment
    public boolean verifyCompleteAppointment(String expectedFacility, String expectedDate,
                                             String expectedProgram, String expectedComment) {
        return getFacility().equals(expectedFacility)
                && getVisitDate().equals(expectedDate)
                && getProgram().contains(expectedProgram)
                && getComment().equals(expectedComment);
    }
}