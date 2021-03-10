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
            driver
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        };

        @Test
        public void firstTest() {

            driver.get("https://www.saucedemo.com");

            WebElement usernameField = driver.findElement(By.className("form_input"));

        }
         @AfterMethod
         public void tearDown(){
        driver.quit();

    }
}
