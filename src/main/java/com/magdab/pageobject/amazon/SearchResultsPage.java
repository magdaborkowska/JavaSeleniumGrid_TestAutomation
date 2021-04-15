package com.magdab.pageobject.amazon;

import com.magdab.PropertyManager;
import com.magdab.Waits;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultsPage.class.getSimpleName());

    static final By SORT_BY_LIST_XPATH = By.xpath("//span[@data-action and @aria-hidden]");
    static final By SORT_BY_NEWEST_ID = By.id("s-result-sort-select_4");
    public static final By RESULT_SELECT_XPATH = By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]");
    static final By BY_IT_NOW_XPATH = By.xpath("//*[@id='buy-now-button']");
    public static final By PAGE_TEXT_XPATH = By.xpath("//h1[contains(text(),'Sign-In')]");


    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Select sorting options")
    public SearchResultsPage clickOnSortList(){
        logger.info("Click on the sorting options list");
        Waits.waitForElementToBePresent(SORT_BY_LIST_XPATH, driver, 1);
        clickOnElement(SORT_BY_LIST_XPATH, logger);
        return this;
    }
    @Step("Select the sorting option")
    public SearchResultsPage sortByNewest(){
        logger.info("Pick the sorting option from list");
        clickOnElement(SORT_BY_NEWEST_ID, logger);
        return this;
    }
    @Step("Select the sorted result")
    public SearchResultsPage selectTheResult(){
        logger.info("Click on result");
        Waits.waitForElementToBePresent(RESULT_SELECT_XPATH, driver,2);
        clickOnElement(RESULT_SELECT_XPATH, logger);
        return this;
    }
    @Step("Buying by Buy It Now option")
    public SearchResultsPage buyItNow(){
        logger.info("Click on Buy It Now button");
        Waits.waitForElementToBePresent(BY_IT_NOW_XPATH, driver,1);
        clickOnElement(BY_IT_NOW_XPATH, logger);
        return this;
    }
}
