package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginTest {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Login() {

        driver.get("http://localhost/covid-tms/login.php");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("inputpwd")).sendKeys("pass");
        driver.findElement(By.name("login")).click();

        // optional validation
        System.out.println(driver.getCurrentUrl());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
