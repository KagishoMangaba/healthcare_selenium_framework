package org.kagisho.tests.regression;

import org.kagisho.base.Retry;
import org.kagisho.base.TestContent;
import org.kagisho.pages.AppointmentPage;
import org.kagisho.pages.ConfirmationPage;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AppointmentCreation extends TestContent {

    private LandingPage landingPage;
    private AppointmentPage appointmentPage;

    @Test(dataProvider = "getData" , retryAnalyzer = Retry.class)
    public void createAppointment(HashMap<String , String> data) {

        String facility = "Hongkong CURA Healthcare Center";
        String program = "Medicare";
        String visitDate = "15/01/2026";
        String comment = "Regular checkup";

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToLoginPage();
        loginPage.enterCredentials(data.get("username") , data.get("password"));

        appointmentPage = loginPage.clickLoginBtn();

        ConfirmationPage confirmationPage = appointmentPage.completeAppointmentPage(
                "Hongkong CURA Healthcare Center",
                "Medicare",
                "15/01/2026",
                "Regular checkup"
        );


        Assert.assertTrue(confirmationPage.isAppointmentConfirmationDisplayed(),
                "Appointment confirmation header is not displayed");


        Assert.assertEquals(confirmationPage.getAppointmentConfirmationText(),
                "Appointment Confirmation",
                "Confirmation header text mismatch");

        Assert.assertEquals(confirmationPage.getFacility(), facility,
                "Facility name mismatch");

        Assert.assertTrue(confirmationPage.getProgram().contains(program),
                "Healthcare program mismatch");

        Assert.assertEquals(confirmationPage.getVisitDate(), visitDate,
                "Visit date mismatch");

        Assert.assertTrue(confirmationPage.verifyCompleteAppointment(
                        facility, visitDate, program, comment),
                "Appointment details verification failed");
    }


    //wil be adding order history tet

}
