package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class CheckoutTest extends BaseTest implements ITestConstants {

    /**
     * Checking the Review stage when placing an order
     */
    @Test (description = "Checking the Review stage when placing an order", alwaysRun = true)
    public void paymentCheckoutOverviewTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .waitForPageOpened()
                .addProductToCart("Sauce Labs Fleece Jacket");
        checkoutPage.openPage(SAUCE_DEMO_CHECKOUT_PAGE_URL)
                .waitForPageOpened()
                .fillingCustomerData("Sergey", "Ivanov", "231400")
                .waitForPageOpened();
        Assert.assertEquals(checkoutPage.getTotalItemsText(), "Item total: $49.99");
        Assert.assertEquals(checkoutPage.getTaxText(), "Tax: $4.00");
        Assert.assertEquals(checkoutPage.getTotalText(), "Total: $53.99");
    }

    /**
     * Verification of the Completed stage when placing an order
     */
    @Test (description = "Verification of the Completed stage when placing an order", retryAnalyzer = Retry.class)
    public void paymentCheckoutCompleteTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .waitForPageOpened()
                .addProductToCart("Sauce Labs Fleece Jacket");
        checkoutPage.openPage(SAUCE_DEMO_CHECKOUT_PAGE_URL)
                .waitForPageOpened()
                .fillingCustomerData("Sergey", "Ivanov", "231400")
                .waitForPageOpened()
                .clickFinishButton()
                .waitForPageOpened();
        Assert.assertEquals(checkoutPage.getCheckoutCompleteText(), "CHECKOUT: COMPLETE!");
    }
}
