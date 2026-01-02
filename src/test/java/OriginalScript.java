import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OriginalScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Click the menu toggle button
        driver.findElement(By.id("menu-toggle")).click();

        // Wait for Login link to be clickable and store it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']"))
        );

        // Click the login link
        loginLink.click();


        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        // Close the browser when done
        // driver.quit();
    }
}