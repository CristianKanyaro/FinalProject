import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)


public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addProductOne()  {

        checkoutPage.addProductOne();
        String message = checkoutPage.getText();
        assertEquals(message ,"Awesome Granite Chips");
    }
    @Test
    public void addToWhishlist (){
        checkoutPage.addProductOne();
        checkoutPage.clickOnWhishlist();
    }
    @Test(description = "Click on search button")
    public void clickOnSearchButton (){

        checkoutPage.clickOnSearchButton();
        checkoutPage.clickSearchBar();

        assertEquals("Refined Frozen Mouse",checkoutPage.getGetFrozenMouse().getText());
        assertEquals("Practical Metal Mouse",checkoutPage.getGetMetalMouse().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Two product has found");
    }

}
