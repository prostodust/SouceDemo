package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        String productName = "Sauce Labs Bolt T-Shirt";
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductQuantity(productName), "1");
        Assert.assertEquals(cartPage.getProductPrice(productName), "$15.99");
    }
}
