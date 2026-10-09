# Salesforce Login Automation Framework

An enterprise-grade test automation framework engineered in **Java**, **Selenium WebDriver**, **Page Object Model (POM)** with **PageFactory**, **TestNG**, and **Maven** targeting the Salesforce Login portal:
`https://login.salesforce.com/?locale=in`

---

## Architecture & Design Highlights

* **Page Object Model with PageFactory:** Clean separation of concerns. Page elements and actions are encapsulated in `LoginPage.java`. Assertions and test flows are isolated in `LoginTest.java`.
* **Exclusively XPath Locators:** Every single element locator strictly uses XPath (`//input[@id='username']`, `//input[@id='password']`, `//input[@id='Login']`, etc.).
* **Zero `Thread.sleep()`:** Deterministic synchronization using `WebDriverWait` and `ExpectedConditions`.
* **Zero Code Comments in Core Java:** Clean, self-documenting code complying with enterprise guidelines.
* **Full TestNG Lifecycle:** Implements `@BeforeSuite`, `@BeforeTest`, `@BeforeMethod`, `@Test`, `@DataProvider`, `@AfterMethod`, and `@AfterTest`.
* **Test Independence:** Every test method initializes and closes a fresh browser process via `@BeforeMethod` and `@AfterMethod(alwaysRun = true)`.
* **Zero Hardcoded Secrets:** Credentials and parameters are dynamically injected via system properties, environment variables, or `config.properties`.

---

## Project Structure

```text
Selenium_Frameworks/
├── pom.xml                                      # Maven dependencies and Surefire configuration
├── testng.xml                                   # TestNG suite runner XML
├── mvnw.cmd                                     # Embedded Maven wrapper (zero setup required)
├── run.bat                                      # 1-click Windows runner script
├── .gitignore                                   # Standard git ignores
├── README.md                                    # Project documentation
└── src/
    ├── main/
    │   └── java/
    │       └── com/salesforce/pages/
    │           └── LoginPage.java               # Page Object Model (PageFactory + XPath)
    └── test/
        ├── java/
        │   └── com/salesforce/tests/
        │       └── LoginTest.java               # TestNG Suite & Scenarios
        └── resources/
            └── config.properties                # Framework runtime properties
```

---

## Test Scenarios Covered

### Positive Scenarios
1. `test01_verifyLoginPageLoadsSuccessfully`: Asserts page title and current URL contain expected Salesforce indicators.
2. `test02_verifyUsernameFieldVisibleAndEnabled`: Verifies username field is visible and interactive.
3. `test03_verifyPasswordFieldVisibleAndEnabled`: Verifies password field is visible and interactive.
4. `test04_verifyLoginButtonVisibleAndEnabled`: Verifies login button is displayed and clickable.
5. `test05_verifyRememberMeCheckboxStateToggle`: Verifies Remember Me checkbox can be toggled on and off.
6. `test06_verifyAuthorizedValidCredentialsLogin`: Authenticates using configured test credentials (skips cleanly if not provided).

### Negative Scenarios
7. `test07_verifySubmitEmptyCredentials`: Submits empty form and verifies error banner.
8. `test08_verifySubmitUsernameWithEmptyPassword`: Submits username only and asserts password validation.
9. `test09_verifySubmitPasswordWithEmptyUsername`: Submits password only and asserts username validation.
10. `test10_verifySubmitInvalidCredentials`: Submits invalid account and asserts authentication rejection.
11. `test11_verifySubmitMalformedEmailInput`: Submits malformed email string and asserts validation response.
12. `test12_verifyErrorMessageBannerAndValidationContent`: Asserts error banner visibility and text length.
13. `testDataProvider_negativeLoginScenarios`: Parameterized negative testing driven by `@DataProvider`.

---

## How to Execute the Framework

### 1. One-Click Run (Windows)
Double-click `run.bat` in the project root.

### 2. Embedded Maven Wrapper (Recommended in Terminal)
Open PowerShell or Command Prompt in `Selenium_Frameworks`:

```powershell
# Run entire test suite (Headed Chrome)
.\mvnw.cmd clean test

# Run in headless mode (CI/CD)
.\mvnw.cmd clean test -Dheadless=true

# Run on Microsoft Edge or Firefox
.\mvnw.cmd clean test -Dbrowser=edge
.\mvnw.cmd clean test -Dbrowser=firefox

# Run with test credentials
.\mvnw.cmd clean test -Dsf.username="user@company.com" -Dsf.password="Secret123!"

# Run a specific test scenario
.\mvnw.cmd test -Dtest=LoginTest#test01_verifyLoginPageLoadsSuccessfully
```

### 3. TestNG HTML Reports
After execution, open:
`target/surefire-reports/index.html` or `target/surefire-reports/emailable-report.html` in any browser.
