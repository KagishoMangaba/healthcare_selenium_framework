package org.kagisho.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

    private WebDriver driver;

    public AppointmentPage(WebDriver driver) {
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
    WebElement healthcare_none;

    public void selectFacility(String facilityName) {
        Select select = new Select(facilityDropdown);
        select.selectByVisibleText(facilityName);
    }

    public void applyForHospitalReadmission() {
        if (!applyForHospitalReadmissionCheckbox.isSelected()) {
            applyForHospitalReadmissionCheckbox.click();
        }


    }

    public void chooseHealthcareProgram(String program) {
        switch (program.toLowerCase()) {
            case "medicare":
                medicareRadio.click();
                break;
            case "medicaid":
                medicaidRadio.click();
                break;
            case "none":
                noneRadio.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid healthcare program: " + program);
        }
    }

}
