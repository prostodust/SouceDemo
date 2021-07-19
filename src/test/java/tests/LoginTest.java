package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest implements ITestConstants {

    /**
     * Entering the correct data
     */
    @Test(description = "Entering the correct data", groups = {"smoke"})
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
     * Invalid value in the "name" and "password" fields
     */
    @Test(description = "Invalid value in the \"name\" and \"password\" fields")
    public void enterInvalidUsernameAndPasswordTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login("standard", "secret")
                .waitForPageLoaded();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }

    /**
     * Passing parameters from CircleCI (or default value from file config.properties) inside the test
     */
    @Test(description = "Passing parameters from CircleCI/config.properties inside the test", groups = {"smoke"})
    public void enterUsernameAndPasswordFromConfigTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(System.getenv().getOrDefault("userFromCircleCI", PropertyReader.getProperty("userFromConfig")), System.getenv().getOrDefault("passFromCircleCI", PropertyReader.getProperty("passFromConfig")))
                .waitForPageOpened();
        Assert.assertEquals(productsPage.getProductCompleteText(), "PRODUCTS");
    }

    /**
     * Passing parameters from the Maven command line (or default value this) inside the test
     */
    @Test(description = "Passing parameters \"name\" and \"password\" from the Maven command line inside the test")
    public void enterUsernameAndPasswordFromMavenTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login(System.getProperty("userFromMaven", "standard_user"), System.getProperty("passFromMaven", "secret_sauce"))
                .waitForPageLoaded();
        Assert.assertEquals(productsPage.getProductCompleteText(), "PRODUCTS");
    }

    /**
     * Passing parameters TestNG from the file soucedemo.xml (or default value from @Optional) inside the test
     */
    @Parameters({"userFromXML", "passFromXML"})
    @Test(description = "Passing parameters \"name\" and \"password\" from the TestNG inside the test")
    public void enterUsernameAndPasswordFromTestNGTest(@Optional(STANDARD_USER_LOGIN) String p1_user, @Optional(STANDARD_USER_PASSWORD) String p2_pass) {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(20)
                .login(p1_user, p2_pass)
                .waitForPageLoaded();
        Assert.assertEquals(productsPage.getProductCompleteText(), "PRODUCTS");
    }
}
