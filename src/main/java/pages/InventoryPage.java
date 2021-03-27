package pages;

import Helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


    public class InventoryPage extends BasePages {

        public InventoryPage(WebDriver driver) {
            super(driver);
            Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), message: "User not log on()");

            public void logout() {
                WebElement burgerButton = driver.findElement(By.id("react-burger-menu-btn"));
                burgerButton.click();
                WebElement logoutButton= driver.findElement(By.id("logout_sidebar_link"));
                WebDriverWait wdw = new WebDriverWait(driver, timeOutInSeconds: 2L);
                wdw.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
                logoutButton.click();


        }
    }
}
