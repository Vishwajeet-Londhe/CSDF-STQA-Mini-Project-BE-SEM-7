package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MissingGovtIDTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testMissingGovtID() {
        driver.get("http://localhost/covid-tms/new-user-testing.php");

        driver.findElement(By.id("fullname")).sendKeys("Test User");
        driver.findElement(By.id("mobilenumber")).sendKeys("9999999999");
        driver.findElement(By.id("dob")).sendKeys("05-05-1999");
        // Govt ID intentionally left blank
        driver.findElement(By.id("govtidnumber")).sendKeys("");
        driver.findElement(By.id("submit")).click();

        boolean isErrorShown = driver.getPageSource().contains("Government ID required")
                || driver.getPageSource().contains("Please enter ID");
        Assert.assertTrue(isErrorShown, "❌ Govt ID validation not triggered!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
