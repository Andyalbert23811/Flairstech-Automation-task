package testcases;

import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

@Epic("Login Tests")
@Feature("Login Functionality")
public class addUser {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    HomePage homePage;
    AddUserPage addUserPage;
    String randomUsername = RandomStringUtils.randomAlphanumeric(8);


    @BeforeMethod
    @Step("Setup the browser and open the application")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @Test
    @Description("Test to verify login functionality and adding a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickAdminButton();
        adminPage = new AdminPage(driver);
        int initialRecordsCount = adminPage.getRecordsCount();
        System.out.println("Records count: " + initialRecordsCount);
        adminPage.clickAddNewButton();
        addUserPage = new AddUserPage(driver);
        addUserPage.enterUsername(randomUsername);
        addUserPage.enterPassword("P@ssw0rd");
        addUserPage.enterConfirmPassword("P@ssw0rd");
        addUserPage.chooseUserRole("Admin");
        addUserPage.chooseStatus("Enabled");
        addUserPage.enterEmployeeName("a");
        Thread.sleep(3000);
        addUserPage.chooseEmployeeName();
        addUserPage.clickSubmit();
        int newRecordsCount = adminPage.getRecordsCount();
        assert newRecordsCount == initialRecordsCount + 1 : "Records count did not increase by 1";
        homePage.searchNewUser(randomUsername);
        homePage.clickSearchButton();
        homePage.clickDeleteButton();
        homePage.clickDeleteConfirmationButton();
        homePage.clickResetButton();
        int finalRecordsCount = adminPage.getRecordsCount();
        assert finalRecordsCount == initialRecordsCount : "Records count did not decrease by 1";
    }

    @AfterMethod
    @Step("Close the browser")
    public void tearDown() {
        driver.quit();
    }
}