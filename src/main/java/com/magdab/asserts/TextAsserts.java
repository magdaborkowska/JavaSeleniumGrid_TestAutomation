package com.magdab.asserts;

import com.magdab.actions.Elements;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TextAsserts {


    public static void assertThatTextIsPresentInField(By xpath, String expectedText, WebDriver driver, Logger logger) {
        logger.info("Checking if expected text: \"" + expectedText
                + "\" is equal to text in field with XPath:  " + xpath);
        Assert.assertEquals(Elements.findElementWithWait(xpath, driver, logger).getText(), expectedText);
        logger.info("Text is equal to expected");
    }

    public static void assertThatTextIsDisplayed(By xpath, WebDriver driver, Logger logger) {
        Assert.assertTrue(Elements.findElementWithWait(xpath, driver, logger).isDisplayed());
        logger.info("Text is equal to expected");
    }
}
