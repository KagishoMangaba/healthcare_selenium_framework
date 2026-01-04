package kagishomangaba.tests;

import kagishomangaba.TestComponents.TestContent;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.annotations.Test;

public class Logout extends TestContent {

    private LandingPage landingPage;

    @Test
     public void userLogOut()   {

        LandingPage landingpage = launchApplication();
        LoginPage loginPage = landingpage.goToLoginPage();
        loginPage.enterCredentials("John Doe" , "ThisIsNotAPassword");
        loginPage.clickLoginBtn();

        landingpage.logOut();

    }



}
