package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class AppleStorePage extends BasePage {
    @FindBy(xpath = "//div[@class='brand-box__info']//a[text()='iPhone']")
    private WebElement iphoneButton;

    @FindBy(xpath = "//div[@class='brand-box__info']//a[text()='MacBook']")
    private WebElement macBookButton;

    private static final String FILTER_BY_SERIES_CHECKBOX = "//a[text()='%s']/ancestor::label/a";

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIPhoneButton() {
        iphoneButton.click();
    }

    public void clickOnMacBookButton() {
        macBookButton.click();
    }

    public void filterSearchResultsBySeries(String series) {
//        /a[text()='%s']/ancestor::label/a -> //a[text()='Iphone']/ancestor::label/a
        driver.findElement(xpath(String.format(FILTER_BY_SERIES_CHECKBOX, series))).click();
    }
}
