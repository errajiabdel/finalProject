package org.eat.pages;

import org.eat.base.CustomDriver;
import org.openqa.selenium.WebDriver;

public class ShoppingPage extends CustomDriver {

    public ShoppingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    private String ADD_TO_CART_FromHomePage =addProductFromHomeLocator("onesie");
    private String ADD_TO_CART_FROM_PRODUCT_DETAIL = "xpath=>//button[text()='Add to cart']";
    private String CLICK_ON_PRODUCT =clickOnProductLocator(" Bike Light");
    private String CART_ICON = "id=>shopping_cart_container";
    private String RETURN_TO_SHOPPING = "id=>continue-shopping";
    private String REMOVE_FROM_CART_PAGE = removeProductLocator("onesie");
    private String REMOVE_PRODUCT_1 = removeProductLocator("bolt-t-shirt");
    private String REMOVE_PRODUCT_2 = removeProductLocator("fleece-jacket");
    private String REMOVE_FROM_HOME_PAGE = removeProductLocator("bike-light");
    private String ADD_PRODUCT_1 =addProductFromHomeLocator("bolt-t-shirt");
    private String ADD_PRODUCT_2 = addProductFromHomeLocator("fleece-jacket");
    private String CHECKOUT = "id=>checkout";
    private String REMOVE_BUTTON="xpath=>//button[text()='Remove']";
    private String TITLE="xpath=>//span[@class='title']";
    private String CHECKOUT_TITLE="xpath=>//span[text()='Checkout: Your Information']";
    public static String clickOnProductLocator( String productName){
        String locator="xpath=>//div[contains(text(),'"+productName+"')]";
        return locator;
    }
    public static String addProductFromHomeLocator( String productName){
        String locator="id=>add-to-cart-sauce-labs-"+productName;
        return locator;
    }
    public static String removeProductLocator( String productName){
        String locator="id=>remove-sauce-labs-"+productName;
        return locator;
    }
    public void addToCartFromHomeP() {
        clickWhenReady(ADD_TO_CART_FromHomePage,"item added from home page",8);
    }
    public boolean isItemAdded() {
        boolean result = isElementPresent(REMOVE_BUTTON, "remove button present as indication of item added ");
        return result;
    }
    public void addToCartFromProductDetail() {
        clickWhenReady(CLICK_ON_PRODUCT,"item clicked for the next step",14);
        clickWhenReady(ADD_TO_CART_FROM_PRODUCT_DETAIL,"item added to cart from product detail",15);
    }
    public void returnToShoppingFromCart(){
       clickWhenReady(CART_ICON,"cart icon clicked",18);
       clickWhenReady(RETURN_TO_SHOPPING,"returned to shopping page from cart",25);
    }
    public boolean isUserReturnedToHomePage() {
        boolean result = isElementPresent(TITLE, "title present as indication of user returned to home page ");
        return result;
    }
    public void removeItemFromCartPage(){
        clickWhenReady(CART_ICON,"cart icon clicked to remove item",8);
        clickWhenReady(REMOVE_FROM_CART_PAGE,"remove product from cart page  ",10);
    }
    public boolean isItemRemovedFromCart() {
        boolean result = isElementPresent(REMOVE_FROM_CART_PAGE,"specific item  should not be present after removing it  ");
        return result;
    }
    public void removeItemFromHomePage(){
        clickWhenReady(REMOVE_FROM_HOME_PAGE,"remove item from home page  ",12);
    }
    public boolean isItemRemovedFromHomePage() {
        boolean result = isElementPresent(ADD_TO_CART_FromHomePage,"add to cart button present as indication of item has been removed   ");
        return result;
    }
    public void addingMultipleItems(){
        clickWhenReady(ADD_PRODUCT_1,"adding product 1 for checkout",24);
        clickWhenReady(ADD_PRODUCT_2,"adding product 2 for checkout",24);
    }
    public boolean isMultipleItemAdded() {
        boolean result = isElementPresent(REMOVE_PRODUCT_1, "remove button product 1  present as indication of of multiple item added ");
        boolean result1 = isElementPresent(REMOVE_PRODUCT_2, "remove button product 2  present as indication of of multiple item added ");
        return result&result1;
    }

    public void checkout(){
        clickWhenReady(CART_ICON,"clicked on cart icon for checkout items",8);
        clickWhenReady(CHECKOUT,"click on checkout button for checkout items ",8);
    }

    public boolean isUserCheckedOut() {
        boolean result = isElementPresent(CHECKOUT_TITLE ,"checkout title present as indication of user checked out  ");
        return result;
    }








}
