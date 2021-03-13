package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class thirdLessonPartTwo {

        WebDriver driver;
        @BeforeMethod
        public void setUp(){
            driver= new ChromeDriver();
            WebDriverManager.chromedriver().setup();

        };

        @Test
        public void secondTest() {

            driver.get("https://www.saucedemo.com");
            WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
            loginButton.click();

            WebElement errorButton = driver.findElement(By.className("error-button"));
            errorButton.click();

            String stringError = 'Username is required';

        }



         @AfterMethod
         public void tearDown(){
        driver.quit();

    }
}
