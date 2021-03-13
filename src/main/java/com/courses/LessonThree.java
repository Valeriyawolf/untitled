package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LessonThree {
    WebDriver driver;

    @Test
    public void lessonThree(){
        LoginPage loginPage = new LoginPage(driver);
        LoginPage.

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.saucedemo.com");

    }

}
