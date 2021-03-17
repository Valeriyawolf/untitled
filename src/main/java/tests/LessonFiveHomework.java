package tests;

import Helpers.BaseTestLesson5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LessonFiveHomework extends BaseTestLesson5 {
    @Test
    public void firstTest() {


        driver.get("https://www.saucedemo.com");

        WebElement usernameField = driver.findElement(By.className("form_input"));
        WebElement passwordField = driver.findElement(By.xpath("//input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));


        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();


          }
}
