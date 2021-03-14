package tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonFourthHomeworkLogin {
    WebDriver driver;

    @Test
    public void LessonFourthHomeworkLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
}

