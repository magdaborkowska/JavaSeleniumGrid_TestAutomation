package com.magdab.amazon;

import com.magdab.BaseTest;
import com.magdab.asserts.TextAsserts;
import com.magdab.pageobject.amazon.CategoryPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GoToCategoryTest extends BaseTest {

    @Test
    public void basicAmazonGoToCategory() {

        homePage.open()
                .pickCategoryFromMainPage();
        assertCategoryPage(CategoryPage.CATEGORY_PAGE_ELEMENT_XPATH);
        categoryPage.pickSubcategory();
        assertCategoryPage(CategoryPage.SUBCATEGORY_PAGE_ELEMENT_XPATH);
    }

    @Step("Check that text on page is as expected")
    private void assertCategoryPage(By xpath) {
        assertLogger.info("Verifying text on page");
        TextAsserts.assertThatTextIsDisplayed(xpath, driver.get(), assertLogger);
    }
}
