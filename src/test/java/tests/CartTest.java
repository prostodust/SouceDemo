package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    //loginPage.openPage()
    //loginPage.login(username,password)
    //productsPage.addToCart("Product Item")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Item")
    //cartPage.getPrice("Product Item")
    //Assertion

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
