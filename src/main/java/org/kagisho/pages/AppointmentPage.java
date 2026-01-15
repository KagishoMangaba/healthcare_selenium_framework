package org.kagisho.pages;

import org.kagisho.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends PageInteractions {

    private WebDriver driver;

    public AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "combo_facility")
    private WebElement facilityDropdown;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement applyForHospitalReadmissionCheckbox;

    @FindBy(id = "radio_program_medicare")
    private WebElement medicareRadio;

    @FindBy(id = "radio_program_medicaid")
    private WebElement medicaidRadio;

    @FindBy(id = "radio_program_none")
    private WebElement noneRadio;

    @FindBy(id = "txt_visit_date")
    private WebElement visitDateField;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;

    @FindBy(id = "txt_comment")
    private WebElement commentField;


    public void selectFacility(String facilityName) {
        waitForElementToBeClickable(facilityDropdown , "facility dropdown button");
        Select select = new Select(facilityDropdown);
        select.selectByVisibleText(facilityName);
    }

    public void applyForHospitalReadmission() {
        waitForElementToBeClickable(applyForHospitalReadmissionCheckbox , "apply For Hospital Readmission Checkbox");
        if (!applyForHospitalReadmissionCheckbox.isSelected()) {
            applyForHospitalReadmissionCheckbox.click();
        }
    }

    public void chooseHealthcareProgram(String program) {
        String lowerProgram = program.toLowerCase();
        WebElement programRadio;

        if (lowerProgram.equals("medicare")) {
            programRadio = medicareRadio;
        } else if (lowerProgram.equals("medicaid")) {
            programRadio = medicaidRadio;
        } else if (lowerProgram.equals("none")) {
            programRadio = noneRadio;
        } else {
            throw new IllegalArgumentException("Invalid healthcare program: " + program);
        }

        waitForElementToBeClickable(programRadio , "program Radio");
        programRadio.click();
    }

    public void setVisitDate(String date) {
        waitForElementToBeClickable(visitDateField , "visitDate field");
        visitDateField.clear();
        visitDateField.sendKeys(date);
    }

    public void enterComment(String comment) {
        waitForElementToBeClickable(commentField , "comment field");
        commentField.sendKeys(comment);
    }

    public ConfirmationPage bookAppointment() {
        waitForElementToBeClickable(bookAppointmentButton , "Book Appointment button");
        bookAppointmentButton.click();
        return new ConfirmationPage(driver);
    }


    public ConfirmationPage completeAppointmentPage(String facilityName, String program, String date, String comment) {
        selectFacility(facilityName);
        chooseHealthcareProgram(program);
        setVisitDate(date);
        enterComment(comment);
        return bookAppointment();
    }
}