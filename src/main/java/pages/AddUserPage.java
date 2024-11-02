package pages;

import helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddUserPage {
    WebDriver driver;
    BrowserHelper browserHelper;

    @FindBy(xpath = "//*[text()='User Role']/../..//*[@class='oxd-select-text-input']")
    WebElement userRoleDDl;

    @FindBy(xpath = "//*[text()='Status']/../..//*[@class='oxd-select-text-input']")
    WebElement statusDDl;

    @FindBy(xpath = "//*[@role='listbox']//span")
    List<WebElement> userRoleSelect;

    @FindBy(xpath = "//*[@role='listbox']//span")
    List<WebElement> statusSelect;

    @FindBy(xpath = "(//*[@type=\"password\"])[1]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@placeholder='Type for hints...']")
    WebElement employeeNameField;

//    @FindBy(xpath = "//*[@role='listbox']//span")
//    List<WebElement> employeeNameSelect;

    @FindBy(xpath = "(//*[@type=\"password\"])[2]")
    WebElement confirmPasswordField;

    @FindBy(xpath = "(//*[@class=\"oxd-input oxd-input--active\"])[2]\n")
    WebElement UsernameField;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    WebElement submitButton;


    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.browserHelper = new BrowserHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmployeeName(String name) {
        browserHelper.fillTextField(employeeNameField, name);
    }
    public void chooseEmployeeName() {
        browserHelper.sendKeysArrowDown(employeeNameField);
        browserHelper.sendKeysReturn(employeeNameField);
    }

    public void enterPassword(String password) {
        browserHelper.fillTextField(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        browserHelper.fillTextField(confirmPasswordField, confirmPassword);
    }

    public void enterUsername(String username) {
        browserHelper.fillTextField(UsernameField, username);
    }

    public void clickSubmit() {
        browserHelper.clickElement(submitButton);
    }

    public void chooseUserRole(String role) {
        browserHelper.clickElement(userRoleDDl);
        browserHelper.selectFromList(userRoleSelect, role);
    }
    public void chooseStatus(String status) {
        browserHelper.clickElement(statusDDl);
        browserHelper.selectFromList(statusSelect, status);
    }
//    public void chooseEmployeeName(String status) {
//        browserHelper.selectFromList(employeeNameSelect, status);
//    }
    }