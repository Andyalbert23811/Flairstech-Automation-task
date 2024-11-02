package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BrowserHelper {
    WebDriver driver;
    WebDriverWait wait;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElement(WebElement element) {
        waitUntilClickable(element).click();
    }

    public void fillTextField(WebElement element, String text) {
        WebElement visibleElement = waitUntilVisible(element);
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    public int extractRecordsCount(WebElement element) {
        String text = waitUntilVisible(element).getText();
        String number = text.replaceAll("[^0-9]", "");
        return Integer.parseInt(number);
    }

    public void selectFromCustomDropdownByText(WebElement dropdown, List<WebElement> options, String visibleText) {
        waitUntilClickable(dropdown).click(); // Click to open the dropdown
        for (WebElement option : options) {
            if (option.getText().equals(visibleText)) {
                waitUntilClickable(option).click(); // Click the desired option by visible text
                break;
            }
        }
    }

    public void selectFromList(List<WebElement> elementsList,String expectedText)
    {
        for (WebElement element : elementsList) {
            if (element.getText().equals(expectedText)) {
                waitUntilClickable(element).click();
                break;
            }
        }
    }

    public void sendKeysReturn(WebElement element) {
        waitUntilVisible(element).sendKeys(Keys.RETURN);
    }
    public void sendKeysArrowDown(WebElement element) {
        waitUntilVisible(element).sendKeys(Keys.ARROW_DOWN);
    }

    private WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}