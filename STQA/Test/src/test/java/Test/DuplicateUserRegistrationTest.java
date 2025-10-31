package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DuplicateUserRegistrationTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDuplicateRegistration() {
        driver.get("http://localhost/covid-tms/new-user-testing.php");

        // Enter details of an already registered user
        driver.findElement(By.id("fullname")).sendKeys("Swapnil Take");
        driver.findElement(By.id("mobilenumber")).sendKeys("8607878789");
        driver.findElement(By.id("dob")).sendKeys("09-04-2000");
        driver.findElement(By.id("govtissuedid")).sendKeys("Aadhar");
        driver.findElement(By.id("govtidnumber")).sendKeys("123456789012");
        driver.findElement(By.id("submit")).click();

        boolean isDuplicateMessage = driver.getPageSource().contains("already registered")
                || driver.getPageSource().contains("User exists");
        Assert.assertTrue(isDuplicateMessage, "❌ Duplicate user registration not blocked!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
