package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LessonFourthHomeworkLogin {

        private WebDriver driver;

        private String username = "standard_user";
        private String password = "secret_sauce";

        public LessonFourthHomeworkLogin (WebDriver driver) {
            this.driver = driver;
        }
        public void login() {
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys(username);

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);

            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

        }

    }


