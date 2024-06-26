# QA Automation Project for DemoQA
## Overview
This project is a QA automation framework designed to test the functionality of the DemoQA website. It utilizes Selenium WebDriver for web automation, Selenium Grid for parallelism and TestNG as the testing framework.

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
    │   │       ├── Pages/
    │   │       │   ├── HomePage.java
    │   │       │   ├── AlertsPage.java       
    │   │       │   ├── AutoCompletePage.java
    │   │       │   └── ... (other page classes)
    │   │       │
    │   │       ├── testComponents
    │   │       │    ├── config/
    │   │       │    │   ├── BrowserManager.java
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
- Cross-browser Testing: The framework supports running tests on multiple browsers (Chrome, Firefox, Edge).
- Data-driven Testing: Test data is stored in external files (e.g., xlsx) and loaded dynamically during test execution.
- Logging and Reporting: Test execution logs and reports are generated for easy analysis and troubleshooting.

# Setup
>[!IMPORTANT]
>Please see the 8 step that file is very important

1. You need to have java downloaded
2. [Install and configure Maven](https://youtu.be/YTvlb6eny_0?si=swpCpuEUvu0vnnKi)
3. Clone the repository:

        git clone:  https://github.com/JorgeSanchez112/JPOMDemoQA.git
4. Download and install [Selenium Server(Grid)](https://www.selenium.dev/downloads/)
5. If you are using a Windows OS, execute Selenium Grid with the commands console (CMD).  
   >[!NOTE] 
   >It must be located where the file was stored.

         java -jar selenium-server-<version>.jar standalone
   <sub> If you want drivers to update automatically. </sub>

         java -jar selenium-server-<version>.jar standalone --selenium manager
6. Update the config.properties. For example changing the urlServer.
7. Update the testSuites change the thread-count according Selenium Grid indicate.
   ![This is example about the interface of Selenium Grid and the max thread-accounts available](https://www.testim.io/wp-content/uploads/2021/03/grid.png)
   <sub> If you want to know what thread-counts you have available you should copy the URL Server gave by selenium grid before and look it up in a browser.</sub>
   
8. Download the [DDTDemoQA.xlsx](https://docs.google.com/spreadsheets/d/1uIJr8EnyRxK1L54hbn02WYHdgHQuLIjr/edit?usp=sharing&ouid=112046374903426947430&rtpof=true&sd=true) ExcelFIle, then store it in DataDriven directory.
9. Run tests using Maven:
   >[!NOTE]
   >First clean the project dependencies contain in POM, You can do it using the next command.

       mvn clean

   <sub> Run all the test one by one </sub>

        mvn test
   <sub> Run all the Smoke tests </sub>

         mvn test -P=smokeTest
   <sub> Run all the UI and Functional Tests. </sub>

         mvn test -P=UIFunctionalTest
   <sub> Run all the Integration Tests. </sub>

         mvn test -P=integrationTest

# Test Execution
- Tests are executed using TestNG test runner.
- Test reports are generated in HTML format and can be found in the reports directory it should be created automatically when a test suite has finished.

# Contribution
Contributions are welcome! Feel free to open issues for bugs, feature requests, or submit pull requests to improve the project.
