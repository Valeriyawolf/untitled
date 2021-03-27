package tests;

import Helpers.BasePages;
import Helpers.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonFiveTest extends BaseTest {
    @Test
    public void lessonFive (){
        System.out.println(setSum(2));
        LoginPage loginPage = new LoginPage(driver);
        LoginPage.login (username: "standard_user", password: "secret_sauce");
    }

}
