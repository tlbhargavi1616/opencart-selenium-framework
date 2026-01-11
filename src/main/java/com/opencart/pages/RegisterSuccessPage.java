package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPage {

    private WebDriver driver;

    private By successHeading = By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");

    public RegisterSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegistrationSuccessful() {
        try {
            return driver.findElement(successHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
