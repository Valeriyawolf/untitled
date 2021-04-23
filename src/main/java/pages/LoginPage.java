package pages;

import Helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePages {
    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage login(String providedUsername, String providedPassword){
        String username = getText0Empty(providedUsername);
        String password = getText0Empty(providedPassword);
        clearText(usernameField);
        usernameField.sendKeys(username);
        clearText(passwordField);
        passwordField.sendKeys(password);
        loginButton.click();

        if(driver.getCurrentUrl().contains("inventory.html"))
        return new InventoryPage(driver);
        return null;
    }

    public String getValuesFromCredentialElements(String className, int index) {
        WebElement valuesElement = driver.findElement(By.className(className));
        System.out.println(valuesElement);
        String[] values = valuesElement.getText().split("\n");
        return values[index];
    }

    private void clearText(WebElement element) {
        while (element.getAttribute("value").length() > 0)
            element.sendKeys(Keys.BACK_SPACE);
    }

    public WebElement getLoginButton(){
        return loginButton;
    }

    private String getText0Empty (String providedText) {
        if (providedText == null)
        return "";
        else return providedText;
    }

}


