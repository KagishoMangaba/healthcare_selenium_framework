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



  <img width="1902" height="906" alt="image" src="https://github.com/user-attachments/assets/352e4411-8e0b-43ba-9a1f-7fa46a974a04" />

  <img width="1902" height="951" alt="image" src="https://github.com/user-attachments/assets/b307d644-f92b-4f06-969f-2f54a6be7a79" />


