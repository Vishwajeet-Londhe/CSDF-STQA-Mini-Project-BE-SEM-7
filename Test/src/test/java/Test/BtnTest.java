package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BtnTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void DashboardLoadTest() {

        // ✅ Open Dashboard page
        driver.get("http://localhost/covid-tms/live-test-updates.php");

        // ✅ Verify Dashboard loaded
        assert driver.getPageSource().contains("Dashboard");

        // ✅ Print test passed
        System.out.println("✅ Dashboard loaded successfully!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
