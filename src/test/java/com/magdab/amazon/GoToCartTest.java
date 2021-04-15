package com.magdab.amazon;

import com.magdab.BaseTest;
import com.magdab.asserts.TextAsserts;
import com.magdab.pageobject.amazon.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GoToCartTest extends BaseTest {


    @Test
    public void basicAmazonGoToCart() {

        homePage.open()
                .clickOnCartButton();
        assertCartPage(HomePage.CART_PAGE_TXT_XPATH);
    }

    @Step("Check that text on page is as expected")
    private void assertCartPage(By xpath) {
        assertLogger.info("Verifying text on page");
        TextAsserts.assertThatTextIsDisplayed(xpath, driver.get(), assertLogger);
    }
}



