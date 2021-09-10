package pageobject;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class LoginPage extends BasePage {
    public static final String LOGIN = "//div[@class='sign-holder clearfix']//input[@name='login']";
    public static final String PASSWORD = "//input[@type='password']";
    public static final String LOGIN_BUTTON = "//div[@class='sign-holder clearfix']//button[@type='submit']";
    public static final String POPUP_MESSAGE = "//div[contains(@class,'js_message')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillCredentialsAndLogin(String login, String password) {
        driver.findElement(xpath(LOGIN)).sendKeys(login);
        driver.findElement(xpath(PASSWORD)).sendKeys(password);
        driver.findElement(xpath(LOGIN_BUTTON)).click();
    }

    public String getPopupMessageText() {
        return driver.findElement(xpath(POPUP_MESSAGE)).getText();
    }
}
