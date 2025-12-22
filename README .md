
# 🎓 Automation Testing Graduation Project

Automation Testing Project – Automation Exercise Website
Graduation Project – Information Technology Institute (ITI)

## 📖 Project Overview
This project is a UI Test Automation framework developed as a Graduation Project at ITI. It focuses on automating end-to-end test scenarios for the Automation Exercise Website, a demo e-commerce platform used for practicing automation testing.

The main goal of the project is to apply software testing concepts, automation best practices, and framework design principles using industry-standard tools
## 🌐 Application Under Test (AUT)
* Website: Automation Exercise

* URL: https://automationexercise.com/

* Type: E-commerce demo web application
## 🧪 Test Coverage
The automation suite covers multiple functional areas, including:

* User Registration

* User Login & Logout

* Product Search

* Add Products to Cart

* Cart Validation

* Checkout flow (basic scenarios)

* Positive and negative test scenarios
## 🛠 Tools & Technologies
* Java – Programming language

* Selenium WebDriver – UI automation

* TestNG – Test execution & assertions

* Maven – Build and dependency management

* Page Object Model (POM) – Framework design pattern

* Git & GitHub – Version control
## 📐 Framework Design
The project follows the Page Object Model (POM) design pattern to ensure:
* High maintainability

* Reusability of page classes

* Clean separation between test logic and UI locators
## 📁 Project Structure
```
UpgradedAutomationExercise/
├── .idea/ # IntelliJ IDEA configuration files
├── .mvn/ # Maven wrapper files
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/AutomationExercise/
│ │ │ ├── drivers/ # WebDriver management & browser factories
│ │ │ │ ├── AbstractDriver.java
│ │ │ │ ├── ChromeFactory.java
│ │ │ │ ├── EdgeFactory.java
│ │ │ │ ├── FirefoxFactory.java
│ │ │ │ ├── GUIDriver.java
│ │ │ │ └── WebDriverOptionsAbstract.java
│ │ │ ├── Listeners/ # TestNG & framework listeners
│ │ │ │ ├── TestngListeners.java
│ │ │ │ └── WebManagementListeners.java
│ │ │ ├── Pages/ # Page Object Model (POM) classes
│ │ │ │ ├── HomePage.java
│ │ │ │ ├── ProductsPage.java
│ │ │ │ ├── CartPage.java
│ │ │ │ ├── PaymentPage.java
│ │ │ │ ├── SignUpLoginPage.java
│ │ │ │ ├── SignUpPage.java
│ │ │ │ ├── SignUpConfirmation.java
│ │ │ │ ├── DeleteConfirmation.java
│ │ │ │ ├── ContactUsPage.java
│ │ │ │ └── TestCasesPage.java
│ │ │ └── utils/ # Common utilities & helpers
│ │ │ ├── AllureUtils.java
│ │ │ ├── BrowserActions.java
│ │ │ ├── CustomSoftAssertion.java
│ │ │ ├── ElementActions.java
│ │ │ ├── FilesUtils.java
│ │ │ ├── JsonUtils.java
│ │ │ ├── LogsUtils.java
│ │ │ ├── PropertiesUtils.java
│ │ │ ├── TerminalUtils.java
│ │ │ ├── TimestampUtils.java
│ │ │ ├── Validations.java
│ │ │ └── Waits.java
│ │ └── resources/ # Configuration & properties files
│ │ ├── allure.properties
│ │ ├── environment.properties
│ │ ├── log4j2.properties
│ │ └── web.properties
│ └── test/
│ ├── java/
│ │ └── com/AutomationExercise/E2E/ # End-to-End test scenarios
│ └── resources/
│ └── test-data.json # Test data file
├── test-outputs/ # Execution outputs
│ ├── allure-report/ # Generated Allure HTML reports
│ │ └── Report_*.html
│ ├── allure-results/ # Allure raw results
│ └── Logs/ # Execution logs
├── target/ # Maven build output
├── TestRunner.xml # TestNG suite runner
├── pom.xml # Maven dependencies & plugins
└── README.md # Project documentation
```
## ▶️ How to Run the Project
1️⃣ Prerequisites
- Java JDK 8 or higher
- Maven installed
- Chrome browser
- ChromeDriver compatible with browser version


2️⃣ Clone the Repository
```bash
git clone https://github.com/MTamer202/Automation-Testing-Project-Automation-Exercise-Website-.git
```
3️⃣ Run Tests Using Maven
```bash
mvn clean test
```
Or run the test suite directly using:

testng.xml from your IDE
## 📊 Reporting
Test execution results are generated using Allure reports

Logs and execution details can be viewed from the IDE console and integrated to reports

## 👤 Author
  Mohamed Tamer Essam Eldin
  
  Graduation Project – ITI
## 📎 References
* Selenium Documentation

* TestNG Documentation
  
* Automation Exercise Website