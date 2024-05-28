import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ExtentTestNGITestListener.class)

public class HomePageTest extends Hooks {

    public HomePage homePage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addProductOne() { //add product on shopping cart from homepage
        homePage.clickOnProduct();
        String message = homePage.getText();
        assertEquals(message, "Awesome Granite Chips");
    }

    @Test
    public void addToWhishlist() { //add product on wishlist from homepage
        homePage.clickOnProduct();
        homePage.clickOnWhishlist();
    }

    @Test(description = "Click on search button")
    public void clickOnSearchButton() { //testing search bar functionality
        homePage.clickOnSearchButton();
        homePage.clickSearchBar();
        assertEquals("Refined Frozen Mouse", homePage.getGetFrozenMouse().getText());
        assertEquals("Practical Metal Mouse", homePage.getGetMetalMouse().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Two product has found");
    }

    @Test
    public void login() { //log into account
        homePage.logIntoApplication();
        assertEquals(homePage.getAccountName(), "dino");
    }

    @Test
    public void logout() { //log in and log out of the account
        homePage.logIntoApplication();
        homePage.logOutOfApplication();
        assertEquals(homePage.getGreetingMessage(), "Hello guest!");
    }
}
