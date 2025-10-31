package Test;
 
	import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.AfterClass;
	 
	public class SearchAndDownloadReportTest {
	public WebDriver driver;
	  @Test
	  public void SearchUser(){
		  // page
	driver.get("http://localhost/covid-tms/patient-search-report.php");
	// Registerd user mobile number
	driver.findElement(By.id("searchdata")).sendKeys("1234567890");
	// Class path 
	driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div/div/div/div[2]/input")).click();
	//String s=driver.getCurrentUrl();
	  
	  String s=driver.getCurrentUrl();
	  if (s.equals("http://localhost/covid-tms/patient-report.php")) {
			System.out.println("1st Test Pass -- User Available"); 
			driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/form/div/div[2]/div/table/tbody/tr/td[8]/a")).click();
		}
		else {
			System.out.println("Test Fail");
			driver.quit();
		}
	  }
	  @BeforeClass
	  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver", "\"C:\\Users\\vishw\\OneDrive\\Desktop\\chromedriver.exe\"");
	  driver = new ChromeDriver();
	  
	  }
	 
	  @AfterClass
	  public void afterClass() {
	  driver.quit();
	  }
	 
	}

