package tests;

import Helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

@Test
public class LoginPositiveTest extends BaseTest {
    private String username;
    private String password;

    public void loginPositiveTest(){
        LoginPage loginPage = new LoginPage(driver);
        username = loginPage.getValuesFromCredentialElements("login_credentials",1);
        password = loginPage.getValuesFromCredentialElements("login_password",1);
        loginPage.login(username,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User not log on()");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openBurgerMenu();
        inventoryPage.logout();

        new InventoryPage(driver).logout();

    }
}
