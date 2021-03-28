package tests;

import Helpers.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LessonFiveTest extends BaseTest {
    @Test
    public void lessonFive() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(getRandomLogin(),"secret_sauce");
    InventoryPage InventoryPage = new InventoryPage(driver);
        }

    private String getRandomLogin() {
        String correctUsername = "standard_user";
        String wrongUsername = "Test";
        if (Math.random() < 0.5)
            return correctUsername;
        return wrongUsername;
    }
}


