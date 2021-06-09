package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstants {

    /**
     * Data for test
     *
     * @return data
     */
    @DataProvider(name = "productNamePriceQuantity")
    public Object[][] asd() {
        return new Object[][]{
                {"Sauce Labs Bolt T-Shirt", "$15.99", "1"},
                {"Sauce Labs Bike Light", "$9.99", "1"},
                {"Sauce Labs Onesie", "$7.99", "1"}
        };
    }

    /**
     * Adding a product to the shopping cart
     */
    @Test(description = "Adding a product to the shopping cart", dataProvider = "productNamePriceQuantity")
    public void addProductToCartTest(String productName, String productPrice, String productQuantity) {
        productSteps.loginAndAddProduct(SAUCE_DEMO_BASE_URL, STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD, productName);
        cartSteps.checkProductInCart(SAUCE_DEMO_CART_PAGE_URL, productName, productPrice, productQuantity);
    }
}
