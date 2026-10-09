package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    private static final Properties config = new Properties();
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeSuite
    public void beforeSuite() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                config.load(input);
            }
        } catch (Exception ignored) {
        }
    }

    @BeforeTest
    public void beforeTest(ITestContext context) {
        if (context != null && context.getName() != null) {
            System.setProperty("current.test.context", context.getName());
        }
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        System.clearProperty("current.test.context");
    }

    @BeforeMethod
    public void setUp() {
        String defaultBrowser = config.getProperty("browser", "chrome");
        String browser = System.getProperty("browser", defaultBrowser).toLowerCase();

        String defaultHeadless = config.getProperty("headless", "false");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", defaultHeadless));

        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-search-engine-choice-screen");
                chromeOptions.addArguments("--remote-allow-origins=*");
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        String defaultUrl = config.getProperty("sf.base.url", "https://login.salesforce.com/?locale=in");
        String baseUrl = System.getProperty("sf.url", defaultUrl);

        int timeoutSeconds = Integer.parseInt(config.getProperty("sf.timeout", "10"));
        driver.get(baseUrl);
        loginPage = new LoginPage(driver, Duration.ofSeconds(timeoutSeconds));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                driver = null;
            }
        }
    }

    @Test
    public void test01_verifyLoginPageLoadsSuccessfully() {
        String title = loginPage.getPageTitle();
        String currentUrl = loginPage.getCurrentUrl();

        Assert.assertNotNull(title, "Page title should not be null.");
        Assert.assertTrue(title.contains("Salesforce"),
                "Page title should contain 'Salesforce', but was: " + title);
        Assert.assertTrue(currentUrl.contains("salesforce.com"),
                "Current URL should contain 'salesforce.com', but was: " + currentUrl);
    }

    @Test
    public void test02_verifyUsernameFieldVisibleAndEnabled() {
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(),
                "Username field should be visible on the Salesforce login page.");
        Assert.assertTrue(loginPage.isUsernameFieldEnabled(),
                "Username field should be enabled for user input.");
    }

    @Test
    public void test03_verifyPasswordFieldVisibleAndEnabled() {
        if (!loginPage.isPasswordFieldDisplayed()) {
            loginPage.enterUsername("automation.test@company.invalid");
            loginPage.clickLogin();
        }
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(),
                "Password field should be visible on the Salesforce login page.");
        Assert.assertTrue(loginPage.isPasswordFieldEnabled(),
                "Password field should be enabled for user input.");
    }

    @Test
    public void test04_verifyLoginButtonVisibleAndEnabled() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Login button should be visible on the Salesforce login page.");
        Assert.assertTrue(loginPage.isLoginButtonEnabled(),
                "Login button should be enabled for user interaction.");
    }

    @Test
    public void test05_verifyRememberMeCheckboxStateToggle() {
        Assert.assertTrue(loginPage.isRememberMeCheckboxDisplayed(),
                "Remember Me checkbox should be displayed.");

        loginPage.setRememberMe(true);
        Assert.assertTrue(loginPage.isRememberMeSelected(),
                "Remember Me checkbox should be selected after enabling.");

        loginPage.setRememberMe(false);
        Assert.assertFalse(loginPage.isRememberMeSelected(),
                "Remember Me checkbox should not be selected after disabling.");
    }

    @Test
    public void test06_verifyAuthorizedValidCredentialsLogin() {
        String username = System.getProperty("sf.username", System.getenv("SF_TEST_USERNAME"));
        String password = System.getProperty("sf.password", System.getenv("SF_TEST_PASSWORD"));

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new SkipException("Skipping authorized login test: valid test credentials (SF_TEST_USERNAME / SF_TEST_PASSWORD) were not provided.");
        }

        loginPage.login(username, password);

        Assert.assertFalse(loginPage.isErrorMessageDisplayed(),
                "Error banner should not appear when authenticating with valid credentials.");
        Assert.assertFalse(loginPage.getCurrentUrl().contains("login.salesforce.com"),
                "Successful authentication should redirect away from the login page.");
    }

    @Test
    public void test07_verifySubmitEmptyCredentials() {
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed when submitting empty credentials.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertFalse(errorText.isEmpty(),
                "Error message banner should contain validation text.");
    }

    @Test
    public void test08_verifySubmitUsernameWithEmptyPassword() {
        loginPage.enterUsername("automation.test@company.invalid");
        loginPage.clickLogin();
        if (loginPage.isPasswordFieldDisplayed()) {
            loginPage.clickLogin();
        }
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed when password field is left empty.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertTrue(errorText.toLowerCase().contains("password"),
                "Validation message should reference password when password is empty, but was: " + errorText);
    }

    @Test
    public void test09_verifySubmitPasswordWithEmptyUsername() {
        if (loginPage.isPasswordFieldDisplayed()) {
            loginPage.enterPassword("DummyPassword123!");
            loginPage.clickLogin();
        } else {
            loginPage.clickLogin();
        }
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed when username field is left empty.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertTrue(errorText.toLowerCase().contains("username"),
                "Validation message should reference username when username is empty, but was: " + errorText);
    }

    @Test
    public void test10_verifySubmitInvalidCredentials() {
        loginPage.login("nonexistent.user.test@example.invalid", "InvalidPassword123!");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error banner should be displayed when submitting invalid credentials.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertFalse(errorText.isEmpty(),
                "Error message banner text should not be empty.");
    }

    @Test
    public void test11_verifySubmitMalformedEmailInput() {
        loginPage.login("malformed-not-an-email", "SomePassword123!");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error banner should be displayed for malformed email login input.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertFalse(errorText.isEmpty(),
                "Error message banner text should not be empty.");
    }

    @Test
    public void test12_verifyErrorMessageBannerAndValidationContent() {
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message banner must be displayed.");
        String errorText = loginPage.getErrorMessageText();
        Assert.assertTrue(errorText.length() > 5,
                "Error message text should be descriptive and contain meaningful characters.");
    }

    @DataProvider(name = "negativeLoginDataProvider")
    public Object[][] negativeLoginDataProvider() {
        return new Object[][] {
            {"invalid.user1@example.test", "WrongPassword1!"},
            {"invalid.user2@example.test", "WrongPassword2!"},
            {"malformed-email-test", "WrongPassword3!"}
        };
    }

    @Test(dataProvider = "negativeLoginDataProvider")
    public void testDataProvider_negativeLoginScenarios(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message banner should be displayed for data provider input: " + username);
        String errorText = loginPage.getErrorMessageText();
        Assert.assertFalse(errorText.isEmpty(),
                "Error message text should not be empty for data provider login attempt.");
    }
}
