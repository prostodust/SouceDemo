package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

@Log4j2
public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    @FindBy(xpath = "//*[@class='title']")
    WebElement completeText;

    @FindBy(xpath = "//*[@class='peek']")
    WebElement botLogo;

    /**
     * Adding a product to the shopping cart
     *
     * @param productName the product name
     */
    @Step("Add product: {productName} to Cart")
    public ProductsPage addProductToCart(String productName) {
        log.info("Add product <" + productName + "> to Cart");
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    /**
     * Getting text from the add product button
     *
     * @param productName the product name
     * @return the text
     */
    public String getAddProductToCartButtonText(String productName) {
        log.info("Getting text from the <Add> button by product <" + productName + ">");
        String textAddProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).getText();
        log.info("Return text: " + textAddProductToCartButton);
        return textAddProductToCartButton;
    }

    /**
     * Get product complete text
     *
     * @return complete text
     */
    public String getProductCompleteText() {
        log.debug("Get product complete text");
        return completeText.getText();
    }

    /**
     * Waiting for the page to open
     */
    public ProductsPage waitForPageOpened() {
        log.debug("Waiting for the page to open");
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = fluent.until(driver -> botLogo);
        return this;
    }
}
