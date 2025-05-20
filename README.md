# Saucedemo Project

## Overview

This project is an automated UI testing solution built using **Selenium WebDriver**, **TestNG**, and **Page Object Model (POM)** to verify key functionalities of the [saucedemo.com](https://www.saucedemo.com) e-commerce demo application. The automation suite covers user login, product selection, add-to-cart, and checkout flows with multiple assertions to ensure functionality works as expected.

Test data is managed via external Excel files using Apache POI, while test execution and reporting are handled using TestNG with support for data-driven testing.

---

## Assumptions

- The application under test (`https://www.saucedemo.com`) is stable and available throughout test execution.
- Valid credentials are pre-known and static (`standard_user` / `secret_sauce`) as provided publicly by saucedemo.
- Chrome browser is used for testing, and the correct version of ChromeDriver is matched.
- All users follow the same checkout flow (no role-based UI difference).
- Only UI validation is in scope; API validations are out of scope for this task.

---

## Challenges and Limitations

- **Browser-native dialogs** (like "Change your password" warnings from Chrome) cannot be handled by Selenium directly and need to be suppressed via ChromeOptions.
- Since the app is demo-based, some features may be limited or mocked, making real backend validation impossible.
- Password manager and auto-fill prompts may interfere with test execution if not disabled.
- The demo environment may not support concurrency testing or performance evaluation accurately.
- No database access means validation is based solely on UI state.

---

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ffadilla00/sauceDemo.git
   cd saucedemo
   ```

2. **Install Maven dependencies**:
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

3. **Configure ChromeDriver**:
   - Place your matching `chromedriver.exe` under `src/test/resources/drivers/`
   - Or let Selenium Manager resolve it automatically (requires Selenium 4.6+)

4. **Run all tests**:
   Using TestNG:
   ```bash
   mvn clean test
   ```

5. **Test Report**:
   After test execution, open:
   ```
   target/surefire-reports/emailable-report.html
   ```
   To view the test summary in your browser.

6. **Test Data**:
   Test login data is managed via:
   ```
   src/test/resources/testData/testData.xlsx
   ```

---

This project showcases test automation best practices including test reusability, maintainability, and separation of concerns (data, logic, and assertions).
