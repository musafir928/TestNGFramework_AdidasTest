package com.adidas.base;

import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String url;
    @BeforeMethod
    public void setup() {
        driver = Driver.get();
         url = ConfigurationReader.get("url");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         wait = new WebDriverWait(driver, 10);
         actions = new Actions(driver);
         driver.get(url);
    }

    @AfterMethod
    public void clear() {
        Driver.closeDriver();
    }
}
