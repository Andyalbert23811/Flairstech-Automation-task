package pages;

import helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    BrowserHelper browserHelper;

    @FindBy(xpath = "//*[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.browserHelper = new BrowserHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        browserHelper.fillTextField(usernameField, username);
    }

    public void enterPassword(String password) {
        browserHelper.fillTextField(passwordField, password);
    }

    public void clickLogin() {
        browserHelper.clickElement(loginButton);
    }
}