package src.tests;

import src.lib.CoreTestCase;
import src.lib.ui.ArticlePageObject;
import src.lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArticleTests extends CoreTestCase {


    @Test

    public void testCompareArticleTitle() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals("We see unexpected title", "Java (programming language)", article_title);

    }


    @Test
    public void testAssertElementHasText() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        SearchPageObject.assertElementHasText(By.id("org.wikipedia:id/view_page_title_text"), "Cannot find element", 15);

    }


    @Test

    public void testAssertElementPresent() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        SearchPageObject.assertElementIsPresenting(By.id("org.wikipedia:id/view_page_title_text"), "Cannot find element", 15);

    }

}
