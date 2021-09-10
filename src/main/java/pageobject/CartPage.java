package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CartPage extends BasePage {
    private static final String REMOVE_FROM_CART_BUTTON = "//div[@class='item']/i[contains(@class,'js-btn-close')]";
    private static final String CART_TEXT_MESSAGE = "//div[@data-cart-name='modal']//p[@class='text-center']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveFromCartButton() {
        waitForPageLoadingComplete(10000);
        driver.findElement(xpath(REMOVE_FROM_CART_BUTTON)).click();
    }

    public String getCartTextMessageText() {
        return driver.findElement(xpath(CART_TEXT_MESSAGE)).getText();
    }

    public By getCartTextMessage() {
        return id(CART_TEXT_MESSAGE);
    }

    public void waitForPageLoadingComplete(long timeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
