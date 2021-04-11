package Assignments;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Configuration;
import utilities.TestBase;

public class BookingFlightFunctionalities extends TestBase {

    BookingHomePage bookingHomePage = new BookingHomePage();


    @Test
    public void selectFlight1 () {
        driver.get(Configuration.getProperty("BlazeDemoURL"));
        bookingHomePage.sanDiegoButton.click();
        bookingHomePage.newYorkButton.click();
        bookingHomePage.findFlightButton.click();
        bookingHomePage.chooseThisFlightButton.click();

        //Assert.assertEquals(driver.findElements(By.xpath("//input[@value='765.32']")), );

    }

    @DataProvider(name = "selectFlight2")
    public static Object [][] testData () {
        return new Object [][] {
                {"John Doe", "123 Washington ave.", "New York", "NY", "12345", "1", "1234567890", "11", "2025", "John Doe"}
        };
    }

    @Test (dataProvider = "selectFlight2")
    public void  selectFlight2 (String name, String address, String city, String state, String zipCode,
                            String cardType, String creditCardNumber, String month, String year, String nameOnCard) {

        BookingFlightRegisterPage bookingFlightRegisterPage = new BookingFlightRegisterPage();

        driver.get(Configuration.getProperty("BlazeDemoURL"));
        bookingHomePage.sanDiegoButton.click();
        bookingHomePage.newYorkButton.click();
        bookingHomePage.findFlightButton.click();
        bookingHomePage.chooseThisFlightButton.click();
        bookingFlightRegisterPage.name.sendKeys(name);
        bookingFlightRegisterPage.address.sendKeys(address);
        bookingFlightRegisterPage.city.sendKeys(city);
        bookingFlightRegisterPage.state.sendKeys(state);
        bookingFlightRegisterPage.zipCode.sendKeys(zipCode);
        bookingFlightRegisterPage.cardType.sendKeys(cardType);
        bookingFlightRegisterPage.creditCardNumber.sendKeys(creditCardNumber);
        bookingFlightRegisterPage.month.sendKeys(month);
        bookingFlightRegisterPage.year.sendKeys(year);
        bookingFlightRegisterPage.nameOnCard.sendKeys(nameOnCard);
        bookingHomePage.purchaseFlight.click();

        //String expectedTitle = "Thank you for your purchase today!";
        //String actualTitle = driver.getTitle();
        //Assert.assertEquals(actualTitle, expectedTitle);
    }
}
