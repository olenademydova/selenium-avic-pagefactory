package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindAll({@FindBy(xpath = "//div[@class='prod-cart__descr']")})
    private List<WebElement> searchResultProductsList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultList() {
        return searchResultProductsList;
    }

    public int getSearchResultCount() {
        return getSearchResultList().size();
    }
}
