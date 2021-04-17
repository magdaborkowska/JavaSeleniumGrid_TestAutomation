package com.magdab;

import com.magdab.drivers.DriverManager;
import com.magdab.pageobject.zooplus.CartPage;
import com.magdab.pageobject.zooplus.HomePage;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger assertLogger = LogManager.getLogger("Assert");

    protected DriverManager driverManager;
    protected PropertyManager propertyManager;

    protected HomePage homePage;
    protected CartPage cartPage;


    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
            , @Optional("default.properties") String testDataFileName){
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver.get());

        propertyManager = new PropertyManager(testDataFileName);
        homePage = new HomePage(driver.get(), propertyManager);;
        cartPage = new CartPage(driver.get(), propertyManager);
    }

    @AfterMethod
    public void browserReset(){
        driver.get().manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }

}

