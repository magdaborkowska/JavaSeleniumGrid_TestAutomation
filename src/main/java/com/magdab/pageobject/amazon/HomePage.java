package com.magdab.pageobject.amazon;

import com.magdab.PropertyManager;
import com.magdab.Waits;
import com.magdab.pageobject.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");

    public static final By CART_PAGE_TXT_XPATH = By.xpath("//*[@class='a-row sc-your-amazon-cart-is-empty']");
    static final By SELECT_LANGUAGE_BUTTON = By.xpath("//a[@id='icp-nav-flyout']");
    static final By CART_BUTTON_ID = By.id("nav-cart");
    static final By DELIVER_TO_BUTTON_ID = By.id("nav-global-location-popover-link");
    static final By DELIVER_TO_LIST_XPATH = By.xpath("//span[@role='radiogroup' and @data-action='a-dropdown-button']");
    static final By PICK_POLAND_XPATH = By.xpath("//a[@id='GLUXCountryList_178' and text()='Poland']");
    static final By CONFIRM_POLAND_BUTTON_XPATH = By.xpath("//button[@name='glowDoneButton' and text()='Done']");
    static final By DROP_DOWN_SEARCH_IN_XPATH = By.xpath("//*[@id='nav-search-dropdown-card']/div");
    static final By CATEGORY_PICK_XPATH = By.xpath("//*[@value='search-alias=music-intl-ship']");
    static final By SEARCH_FIELD_ID = By.id("twotabsearchtextbox");
    static final By SEARCH_BUTTON_ID = By.id("nav-search-submit-button");
    static final By COOKIES_DISMISS_XPATH = By.xpath("//*[@data-action-type='DISMISS']");

    static final By PICK_CATEGORY_MAIN_PAGE = By.xpath("//img[@alt='Computers & Accessories' and @class='landscape-image']");
    public static final By LANGUAGE_CHANGED_ELEMENT = By.xpath("//a[@class='nav-a  ' and text()='Geschenkkarten ']");


    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }


    @Step("Open application home page")
    public HomePage open() {
        logger.info("Trying to open application home page");
        openWebPage(HOME_PAGE_URL, logger);
        return this;
    }

    @Step("Go to the cart from the home page")
    public HomePage clickOnCartButton() {
        logger.info("Click on the cart button");
        clickOnElementId(CART_BUTTON_ID, logger);
        return this;
    }

    @Step("Change the delivery options")
    public HomePage clickOnDeliveryButton() {
        logger.info("Click on the delivery button");
        clickOnElement(DELIVER_TO_BUTTON_ID, logger);
        return this;
    }

    @Step("Open the country options list")
    public HomePage clickOnDeliveryList(){
        logger.info("click on the country list");
        Waits.waitForElementToBePresent(DELIVER_TO_LIST_XPATH, driver, 3);
        clickOnElement(DELIVER_TO_LIST_XPATH, logger);
        return this;
    }

    @Step("Select the country on list")
    public HomePage clickOnCountry() {
        logger.info("Click on the country to pick");
        Waits.waitForElementToBePresent(PICK_POLAND_XPATH,driver,2);
        clickOnElement(PICK_POLAND_XPATH, logger);
        return this;
    }

    @Step("Confirm change the country")
    public HomePage clickOnConfirmButton() {
        logger.info("Click on the country confirm button");
        clickOnElement(CONFIRM_POLAND_BUTTON_XPATH, logger);
        return this;
    }

    @Step("Dismiss the cookies")
    public HomePage clickOnCookies(){
        logger.info("Click on the dismiss cookies button");
        Waits.waitForElementToBePresent(COOKIES_DISMISS_XPATH, driver,1);
        clickOnElement(COOKIES_DISMISS_XPATH, logger);
        return this;
    }

    @Step("Select the category in the search field")
    public HomePage clickOnSearchCategoryList(){
        logger.info("Click on the category drop down list");
        Waits.waitForElementToBePresent(DROP_DOWN_SEARCH_IN_XPATH, driver, 1);
        clickOnElement(DROP_DOWN_SEARCH_IN_XPATH, logger);
        return this;
    }

    @Step("Select the category to search in")
    public HomePage clickOnCategoryPick(){
        logger.info("Click on the category to pick Music and Vinyls");
        Waits.waitForElementToBePresent(CATEGORY_PICK_XPATH, driver, 2);
        driver.findElement(CATEGORY_PICK_XPATH).click();
        return this;
    }

    @Step("Search term in the search field")
    public HomePage searchByTerm(String termToSearch){
        logger.info("Performing search for product with title: " + termToSearch);
        Waits.waitForElementToBePresent(SEARCH_FIELD_ID, driver,1);
        enterTextIntoField(SEARCH_FIELD_ID, termToSearch, logger);
        pressKey(Keys.ENTER, logger);
        return this;
    }

    @Step("Go to the category page from home page")
    public HomePage pickCategoryFromMainPage(){
        logger.info("Click on the category button");
        clickOnElement(PICK_CATEGORY_MAIN_PAGE, logger);
        return this;
    }
    @Step("Click on the flag button to change the language")
    public HomePage changeLanguage(){
        logger.info("ABC");
        clickOnElement(SELECT_LANGUAGE_BUTTON, logger);
        return this;
    }

}
