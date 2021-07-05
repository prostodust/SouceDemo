package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {
    /**
     * Changing the text on the button
     */
    @Test(description = "Changing the text on the button")
    public void changingButtonNameTest() {
        String productName = "Sauce Labs Bolt T-Shirt";
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD)
                .waitForPageOpened()
                .addProductToCart(productName);
        Assert.assertEquals(productsPage.getAddProductToCartButtonText(productName), "REMOVE");
    }
}
