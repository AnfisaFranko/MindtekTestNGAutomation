package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoFlightsPage;
import pages.BlazeDemoHomepage;
import utilities.Configuration;
import utilities.TestBase;
import java.util.List;

public class BlazeDemoPriceTest extends TestBase {


    @Test (groups = {"regression", "smoke"})
    public void priceTest () {
        BlazeDemoHomepage blazeDemoHomepage = new BlazeDemoHomepage();
        BlazeDemoFlightsPage blazeDemoFlightsPage = new BlazeDemoFlightsPage();

        driver.get(Configuration.getProperty("BlazeDemoURL"));
        blazeDemoHomepage.findFlightsButton.click();
       // List <WebElement> prices = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
        List <WebElement> prices = blazeDemoFlightsPage.prices;


        for (WebElement price: prices) {
           String strPrice = price.getText().substring(1); // $472.56 -> 472.56

           double doublePrice = Double.parseDouble(strPrice);

            Assert.assertTrue(doublePrice < 1000); // 472.56 < 1000 -> true
           System.out.println(doublePrice);
        }
    }

    /*
    Test1 : Verify that test result  having only two "Virgin America" flights
    Test2 : Verify that flight text having right city names like (Flights from San Diego to New York)
     */


    @Test
    public void flightTest1 () {
        driver.get(Configuration.getProperty("BlazeDemoURL"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List <WebElement> airlines = driver.findElements(By.xpath("//table[@class='table']//td[3]"));

        String certainAirline = "Virgin America";
        int count = 0;
        for (WebElement airline : airlines) {
            String strAirline = airline.getText();
            if (strAirline.equals(certainAirline)) {
                count++;
            }
        }
        Assert.assertTrue(count == 2);
    }

}
