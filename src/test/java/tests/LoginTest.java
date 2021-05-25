package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {

    /**
     * Entering the correct data
     */
    @Test
    public void enterCorrectUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getProductCompleteText(), "PRODUCTS");
    }

    /**
     * Empty value in the "username" field
     */
    @Test
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
    @Test
    public void enterEmptyPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, "")
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    /**
     * Empty value in the "name" and "password" fields
     */
    @Test
    public void enterEmptyUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login("", "")
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }
}
