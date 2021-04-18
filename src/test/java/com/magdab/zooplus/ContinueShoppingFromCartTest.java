package com.magdab.zooplus;

import com.magdab.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContinueShoppingFromCartTest extends BaseTest {

    static final String SHOP_WELCOME_HEADER_XPATH = "//*[text()='Internetowy sklep zoologiczny zooplus – karma i akcesoria dla zwierząt']";

    @Test
    public void ZooplusContinueShopping() {

        homePage.open()
                .clickAcceptCookies()
                .goToCart();
        cartPage.clickOnContinueShopping();
        Assert.assertTrue(driver.get().findElement(By.xpath(SHOP_WELCOME_HEADER_XPATH)).isDisplayed());
    }
}
