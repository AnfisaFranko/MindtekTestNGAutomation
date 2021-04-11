package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import utilities.Configuration;

public class DriverTest {

    @Test
    public void edgeTest () {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testProperties () {
        System.out.println(Configuration.getProperty("browser")); // chrome
        System.out.println(Configuration.getProperty("username")); // Mindtek
    }
}
