package com.adidas.tests;

import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import org.testng.annotations.Test;

public class PurchaseTest extends TestBase {
    BasePage productPage = new ProductsPage();
    BasePage cartPage = new CartPage();

    @Test
    public void test1(){
        System.out.println(driver.getCurrentUrl());
        productPage.cart.click();
        System.out.println(driver.getCurrentUrl());
    }
}
