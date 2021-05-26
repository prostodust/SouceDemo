package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest implements ITestConstants {

    /**
     * Changing the text on the button
     */
    @Parameters({"username", "password"})
    @Test (description = "Changing the text on the button")
    public void changingButtonNameTest(@Optional(STANDARD_USER_LOGIN) String p1, @Optional(STANDARD_USER_PASSWORD) String p2) {
        String productName = "Sauce Labs Bolt T-Shirt";
        loginPage.openPage(SAUCE_DEMO_BASE_URL)
                .waitForElementBotLogoLocated(10)
                .login(p1, p2)
                .waitForPageOpened()
                .addProductToCart(productName);
        Assert.assertEquals(productsPage.getAddProductToCartButtonText(productName), "REMOVE");
    }

}
