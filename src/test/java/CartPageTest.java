import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends Hooks {
    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;

    @BeforeMethod
    public void setupPageObject() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test ()
    public void verifyProductPrice(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        String actualPrice = cartPage.getUnitPrice();
        Assert.assertEquals(actualPrice, "$15.99");
    }

    @Test ()
    public void increaseProductQuantity(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.incrementProductQuantity();
        String actualTotalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(actualTotalPrice, "$31.98");
    }

    @Test ()
    public void returnToProductPage(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.goBackToProduct();
        String actualProductName = productPage.getProductName();
        Assert.assertEquals(actualProductName,"Awesome Granite Chips");
    }

    @Test ()
    public void removeProduct(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.removeProduct();
        String message = cartPage.friendlyMessage();
        Assert.assertEquals(message, "How about adding some products in your cart?");
    }

    @Test ()
    public void removeProductThroughProductQuantity(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        productPage.goToShoppingCart();
        cartPage.decrementProductQuantity();
        String message = cartPage.friendlyMessage();
        Assert.assertEquals(message, "How about adding some products in your cart?");
    }

}
