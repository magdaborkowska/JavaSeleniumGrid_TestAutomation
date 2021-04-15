package com.magdab.amazon;

import com.magdab.BaseTest;
import com.magdab.asserts.TextAsserts;
import com.magdab.pageobject.amazon.SearchResultsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class BuyFlowTest extends BaseTest {

    static final String termToSearch = "Led Zeppelin vinyl";

    @Test
    public void basicAmazonBuyFlow() {

        homePage.open()
                .clickOnDeliveryButton()
                .clickOnDeliveryList()
                .clickOnCountry()
                .clickOnConfirmButton()
                .clickOnCookies()
                .clickOnSearchCategoryList()
                .clickOnCategoryPick()
                .searchByTerm(termToSearch);
        searchResultsPage.clickOnSortList()
                .sortByNewest()
                .selectTheResult()
                .buyItNow();
        assertCartPage(SearchResultsPage.PAGE_TEXT_XPATH);
    }

    @Step("Check that text on page is as expected")
    private void assertCartPage(By xpath) {
        assertLogger.info("Verifying text on page");
        TextAsserts.assertThatTextIsDisplayed(xpath, driver.get(), assertLogger);
    }
}



