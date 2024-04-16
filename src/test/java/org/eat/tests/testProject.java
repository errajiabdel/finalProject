package org.eat.tests;

import org.eat.base.WebDriverFactory;
import org.eat.base.baseTestProject;
import org.eat.utilities.Constants;
import org.eat.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.*;



public class testProject extends baseTestProject {


    @Test( dataProvider = "loginDataInvalid",groups = {"smoke"})
    public void singInWithInvalidData(String username, String password) {
        navP.toLoginPage();

        logP.SignInWith(username, password);
        boolean result = logP.verifyInvalidCredentialsErrorMessage();
        Assert.assertTrue(result);


    }

    @Test(groups = {"regression"})
    public void addToCartFromProductD() {
        shop.addToCartFromProductDetail();

    }

    @Test(groups = {"smoke"})
    public void addToCartFromHome() {
        shop.addToCartFromHomeP();

    }


    @Test(groups = {"regression"})
    public void returnToShoppingFromCArt() {
        shop.returnToShoppingFromCart();

    }

    @Test(groups = {"smoke"})
    public void removeItemFromCartPAge() {
        shop.removeItemFromCartPage();
    }

    @Test(groups = {"smoke"})
    public void removeItemFromHomePage() {
        shop.returnToShoppingFromCart();
        shop.removeItemFromHomePage();
    }

    @Test(groups = {"regression"})
    public void multipleItemToAdd() {

        shop.addingMultipleItems();
    }





    @AfterClass(groups = {"smoke","regression"})
    public void cleanUP () {
       WebDriverFactory.getInstance().quitDriver();
    }
}

