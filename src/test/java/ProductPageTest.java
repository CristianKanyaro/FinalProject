import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends Hooks {
    public HomePage homePage;
    public ProductPage productPage;

    @BeforeMethod
    public void setupPageObject() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test ()
    public void addProductToCart(){
        homePage.clickOnProductOne();
        productPage.addToCart();
        boolean hasProductName = productPage.verifyProductNameInShoppingCart("Awesome Granite Chips");
        Assert.assertTrue(hasProductName);
    }

    @Test()
    public void addProductToWishlist(){
        homePage.clickOnProductOne();
        productPage.addToWishlist();
        boolean hasProductName = productPage.verifyProductNameInWishlist("Awesome Granite Chips");
        Assert.assertTrue(hasProductName);
    }

    @Test ()
    public void verifyPrice(){
        homePage.clickOnProductOne();
        String actualPrice = productPage.getProductPrice();
        Assert.assertEquals(actualPrice, "15.99");
    }

    @Test ()
    public void verifyProductName(){
        homePage.clickOnProductOne();;
        String productName = productPage.getProductName();
        Assert.assertEquals(productName, "Awesome Granite Chips");
    }

    @Test ()
    public void goToHomePage(){
        homePage.clickOnProductOne();
        productPage.returnToHomePage();
    }

}
