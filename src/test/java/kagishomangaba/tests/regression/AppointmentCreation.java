package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.TestContent;
import org.kagisho.pages.AppointmentPage;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.kagisho.utilities.JsonDataReader.getJsonDataToMap;

public class AppointmentCreation extends TestContent {

    private LandingPage landingPage;
    private AppointmentPage appointmentPage;

    @Test(dataProvider = "getData")
    public void createAppointment(HashMap<String , String> input) {

        LandingPage landingPage = launchApplication();

        LoginPage loginPage = landingPage.goToLoginPage();

        loginPage.enterCredentials(input.get("username") , input.get("password"));

        appointmentPage = loginPage.clickLoginBtn();
        appointmentPage.selectFacility("Tokyo CURA Healthcare Center");

        appointmentPage.applyForHospitalReadmission();
        appointmentPage.chooseHealthcareProgram("medicare");
    }

    @Test(dependsOnMethods = {"createAppointment"})


    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//main//java//org//kagisho//data//patientData.json");
        return new Object [][] { {data.get(0)}  , {data.get(1)} };

    }





}
