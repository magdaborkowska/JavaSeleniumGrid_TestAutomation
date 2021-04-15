package com.magdab.pageobject;

import com.magdab.PropertyManager;
import com.magdab.actions.Elements;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage extends Page {

    protected WebDriver driver;
    protected PropertyManager propertyManager;

    public BasePage(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.propertyManager = propertyManager;
    }

    protected void checkPageTitle(String title, Logger logger) {
        logger.info("Verifying if page title is equal to: " + title);
        Assert.assertEquals(driver.getTitle(), title);
        logger.info("Page title is correct: \"" + title + "\"");
    }

    protected void pressKey(Keys key, Logger logger) {
        logger.info("Pressing key: " + key.name());
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    protected void enterTextIntoField(By xpath, String text, Logger logger) {
        logger.info("Entering text: \"" + text + "\" into field with XPath: " + xpath);
        Actions actions = new Actions(driver);
        actions.sendKeys(Elements.findElement(xpath, driver, logger), text).perform();
    }

    protected void openWebPage(String url, Logger logger) {
        logger.info("Navigating to website with url:   " + url);
        driver.navigate().to(url);
    }

    protected void clickOnElementId(By id, Logger logger) {
        logger.info("Clicking on element with id: " + id);
        clickOnElement(id, logger);
    }

    protected void clickOnElement(By xpath, Logger logger) {
        logger.info("Clicking on element with xpath: " + xpath);
        driver.findElement(xpath).click();
    }

    protected void selectFromDropdownByValue(By xpath, String value, Logger logger) {
        logger.info("Trying to select option: \"" + value + "\" from dropdown with XPath: " + xpath);
        Select dropdown = new Select(Elements.findElement(xpath, driver, logger));
        try {
            dropdown.selectByValue(value);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }

}