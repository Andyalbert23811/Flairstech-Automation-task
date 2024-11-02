package pages;
import helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    BrowserHelper browserHelper;

    @FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
    WebElement adminButton;

    @FindBy(xpath = "(//*[@class=\"oxd-input oxd-input--active\"])[2]")
    WebElement searchField;

    @FindBy(xpath = "(//*[@class=\"oxd-icon-button oxd-table-cell-action-space\"])[1]")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")
    WebElement deleteConfirmationButton;

    @FindBy(xpath = "//*[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement searchButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.browserHelper = new BrowserHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAdminButton() {
        browserHelper.clickElement(adminButton);
    }
    public void searchNewUser(String text) {
        browserHelper.fillTextField(searchField, text);
    }

    public void clickDeleteButton() {
        browserHelper.clickElement(deleteButton);
    }
    public void clickDeleteConfirmationButton() {
        browserHelper.clickElement(deleteConfirmationButton);
    }
    public void clickResetButton() {
        browserHelper.clickElement(resetButton);
    }
    public void clickSearchButton() {
        browserHelper.clickElement(searchButton);
    }
}