package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.LoginPage;
import pages.ProductCheckoutPage;

public class TC2_AddToCartAndCheckout extends BaseTest {

    @DataProvider(name = "LoginData2")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "LoginData2")
    public void AddToCartAndCheckoutFlow(String username, String password) throws InterruptedException { // error handling if any error during thread
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();
        
        ProductCheckoutPage productCheckoutPage = new ProductCheckoutPage(driver);
        productCheckoutPage.addItem1ToCart();
        productCheckoutPage.addItem2ToCart();
        productCheckoutPage.addItem3ToCart();
        productCheckoutPage.goToCart();
        
        Thread.sleep(5000);

         // Assertion check for qty in shopping cart
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(), 3, "Expected 3 items in cart");

        productCheckoutPage.checkoutProduct();

        productCheckoutPage.fillCustomerInfo("Ferri", "Fadilla", "12345");
        productCheckoutPage.completeCheckout();

        // Assertion check for confirmation
        WebElement confirmation = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(confirmation.getText(), "Thank you for your order!");
    }
}
