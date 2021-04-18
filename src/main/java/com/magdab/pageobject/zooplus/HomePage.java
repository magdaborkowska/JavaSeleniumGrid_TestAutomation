package com.magdab.pageobject.zooplus;

import com.magdab.PropertyManager;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");
    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler' and text()='Zaakceptuj i kontynuuj']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//span[text()='Karma sucha dla psa']")
    public WebElement pickCategory;

    @FindBy(xpath = "//*[@class='cart-label' and text()='Twój koszyk']")
    public WebElement cartButton;

    @FindBy(xpath = "//input[@value]")
    public WebElement searchField;

    @FindBy(xpath = "//span[@class='icon-search']")
    public WebElement searchButton;


    @Step("Open application home page")
    public HomePage open() {
        logger.info("Trying to open application home page");
        openWebPage(HOME_PAGE_URL, logger);
        return this;
    }

    @Step("Accept the cookies")
    public HomePage clickAcceptCookies(){
        logger.info("Click on the accept cookies button");
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(acceptCookies)).click();
        return this;
    }

    @Step("Select the product category")
    public HomePage clickOnTheCategory(){
        logger.info("click on the category button");
        pickCategory.click();
        return this;
    }

    @Step("Go to the cart page")
    public HomePage goToCart(){
        logger.info("click on the cart button");
        cartButton.click();
        return this;
    }
    @Step("Fill the term in search field")
    public HomePage searchTerm(String term){
        logger.info("Term in the search field");
        searchField.sendKeys(term);
        return this;
    }
    @Step("Search results")
    public HomePage searchAction(){
        logger.info("click on the search button");
        searchButton.click();
        return this;
    }
}
