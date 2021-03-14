package tests;

import Helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LessonFourthHomework extends BaseTest {
    @Test
    public void firstTest() {


        driver.get("https://www.saucedemo.com");

        WebElement usernameField = driver.findElement(By.className("form_input"));
        WebElement passwordField = driver.findElement(By.xpath("//input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));


        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();


      setUp();
      driver.quit();
    }
}
