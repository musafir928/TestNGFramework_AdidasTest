package com.adidas.pages;

import com.adidas.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    @FindBy(linkText = "Add to cart")
    WebElement addToCartBtn;
    public double productAdder(String category, String product) {
        driver.findElement(By.linkText(category)).click();
        // since @FindBy annotation doesn't accept dynamic vars so, we couldn't use it here
        driver.findElement(By.linkText(product)).click();
        double price = getPrice("//h3[@class='price-container']");
        addToCartBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        home.click();
        return price;
    }

    public double getPrice(String path) {
        String[] priceText = driver.findElement(By.xpath(path)).getText().split(" ");
        int begin  = Character.isDigit(priceText[0].charAt(0)) ? 0 : 1;
        return Double.parseDouble(priceText[0].substring(begin));
    }
}
