🏥 CURA Healthcare Automation Framework

CURA Healthcare Service is a public demo web application used for practicing UI automation.
I designed and built a complete end-to-end automation framework around this application with a
strong focus on framework architecture, scalability, and real-world maintainability.

The goal of the framework is not just to automate a demo site 
it is structured so it can plug into any real production system with minimal change.


🧠 What the Framework Solves

- Clean separation of test logic using Page Object Model (POM)
- Fully data-driven execution using JSON
- Easily extendable for new features, new test suites, and parallel execution
- Designed for CI/CD pipelines and distributed execution with Selenium Grid (Docker)

🧪 Automated Business Flows

🔐 1. Login Flow

- Load homepage
- Click Make Appointment
- Authenticate using demo credentials
- Validate successful login using TestNG assertions

🏥 2. Appointment Booking Flow

- Select medical facility
- Configure hospital readmission
- Choose healthcare program
- Pick appointment date
- Enter comments
- Submit appointment
- Validate confirmation page

🔧 Tech Stack:

- Automation & Testing: Selenium WebDriver, TestNG, Cucumber
- Programming Language: Java
- Build & Dependency Management: Maven
- Framework Design: Page Object Model (POM), End-to-End Automation Framework
- Data-Driven Testing: JSON
- Logging & Reporting: Log4j, ExtentReports
- CI/CD Integration: Jenkins
- Distributed Execution: Selenium Grid with Docker
- Browser & Driver Management: WebDriverManager
- Version Control: Git, GitHub
- Execution Environments: Runs locally via Command Prompt and remotely via Jenkins pipelines


  <img width="1902" height="906" alt="image" src="https://github.com/user-attachments/assets/352e4411-8e0b-43ba-9a1f-7fa46a974a04" />



  <img width="1902" height="951" alt="image" src="https://github.com/user-attachments/assets/b307d644-f92b-4f06-969f-2f54a6be7a79" />


