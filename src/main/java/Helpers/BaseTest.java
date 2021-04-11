package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    private final static Long DEFAULT_TIMEOUT = 10L;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        setTimeOut(DEFAULT_TIMEOUT);
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        } finally {
            setTimeOut(DEFAULT_TIMEOUT);
        }
    }
   private void setTimeOut(Long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

}

}