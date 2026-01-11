package com.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // OpenCart 4 - click the <a>, not the span
    private By myAccountMenu =
        By.xpath("//a[contains(@class,'dropdown-toggle') and contains(.,'My Account')]");

    private By registerLink =
        By.xpath("//a[normalize-space()='Register']");

    private By loginLink =
        By.xpath("//a[normalize-space()='Login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openRegisterPage() {
        WebElement myAccount = wait.until(
            ExpectedConditions.elementToBeClickable(myAccountMenu)
        );
        myAccount.click();

        wait.until(
            ExpectedConditions.elementToBeClickable(registerLink)
        ).click();
    }

    public void openLoginPage() {
        WebElement myAccount = wait.until(
            ExpectedConditions.elementToBeClickable(myAccountMenu)
        );
        myAccount.click();

        wait.until(
            ExpectedConditions.elementToBeClickable(loginLink)
        ).click();
    }
}
