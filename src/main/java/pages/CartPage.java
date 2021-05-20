package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage implements ICartPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page
     *
     * @param url the url
     */
    public CartPage openPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Gets product quantity
     *
     * @param productName the product name
     * @return the product quantity
     */
    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    /**
     * Gets product price
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
}