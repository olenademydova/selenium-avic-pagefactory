package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
    @FindBy(xpath = "//div[@class='item']/i[contains(@class,'js-btn-close')]")
    private WebElement removeFromCartButton;

    @FindBy(xpath = "//div[@data-cart-name='modal']//p[@class='text-center']")
    private WebElement cartTextMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveFromCartButton() {
        waitForPageLoadingComplete(10000);
        removeFromCartButton.click();
    }

    public String getCartTextMessageText() {
        return cartTextMessage.getText();
    }

    public void waitForPageLoadingComplete(long timeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
