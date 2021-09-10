package pageobject;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class AppleStorePage extends BasePage {
    private static final String IPHONE_BUTTON = "//div[@class='brand-box__info']//a[text()='iPhone']";
    private static final String MACBOOK_BUTTON = "//div[@class='brand-box__info']//a[text()='MacBook']";
    private static final String FILTER_BY_SERIES_CHECKBOX = "//a[text()='%s']/ancestor::label/a";

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIPhoneButton() {
        driver.findElement(xpath(IPHONE_BUTTON)).click();
    }

    public void clickOnMacBookButton() {
        driver.findElement(xpath(MACBOOK_BUTTON)).click();
    }

    public void filterSearchResultsBySeries(String series) {
        driver.findElement(xpath(String.format(FILTER_BY_SERIES_CHECKBOX, series))).click();
    }
}
