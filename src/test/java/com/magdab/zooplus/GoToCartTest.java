package com.magdab.zooplus;

import com.magdab.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoToCartTest extends BaseTest {

    static final String CART_STATUS_TEXT_XPATH = "//*[text()='Twój koszyk jest pusty']";

    @Test
    public void ZooplusGoToCart() {

        homePage.open()
                .clickAcceptCookies()
                .goToCart();
        Assert.assertTrue(driver.get().findElement(By.xpath(CART_STATUS_TEXT_XPATH)).isDisplayed());
    }
}



