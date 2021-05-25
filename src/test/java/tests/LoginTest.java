package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstants {

    /**
     * Empty value in the "username" field
     */
    @Test
    public void enterEmptyUsernameTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login("", STANDARD_USER_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

    /**
     * Empty value in the "password" field
     */
    @Test
    public void enterEmptyPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER_LOGIN, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    /**
     * Empty value in the "name" and "password" fields
     */
    @Test
    public void enterEmptyUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

}
