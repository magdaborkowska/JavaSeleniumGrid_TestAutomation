package com.magdab.pageobject.amazon;

import com.magdab.PropertyManager;
import com.magdab.Waits;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CategoryPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CategoryPage.class.getSimpleName());

    public static final By CATEGORY_PAGE_ELEMENT_XPATH = By.xpath("//b[text()='Computers, Tablets and IT Accessories']");
    static final By PICK_SUBCATEGORY_NEXT_PAGE = By.xpath("//a[@aria-label='COMPUTER ACCESSORIES']");
    public static final By SUBCATEGORY_PAGE_ELEMENT_XPATH = By.xpath("//span[text()='Audio & Video Accessories']");

    public CategoryPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Click to select subcategory")
    public CategoryPage pickSubcategory(){
        logger.info("Pick subcategory on the category page");
        Waits.waitForElementToBePresent(PICK_SUBCATEGORY_NEXT_PAGE, driver, 1);
        clickOnElement(PICK_SUBCATEGORY_NEXT_PAGE, logger);
        return this;
    }
}
