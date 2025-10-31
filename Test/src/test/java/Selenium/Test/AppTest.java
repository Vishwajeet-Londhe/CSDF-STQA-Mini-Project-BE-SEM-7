package Selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testApp() {
        System.out.println("TestNG is running!");
        Assert.assertTrue(true);
    }
}
