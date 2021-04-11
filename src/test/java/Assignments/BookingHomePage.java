package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BookingHomePage {

    WebDriver driver;
    public BookingHomePage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//option[@value='San Diego']")
    public WebElement sanDiegoButton;

    @FindBy (xpath = "//option[@value='New York']")
    public WebElement newYorkButton;

    @FindBy (xpath = "//input[@value='Find Flights']")
    public WebElement findFlightButton;

    @FindBy (xpath = "/html/body/div[2]/table/tbody/tr[4]/td[1]/input")
    public WebElement chooseThisFlightButton;

    @FindBy (xpath = "//input[@value='Purchase Flight']")
    public WebElement purchaseFlight;


}
