package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;

public class CartSteps {
    private CartPage cartPage;

    /**
     * Init pages
     *
     * @param driver
     */
    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    /**
     * Check the product in the shopping cart
     *
     * @param url
     * @param productName
     * @param productPrice
     * @param productQuantity
     * @return
     */
    @Step("Check the product in the shopping cart")
    public CartSteps checkProductInCart(String url, String productName, String productPrice, String productQuantity) {
        cartPage.openPage(url)
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getProductQuantity(productName), productQuantity);
        Assert.assertEquals(cartPage.getProductPrice(productName), productPrice);
        return this;
    }
}