📌 Automation Testing Project – Automation Exercise Website

A complete Selenium Web Automation Framework built for the ITI Graduation Project, implementing 25 automated UI test cases on the Automation Exercise website.

This framework uses Java, Selenium WebDriver, TestNG, POM, Allure Reports, and Log4j to create a scalable and maintainable testing architecture.

📂 Project Structure
Graduation_Project
├── .idea/                          # IntelliJ IDEA settings (ignored in CI)
├── .mvn/                           # Maven Wrapper files
│
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           ├── Main.java       # Entry point (optional)
│   │           │
│   │           ├── Pages/          # Page Object Model (POM)
│   │           │   ├── CartPage.java
│   │           │   ├── ContactUsPage.java
│   │           │   ├── DeleteConfirmation.java
│   │           │   ├── HomePage.java
│   │           │   ├── PaymentPage.java
│   │           │   ├── ProductsPage.java
│   │           │   ├── SignUpConfirmation.java
│   │           │   ├── SignUpLoginPage.java
│   │           │   ├── SignUpPage.java
│   │           │   └── TestCasesPage.java
│   │           │
│   │           └── utilies/        # Utility Classes
│   │               ├── AllureUtils.java
│   │               ├── FilesUtils.java
│   │               └── LogsUtils.java
│   │
│   └── resources
│       ├── allure.properties       # Allure configuration
│       └── log4j2.properties       # Logging configuration
│
├── test
│   └── java
│       └── Selenium
│           ├── BaseTest.java       # TestNG setup & WebDriver initialization
│           └── End2End.java        # End-to-end test scenarios
│
├── test-outputs/
│   ├── allure-results/             # Allure raw output
│   └── Logs/                       # Logging output during test runs
│
├── target/                         # Maven compiled output (auto-generated)
│
├── TestRunner.xml                  # TestNG Suite
├── pom.xml                         # Maven dependencies & configuration
├── README.md                       # Project documentation
└── Me.pdf                          # Project PDF (your documentation)

🚀 Project Overview

This is a graduation project developed during the ITI training program under the supervision of Dr. Amany.
It demonstrates a complete automation testing framework built to cover real-world UI test cases on the Automation Exercise website.

The framework follows industry-standard practices:

Page Object Model (POM)

TestNG test execution

Logging with Log4j2

Allure reporting

Clean and scalable architecture

🧪 Test Cases Covered (25 Total)
🔹 User Account

Register new user

Login with valid/invalid data

Logout

Delete account

Account creation confirmation

🔹 Product & Cart

Add products to cart

Verify cart quantities

Remove items

Checkout and payment flow

🔹 Contact & Forms

Fill contact form

Submit form with file upload

Validate form success

🔹 Browsing & Navigation

Navigate product categories

Verify home page sliders

Scroll tests

Subscription section tests

🔹 API Test Page

Navigate to API test section

Validate displayed API examples

🛠️ Technologies Used
Tool	Purpose
Java	Primary language
Selenium WebDriver	UI automation
TestNG	Test runner & assertions
POM (Page Object Model)	Clean and maintainable test structure
Allure Reports	Detailed test reporting
Log4j2	Logging configuration
Maven	Dependency management
▶️ How to Run the Tests
1️⃣ Clone the repository
git clone https://github.com/MTamer202/Automation-Testing-Project-Automation-Exercise-Website-.git

2️⃣ Install dependencies
mvn clean install

3️⃣ Run the TestNG Suite
mvn test -DsuiteXmlFile=TestRunner.xml

📊 Generating Allure Reports
Generate report
allure generate test-outputs/allure-results --clean -o allure-report

Open report
allure open allure-report
