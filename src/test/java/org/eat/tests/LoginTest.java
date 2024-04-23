package org.eat.tests;

import org.eat.base.WebDriverFactory;
import org.eat.base.BaseTestProject;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTest extends BaseTestProject {


    @Test( dataProvider = "loginDataInvalid",groups = {"smoke"})
    public void singInWithInvalidData(String username, String password) {
        navP.toLogout();
       // navP.toLoginPage();

        logP.SignInWith(username, password);
        boolean result = logP.verifyInvalidCredentialsErrorMessage();
        Assert.assertTrue(result);


    }
    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void singInWithValidData (String username,String password) {
        //navP.toLogout();
       // navP.toLoginPage();
        logP.SignInWith(username,password);
        boolean result=navP.isUserLoggedIn();
        Assert.assertTrue(result);

    }






//    @AfterClass(groups = {"smoke","regression"})
//    public void cleanUP () {
//       WebDriverFactory.getInstance().quitDriver();
//    }
}

