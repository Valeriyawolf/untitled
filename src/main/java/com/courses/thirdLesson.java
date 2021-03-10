package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class thirdLesson {
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
        WebElement passwordField = driver.findElement(By.xpath("//input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));


        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        List<WebElement> list = driver.findElements(By.xpath("//button"));
        WebElement addToCart2 = list.get(3);
        addToCart2.click();

        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);

        List<WebElement> listOfOptions = select.getOptions();

        for(int i = 0; i < listOfOptions.size(); i++) {
            System.out.println(listOfOptions.get(i).getText());
        }

        select.selectByIndex(indexForReversionFilter);
        select.selectByValue("za");
        select.selectByVisibleText("Name (Z to A)");


        List<WebElement> listNew = driver.findElements(By.xpath("//button"));
        WebElement addToCart3 = listNew.get(4);
        addToCart3.click();


        WebElement burgerButton = driver.findElement (By.id("react-burger-menu-btn"));
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        burgerButton.click();
        logoutButton.click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
