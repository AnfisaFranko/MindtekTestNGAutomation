package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BookingFlightRegisterPage {

    WebDriver driver;
    public BookingFlightRegisterPage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "inputName")
    public WebElement name;

    @FindBy (id = "address")
    public WebElement address;

    @FindBy (id = "city")
    public WebElement city;

    @FindBy (id = "state")
    public WebElement state;

    @FindBy (id = "zipCode")
    public WebElement zipCode;

    @FindBy (id = "cardType")
    public WebElement cardType;

    @FindBy (id = "creditCardNumber")
    public WebElement creditCardNumber;

    @FindBy (id = "creditCardMonth")
    public WebElement month;

    @FindBy (id = "creditCardYear")
    public WebElement year;

    @FindBy (id = "nameOnCard")
    public WebElement nameOnCard;
}
