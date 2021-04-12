package tests;

import Helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginDataProviderPositiveTest extends BaseTest {
    @DataProvider(name= "credentials")
    private Object[][] credentials() {
        String password = "secret-sauce";
        return new Object[][]{{"standard_user", password}, {"problem_user", password},{"performance_glitch_user", password}};

            }


    @Test (dataProvider = "credentials")
    public void LoginDataProviderPositiveTest(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();

            InventoryPage inventoryPage = new InventoryPage(driver);
            Assert.assertEquals(inventoryPage.getTitleText().toLowerCase(),"products", "User not logged on!");




    }
}
