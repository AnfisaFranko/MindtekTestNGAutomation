package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreAppSignInPage {

    WebDriver driver;
    public StoreAppSignInPage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email_create")
    public WebElement emailInputBox;

    @FindBy (id = "SubmitCreate")
    public WebElement createAccountButton;
}
