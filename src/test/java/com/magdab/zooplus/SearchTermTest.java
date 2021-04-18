package com.magdab.zooplus;

import com.magdab.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTermTest extends BaseTest {

    static final String TERM_STRING = "Miska dla kota";
    static final String RESULT_TEXT_XPATH = "//*[@rel='1' and contains(text(),'miska')]";

    @Test
    public void zooplusSearchTerm() {

        homePage.open()
                .clickAcceptCookies()
                .searchTerm(TERM_STRING)
                .searchAction();
        Assert.assertTrue(driver.get().findElement(By.xpath(RESULT_TEXT_XPATH)).isDisplayed());
    }

}
