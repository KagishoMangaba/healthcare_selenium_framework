package kagishomangaba.tests;

import kagishomangaba.TestComponents.BaseTest;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.annotations.Test;

public class Login extends BaseTest {

        private LandingPage landingPage;

        @Test
        public void userCanLogin() {

            LandingPage landingpage = launchApplication();
            LoginPage loginPage = landingpage.goToLoginPage();



        }
    }




