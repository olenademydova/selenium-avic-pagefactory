package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


public class HomePage extends BasePage {
    private static final String SEARCH_INPUT = "//input[@id='input_search']";
    private static final String PRODUCT_CATALOGUE_BUTTON = "//span[@class='sidebar-item']";
    private static final String APPLE_STORE_BUTTON = "//a[@class='sidebar-item']//span[text()='Apple Store']";
    private static final String AMOUNT_OF_PRODUCTS_IN_CART = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]";
    private static final String CART_BUTTON = "//div[@class='header-bottom__right-icon']/i[@class='icon icon-cart-new']";
    private static final String ADD_TO_CART_POPUP = "js_cart";
    private static final String SIGN_IN_BUTTON = "//div[contains(@class,'header-bottom')]/a[@href='https://avic.ua/sign-in']";
    private static final String CHANGE_LANGUAGE_DROPDOWN = "//ul[@class='menu-dropdown menu-dropdown__lang']/..";
    private static final String CHANGE_LANGUAGE_BUTTON = "//ul[@class='menu-dropdown menu-dropdown__lang']//a[text()='UA']";
    private static final String CONTACTS_DROPDOWN = "//div[@class='header-top__item js-cont-btn']";
    private static final String CHANGE_CITY_BUTTON = "//ul[@class='tab-navigation tab-contact flex-wrap']//a[@href='#tab1']";
    private static final String KYIV_ADDRESS = "//*[@id='tab101']//p[3]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogueButton() {
        driver.findElement(xpath(PRODUCT_CATALOGUE_BUTTON)).click();
    }

    public void clickOnAppleStoreButton() {
        driver.findElement(xpath(APPLE_STORE_BUTTON)).click();
    }

    public void clickOnCartButton() {
        driver.findElement(xpath(CART_BUTTON)).click();
    }

    public void clickOnSignInButton() {
        driver.findElement(xpath(SIGN_IN_BUTTON)).click();
    }

    public String getTextOfAmountProductsInCart() {
        return driver.findElement(xpath(AMOUNT_OF_PRODUCTS_IN_CART)).getText();
    }

    public By getAddToCartPopup() {
        return id(ADD_TO_CART_POPUP);
    }

    public void changeLanguage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(xpath(CHANGE_LANGUAGE_DROPDOWN))).build().perform();
        driver.findElement(xpath(CHANGE_LANGUAGE_BUTTON)).click();
    }

    public String getTextInSearchField(){
        return driver.findElement(xpath(SEARCH_INPUT)).getAttribute("placeholder").trim();
    }

    public void changeCity(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(xpath(CONTACTS_DROPDOWN))).build().perform();
        driver.findElement(xpath(CHANGE_CITY_BUTTON)).click();
    }

    public String getKyivAddressText(){
        return driver.findElement(xpath(KYIV_ADDRESS)).getAttribute("textContent");
    }
}
