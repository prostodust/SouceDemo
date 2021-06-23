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
public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";

    @FindBy(xpath = "//*[@class='header_secondary_container']/span")
    WebElement completeText;

    /**
     * Open page
     *
     * @param url the url
     */
    @Step("Opening cart page")
    public CartPage openPage(String url) {
        log.info("Opening the shopping cart page at " + url);
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
        log.info("Gets product <" + productName + "> quantity");
        String textProductQuantity = driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
        log.info("Return text: " + textProductQuantity);
        return textProductQuantity;
    }

    /**
     * Gets product price
     *
     * @param productName the product name
     * @return the product price
     */
    public String getProductPrice(String productName) {
        log.info("Gets product <" + productName + "> price");
        String textProductPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Return text: " + textProductPrice);
        return textProductPrice;
    }

    /**
     * Waiting for the page to open
     */
    public CartPage waitForPageOpened() {
        log.debug("Waiting for the page to open");
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement foo = fluent.until(driver -> completeText);
        return this;
    }
}