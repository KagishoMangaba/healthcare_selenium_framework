package kagishomangaba.steps;

import io.cucumber.java.en.Given;
import kagishomangaba.TestComponents.TestContent;
import org.kagisho.factory.DriverFactory;
import org.kagisho.pages.LandingPage;
import org.kagisho.pages.LoginPage;

public class Login extends TestContent {


    private LandingPage landingPage;


    @Given("the user has landed on the landing page")
    public void i_have_landed_on_Incredible_Connection() {

        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
        landingPage = launchApplication();
    }


    @Given("the user logs in with username {string} and password {string}")
    public void i_enter_the_valid_credentials(String username, String password) {


    }
}
