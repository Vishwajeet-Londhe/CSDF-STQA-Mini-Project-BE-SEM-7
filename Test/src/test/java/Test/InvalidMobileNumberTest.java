package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidMobileNumberTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidMobileNumber() {
        driver.get("http://localhost/covid-tms/new-user-testing.php");

        driver.findElement(By.id("fullname")).sendKeys("Test User");
        driver.findElement(By.id("mobilenumber")).sendKeys("123"); // invalid
        driver.findElement(By.id("dob")).sendKeys("01-01-2000");
        driver.findElement(By.id("govtissuedid")).sendKeys("Aadhar");
        driver.findElement(By.id("govtidnumber")).sendKeys("123456789012");
        driver.findElement(By.id("submit")).click();

        boolean isErrorShown = driver.getPageSource().contains("Invalid Mobile Number")
                || driver.getPageSource().contains("Enter valid phone");
        Assert.assertTrue(isErrorShown, "❌ No validation for invalid mobile number!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
