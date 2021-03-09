package com.courses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class first_lesson1 {

    public static void main(String[] args) {
        int indexForReversionFilter = 1;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
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


        //WebElement list = driver.findElement(By.className("product_sort_container"));
       // List<WebElement> list = driver.findElements(By.xpath("//button"));
        //WebElement addToCart3 = list.get(4);
        //addToCart3.click();


        WebElement burgerButton = driver.findElement (By.id("react-burger-menu-btn"));
        WebElement logoutButton = driver.findElement(By.id("bm-item menu-item"));
        burgerButton.click();
        logoutButton.click();



        //driver.quit();

    }
}