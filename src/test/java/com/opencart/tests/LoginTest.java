package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        homePage.openLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@test.com", "password");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("route=account/account"),
                "Login failed"
        );
    }
}
