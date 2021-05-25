package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest implements ITestConstants {

    /**
     * Checking the purchase payment
     */
    @Test
    public void paymentForThePurchaseTest() {
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .addProductToCart("Sauce Labs Fleece Jacket");
        checkoutPage.openPage(SAUCE_DEMO_CHECKOUT_PAGE_URL)
                .fillingCustomerData("Sergey", "Ivanov", "231400")
                .waitForPageLoaded();
        Assert.assertEquals(checkoutPage.getTotalItemsText(), "Item total: $49.99");
        Assert.assertEquals(checkoutPage.getTaxText(), "Tax: $4.00");
        Assert.assertEquals(checkoutPage.getTotalText(), "Total: $53.99");
        checkoutPage.clickFinishButton()
                .waitForPageLoaded();
        Assert.assertEquals(checkoutPage.getCheckoutCompleteText(), "CHECKOUT: COMPLETE!");
    }

}
