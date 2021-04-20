package tests;

import Helpers.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginDataProviderNegativeTest extends BaseTest {
    private final static String EMPTY_STRING = "";
    private final static String USERNAME_ERROR_TEXT = "Error for username";
    private LoginPage loginPage;
    String password = "secret_sauce";
    String username = "standard_user";

    @DataProvider(name = "credentials")
    private Object[][] credentials() {
        return new Object[][]{{EMPTY_STRING, EMPTY_STRING}, {EMPTY_STRING, password}, {username, EMPTY_STRING}, {"Test", "Test"}};
    }


    @Test(dataProvider = "credentials")
    public void LoginDataProviderNegativeTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();

        if (username.equals(EMPTY_STRING) && password.equals(EMPTY_STRING)) {
            Assert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT);
            Assert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT + "(2)");
        } else if (username.equals(EMPTY_STRING) && password.equals(password)) {
            Assert.assertTrue(isErrorContainsText("Username is required"), USERNAME_ERROR_TEXT + "(2)");
        } else if (username.equals(username) && password.equals(EMPTY_STRING)) {
            Assert.assertTrue(isErrorContainsText("Password is required"), "Error for password not found or different");
        } else if (username.equals("Test") && password.equals("Test")) {
            Assert.assertTrue(isErrorContainsText("Username and password do not match any user in this service"),
                    "Error for password not found or different");
        }
    }

    private boolean isErrorContainsText(String expectedText){
        String text;
        try {
            text = loginPage.error.getText();
            text = "test";
        } catch (NoSuchElementException ignore) {
            text = "";
        }
        return text.contains(expectedText);
    }

}
