package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    /**
     * Adding a product to the shopping cart
     *
     * @param productName the product name
     */
    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    /**
     * Getting text from the add product button
     *
     * @param productName the product name
     * @return the text
     */
    public String getButtonTextProduct(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).getText();
    }

}


