import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest extends Hooks {
    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @BeforeMethod
    public void setupPageObject() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test ()
    public void verifyDeliveryInfoSelected(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi","Kanyaro", "Cluj");
        String shippingInfo = checkoutPage.getShippingInfo();
        Assert.assertEquals(shippingInfo, "CHOO CHOO DELIVERY!");
    }

    @Test ()
    public void verifyPaymentInfoSelected(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi", "Kanyaro", "Cluj");
        String paymentInfo = checkoutPage.getPaymentInfo();
        Assert.assertEquals(paymentInfo, "Cash on delivery");
    }

    @Test ()
    public void returnToCartPageFromCheckoutInfoSection(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.goBackToCartPage();
    }

    @Test ()
    public void returnToCartPageFromCheckoutSummarySection(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi", "Kanyaro", "Cluj");
        checkoutPage.goBackToCartPage();
    }

    @Test ()
    public void verifyTotalPrice(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi", "Kanyaro", "Cluj");
        String totalPrice = checkoutPage.getTotalPrice();
        Assert.assertEquals(totalPrice, "$15.99");
    }

    @Test ()
    public void verifyErrorMessageWhenFirstNameNotSelected(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("","Kanyaro", "Cluj");
        String errorMessage = checkoutPage.getOrderMessage();
        Assert.assertEquals(errorMessage, "First Name is required");
    }

    @Test ()
    public void verifyErrorMessageWhenLastNameNotSelected(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi", "", "Cluj");
        String errorMessage = checkoutPage.getOrderMessage();
        Assert.assertEquals(errorMessage, "Last Name is required");
    }

    @Test ()
    public void verifyErrorMessageWhenAddressNotSelected(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi", "Kanyaro", "");
        String errorMessage = checkoutPage.getOrderMessage();
        Assert.assertEquals(errorMessage, "Address is required");
    }

    @Test ()
    public void completeOrder(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi","Kanyaro", "Cluj");
        checkoutPage.completeOrder();
        String successfulMessage = checkoutPage.getCompleteOrderSuccessfulMessage();
        Assert.assertEquals(successfulMessage, "Thank you for your order!");
    }

    @Test ()
    public void returnToShoppingAfterCompleteOrder(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goToCheckoutPage();
        checkoutPage.provideInfo("Cristi","Kanyaro", "Cluj");
        checkoutPage.completeOrder();
        String successfulMessage = checkoutPage.getCompleteOrderSuccessfulMessage();
        Assert.assertEquals(successfulMessage, "Thank you for your order!");
        checkoutPage.continueShopping();
    }

}
