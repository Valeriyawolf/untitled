package tests;


import Helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void  LoginNegativeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(null, null);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.error.getText(), "Epic sadface: Username is required", "Error message is shown");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-html"), "User not log on");

        loginPage.login(null, "secret_sauce");
        softAssert.assertEquals(loginPage.error.getText(), "Epic sadface: Username and password do not match any user in this service", "Error message is shown");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-html"), "User not log on");

        loginPage.login("standard_user", null);
        softAssert.assertEquals(loginPage.error.getText(), "Epic sadface: Password is required", "Error message is shown");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-html"), "User not log on");

        loginPage.login("admin", "admin");
        softAssert.assertEquals(loginPage.error.getText(), "Epic sadface: Username and password do not match any user in this service", "Error message is shown");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-html"), "User not log on");

        softAssert.assertAll();
    }

}

