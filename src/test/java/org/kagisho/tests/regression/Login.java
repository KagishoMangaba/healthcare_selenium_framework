package org.kagisho.tests.regression;

import org.kagisho.base.TestContent;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Login extends TestContent {

        private LandingPage landingPage;

        @Test(dataProvider = "getData")
        public void userCanLogin(HashMap<String , String> data) {

            LandingPage landingpage = launchApplication();
            LoginPage loginPage = landingpage.goToLoginPage();
            loginPage.enterCredentials(data.get("username") , data.get("password"));
            loginPage.clickLoginBtn();


        }

    @Test(dataProvider = "getData")
    public void inValidCredentials(HashMap<String , String> data) {

        String expectedErrorMessage = data.get("expectedErrorMessage");


        LandingPage landingPage = launchApplication();
        LoginPage loginPage = landingPage.goToLoginPage();

        loginPage.enterCredentials(data.get("invalidUsername") , data.get("invalidPassword"));
        loginPage.clickLoginBtn();

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }


}




