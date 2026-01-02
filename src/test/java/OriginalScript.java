import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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


        WebElement dropdown = driver.findElement(By.id("combo_facility"));
        Select select = new Select(dropdown);
        select.selectByIndex(0);

        driver.findElement(By.id("chk_hospotal_readmission")).click();


        // Open the calendar
        driver.findElement(By.id("txt_visit_date")).click();

        driver.findElement(By.xpath("//td[normalize-space()='8']")).click();

        driver.findElement(By.id("btn-book-appointment")).click();



//// Navigate month/year
//        WebElement nextMonth = driver.findElement(By.cssSelector(".ui-datepicker-next"));
//        nextMonth.click(); // repeat if necessary
//
//// Select day
//        List<WebElement> days = driver.findElements(By.cssSelector(".ui-datepicker-calendar td"));
//        for (WebElement day : days) {
//            if(day.getText().equals("15")) {
//                day.click();
//                break;
//            }
//        }


        // Close the browser when done
        // driver.quit();
    }
}