import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = "svg[data-icon='cart-plus']")
    private WebElement addProductOne ;
    public void addProductOne() {
        addProductOne.click();
    }
    @FindBy (linkText = "Awesome Granite Chips")
    private WebElement productName;
    public String getText(){
        return productName.getText();
    }
    @FindBy (css = "svg[data-icon='heart']")
    private WebElement whishlist;
    public void clickOnWhishlist (){
        whishlist.click();
    }
    @FindBy (id = "input-search")
    private WebElement searchButton;

    public void clickOnSearchButton (){
        searchButton.sendKeys("mouse");
    }
    @FindBy( css = ".btn.btn-light.btn-sm")
    private WebElement searchBar;
    public void clickSearchBar (){
        searchButton.click();
    }
    @FindBy (linkText = "Refined Frozen Mouse")
    private WebElement getFrozenMouse ;

    public WebElement getGetFrozenMouse (){
        return getFrozenMouse;

    }
    @FindBy (linkText = "Practical Metal Mouse")
    private WebElement getMetalMouse ;

    public WebElement getGetMetalMouse (){
        return getMetalMouse;}





}
