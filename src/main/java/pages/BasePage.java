package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waiting for an element to load during a timeout
     *
     * @param element the element
     * @param timeout the timeout
     */
    public void waitForElementLocated(By element, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * Waiting for the page to load
     */
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

}
