package com.magdab.zooplus;

import com.magdab.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoToCategoryTest extends BaseTest {

    static final String CATEGORY_HEADER_XPATH = "//*[@class='pagetitle' and text()='Karma sucha dla psa']";

    @Test
    public void basicZooplusGoToCategory(){

        homePage.open()
                .clickAcceptCookies()
                .clickOnTheCategory();
        Assert.assertTrue(driver.get().findElement(By.xpath(CATEGORY_HEADER_XPATH)).isDisplayed());
    }
}
