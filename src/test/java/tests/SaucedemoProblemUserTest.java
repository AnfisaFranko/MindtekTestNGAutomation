package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SaucedemoHomePage;
import pages.SaucedemoLoginPage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

import java.io.IOException;
import java.util.List;

public class SaucedemoProblemUserTest extends TestBase {

    @Test (groups = {"regression"})
    @Parameters ({"username", "password"})
    public void test1 (String username, String password) throws IOException {
        driver.get(Configuration.getProperty("SaucedemoURL"));
        SaucedemoLoginPage saucedemoLoginPage = new SaucedemoLoginPage();
        saucedemoLoginPage.username.sendKeys(username); // username = "problem_user";
        saucedemoLoginPage.password.sendKeys(password); // password = "secret_sauce";
        saucedemoLoginPage.loginButton.click();
        SaucedemoHomePage saucedemoHomePage = new SaucedemoHomePage();
        BrowserUtils.selectDropdownByValue(saucedemoHomePage.filterDropdown, "lohi");

        BrowserUtils.takeScreenshot("FilteredDropdown");
        BrowserUtils.scroll(250);
        BrowserUtils.takeScreenshot("FilteredDropdown2");

        List <WebElement> prices = saucedemoHomePage.prices;

        for (int i = 0; i < prices.size(); i++) {
            double price1 = Double.parseDouble(prices.get(i).getText().substring(1));
            double price2 = Double.parseDouble(prices.get(i + 1).getText().substring(1));
            Assert.assertTrue(price2 >= price1);
        }
    }

    @Test
    public void test2 () {
        System.out.println(System.getProperty("user.dir"));
    }
}
