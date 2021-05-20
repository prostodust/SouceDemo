package pages;

public interface ICartPage {
    String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
}
