package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogoutFunctionalityTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogout() {
        driver.get("http://localhost/covid-tms/login.php");

        // Login
        driver.findElement(By.id("username")).sendKeys("swapnil");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login")).click();

        // Click logout
        driver.findElement(By.id("logout")).click();

        // Check redirect to login page
        boolean isRedirected = driver.getCurrentUrl().contains("login.php")
                || driver.getPageSource().contains("Login to continue");
        Assert.assertTrue(isRedirected, "❌ Logout failed or session not cleared!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
