package com.magdab.amazon;

import com.magdab.BaseTest;
import com.magdab.asserts.TextAsserts;
import com.magdab.pageobject.amazon.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ChangeLanguageTest extends BaseTest {

    @Test
    public void basicAmazonChangeLanguage() {

        homePage.open()
                .changeLanguage();
        languagePage.clickOnLanguage()
                .submitLanguageChange();
        assertHomePage(HomePage.LANGUAGE_CHANGED_ELEMENT);
    }

    @Step("Check that text on page is as expected")
    private void assertHomePage(By xpath) {
        assertLogger.info("Verifying text on page");
        TextAsserts.assertThatTextIsDisplayed(xpath, driver.get(), assertLogger);
    }
}
