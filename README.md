📌 Automation Testing Project – Automation Exercise Website

A complete Selenium + TestNG automation framework covering 25 real end-to-end UI test cases on the Automation Exercise
 demo website.

🚀 Project Overview

This project demonstrates a robust and scalable web automation framework built using:

Java

Selenium WebDriver

TestNG

Page Object Model (POM)

Allure Reporting

Log4j Logging

It includes 25 functional test cases, covering multiple features such as authentication, product flow, API interactions, contact forms, and more.

Graduation_Project
├── .idea/                          # IntelliJ IDEA settings (ignored in CI)
├── .mvn/                           # Maven Wrapper files
│
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
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

🛠️ Tech Stack
Tool	Purpose
Java	Main programming language
Selenium WebDriver	UI automation
TestNG	Test runner, assertions, reporting
Page Object Model	Maintainable test structure
Allure Reports	Detailed reporting & analytics
Log4j	Logs for debugging
Maven	Build + dependency management
✔️ Test Coverage (25 Test Cases)

Your test suite includes coverage for:

🔹 Authentication

User registration

Login / logout

Negative login cases

Account deletion

🔹 Product & Cart

Add to cart

Verify product quantity

Add multiple products

Checkout process

🔹 Contact & Forms

Contact us form

Submitting messages

File upload

🔹 API Testing Section

Navigating to API page

Validating API response samples

🔹 Website Navigation

Verifying pages

Subscription section

Scroll & visibility tests

Category filters

▶️ How to Run the Project
1️⃣ Clone the Repo
git clone https://github.com/MTamer202/Automation-Testing-Project-Automation-Exercise-Website-.git

2️⃣ Install Dependencies
mvn clean install

3️⃣ Run All Test Cases
mvn test

📊 Generate Allure Report
Generate report
allure serve test-outputs/allure-results