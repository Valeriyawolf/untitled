package tests;

import Helpers.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonFourth extends BaseTest {
 @Test
 public void lessonFourth() {
     LoginPage loginPage = new LoginPage(driver);
     loginPage.setupCredentials();
     loginPage.login();

    }
}
