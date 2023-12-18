# Automated Tests for myDemoApp

This repository comprises automated tests scripted in Java using a combination of Appium, Selenium, Cucumber, JUnit, TestNG, and Gherkin for the myDemoApp Android application.

## Overview

The automated tests validate various functionalities of the *myDemoApp*, covering aspects such as login, logout, product sorting, product details page, product exploration, and checkout processes.

## Prerequisites

Before running the automated tests, ensure the following tools are installed:
- **Java Development Kit (JDK) 8** or above installed
- **Appium server** installed and running
- **Android Studio** with Android SDK configured
- Emulator set up with *myDemoApp* installed

## Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/ViktorijaGol/myDemoApp.git
    ```
2. Open the project in your preferred **Java IDE (such as IntelliJ IDEA, Eclipse, etc.).**
3. Install required dependencies by either using Maven or Gradle. Example using **Maven:**
   ```bash
   cd myDemoApp-tests
   mvn clean install
    ```

## Configuration

- Ensure Appium server address, device capabilities, and application package details are correctly configured in test files **(src/test/java/steps/DriverFactory).**
- When setting up the Appium capabilities for test execution, make sure to include the following details::
  - **Emulator ID:** emulator-5556
  - **Platform Version:** 12.0
- These emulator details are essential for the tests to correctly target the specified emulator running Android 12.0 for testing the myDemoApp.

## Running Tests

### Using Maven

Run the following Maven command to execute all the tests:
   mvn test

### Using IDE

Run test suites directly from the IDE by executing the Cucumber runner file **(features/login.feature or similar)** as a JUnit test.

## Test Structure

Tests are structured using Cucumber (Behavior Driven Development) framework, allowing for easy readability and maintenance. Key test scenarios covered include:

- **Login:** Testing the login functionality with valid and invalid credentials.
- **Logout:** Verifying the user can successfully log out from the application.
- **Product Sorting:** Testing various sorting options for products and verifying the order.
- **Product Detailed Page:** Verifying the functionality and accuracy of the product detail page.
- **Product Exploration:** Testing the navigation and exploration of various products/categories
- **Checkout:** Verifying the checkout process from cart addition to order placement.

## Reporting

Generate test execution reports post-test run. For example, use Cucumber HTML reports for detailed information on test execution, passed/failed scenarios, etc.

## Contributors

- Viktorija Golovinova (@ViktorijaGol)
