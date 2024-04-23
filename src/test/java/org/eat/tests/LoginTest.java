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


    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void singInWithValidData (String username,String password) {
        //navP.toLoginPage();
        logP.SignInWith(username,password);
        boolean result=navP.isUserLoggedIn();
        Assert.assertTrue(result);

    }






    @AfterClass(groups = {"smoke","regression"})
    public void cleanUP () {
       WebDriverFactory.getInstance().quitDriver();
    }
}

