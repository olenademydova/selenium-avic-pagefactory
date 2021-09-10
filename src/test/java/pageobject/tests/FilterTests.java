package pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FilterTests extends BaseTest {
    private static final String SERIES_KEYWORD = "MacBook 12";

    @Test
    public void verifyFilteringBySeries(){
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnMacBookButton();
        getIphonePage().waitForPageLoadingComplete(10);
        getAppleStorePage().filterSearchResultsBySeries(SERIES_KEYWORD);

        for (WebElement webElement : getSearchResultPage().getSearchResultList()) {
            assertTrue(webElement.getText().contains(SERIES_KEYWORD));
        }
    }
}
