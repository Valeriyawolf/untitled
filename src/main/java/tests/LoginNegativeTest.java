package tests;

import Helpers.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static tests.LoginPositiveTest.CORRECT_LOGIN;

public class LoginNegativeTest extends BaseTest {
    private final static String EMPTY_STRING = "";
    private final static String USERNAME_ERROR_TEXT = "Error for username";
    private LoginPage loginPage;

    @Test
    public void LoginNegativeTest() {
        //LoginPage loginPage = new LoginPage(driver);
        loginPage = new LoginPage(driver);
        softAssert.assertTrue(isErrorContainsText(""), "Error is present on login page!");
        softAssert.assertFalse(isElementVisible(loginPage.error), "Error message is shown");

        loginPage.login(EMPTY_STRING, EMPTY_STRING);
        //softAssert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT);
        softAssert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT);

        loginPage.login(EMPTY_STRING, "secret_sauce");
        softAssert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT + "(2)");

        loginPage.login(CORRECT_LOGIN, null);
        softAssert.assertTrue(isErrorContainsText("Password is required"), "Error for password not found or different");

        loginPage.login("Test", "Test");
        Assert.assertTrue(isErrorContainsText("Username and password do not match any user in this service"), "Error for password not found or different");
    }

    private boolean isErrorContainsText(String expectedText){
        String text;
        try {
            text = loginPage.error.getText();
        } catch (NoSuchElementException ignore) {
            text = "";
        }

        return text.contains(expectedText);
    }

}