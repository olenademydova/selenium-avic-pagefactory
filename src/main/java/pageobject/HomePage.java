package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(css = ".search-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogueButton;

    @FindBy(xpath = "//a[@class='sidebar-item']//span[text()='Apple Store']")
    private WebElement appleStoreButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//div[@class='header-bottom__right-icon']/i[@class='icon icon-cart-new']")
    private WebElement cartButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopUp;

    @FindBy(xpath = "//div[contains(@class,'header-bottom')]/a[@href='https://avic.ua/sign-in']")
    private WebElement sinInButton;

    @FindBy(xpath = "//ul[@class='menu-dropdown menu-dropdown__lang']/..")
    private WebElement changeLanguageDropdown;

    @FindBy(xpath = "//ul[@class='menu-dropdown menu-dropdown__lang']//a[text()='UA']")
    private WebElement changeLanguageButton;

    @FindBy(xpath = "//div[@class='header-top__item js-cont-btn']")
    private WebElement contactsDropdown;

    @FindBy(xpath = "//ul[@class='tab-navigation tab-contact flex-wrap']//a[@href='#tab1']")
    private WebElement changeCityButton;

    @FindBy(xpath = "//*[@id='tab101']//p[3]")
    private WebElement kyivAddress;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnProductCatalogueButton() {
        productCatalogueButton.click();
    }

    public void clickOnAppleStoreButton() {
        appleStoreButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnSignInButton() {
        sinInButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public WebElement getAddToCartPopUp() {
        return addToCartPopUp;
    }

    public void changeLanguage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(changeLanguageDropdown).build().perform();
        changeLanguageButton.click();
    }

    public String getTextInSearchField() {
        return searchInput.getAttribute("placeholder").trim();
    }

    public void changeCity() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsDropdown).build().perform();
        changeCityButton.click();
    }

    public String getKyivAddressText() {
        return kyivAddress.getAttribute("textContent");
    }
}
