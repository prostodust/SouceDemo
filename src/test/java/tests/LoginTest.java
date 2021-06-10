package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {

    /**
     * Entering the correct data
     */
    @Test(description = "Entering the correct data", groups = {"smoke"})
    public void enterCorrectUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
//                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .login(System.getenv("user"), System.getenv("pass"))
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getProductCompleteText(), "PRODUCTS");
    }

    /**
     * Empty value in the "username" field
     */
    @Test(description = "Empty value in the \"username\" field")
    public void enterEmptyUsernameTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login("", STANDARD_USER_PASSWORD)
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

    /**
     * Empty value in the "password" field
     */
    @Test(description = "Empty value in the \"password\" field")
    public void enterEmptyPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, "")
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    /**
     * Passing parameters from the Maven command line inside the test
     * Invalid value in the "name" and "password" fields
     */
    @Test(description = "Empty value in the \"name\" and \"password\" fields")
    public void enterEmptyUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login(System.getProperty("username", "standard"), System.getProperty("password", "secret"))
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
