package Helpers;

import org.openqa.selenium.WebDriver;

public abstract class BasePages {
    protected WebDriver driver;

    protected BasePages (WebDriver driver) {
        this.driver = driver;
    }
}
