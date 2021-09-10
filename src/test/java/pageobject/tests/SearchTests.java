package pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {
    private static final String SEARCH_KEYWORD = "iPhone 11";
    private static final String EXPECTED_SEARCH_QUERY = "query=iPhone";

    @Test
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }

    @Test
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        assertEquals(getSearchResultPage().getSearchResultCount(), 12);
    }

    @Test
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        for (WebElement webElement : getSearchResultPage().getSearchResultList()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }
}
