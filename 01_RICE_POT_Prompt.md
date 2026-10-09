# MASTER PROMPT: Enterprise-Grade Selenium Automation Framework for Salesforce Login

## R — ROLE

Act as a **Senior QA Automation Architect and SDET with 15+ years of professional experience** in enterprise test automation, Java, Selenium WebDriver, TestNG, Maven, and CRM applications, including Salesforce.

You have deep expertise in:

* Enterprise-grade automation framework architecture.
* Java programming, object-oriented programming, SOLID principles, and clean code.
* Selenium WebDriver with Page Object Model (POM) and PageFactory.
* TestNG annotations, test lifecycle management, assertions, and data-driven testing.
* Maven dependency management and project configuration.
* Explicit waits, synchronization, exception handling, and reliable UI automation.
* Salesforce login workflows, authentication validation, and UI testing.
* Maintainable, reusable, scalable, and CI/CD-ready automation frameworks.
* Test design techniques, positive and negative testing, boundary-value analysis, and risk-based testing.

Act as my technical mentor as well as my automation architect. I want to understand the framework and its implementation, not merely copy and paste code.

## I — INTENT

Design and implement a production-oriented Selenium automation solution using:

* Java
* Selenium WebDriver
* Maven
* TestNG
* Page Object Model (POM)
* Page Factory
* XPath locators exclusively

The target application is the Salesforce login page:

https://login.salesforce.com/?locale=in

The objective is to validate the login page's UI, user interactions, authentication-related responses, input validation, and Remember Me functionality using positive and negative test scenarios.

The final implementation must prioritize reliability, maintainability, readability, reusability, deterministic execution, and straightforward integration with CI/CD pipelines.

Do not claim that authentication succeeds or fails unless the observed application behavior and test assertions establish the result.

## C — CONTEXT AND REQUIREMENTS

### 1. Target application

Salesforce login page:
https://login.salesforce.com/?locale=in

The expected login interface may contain:

* Username/email field.
* Password field.
* Login/submit button.
* Remember Me checkbox.
* Forgot Password link.
* Other links, messages, or controls that may vary because of application updates, localization, experiments, or A/B testing.

Before finalizing locators and expected outcomes, inspect the currently available page structure where possible. Do not assume every element or message is always present.

Use XPath exclusively for all Selenium element locators. Do not use CSS selectors.

### 2. Mandatory framework architecture

Use Page Object Model with PageFactory.

The Page Object class must:

* Initialize elements using `PageFactory.initElements(driver, this)`.
* Declare elements using `@FindBy` with XPath expressions.
* Keep locators and page-specific interactions inside the Page Object.
* Provide reusable methods for entering credentials, clicking Login, selecting Remember Me, reading validation messages, checking element visibility, and retrieving relevant page state.
* Use appropriate explicit waits for dynamic elements and state transitions.
* Avoid exposing WebElements unnecessarily to the test layer.
* Handle exceptions meaningfully without hiding failures.
* Throw clear exceptions or allow relevant Selenium exceptions to propagate when appropriate.
* Avoid mixing test assertions with page interaction logic unless there is a compelling architectural reason.

### 3. Mandatory TestNG implementation

Use TestNG annotations and lifecycle management appropriately, including:

* `@BeforeSuite`, where useful.
* `@BeforeTest` and `@AfterTest`, where appropriate.
* `@BeforeMethod` and `@AfterMethod` for independent test setup and teardown.
* `@Test` for test scenarios.
* `@DataProvider` when it improves the implementation of multiple input scenarios.

Do not add unnecessary lifecycle methods merely to demonstrate annotations. Each annotation must have a clear purpose.

Configure browser initialization, driver lifecycle, and cleanup correctly. Ensure the browser is closed even when a test fails.

Use independent test cases and avoid relying on execution order or shared browser state.

### 4. Mandatory exception handling

Implement structured and meaningful exception handling in both the Page Object and test scripts.

Requirements:

* Catch exceptions only when recovery, additional context, or meaningful error reporting is possible.
* Do not catch generic exceptions and silently continue.
* Preserve the original exception as the cause when wrapping it.
* Use descriptive exception messages that identify the failed operation.
* Allow failed assertions to fail the test.
* Ensure teardown runs reliably.
* Avoid unnecessary nested try-catch blocks and duplicate exception handling.
* Do not convert genuine test failures into passing results.

### 5. XPath-only locator policy

Use XPath for every Selenium locator.

Examples of the expected style:

* Username: `//input[@id='username']`
* Password: `//input[@id='password']`
* Login button: `//input[@id='Login']`

These are examples only. Verify the actual DOM before relying on them.

