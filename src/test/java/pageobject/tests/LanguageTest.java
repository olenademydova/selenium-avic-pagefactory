package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LanguageTest extends BaseTest {
    @Test
    public void checkLanguageChanging() {
        getHomePage().changeLanguage();
        assertEquals(getDriver().getCurrentUrl(), "https://avic.ua/ua");
        assertEquals(getHomePage().getTextInSearchField(), "Пошук");
    }
}
