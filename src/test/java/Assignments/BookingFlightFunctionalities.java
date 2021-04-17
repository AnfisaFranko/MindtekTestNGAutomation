package Assignments;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Configuration;
import utilities.TestBase;

public class BookingFlightFunctionalities extends TestBase {

    @Test
    public void selectFlight1() {
        BookingHomePage bookingHomePage = new BookingHomePage();

        driver.get(Configuration.getProperty("BlazeDemoURL"));
        bookingHomePage.sanDiegoButton.click();
        bookingHomePage.newYorkButton.click();
        bookingHomePage.findFlightButton.click();

        String firstPrice = driver.findElement(By.xpath("(//table[@class='table']//td[6])[4]")).getText().trim();
        ;
        bookingHomePage.chooseThisFlightButton.click();
        String secondPrice = driver.findElement(By.xpath("//em")).getText().trim();
        Assert.assertEquals(secondPrice, firstPrice, "Not equal.");

    }

    @DataProvider(name = "selectFlight2")
    public static Object[][] testFlight2() {
        return new Object[][]{
                {"John Doe", "123 Washington ave.", "New York", "NY", "12345", "1", "1234567890", "11", "2025", "John Doe"}
        };
    }

    @Test(dataProvider = "selectFlight2")
    public void selectFlight2(String name, String address, String city, String state, String zipCode,
                              String cardType, String creditCardNumber, String month, String year, String nameOnCard) {

        BookingFlightRegisterPage bookingFlightRegisterPage = new BookingFlightRegisterPage();
        BookingHomePage bookingHomePage = new BookingHomePage();

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

        String expectedMessage = "Thank you for your purchase today!";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage);

         String cardNumber = driver.findElement(By.xpath("(//td)[8]")).getText();
        String last4Digits = "";
        if (cardNumber.length() > 4) {
            last4Digits = cardNumber.substring(cardNumber.length() - 4);
        }
        String expectedLast4Digits = "7890";
        String actualLast4Digits = last4Digits;
        Assert.assertEquals(actualLast4Digits, expectedLast4Digits, "Not equal.");

        String expectedDate = "Mon, 12 Apr 2021";
        String dateOnSite = driver.findElement(By.xpath("(//td)[14]")).getText();
        String actualDate = dateOnSite.substring(0, dateOnSite.length() - 15);
        Assert.assertEquals(actualDate, expectedDate);

    }

    @DataProvider(name = "selectFlight3")
    public static Object[][] testFlight3() {
        return new Object[][]{
                {"David Clark", "123 Washington ave.", "Austin", "TX", "12345", "2", "mycreditcardnumber", "11", "2025", "David Clark"}
        };
    }

    @Test(dataProvider = "selectFlight3")
    public void selectFlight3(String name, String address, String city, String state, String zipCode,
                              String cardType, String creditCardNumber, String month, String year, String nameOnCard) {

        BookingFlightRegisterPage bookingFlightRegisterPage = new BookingFlightRegisterPage();
        BookingHomePage bookingHomePage = new BookingHomePage();

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

        String expectedMessage = "Invalid credit card number!";
        String actualMessage = driver.findElement(By.xpath("(//td)[8]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "No such message founded.");
    }
}
