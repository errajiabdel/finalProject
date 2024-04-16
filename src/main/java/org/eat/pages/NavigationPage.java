package org.eat.pages;

import org.eat.base.CustomDriver;
import org.eat.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends CustomDriver {

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver driver;


    private String CART_ICON = "id=>shopping_cart_container";
    private String MENU = "id=>react-burger-menu-btn";
    private String LOGOUT_FROM_MENU = "id=>logout_sidebar_link";



    public void toLoginPage() {
        driver.get(Constants.TEST_URL);
    }

    public void toLogout() {
        clickElement(MENU,"click on menu to choose logout option");
        clickElement(LOGOUT_FROM_MENU,"logged out");
    }



    public boolean isUserLoggedIn() {
        boolean result = isElementPresent(CART_ICON, "cart icon as indication of user successfully logged in");
        return result;
    }


}