package org.kagisho.base;

import org.kagisho.pages.LandingPage;

public class TestContent  extends BaseTest{

    protected LandingPage launchApplication() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

}
