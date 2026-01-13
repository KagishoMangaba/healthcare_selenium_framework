package kagishomangaba.tests.regression;

import kagishomangaba.TestComponents.BaseTest;
import kagishomangaba.TestComponents.TestContent;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestContent {

        private LandingPage landingPage;

        @Test
        public void userCanLogin() {

            LandingPage landingpage = launchApplication();
            LoginPage loginPage = landingpage.goToLoginPage();
            loginPage.enterCredentials("John Doe" , "ThisIsNotAPassword");
            loginPage.clickLoginBtn();

        }

    @Test
    public void shouldDisplayErrorMessageForInvalidCredentials() {

        String expectedErrorMessage =
                "Login failed! Please ensure the username and password are valid.";

        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToLoginPage();

        loginPage.enterCredentials("Kagisho_m" , "Passwekd");
        loginPage.clickLoginBtn();

        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

}




