package com.magdab.pageobject;

import com.magdab.PropertyManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage extends Page {

    protected WebDriver driver;
    protected PropertyManager propertyManager;

    public BasePage(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.propertyManager = propertyManager;
    }


    protected void openWebPage(String url, Logger logger) {
        logger.info("Navigating to website with url:   " + url);
        driver.navigate().to(url);
    }

}