package kagishomangaba.steps;

import io.cucumber.java.en.Given;
import kagishomangaba.TestComponents.TestContent;
import org.kagisho.factory.DriverFactory;
import org.kagisho.pages.LandingPage;

public class Login extends TestContent{


    private LandingPage landingPage;



    @Given("the user has landed on the landing page")
    public void i_have_landed_on_Incredible_Connection() {

        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
        landingPage = launchApplication();
    }



}
