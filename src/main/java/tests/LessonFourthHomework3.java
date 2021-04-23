package tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonFourthHomework3 {
 WebDriver driver;

 @Test
public void LoginPage() {
   LoginPage loginPage = new LoginPage(driver);
   loginPage.login();
  }
}
