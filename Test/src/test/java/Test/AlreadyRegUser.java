package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import java.time.Duration;

public class AlreadyRegUser {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver
        .manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost/covid-tms/registered-user-testing.php");
    }

    @Test
    public void validMobileNumberSearch() {

        // ✅ Enter registered number
        driver.findElement(By.id("regmobilenumber")).sendKeys("1234567890");

        // ✅ Click search
        driver.findElement(By.name("search")).click();

        // ✅ Verify section appears
        assert driver.getPageSource().contains("Personal Information");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
