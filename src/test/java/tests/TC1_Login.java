package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.LoginPage;
import utils.dataTestUtils;

public class TC1_Login extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/testData.xlsx";
        dataTestUtils.loadExcel(filePath, "Sheet1");
        int rowCount = dataTestUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=1; i<rowCount; i++) {
            data[i-1][0] = dataTestUtils.getCellData(i, 0); //username
            data[i-1][1] = dataTestUtils.getCellData(i, 1); //password
        }
        dataTestUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "LoginData")
    public void executeLoginTest(String username, String password) {
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();

        String actualHeader = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals(actualHeader, "Products");

    }

}
