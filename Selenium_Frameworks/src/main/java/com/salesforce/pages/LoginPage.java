package com.salesforce.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[@for='rememberUn']")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessageBanner;

    @FindBy(xpath = "//a[@id='forgot_password_link']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        this(driver, Duration.ofSeconds(10));
    }

    public LoginPage(WebDriver driver, Duration timeout) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null.");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUsernameFieldDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(usernameInput)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isUsernameFieldEnabled() {
        return wait.until(ExpectedConditions.visibilityOf(usernameInput)).isEnabled();
    }

    public boolean isPasswordFieldDisplayed() {
        List<WebElement> elements = driver.findElements(By.xpath("//input[@id='password']"));
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public boolean isPasswordFieldEnabled() {
        return wait.until(ExpectedConditions.visibilityOf(passwordInput)).isEnabled();
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isLoginButtonEnabled() {
        return wait.until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    public boolean isRememberMeCheckboxDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(rememberMeCheckbox)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isRememberMeSelected() {
        wait.until(ExpectedConditions.visibilityOf(rememberMeCheckbox));
        return rememberMeCheckbox.isSelected();
    }

    public void clearUsername() {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        if (username != null && !username.isEmpty()) {
            usernameInput.sendKeys(username);
        }
    }

    public void clearPassword() {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        if (password != null && !password.isEmpty()) {
            passwordInput.sendKeys(password);
        }
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        if (!isPasswordFieldDisplayed()) {
            clickLogin();
        }
        if (isErrorMessageDisplayed()) {
            return;
        }
        if (isPasswordFieldDisplayed()) {
            enterPassword(password);
            clickLogin();
        }
    }

    public void setRememberMe(boolean shouldSelect) {
        wait.until(ExpectedConditions.visibilityOf(rememberMeCheckbox));
        if (rememberMeCheckbox.isSelected() != shouldSelect) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox)).click();
            } catch (Exception e) {
                wait.until(ExpectedConditions.elementToBeClickable(rememberMeLabel)).click();
            }
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessageBanner)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageBanner));
        return errorMessageBanner.getText().trim();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
