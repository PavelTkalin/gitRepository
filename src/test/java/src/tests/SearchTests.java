package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import src.lib.CoreTestCase;
import src.lib.ui.ArticlePageObject;
import src.lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTests extends CoreTestCase {


    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test cancelling search by pressing cancel button")
    @Description("We verify whether it is possible to cancel test")
    @Step("Starting test testCancelTestSearch")
    @Severity(value = SeverityLevel.MINOR)

    public void testCancelTestSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test searching the article and pressing the button")
    @Description("We verify whether it is possible to search the article and pressing the button")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.CRITICAL)

    public void testSearch() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }


    @Test
    public void testTestSwipeArticle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();



    }

    @Test

    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Linkin park discography");
        SearchPageObject.clickByArticle();
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();


        assertTrue(
                "We found too few results",
                amount_of_search_results > 0);
    }


    @Test

    public void testOfEmptyAmountSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("fdfd&454d");
        SearchPageObject.clickByArticle();
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }


    public void testVerifyTestSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        WebElement java = SearchPageObject.waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']//*[@text ='Java']"), "Cannot find object-oriented programming language searching by Java", 15);
        WebElement javaScript = SearchPageObject.waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']//*[@text ='JavaScript']"), "Cannot find object-oriented programming language searching by JavaScript", 15);
        String expected_article_text = "Java";
        String actual_article_text_java = java.getText();
        String actual_article_text_javascript = javaScript.getText();
        assertTrue(actual_article_text_java.contains(expected_article_text));
        assertTrue(actual_article_text_javascript.contains(expected_article_text));

    }


}
