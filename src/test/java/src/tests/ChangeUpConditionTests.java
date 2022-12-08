package src.tests;

import src.lib.CoreTestCase;
import src.lib.ui.ArticlePageObject;
import src.lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class ChangeUpConditionTests extends CoreTestCase {

    @Test

    public void testChangeScreenOrientationOnSearchResults() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();

        this.rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle();


        assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);

        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();


        assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_second_rotation);
    }


    @Test

    public void testSearchArticleBackground() {


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();


        SearchPageObject.assertElementNotPresent(By.xpath(SearchPageObject.SEARCH_MAIN_ARTICLE), "article is not in the background");
    }

}
