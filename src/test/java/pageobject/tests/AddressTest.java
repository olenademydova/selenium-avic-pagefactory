package pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddressTest extends BaseTest{
    @Test
    public void checkAddressForCity() {
        getHomePage().changeCity();
        assertEquals(getHomePage().getKyivAddressText(),"ул. Пушкинская, 2-4/7, м. \"Крещатик\" (красная линия), м. \"Золотые ворота\" (зеленая линия)");
    }
}
