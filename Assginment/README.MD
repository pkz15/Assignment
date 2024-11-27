Selenium Cucumber Java Automation Project
This project demonstrates how to automate functional testing for web applications using Selenium, Cucumber, and Java. The key functionalities covered include:
•	Login functionality
•	Cascade dropdown handling
•	Dynamic table interactions
•	Extent Reports integration for detailed test reporting
________________________________________
Table of Contents
•	Prerequisites
•	Setup
•	Features
o	Login Test
o	Cascade Dropdown Handling
o	Dynamic Table Handling
•	Running Tests
•	Extent Reports
•	Contributing
•	License
________________________________________
Prerequisites
Before setting up the project, ensure you have the following installed on your system:
•	Java 11+
•	Maven (for dependency management)
•	IDE (e.g., IntelliJ IDEA, Eclipse)
•	Webdrivers (or any other browser driver for Selenium)
________________________________________
Setup
1.	Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/selenium-cucumber-java-automation.git
2.	Navigate into the project directory:
bash
Copy code
cd selenium-cucumber-java-automation
3.	Install Maven dependencies:
bash
Copy code
mvn clean install
4.	Set up WebDriver for the browser of your choice (e.g., ChromeDriver).
________________________________________
Features
Login Test
This test validates the login functionality by automating the following steps:
1.	Navigate to the login page.
2.	Enter valid/invalid credentials.
3.	Validate successful login or error message.
Cascade Dropdown Handling
This test demonstrates how to handle cascading dropdowns (dependent dropdowns). It automates:
1.	Selecting a value in the parent dropdown.
2.	Waits for the child dropdown to be populated dynamically.
3.	Selects a value from the child dropdown.
Dynamic Table Handling
This test automates interaction with dynamic tables, including:
1.	Searching for a specific row.
2.	Performing actions (e.g., add , delete) on a row in the dynamic table.
3.	Validating the expected result based on dynamic length.
________________________________________
Running Tests
You can run the tests in different ways:
•	To run all tests:
bash
Copy code
mvn test
•	To run a specific feature:
bash
Copy code
mvn test -Dcucumber.options="--tags @Login"
Running Tests with Cucumber
1.	The feature files are stored in the src/test/resources folder under the features directory.
2.	Cucumber options are defined in the @CucumberOptions annotation in the runner class.
3.	You can run the tests directly through Maven using the cucumber plugin.
________________________________________
Extent Reports
For reporting, we are using ExtentReports to generate detailed HTML reports. The reports will provide a summary of:
•	Test execution results (pass/fail).
Report Generation
After running the tests, the report can be found under the target/extent-reports directory.
________________________________________

