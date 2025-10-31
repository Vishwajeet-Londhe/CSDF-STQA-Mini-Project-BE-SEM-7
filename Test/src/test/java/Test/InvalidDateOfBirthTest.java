package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidDateOfBirthTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFutureDateOfBirth() {
        driver.get("http://localhost/covid-tms/new-user-testing.php");

        driver.findElement(By.id("fullname")).sendKeys("Test User");
        driver.findElement(By.id("mobilenumber")).sendKeys("9876543210");
        driver.findElement(By.id("dob")).sendKeys("01-01-2030"); // future DOB
        driver.findElement(By.id("govtissuedid")).sendKeys("Aadhar");
        driver.findElement(By.id("govtidnumber")).sendKeys("987654321098");
        driver.findElement(By.id("submit")).click();

        boolean isErrorShown = driver.getPageSource().contains("Invalid Date of Birth")
                || driver.getPageSource().contains("Future date not allowed");
        Assert.assertTrue(isErrorShown, "❌ Invalid DOB not validated!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
