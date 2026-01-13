🏥 CURA Healthcare Service — Demo Site

This is a public demo web application called CURA Healthcare Service, created for software testing and automation practice.
I built an end-to-end automation framework around this application, focusing on test design, framework architecture, and system design.
The framework is designed to easily accommodate additional test cases and simulate real-world application scenarios, making it scalable and maintainable for complex testing needs.
The primary purpose of this framework is to allow the system to accommodate any real-time project, making it scalable, maintainable, and adaptable for complex, real world testing scenarios.


The site simulates a basic health appointment booking system where a user can:

-  View the homepage with title CURA Healthcare Service and a “Make Appointment” button.
-  Navigate to a login page for authentication.
-  After login, fill out an appointment form (facility, date, comment, and options).
-  Submit and see a confirmation page for the appointment.

🚀 Typical Test Scenarios

Here are example flows automation frameworks often implement:

📌 1. Login Flow
- Open homepage.
- Click Make Appointment.
- Enter demo credentials (e.g., “John Doe” / sample password).
- Verify user logs in successfully.

📌 2. Appointment Booking
- After login, fill in:
- Facility (e.g., Hongkong CURA Healthcare Center)
- Hospital readmission option
- Healthcare program (e.g., Medicaid)
- Date picker
- Comments
- Submit form.
- Verify appointment confirmation with TestNG assertions

🔧 Tech Stack:
  
- Automation & Testing: Selenium WebDriver, TestNG, Cucumber
- Programming Language: Java
- Build & Dependency Management: Maven
- Reporting & Logging: ExtentReports, Log4j
- Data driver: Json
- Framework Design: Page Object Model (POM), End-to-End Automation Framework
- CI/CD: Jenkins
- Browser & Driver Management: WebDriverManager, Selenium Grid (Docker)
- Version Control: Git, GitHub

  Framework Features ✨:
  

- Detailed Logging & Reporting: Uses Log4j and ExtentReports for clear, actionable test reports.
- Externalized Test Data (JSON/Config): Eliminates hard-coded values for flexible, maintainable tests.
- Retry Mechanism: Automatically retries failed tests to handle intermittent issues.
- Cross-Browser & Parallel Execution: Supports multiple browsers and Selenium Grid for faster test runs.
- Page Object Model (POM): Promotes reusable and maintainable code structure.
- End-to-End Automation: Covers UI flows within a single framework.
- CI/CD Ready: Easily integrates with Jenkins pipelines for automated execution.
- Dynamic Waits & Error Handling: Handles timing issues gracefully and reduces flaky tests.
- Full regression Suite for Max test coverage
- Screenshot on test failure
- Implicit and explicit wait
