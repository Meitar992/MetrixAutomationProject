# Test Automation Home Assignment for Metrix

## Objective

The objective of this project is to create a test automation solution for interacting with a demo web application. It involves automating the login process and counting and asserting the number of successful transactions in a table.

## Technology Stack

For this project, we have chosen the following technology stack:

- **Programming Language:** Java
- **Testing Framework:** TestNG
- **Build Tool:** Maven
- **Automation Library:** Selenium WebDriver

## Assignment Instructions

### 1. Project Setup

- Set up a new automation project using Java, TestNG, and Maven.
- Use Maven as the build tool to manage project dependencies.

### 2. Automation Scenario

- Opened a web browser (any modern browser can be used).
- Navigate to the demo application: [https://demo.applitools.com/](https://demo.applitools.com/)
- Implemented the login functionality using the provided credentials:
  - Use any credentials (e.g., username: "testuser," password: "password123").
  - Locate the login elements (username input field, password input field, and login button) and automate the login process.
  - Assume the login is successful if the user is redirected to a page with the transaction table.

### 3. Count and Assertion

- Once logged in, locate the transaction table on the page.
- Count the number of rows in the table where the transaction status is marked as "Succeeded."
- Assert that the counted number of successful transactions is equal to an expected value (e.g., 3).

### 4. Clean Up

- After test execution, ensure that the browser is closed gracefully.

---

This README provides an overview of the project's objectives, technology stack, and assignment instructions. It outlines the setup process, automation scenario, counting and assertion tasks, and cleanup steps.

