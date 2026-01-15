package kagishomangaba.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.kagisho.factory.DriverFactory;
import org.kagisho.managers.BrowserManager;
import org.kagisho.pages.LandingPage;
import org.kagisho.utilities.ConfigLoader;
import org.kagisho.utilities.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import static org.kagisho.utilities.JsonDataReader.getJsonDataToMap;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        BrowserManager.launchBrowser();
        driver = DriverFactory.getDriver();
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {}
    }



    @DataProvider
    public Object[][] getData() throws IOException {
        String jsonPath = Paths.get(System.getProperty("user.dir"),
                        "src", "main", "java", "org", "kagisho", "data", "patientData.json")
                .toString();
        List<HashMap<String, String>> dataList = getJsonDataToMap(jsonPath);


        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }
        return dataArray;
    }
}
