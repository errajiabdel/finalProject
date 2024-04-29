package org.eat.tests;

import org.eat.base.BaseTestProject;
import org.eat.base.WebDriverFactory;
import org.eat.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShoppingTest extends BaseTestProject  {






    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void AddToCartFromHome(String username,String password)  {
        logP.SignInWith(username,password);
        shop.addToCartFromHomeP();
        boolean result=shop.isItemAdded();
        Assert.assertTrue(result);


    }
    @Test(groups = {"regression"})
    public void AddToCartFromProductD()  {

        shop.addToCartFromProductDetail();
        boolean result=shop.isItemAdded();
        Assert.assertTrue(result);



    }


    @Test(groups = {"regression"})
    public void ReturnToShoppingFromCArt() {
        shop.returnToShoppingFromCart();
        boolean result=shop.isUserReturnedToHomePage();
        Assert.assertTrue(result);

    }

    @Test(groups = {"smoke"})
    public void RemoveItemFromCartPAge()  {
        shop.removeItemFromCartPage();

    }

    @Test(groups = {"smoke"})
    public void RemoveItemFromHomePage()  {
        shop.returnToShoppingFromCart();
        shop.removeItemFromHomePage();

    }

    @Test(groups = {"regression"})
    public void multipleItemToAdd()  {

        shop.addingMultipleItems();
        boolean result=shop.isMultipleItemAdded();
        Assert.assertTrue(result);
        shop.checkout();

    }

    @AfterClass(groups = {"smoke","regression"})
    public void cleanUP () {
        WebDriverFactory.getInstance().quitDriver();
    }







}
