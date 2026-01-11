package com.opencart.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class RegisterPage {

    private WebDriver driver;

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By privacyPolicy = By.name("agree");
    private By continueBtn = By.xpath("//button[@type='submit']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fn) {
        driver.findElement(firstName).sendKeys(fn);
        System.out.println("✅ First Name entered");
    }

    public void enterLastName(String ln) {
        driver.findElement(lastName).sendKeys(ln);
        System.out.println("✅ Last Name entered");
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
        System.out.println("✅ Email entered: " + email);
    }

    public void enterPassword(String pwd) {
        WebElement pwdField = driver.findElement(password);
        scrollToElement(pwdField);
        pwdField.sendKeys(pwd);
        System.out.println("✅ Password entered");
        
    }

    public void acceptPrivacyPolicy() {
        WebElement checkbox = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        System.out.println("✅ Privacy Policy accepted");
    }



public void clickContinue() {
    WebElement btn = driver.findElement(By.xpath("//button[text()='Continue']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    System.out.println("✅ Continue clicked");
}


    // 🔽 reusable scroll helper
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
}
