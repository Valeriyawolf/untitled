package pages;

import Helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class InventoryPage extends BasePages {
        private final String LOGOUT_BUTTON_ID = "logout_sidebar_link";

        @FindBy(id = "react-burger-menu-btn")
        private  WebElement burgerButton;

        @FindBy(id = LOGOUT_BUTTON_ID)
        @SuppressWarnings("Initialize by PageFactory")
        private WebElement logoutButton;

        @FindBy(className = "title")
        private WebElement title;


         InventoryPage(WebDriver driver) {
            super(driver);
            Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),"User not logged on!");
        }

        public void logout() {logoutButton.click();}

        public void openBurgerMenu(){
            burgerButton.click();
            WebDriverWait wdw = new WebDriverWait(driver,  2L);
            wdw.until(ExpectedConditions.elementToBeClickable(By.id(LOGOUT_BUTTON_ID)));
        }

        public String getTitleText(){
            return title.getText();

        }


    }

