package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // All page factory for Login page
    @FindBy(id="user-name")
    WebElement userNameTxtBox;

    @FindBy(id="password")
    WebElement passtxtBox;

    @FindBy(id="login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String username) {
        userNameTxtBox.clear();
        userNameTxtBox.sendKeys(username);
    }

    public void typePassword(String password) {
        passtxtBox.clear();
        passtxtBox.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginButton.click();
    }

}
