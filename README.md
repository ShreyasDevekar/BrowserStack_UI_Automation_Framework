# UI Automation Framework Using BrowserStack ( IOS cloud devices )

An UI test automation framework to execute Selenium test cases on **BrowserStack iOS devices**, designed for automating the **Amazon Shopping iOS app**.

---

## Features

- Runs Selenium tests on BrowserStack's iOS devices
- Uses TestNG for test execution management
- Screenshots captured for both passed and failed steps
- Generates detailed HTML test reports
- Fully configurable through `capability.properties`
- Target app: **Amazon Shopping iOS**

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- BrowserStack
- HTML Reporting
- Screenshot Utility
- Config-driven execution

## Configuration (config/capability.properties)

```properties
browserName = <browserName>
device = <device> example- iPhone 11
realMobile = true or flase
os_version = 14
name = AmazonTest_ Validation of Cart Product Details Test
USERNAME = <browserstack_username>
AUTOMATE_KEY = <browserstack_api_key>
```

---

## How to Run Tests

### 1. Clone the Repository

```bash
git clone https://github.com/ShreyasDevekar/BrowserStack_UI_Automation_Framework.git
cd BrowserStack_UI_Automation_Framework
```

### 2. Configure BrowserStack

Update your `capability.properties` with valid `username`, `accessKey` from BrowserStack.

### 3. Execute Tests

```bash
mvn clean test
```

---

## Screenshots & Reporting

- Screenshots for **each test step** (pass/fail) are stored in `/screenshots`.
- TestNG **HTML reports** are generated in the `/reports` directory.
- Reports and screenshots help debug and review test executions visually.

---
