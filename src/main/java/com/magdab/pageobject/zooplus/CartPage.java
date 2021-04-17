package com.magdab.pageobject.zooplus;

import com.magdab.PropertyManager;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CartPage.class.getSimpleName());
    public CartPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }


    @FindBy(xpath = "//*[@class='v3-btn v3-btn__cart v3-btn--fullWidth']")
    public WebElement continueShoppingButton;


    @Step("Continue shopping from empty cart")
    public CartPage clickOnContinueShopping(){
        logger.info("Click on continue shopping button");
        continueShoppingButton.click();
        return this;
    }
}
