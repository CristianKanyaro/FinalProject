import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = "svg[data-icon='cart-plus']")
    private WebElement addProductOne ;
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

//    @FindBy( css = ".btn.btn-light.btn-sm")
//    private WebElement searchBar;

    @FindBy (linkText = "Refined Frozen Mouse")
    private WebElement getFrozenMouse ;

    @FindBy (linkText = "Practical Metal Mouse")
    private WebElement getMetalMouse;

    @FindBy (linkText = "Awesome Granite Chips")
    private WebElement awesomeGraniteChips;

    public void clickOnProduct() {
        addProductOne.click();
    }
    public void clickOnSearchButton (){
        searchButton.sendKeys("mouse");
    }
    public void clickSearchBar (){
        searchButton.click();
    }
    public WebElement getGetFrozenMouse (){
        return getFrozenMouse;
    }
    public WebElement getGetMetalMouse (){
        return getMetalMouse;
    }
    public void logIntoApplication(){
        getGoToLogin().click();
        waitForElementToAppear(getUserNameField());
        getUserNameField().sendKeys("dino");
        getPwdField().sendKeys("choochoo");
        getLoginButton().click();
    }

    public String getAccountName(){
        return getAccount().getText();
    }

    public void logOutOfApplication(){
        getLogout().click();
    }

    public String getGreetingMessage(){
        return getGreetMessage().getText();
    }

    public void clickOnProductOne(){
        awesomeGraniteChips.click();
    }
}
