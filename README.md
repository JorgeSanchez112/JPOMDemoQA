# QA Automation Project for DemoQA
## Overview
This project is a QA automation framework designed to test the functionality of the DemoQA website. It utilizes Selenium WebDriver for web automation and TestNG as the testing framework.

# Project Structure

    demoqa-automation/
    │
    ├── reports/
    │   ├── index.html
    │   └── log4j-application.log
    │
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       ├── pages/
    │   │       │   ├── HomePage.java
    │   │       │   ├── AlertsPage.java       
    │   │       │   ├── AutoCompletePage.java
    │   │       │   └── ... (other page classes)
    │   │       │
    │   │       ├── testComponents
    │   │       │    ├── config/
    │   │       │    │   ├── PageBase.java
    │   │       │    │   └── TestBase.java
    │   │       │    │      
    │   │       │    └── utilities/
    │   │       │        ├── dataDriven/
    │   │       │        │   ├── DDTDemoQA.xlsx             #Excel File, it must be added.
    │   │       │        │   └── ExcelReader.java
    │   │       │        │
    │   │       │        ├── report/
    │   │       │        ├── ExtentReporterNG.java
    │   │       │        │   └── Listeners.java
    │   │       │        │
    │   │       │        └── retry/
    │   │       │                 ├── MyTransformer.java
    │   │       │                 └── Retry.java
    │   │       │
    │   │       ├── resources/
    │   │       │   ├── config.properties
    │   │       │   └── Log4j2.xml
    │   │       │
    │   │       └── testSuites/
    │   │           ├── integrationTest.xml
    │   │           ├── smokeTest.xml
    │   │           └── UIFuntionalTest.xml
    │   │
    │   └── test/
    │       └── java/
    │           └── org/
    │               └── tests/
    │                   ├── HomePageTest.java
    │                   ├── AlertsPageTest.java       
    │                   ├── AutoCompletePageTest.java
    │                   └── ... (other test classes)
    │
    ├── pom.xml                # Maven project configuration
    └── README.md              

# Features
- Page Object Model (POM): The project follows the POM design pattern to maintain separation between test code and page-specific code.
- Cross-browser Testing: The framework supports running tests on multiple browsers (Chrome, Firefox, etc.).
- Data-driven Testing: Test data is stored in external files (e.g., CSV) and loaded dynamically during test execution.
- Logging and Reporting: Test execution logs and reports are generated for easy analysis and troubleshooting.

# Setup
1. Clone the repository:

        git clone https://github.com/yourusername/demoqa-automation.git
2. Install dependencies using Maven:

        cd demoqa-automation
        mvn clean install
3. Update config.properties with appropriate browser and driver settings.

4. Run tests using Maven:

        mvn test

# Test Execution
- Tests are executed using TestNG test runner.
- Test reports are generated in HTML format and can be found in the target/surefire-reports directory.

# Contribution
Contributions are welcome! Feel free to open issues for bugs, feature requests, or submit pull requests to improve the project.
