package pageobject.tests;

import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.LoginPage;

import static org.testng.Assert.assertEquals;

public class LogInTests extends BaseTest {
    private final String invalidLogin = "wrongmail@gmail.com";
    private final String invalidPassword = "1234567890";
    private final String popupErrorMessage = "Неверные данные авторизации.";

    @Test
    public void verifyUserCannotLoginWithInvalidCredentials(){
        getHomePage().clickOnSignInButton();
        getLoginPage().fillCredentialsAndLogin(invalidLogin, invalidPassword);
        assertEquals(getLoginPage().getPopupMessageText(), popupErrorMessage);
    }
}
