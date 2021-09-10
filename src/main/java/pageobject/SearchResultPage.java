package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.*;

public class SearchResultPage extends BasePage {
    private static final String SEARCH_RESULT_PRODUCTS_LIST = "//div[@class='prod-cart__descr']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultList() {
        return driver.findElements(xpath(SEARCH_RESULT_PRODUCTS_LIST));
    }

    public int getSearchResultCount() {
        return getSearchResultList().size();
    }
}
