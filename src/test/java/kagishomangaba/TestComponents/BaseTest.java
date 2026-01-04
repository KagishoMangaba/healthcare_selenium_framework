package kagishomangaba.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.kagisho.factory.DriverFactory;
import org.kagisho.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        Properties prop = new Properties();

        String configPath = Paths.get(
                System.getProperty("user.dir"),
                "src", "main", "java",
                "org", "kagisho", "resources",
                "Globaldata.properties"
        ).toString();

        FileInputStream fis = new FileInputStream(configPath);
        prop.load(fis);

        String browser = prop.getProperty("browser", "chrome");



        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(
                new File(filePath),
                StandardCharsets.UTF_8
        );

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {}
        );
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }


}
