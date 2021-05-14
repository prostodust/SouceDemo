package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void changingButtonNameTest() {
        String productName = "Sauce Labs Bolt T-Shirt";
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productsPage.getButtonName(productName), "REMOVE");
    }

}
