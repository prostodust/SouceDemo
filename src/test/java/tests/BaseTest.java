package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    /**
     * Actions performed before each test
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    /**
     * Actions performed after each test
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

}
