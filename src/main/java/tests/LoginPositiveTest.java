package tests;

import Helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginPositiveTest extends BaseTest {

  private final static String EXPECTED_TITLE = "products";
  final static String PASSWORD = "secret_sauce";
  final static String CORRECT_LOGIN = "standard_user";

  @Test
    public void loginPositiveTest(){
        LoginPage loginPage = new LoginPage(driver);
        //System.out.println(loginPage);
        String username = loginPage.getValuesFromCredentialElements("login_credentials",1);
        String password = loginPage.getValuesFromCredentialElements("login_password",1);
        InventoryPage inventoryPage = loginPage.login(username,password);
        Assert.assertEquals(inventoryPage.getTitleText().toLowerCase(),EXPECTED_TITLE, "User is not logged on");

        inventoryPage.openBurgerMenu();
        inventoryPage.logout();
        softAssert.assertFalse(driver.getCurrentUrl().contains("inventory"),"User did not log out!");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed(),"User not log out!");
    }
}
