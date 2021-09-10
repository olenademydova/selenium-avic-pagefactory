package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";

    @Test
    public void checkAddToCart() throws InterruptedException {
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIPhoneButton();
        getIphonePage().waitForPageLoadingComplete(30);
        getIphonePage().clickOnAddToCartButton();
        getHomePage().waitForVisibilityOfElement(30, getHomePage().getAddToCartPopup());
        getIphonePage().clickOnContinueShoppingButton();
        Thread.sleep(1000);
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }

    @Test
    public void checkRemovalOfOneItemFromCart(){
        getHomePage().clickOnProductCatalogueButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIPhoneButton();
        getIphonePage().waitForPageLoadingComplete(30);
        getIphonePage().clickOnAddToCartButton();
        getCartPage().clickOnRemoveFromCartButton();
        getDriver().navigate().refresh();
        getHomePage().clickOnCartButton();
        assertEquals(getCartPage().getCartTextMessageText(), "Корзина пустая!");
    }
}