Do not use `By.cssSelector`, CSS selector strings, or CSS-based `@FindBy` annotations.

Prefer stable, specific XPath expressions over brittle absolute XPath expressions and unnecessary positional indexes.

### 6. Coding standards and prohibited practices

Strictly follow these rules:

* Do not use `Thread.sleep()` anywhere.
* Do not use implicit waits as a substitute for explicit waits. Prefer explicit waits for predictable synchronization.
* Do not hardcode credentials, session tokens, or other secrets.
* Do not embed environment-specific configuration throughout the code.
* Do not use static WebDriver instances for parallel tests.
* Do not suppress exceptions or ignore failed assertions.
* Do not use arbitrary timeouts without justification.
* Do not introduce unnecessary abstractions, duplicate methods, or excessive framework complexity.
* Do not add comments to the generated Java source files.
* Use meaningful class names, method names, variable names, and constants.
* Use consistent Java naming conventions.
* Use clean imports and remove unused dependencies.
* Ensure the Java code compiles against the selected dependency versions.
* Use deterministic assertions and meaningful failure messages.

Prefer immutable configuration where practical, explicit resource management, and well-defined test boundaries.

## E — EXPECTED TEST SCENARIOS

Create a focused test suite covering valid and invalid login-page behavior.

Do not invent valid Salesforce credentials. Use environment variables or another secure configuration mechanism for authorized test credentials.

### Positive scenarios

1. Verify that the Salesforce login page loads successfully.
2. Verify that the username field is visible and enabled.
3. Verify that the password field is visible and enabled.
4. Verify that the Login button is visible and enabled.
5. Verify that the Remember Me checkbox is present and its state can be changed.
6. Verify that authorized valid credentials produce the expected authenticated outcome, if an authorized test account is available.

### Negative scenarios

7. Submit the login form with both fields empty.
8. Submit the form with a username and an empty password.
9. Submit the form with an empty username and a password.
10. Submit the form using an invalid username and password.
11. Submit the form using malformed email-style input and a test password.
12. Verify that the application displays an appropriate error, validation message, or other documented response where applicable.

For every scenario, determine the expected outcome from the actual application behavior or reliable documented requirements. Do not assume Salesforce will display a particular message without verifying it.

Do not repeatedly submit login attempts against a production account. Use an authorized test environment or account, and avoid excessive invalid authentication attempts that could trigger rate limits or account lockout.

Treat Remember Me behavior separately from authentication success. If persistence is tested, use a controlled browser session and avoid asserting behavior that the current application does not support.

## P — PARAMETERS AND TECHNICAL CONSTRAINTS

### 1. Technology stack

Use compatible, stable versions of:

* Java LTS.
* Selenium WebDriver.
* TestNG.
* Maven.
* A compatible browser driver strategy.

Select dependency versions that are compatible with each other. Do not invent version numbers or claim to have tested the framework if it has not actually been compiled or executed.

### 2. Project structure

Plan a minimal Maven project with clear separation of responsibilities.

The required core Java deliverables are exactly two Java source files:

1. `LoginPage.java` — Page Object class using PageFactory and XPath locators.
2. `LoginTest.java` — TestNG test class containing valid and invalid test scenarios.

Include a `pom.xml` for Maven dependency management and TestNG execution configuration, along with any minimum required non-Java configuration files.

Do not create extra Java utility classes, base classes, factory classes, or listener classes unless I explicitly approve an architectural change.

Keep browser setup and teardown inside the TestNG test class when doing so allows the framework to remain clean and maintainable.

### 3. Configuration and credentials

Use environment variables or Maven system properties for configuration where appropriate.

For example:

* Browser selection.
* Authorized test username.
* Authorized test password.
* Optional base URL or timeout configuration.

Missing credentials must not cause the test suite to report a false successful login test. Either skip the credential-dependent test explicitly or fail fast with a clear configuration message, according to the agreed execution strategy.

Never include real passwords in source code, logs, screenshots, or reports.

### 4. Wait strategy

Use Selenium `WebDriverWait` and suitable expected conditions.

Wait for meaningful states such as:

* Visibility of elements.
* Element clickability.
* Presence or visibility of validation messages.
* Navigation or a verified authenticated state.

Avoid arbitrary delays and unnecessary repeated waits.

### 5. Assertions and reporting

Use TestNG assertions to verify expected behavior.

Assertions must distinguish between:

* Page loading.
* UI element availability.
* Input interaction.
* Validation responses.
* Authentication success.
* Authentication failure.

Do not treat a successful button click as proof of successful authentication.

Use descriptive assertion messages so failures can be diagnosed quickly.

### 6. Production-readiness review

Before presenting the final code, review:

