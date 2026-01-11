package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.RegisterSuccessPage;
import com.opencart.utils.DBUtil;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        String email = "Varsh" + System.currentTimeMillis() + "@test.com";

        HomePage homePage = new HomePage(driver);
        homePage.openRegisterPage();

        

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName("varsha");
        registerPage.enterLastName("new");
        registerPage.enterEmail(email);
        registerPage.enterPassword("Test@123");
        registerPage.acceptPrivacyPolicy();
        registerPage.clickContinue();
        
     // ⏳ WAIT for redirect to success page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean redirectedToSuccess = wait.until(ExpectedConditions.urlContains("route=account/success"));

        Assert.assertTrue(redirectedToSuccess,"❌ Registration submitted but not redirected to success page");

        // ✅ Validate success message
        RegisterSuccessPage successPage = new RegisterSuccessPage(driver);
        Assert.assertTrue(successPage.isRegistrationSuccessful(),"❌ Account created but success message not visible");
        
        boolean isUserInDB =
                DBUtil.isCustomerPresent(email);

        Assert.assertTrue(
                isUserInDB,
                "❌ User not found in DB after registration"
        );
  

    }
}
