package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {

    /**
     * Adding a product to the shopping cart
     */
    @Test
    public void addProductToCartTest() {
        String productName = "Sauce Labs Bolt T-Shirt";
        loginPage.openPage(SAUCE_DEMO_BASE_URL);
        loginPage.waitForPageOpened();
        loginPage.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productsPage.addProductToCart(productName);
        cartPage.openPage(SAUCE_DEMO_CART_PAGE_URL);
        cartPage.waitForPageLoaded();
        Assert.assertEquals(cartPage.getProductQuantity(productName), "1");
        Assert.assertEquals(cartPage.getProductPrice(productName), "$15.99");
    }
}
