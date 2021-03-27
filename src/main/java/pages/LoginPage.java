package pages;

import Helpers.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePages {

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private String correctUsername;
    private String wrongUsername;
    private String password;


   public LoginPage (WebDriver driver) {
       super(driver);
       usernameField = driver.findElement(By.id("user-name"));
       passwordField = driver.findElement(By.id("password"));
       loginButton = driver.findElement(By.id("login-button"));
   }
   public void login() {
        usernameField.sendKeys(correctUsername);
        passwordField.sendKeys(password);
        loginButton.click();


   }
   public void setupCredentials () {
       final String loginCredentialsClass = "login_credentials";
       final String passwordCredentialsClass = "password_credentials";
       final int correctLoginAndPasswordIndex = 1;
       final int wrongLoginIndex = 2;

       correctUsername = getValuesFromCredentialElements (loginCredentialsClass, correctLoginAndPasswordIndex);
       wrongUsername = getValuesFromCredentialElements (loginCredentialsClass, wrongLoginIndex);
       password = getValuesFromCredentialElements (passwordCredentialsClass, correctLoginAndPasswordIndex;

          }
          private String getValuesFromCredentialElements (String classname, int index) {
          WebElement valuesElement = driver.findElement(By.className(classname));
          String[] values = valuesElement.getText().split( "\n");

          return values [index];
          }

}

