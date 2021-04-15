package com.magdab.pageobject.amazon;

import com.magdab.PropertyManager;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguagePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultsPage.class.getSimpleName());

    static final By SELECT_LANGUAGE_XPATH = By.xpath("//span[contains(text(),'Deutsch - DE')]");
    static final By SAVE_LANGUAGE_BUTTON_XPATH = By.xpath("//input[@aria-labelledby]");

    public ChangeLanguagePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Select the language")
    public ChangeLanguagePage clickOnLanguage(){
        logger.info("Click on radio button to select the language");
        clickOnElement(SELECT_LANGUAGE_XPATH, logger);
        return this;
    }

    @Step("Confirm change the language")
    public ChangeLanguagePage submitLanguageChange(){
        logger.info("Click on submit button to confirm the language");
        clickOnElement(SAVE_LANGUAGE_BUTTON_XPATH, logger);
        return this;
    }
}
