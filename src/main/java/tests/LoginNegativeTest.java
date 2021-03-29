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
        loginPage.login("Test", "TEst");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.error.getText(), "Epic sandface: Username is required", "Error message wrong");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-html"), "User not log on");
    }

}

