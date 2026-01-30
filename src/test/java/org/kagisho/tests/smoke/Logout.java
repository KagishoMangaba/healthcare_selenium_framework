package org.kagisho.tests.smoke;

import org.kagisho.base.TestContent;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Logout extends TestContent {

    private LandingPage landingPage;

    @Test(dataProvider = "getData")
     public void userLogOut(HashMap<String , String> data)   {

        LandingPage landingpage = launchApplication();
        LoginPage loginPage = landingpage.goToLoginPage();
        loginPage.enterCredentials(data.get("username"), data.get("password"));
        loginPage.clickLoginBtn();
        landingpage.logOut();

    }


}
