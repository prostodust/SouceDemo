package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void enterEmptyUsernameTest() {
        loginPage.openPage();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getAnErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void enterEmptyPasswordTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getAnErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void enterEmptyUsernameAndPasswordTest() {
        loginPage.openPage();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getAnErrorMessage(), "Epic sadface: Username is required");
    }

}
