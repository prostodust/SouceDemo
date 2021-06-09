package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    /**
     * Init pages
     *
     * @param driver
     */
    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    /**
     * Login and add product to cart
     *
     * @param url
     * @param username
     * @param password
     * @param productName
     * @return
     */
    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProduct(String url, String username, String password, String productName) {
        loginPage
                .openPage(url)
                .waitForElementBotLogoLocated(10)
                .login(System.getProperty("username", username), System.getProperty("password", password))
                .waitForPageOpened()
                .addProductToCart(productName);
        return this;
    }

}
