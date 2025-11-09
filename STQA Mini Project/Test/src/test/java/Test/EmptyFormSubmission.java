package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmptyFormSubmission {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testEmptyFormSubmission() {
        // Open your local COVID testing form page
        driver.get("http://localhost/covid-tms/new-user-testing.php");

        // Click on submit without filling anything
        driver.findElement(By.id("submit")).click();

        // Check if an error message appears
        boolean isErrorDisplayed = driver.getPageSource().contains("All fields are required")
                || driver.getPageSource().contains("Please fill out this field");

        Assert.assertTrue(isErrorDisplayed, "❌ Error message not displayed for empty form submission!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
