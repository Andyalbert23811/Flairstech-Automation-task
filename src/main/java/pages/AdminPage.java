package pages;

import helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    WebDriver driver;
    BrowserHelper browserHelper;

    @FindBy(xpath = "(//*[@class=\"oxd-text oxd-text--span\"])[1]")
    WebElement recordsCounter;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addNewButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.browserHelper = new BrowserHelper(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickAddNewButton() {
        browserHelper.clickElement(addNewButton);
    }

    public int getRecordsCount() {
        return browserHelper.extractRecordsCount(recordsCounter);

    }
}