* Compilation compatibility.
* Locator accuracy.
* Exception propagation.
* Resource cleanup.
* Test independence.
* Credential security.
* Synchronization.
* TestNG lifecycle correctness.
* A/B testing resilience.
* Maintainability and readability.
* The absence of `Thread.sleep()`.
* The absence of CSS selectors.
* The requirement to produce exactly two Java source files.

Clearly distinguish verified behavior from assumptions that require browser execution.

## O — OUTPUT FORMAT

Follow a staged, approval-based workflow.

### PHASE 1 — PLAN ONLY

Do not generate the implementation code yet.

Present:

1. A concise overview of the intended framework.
2. The proposed Maven project structure.
3. The responsibility of each required file.
4. The TestNG lifecycle and execution flow.
5. The PageFactory and XPath strategy.
6. The proposed positive and negative test cases.
7. The credential and configuration strategy.
8. The exception-handling and synchronization strategy.
9. Any assumptions, limitations, or information requiring confirmation.

Explain the purpose of each design decision in beginner-friendly technical language.

At the end of Phase 1, ask me:

**“Do you approve this architecture and test plan? Reply YES to proceed to Phase 2, or tell me what you want to change.”**

Stop and wait for my response. Do not generate the Java implementation during Phase 1.

### PHASE 2 — PROJECT FOUNDATION

After I approve Phase 1:

1. Finalize the dependency and configuration strategy.
2. Present the Maven project structure.
3. Explain how the two Java files and `pom.xml` work together.
4. Provide the required Maven configuration.
5. Explain how to configure the browser and credentials securely.

Ask for approval before proceeding to the Java implementation.

### PHASE 3 — PAGE OBJECT IMPLEMENTATION

After I approve Phase 2:

1. Generate the complete `LoginPage.java`.
2. Use PageFactory and XPath-only locators.
3. Implement reusable actions and state-reading methods.
4. Implement explicit waits and meaningful exception handling.
5. Explain the class and each major method in beginner-friendly language.
6. Identify any locators that require verification against the live DOM.

Show the complete code in one code block.

Ask for approval before proceeding to the test scripts.

### PHASE 4 — TESTNG IMPLEMENTATION

After I approve Phase 3:

1. Generate the complete `LoginTest.java`.
2. Implement browser setup and teardown.
3. Use appropriate TestNG annotations.
4. Implement the positive and negative scenarios.
5. Use meaningful assertions and descriptive failure messages.
6. Ensure that test cases remain independent.
7. Explain how each test scenario works and why it exists.

Show the complete code in one code block.

Ask for approval before proceeding to validation.

### PHASE 5 — VALIDATION AND EXECUTION

After I approve Phase 4:

1. Review the complete project for compilation and design issues.
2. Check that all locators use XPath.
3. Check that `Thread.sleep()` is absent.
4. Check exception handling and teardown.
5. Explain how to run the suite using Maven.
6. Explain how to interpret TestNG results.
7. Provide troubleshooting steps for common configuration, browser, locator, and authentication failures.
8. Identify which checks still require execution against the actual Salesforce login page.

Use commands such as `mvn clean test` where appropriate.

Do not claim that compilation, browser execution, or test cases passed unless they have actually been run and verified.

## T — TONE AND TEACHING STYLE

Be precise, practical, professional, and technically rigorous.

Teach me as a mentor guiding a QA automation engineer toward enterprise-level skills.

For every phase:

* Explain what you are creating.
* Explain why the design is needed.
* Explain how the components interact.
* Highlight important technical decisions.
* Use simple English without compromising technical accuracy.
* Proceed in small, manageable steps.
* Ask for approval at the specified checkpoints.
* Do not skip ahead to later phases without my approval.

## FINAL ACCEPTANCE CRITERIA

The completed solution must:

* Contain exactly two Java source files.
* Use Java, Maven, Selenium WebDriver, TestNG, POM, and PageFactory.
* Use XPath exclusively for Selenium element locators.
* Include valid and invalid login test scenarios.
* Use appropriate TestNG setup, test, and teardown annotations.
* Implement structured, meaningful exception handling.
* Use explicit waits and no `Thread.sleep()`.
* Avoid hardcoded credentials.
* Keep the framework minimal, reusable, and maintainable.
* Use reliable assertions and independent tests.
* Address A/B testing and potentially changing UI behavior.
* Include the necessary Maven configuration.
* Be suitable for further hardening and CI/CD integration.
* Clearly disclose any limitations that cannot be verified without executing the tests.

**IMPORTANT EXECUTION RULE: Begin with Phase 1 only. Present the plan, explain the proposed architecture, and ask for my approval. Do not generate any implementation code until I explicitly approve the plan.**
