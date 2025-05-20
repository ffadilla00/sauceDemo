package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckoutPage {

    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackPackToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addHoddieSweaterToCartButton;

     @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addOnesieToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

     @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    public ProductCheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addItem1ToCart() {
        addBackPackToCartButton.click();
    }

    public void addItem2ToCart() {
        addHoddieSweaterToCartButton.click();
    }

    public void addItem3ToCart() {
        addOnesieToCartButton.click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public void checkoutProduct() {
        checkoutBtn.click();
    }

    public void fillCustomerInfo(String fName, String lName, String zip) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(zip);
        continueButton.click();
    }

    public void completeCheckout() {
        finishButton.click();
    }
}
