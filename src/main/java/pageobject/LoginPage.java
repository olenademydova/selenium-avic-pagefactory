package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='sign-holder clearfix']//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='sign-holder clearfix']//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'js_message')]")
    private WebElement popUpMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillCredentialsAndLogin(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getPopupMessageText() {
        return popUpMessage.getText();
    }
}
